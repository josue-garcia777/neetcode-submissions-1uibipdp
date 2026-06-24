class Solution {
    /*
    start from the last position of the array 
    were we are going to write but we need to compare
    the last position that each array has elements and then 
    return build in place the output. 
    [10, 20, 20, 40, 0, 0] 
    [1,2]
    */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mpos = m -1;
        int npos = n-1;

        for (int i = (m+n)-1; i >=0; i--){
            if(npos < 0){
                break;
            }

            if(mpos >= 0 && nums1[mpos] > nums2[npos]){
                nums1[i] = nums1[mpos];
                mpos--;
            }else {
                 nums1[i] = nums2[npos];
                npos--;
            }
        }
    }
}