class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0;

        while(l < n){
            while(l > 0 && numbers[l] == numbers[l-1]) l++;

            int find = target - numbers[l];
            System.out.println(find);

            for(int j = n-1; j > l; j--){
                while(l < j && numbers[j] == numbers[l]) j--;
                if(numbers[j] < find) break;
                if(numbers[j] == find) return new int[]{l+1, j+1};
            }
            l++;
        }
        return null;
    }
}
