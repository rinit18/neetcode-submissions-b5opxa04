class TimeMap {

    private Map<String, List<String[]>> map;

    public TimeMap() {
        map = new HashMap<>();
}
    
    public void set(String key, String value, int timestamp) {
    List<String[]> list = map.computeIfAbsent(key, k -> new ArrayList<>());
    list.add(new String[]{value, String.valueOf(timestamp)});
}
    public String get(String key, int timestamp) {
        
        List<String[]> list = map.get(key);
        if (list == null) return "";

        int low = 0, high = list.size() - 1;
        String res = "";

        while(low <= high){

            int mid = low + (high - low)/ 2;
             int midTime = Integer.parseInt(list.get(mid)[1]);

              if (midTime <= timestamp) {
            res = list.get(mid)[0];   // candidate found
            low = mid + 1;            // look for a better (later) one
        } else {
            high = mid - 1;
            }
        }

        return res;
    }
}
