class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        long next = findNextPalin(num);
        long prev = findPrevPalin(num);

        if (Math.abs(num - prev) <= Math.abs(next - num)) {
            return Long.toString(prev);
        }
        return Long.toString(next);
    }

    private long findPrevPalin(long num) {
        long beg = 0;
        long end = num;
        long ans = 0L;

        while (beg <= end) {
            long mid = beg + (end - beg) / 2;

            long palin = convertToPalin(mid);
            if (palin < num) {
                ans = palin;
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    private long findNextPalin(long num) {
        long beg = num;
        long end = (long) 1e18;
        long ans = 0L;
        while (beg <= end) {
            long mid = beg + (end - beg) / 2;

            long palin = convertToPalin(mid);
 
            if (palin > num) {
                ans = palin;
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }

        return ans;
    }

    private long convertToPalin(long num) {
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