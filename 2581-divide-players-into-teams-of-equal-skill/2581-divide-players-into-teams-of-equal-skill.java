class Solution {
    public long dividePlayers(int[] skill) {
        int[] freq = new int[1001];
        int totalSkill = 0;

        for(int num : skill){
            totalSkill += num;
            freq[num]++;
        }
        int half = skill.length/2;

        if(totalSkill % half != 0) return -1;

        int targetSkill = totalSkill / half;
        long chemistry = 0;
        for(int i=0; i<skill.length; i++){
            int pair = targetSkill-skill[i];
            if(freq[pair] != 0){
                chemistry += pair*skill[i]*1l;
                freq[pair]--;
            }else{
                return -1;
            }
        }
        return chemistry/2;
    }
}