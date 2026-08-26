class Solution {
    public int maxArea(int[] heights) {
        
        int maxAreaa = 0;
        int i = 0;
        int j = heights.length-1;
        

        while(i < j){

            int area = (j - i) * Math.min(heights[i], heights[j]);

            maxAreaa = Math.max(area, maxAreaa);

            if(heights[i] < heights[j]){
                    i++;
            }

            else{
                j--;
            }
           

        }
        return maxAreaa;
    }
}
