class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[] arr = new int[n];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[src] = 0;

        for(int i = 0; i < k + 1; i++){
            boolean update = false;
            int[] temp = arr.clone();
            for(int[] flight : flights){
                int s = flight[0];
                int d = flight[1];
                int v = flight[2];
                if(temp[s] != Integer.MAX_VALUE){
                    if(temp[s] + v < arr[d]){
                        arr[d] = temp[s] + v;
                        update = true;
                    }
                }
            }
            if(update = false ) break;
        }
        return arr[dst] == Integer.MAX_VALUE ? -1 : arr[dst];


    }
}
