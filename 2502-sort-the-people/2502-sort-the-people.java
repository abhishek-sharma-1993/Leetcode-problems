class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Pair[] list = new Pair[n];
        for(int i=0; i<n; i++){
            list[i] = new Pair(names[i],heights[i]);
        }

        Arrays.sort(list, (a,b)->b.height-a.height);
        String[] ans = new String[n];
        for(int i=0; i<n; i++){
            ans[i] = list[i].name;
        }
        return ans;
    }
}

class Pair{
    String name;
    int height;

    Pair(String name, int height){
        this.name = name;
        this.height = height;
    }
}