class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left=0;
        int right=0;
        int idx=0;
        int[] result = new int[m+n];
        while(left<m && right<n){
            if(nums1[left]<=nums2[right]){
                result[idx]=nums1[left];
                left++;
                idx++;
            }else if(nums1[left]>nums2[right]){
                result[idx]=nums2[right];
                right++;
                idx++;
            }
        }
        while(left<m){
            result[idx]=nums1[left];
            left++;
            idx++;
        }
        while(right<n){
            result[idx]=nums2[right];
            right++;
            idx++;
        }
        for(int i =0;i<m+n;i++){
            nums1[i] = result[i];
        }
    }
}