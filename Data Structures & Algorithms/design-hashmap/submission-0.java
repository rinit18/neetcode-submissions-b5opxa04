class MyHashMap {

    private List<Integer[]> map;

    public MyHashMap() {

        map = new ArrayList<>();
    }

    public void put(int key, int value) {
        for(Integer[] pair : map){
            if(pair[0] == key){
                pair[1] = value;
                return;
            }

        }
        map.add(new Integer[]{key, value});
        

    }

    public int get(int key) {
        
        for(Integer[] pair : map){
            if(pair[0] == key){
                return pair[1];
            }

        }
        return -1;

    }

    public void remove(int key) {
        for(Integer[] pair : map){
            if(pair[0] == key){
                map.remove(pair);
                return;
            }

        }

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */