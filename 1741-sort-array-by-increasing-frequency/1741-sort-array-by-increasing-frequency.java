class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Integer[] arr = new Integer[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i] = nums[i];
        } 

        Arrays.sort(arr, (a,b) -> {
            if(freq.get(a) == freq.get(b)){
                return b-a;
            }else{
                return freq.get(a)-freq.get(b);
            }
        });

        int[] ans = new int[nums.length];
        for(int i=0; i<ans.length; i++){
            ans[i] = arr[i];
        }
        return ans;
    }
}

