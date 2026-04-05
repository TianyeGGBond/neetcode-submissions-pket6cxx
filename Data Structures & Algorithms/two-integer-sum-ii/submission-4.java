class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++){
            for(int j = i ; j < numbers.length; j++){
                if(numbers[i] + numbers[j] == target && numbers[i] != numbers[j] ){
                    return new int[]{i + 1, j + 1};
                }
                if(numbers[i] + numbers[j] > target) break;
            }
        }
        return null;
    }
}
