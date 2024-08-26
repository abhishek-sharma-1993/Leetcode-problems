class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums,0, nums.length-1);
    }

    private int[] mergeSort(int[] nums, int start, int end){
        if(start==end) return new int[]{nums[start]};

        int mid = (start+end)/2;
        int[] firstHalf = mergeSort(nums, start, mid);
        int[] secHalf = mergeSort(nums, mid+1, end);
        return merge(firstHalf, secHalf);
    }

    private int[] merge(int[] a, int[] b){
        int n = a.length;
        int m = b.length;
        int l=0,r=0,i=0;
        int[] merged = new int[n+m];

        while(l<n && r<m){
            if(a[l]<b[r])
                merged[i++] = a[l++];
            else
                merged[i++] = b[r++];
        }

        while(l<n){
            merged[i++] = a[l++];
        }
        while(r<m){
            merged[i++] = b[r++];
        }

        return merged;
    }
}