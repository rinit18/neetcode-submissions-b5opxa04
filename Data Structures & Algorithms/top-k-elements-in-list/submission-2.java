class Solution {
    public int[] topKFrequent(int[] nums, int k) {
          
       HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1 );
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());

      int [] result = new int[k];
      for(int i = 0; i < k; i++){
          result[i] = pq.poll().getKey();
      }
      return result;
    }
    }

