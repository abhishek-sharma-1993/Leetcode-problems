class Solution {
    List<List<Integer>> ans;
    int[] candidates;
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.ans = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        Arrays.sort(candidates);
        helper(0,target,new ArrayList<>());
        return ans;
    }

    private void helper(int index, int target, List<Integer> list){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=index; i<candidates.length && target>=candidates[i]; i++){
            if(i>index && candidates[i] == candidates[i-1]) continue;

            list.add(candidates[i]);
            helper(i+1, target-candidates[i], list);
            list.remove(list.size()-1);
        }
    }
}