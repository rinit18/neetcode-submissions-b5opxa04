class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;

        int [] prefixsum = new int [n] ;


        prefixsum [0] = 1;
        for(int i = 1; i < n; i++){

          prefixsum[i] = prefixsum[i-1] * nums[i - 1];
            
        }


        int suffix = 1;
        for(int i = n - 1; i >=0 ; i--){

          prefixsum[i] = prefixsum[i] * suffix;

            suffix = suffix * nums[i];
        }

        return prefixsum;


    }
}  
