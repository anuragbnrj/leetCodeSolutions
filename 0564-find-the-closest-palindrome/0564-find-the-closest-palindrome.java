class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        long next = findNextPalin(num);
        long prev = findPrevPalin(num);

        System.out.println("next: " + next);
        System.out.println("prev: " + prev);

        if (Math.abs(num - prev) <= Math.abs(next - num)) {
            return Long.toString(prev);
        }
        return Long.toString(next);
    }

    private long findPrevPalin(long num) {
        long beg = 0;
        long end = num;

        while (beg < end) {
            long mid = beg + (end - beg) / 2;

            long palin = convertToPalin(mid);
            if (palin < num) {
                beg = mid + 1;
            } else {
                end = mid;
            }
        }

        return convertToPalin(beg - 1);
    }

    private long findNextPalin(long num) {
        long beg = num;
        long end = (long) 1e18;

        while (beg < end) {
            long mid = beg + (end - beg) / 2;
            long palin = convertToPalin(mid);
 
            if (palin <= num) {
                beg = mid + 1;
            } else {
                end = mid;
            }
        }

        return convertToPalin(beg);
    }

    private long convertToPalin(long num) {
        // System.out.println(num);
        
        char[] arr = Long.toString(num).toCharArray();
        int n = arr.length;
        int l = (n - 1) / 2;
        int r = n / 2;

        while (l >= 0) {
            arr[r] = arr[l];
            l--;
            r++;
        }

        return Long.parseLong(new String(arr));
    }
}