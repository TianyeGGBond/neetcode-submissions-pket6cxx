class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
         int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>(); // 存储下标

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex; // 当前暖和日 - 之前的日子
            }
            stack.push(i); // 当前的日子作为“等待升温”的候选
        }

        // 没有升温的保持 0
        return res;
    }
}
