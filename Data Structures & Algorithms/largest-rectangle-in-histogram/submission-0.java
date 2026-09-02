class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack <Integer> stack = new Stack<>();
        int maxArea = 0 ;
        int  n = heights.length;

        for(int i = 0; i<n ; i++){

            while(!stack.empty() && heights[i] < heights[stack.peek()]){

                int poppedIndex = stack.pop();
                int height = heights[poppedIndex];

               int rightBoundary = i;
               int leftBoundary = stack.empty() ? -1 : stack.peek();

                int width =  rightBoundary - leftBoundary -1;
                 maxArea = Math.max(maxArea, height * width);
            } 

            stack.push(i);

        }

          while(!stack.empty()){

                int poppedIndex = stack.pop();
                int height = heights[poppedIndex];

               int rightBoundary = n;
               int leftBoundary = stack.empty() ? -1 : stack.peek();

                int width =  rightBoundary - leftBoundary -1;
                 maxArea = Math.max(maxArea, height * width);
            } 

         return maxArea;
    }
}
