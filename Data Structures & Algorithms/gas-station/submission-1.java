class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int sum = 0;
        int res = 0;
        for(int i = 0; i < gas.length; i++){
            int diff = gas[i] - cost[i];
            sum += diff;
            tank += diff;
            if(tank < 0){
                tank = 0;
                res = i + 1;
                continue;
            }
        }
        return sum >= 0? res : -1;
    }
}
