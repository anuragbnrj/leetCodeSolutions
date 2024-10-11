class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        Friend[] friend = new Friend[n];
        for (int i = 0; i < n; i++) {
            Friend f = new Friend(times[i][0], times[i][1], i);
            friend[i] = f;
        }

        Arrays.sort(friend, (a, b) -> {
            return Integer.compare(a.arr, b.arr);
        });

        PriorityQueue<Integer> empty = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            empty.add(i);
        }

        PriorityQueue<int[]> occupied = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        for (int i = 0; i < n; i++) {
            int arr = friend[i].arr;
            int dep = friend[i].dep;
            int num = friend[i].num;

            while (occupied.size() > 0 && occupied.peek()[0] <= arr) {
                int[] top = occupied.poll();
                empty.add(top[1]);
            }

            int selected = empty.poll();
            occupied.add(new int[]{dep, selected});

            if (num == targetFriend) {
                return selected;
            }
        }

        return -1;
    }

    class Friend {
        int arr;
        int dep;
        int num;

        public Friend(int _arr, int _dep, int _num) {
            arr = _arr;
            dep = _dep;
            num = _num;
        }
    }
}