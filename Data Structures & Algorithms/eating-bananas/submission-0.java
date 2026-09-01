class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int maxPile = Arrays.stream(piles).max().getAsInt();

        int low = 1, high = maxPile;  // what's high?
    while (low < high) {
        int mid = low + (high - low) / 2;
        if (canEatAll(piles, h, mid)) {
            high = mid;  // fill in
        } else {
            low = mid+1;   // fill in
        }
    }
    return low;
    }

    boolean canEatAll(int[] piles, int h, int k) {
        long totalHours = 0;
        for (int p : piles)     {
            totalHours += (p + k - 1) / k;
        }
        return totalHours <= h;
    }
}
