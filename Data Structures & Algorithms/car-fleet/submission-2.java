class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int num = position.length;
        PriorityQueue<float[]> cars_q = new PriorityQueue<>((a,b) -> Float.compare(b[1] , a[1]));

        for(int i = 0; i < num; i++){
            int cur_p = position[i];
            int cur_s = speed[i];
            float time = (float)(target - cur_p) / cur_s;
            cars_q.add(new float[]{time, (float)cur_p});
        }

        int fleet_num = 0;
        float prev = 0;
        while(!cars_q.isEmpty()){
            float cur = cars_q.poll()[0];
            if(prev < cur){
                fleet_num++;
                prev = cur;
            }
        }
        return fleet_num;
    }
} 