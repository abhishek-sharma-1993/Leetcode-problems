class Solution {
    List<Integer>[] graph;
    public List<Boolean> checkIfPrerequisite(int numCourses, 
        int[][] prerequisites, int[][] queries) {

        this.graph = new List[numCourses];
        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : prerequisites){
            graph[edge[0]].add(edge[1]);
        }

        List<Boolean> ans = new ArrayList<>();
        for(int[] query: queries){
            boolean res = dfs(new boolean[numCourses], query[0], query[1]);
            ans.add(res);
        }
        return ans;
    }
    
    private boolean dfs(boolean[] visited, int node, int target){
        if(node == target) 
            return true;

        visited[node] = true;
        boolean ans = false;

        for(int nei: graph[node]){
            if(!visited[nei]) 
                ans |= dfs(visited, nei, target);
        }

        return ans;
    }
}