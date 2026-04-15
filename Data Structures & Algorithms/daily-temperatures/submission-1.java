class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<int[]> prev_temp = new Stack<>();
        int[] cooler_day = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            int[] cur = new int[]{temperatures[i], i};
            //not empty
            //cur is warmer
            while(!prev_temp.isEmpty() && prev_temp.peek()[0] < cur[0]){
                int[] prev = prev_temp.pop();
                cooler_day[prev[1]] = cur[1] - prev[1]; 
            }
            prev_temp.push(cur);
        }

        return cooler_day;
    }
}
