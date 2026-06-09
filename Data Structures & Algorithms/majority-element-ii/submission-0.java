class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
           int count1 = 0;
        int candidate1 = 0 ;

        int count2 = 0;
        int candidate2 = 0 ;

        List<Integer> result = new ArrayList<>();

        for(int num : nums) {
            if (count1 == 0 && num != candidate2) {
                candidate1 = num;
            }else if (count2 == 0 && num != candidate1){

                candidate2 = num;
            }

            if (num == candidate1) {
            count1++;
        } else if (num == candidate2) {
            count2++;
        } else {
            count1--;
             count2--;
}

        }

        int c1 = 0, c2 = 0;

        for (int num : nums) {
            if (num == candidate1) c1++;
        else if (num == candidate2) c2++;
        }

            if (c1 > nums.length / 3) result.add(candidate1);
            if (c2 > nums.length / 3) result.add(candidate2);
            return result;
    }
}