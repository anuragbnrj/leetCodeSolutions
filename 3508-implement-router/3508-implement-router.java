import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.TreeSet;

class Router {

    int memoryLimit;
    long sequenceCounter;
    
    // Use a HashSet for fast, content-based duplicate checks (O(1) time).
    // It relies on the Packet's equals() and hashCode() methods.
    HashSet<Packet> uniquePackets;

    // Use a TreeSet to keep packets sorted by timestamp, then by arrival sequence.
    // This provides O(log n) for additions and removals.
    TreeSet<Packet> orderedPackets;

    public Router(int memLim) {
        memoryLimit = memLim;
        sequenceCounter = 0;
        uniquePackets = new HashSet<>();
        
        orderedPackets = new TreeSet<>((a, b) -> {
            int timeCompare = Integer.compare(a.timestamp, b.timestamp);
            if (timeCompare != 0) {
                return timeCompare;
            }
            // If timestamps are the same, use the arrival sequence as a tie-breaker.
            return Long.compare(a.sequence, b.sequence);
        });
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        // Create a temporary packet to check for existence in the HashSet.
        // The sequence number doesn't matter for equality.
        Packet key = new Packet(source, destination, timestamp, 0);

        if (uniquePackets.contains(key)) {
            return false;
        }

        if (orderedPackets.size() == memoryLimit) {
            // Remove the oldest packet from both data structures.
            Packet oldestPacket = orderedPackets.pollFirst();
            uniquePackets.remove(oldestPacket);
        }

        // Create the real packet with a unique, incrementing sequence number.
        Packet newPacket = new Packet(source, destination, timestamp, sequenceCounter++);
        uniquePackets.add(newPacket);
        orderedPackets.add(newPacket);
        
        return true;
    }
    
    public int[] forwardPacket() {
        if (orderedPackets.isEmpty()) {
            return new int[0];
        }

        // Get the oldest packet from the sorted set.
        Packet frontPacket = orderedPackets.pollFirst();
        // Also remove it from the uniqueness set.
        uniquePackets.remove(frontPacket);

        return new int[]{frontPacket.source, frontPacket.destination, frontPacket.timestamp};
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        // Create boundary packets for the subset search. The sequence number
        // range [0, Long.MAX_VALUE] covers all possibilities.
        Packet startPacket = new Packet(0, 0, startTime, 0);
        Packet endPacket = new Packet(0, 0, endTime, Long.MAX_VALUE);

        NavigableSet<Packet> rangeView = this.orderedPackets.subSet(startPacket, true, endPacket, true);

        int count = 0;
        for (Packet packetInRange : rangeView) {
            if (packetInRange.destination == destination) {
                count++;
            }
        }
        return count;
    }

    private class Packet {
        int source;
        int destination;
        int timestamp;
        // This is used for ordering only, not for equality.
        long sequence;

        public Packet(int src, int des, int tstamp, long seq) {
            source = src;
            destination = des;
            timestamp = tstamp;
            sequence = seq;
        }

        // IMPORTANT: equals() and hashCode() intentionally ignore the 'sequence'
        // field because packet uniqueness is defined only by its content.
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Packet packet = (Packet) o;
            return source == packet.source &&
                   destination == packet.destination &&
                   timestamp == packet.timestamp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }
    }
}