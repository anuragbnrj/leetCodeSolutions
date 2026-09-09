class Solution {
    public long countCommas(long n) {

        return Math.max(n - 999L, 0L) + Math.max(n - 999_999L, 0L) + Math.max(n - 999_999_999L, 0L) + Math.max(n - 999_999_999_999L, 0L) + Math.max(n - 999_999_999_999_999L, 0L); 
    }
}