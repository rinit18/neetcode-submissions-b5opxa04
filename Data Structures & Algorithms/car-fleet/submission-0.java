class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
    int[][] cars = new int[n][2];
    for (int i = 0; i < n; i++) {
        cars[i][0] = position[i];
        cars[i][1] = speed[i];
    }
    
    Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));  // sort by position ascending
    
    double lastFleetTime = 0;
    int fleets = 0;
    
    for (int i = n - 1; i >= 0; i--) {
        int pos = cars[i][0];
        int spd = cars[i][1];
        double time = (target - pos) / (double) spd;  // (target - position) / speed
        if (time > lastFleetTime) {
            fleets++;
            lastFleetTime = time;
        }
    }
    
    return fleets;
    }
}
