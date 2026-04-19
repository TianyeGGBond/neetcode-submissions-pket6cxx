class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 1) return heights[0];
        
        Stack<int[]> mins = new Stack<>();
        Stack<int[]> mins_back = new Stack<>();
        int[] min_scale = new int[n];

        int max_rect = 0;
        
        for(int i = 0; i < n; i++){
            while(!mins.isEmpty() && mins.peek()[0] >= heights[i]){
               mins.pop();
            }

            if(mins.isEmpty()) min_scale[i] += i + 1;
            else min_scale[i] += i - mins.peek()[1] ;

            mins.push(new int[]{heights[i], i});
        
        }

        for(int i = n-1; i >= 0; i--){
           while(!mins_back.isEmpty() && mins_back.peek()[0] >= heights[i]){
               mins_back.pop();
            }

            if(mins_back.isEmpty()) min_scale[i] += n-i;
            else min_scale[i] += mins_back.peek()[1] - i ;

            mins_back.push(new int[]{heights[i], i});
        }


        for(int i = 0; i < n; i++){
            System.out.println(min_scale[i]);
            max_rect = Math.max(max_rect, heights[i] * (min_scale[i] - 1));
        }

        return max_rect;
    }
}
