class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;

        if(nums1.length > nums2.length){
            A = nums2;
            B = nums1;
        }

        int m = A.length;
        int n = B.length;
        int total = m + n;
        int pre_num = total /2;
        
        //select mid numbers in A(length m)
        int l = 0, r = m;
        int A_left = 0, B_left = 0, A_right = 0, B_right = 0;
        while(l <= r){
            int i = l + (r - l)/2;
            int j = pre_num - i;

            A_left = (i == 0)? Integer.MIN_VALUE : A[i - 1];
            B_left = (j == 0)? Integer.MIN_VALUE : B[j - 1];
            A_right = (i == m)? Integer.MAX_VALUE : A[i];
            B_right = (j == n)? Integer.MAX_VALUE : B[j];

            if(A_left <= B_right && B_left <= A_right){
                double result_med = 0.0;
                if(total % 2 == 1){
                    result_med = Math.min(A_right, B_right);
                }else{
                    int left = Math.max(A_left, B_left);
                    int right = Math.min(A_right, B_right);
                    result_med = (left+right)/2.0;
                }
                return result_med;
            }

            if(A_left > B_right){
                r = i - 1;
            }else{
                l = i + 1;
            }
        }

        return -1.0;
    }
}
