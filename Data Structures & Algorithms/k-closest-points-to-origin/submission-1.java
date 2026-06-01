class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if(points == null || k > points.length) return null;

        Queue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));

        for(int i = 0; i < points.length; i++){
            int[] temp = new int[2];
            temp[0] = (int)Math.pow(points[i][0], 2) + (int)Math.pow(points[i][1], 2);
            temp[1] = i;
            pq.offer(temp);
        }

        int[][] kClosest = new int[k][2];
        for(int i = 0; i < k; i++){
            int idx = pq.poll()[1];
            kClosest[i][0] = points[idx][0];
            kClosest[i][1] = points[idx][1];
        }
        
        return kClosest;
    }
}
