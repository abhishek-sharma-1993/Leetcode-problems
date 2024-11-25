class Solution {
    int r,c;
    Map<String, Integer> visited;
    public int slidingPuzzle(int[][] board) {
        this.r = board.length;
        this.c = board[0].length;
        this.visited = new HashMap<>();

        StringBuilder state = new StringBuilder();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                state.append(board[i][j]);
            }
        }
        String start = state.toString();
        bfs(start, start.indexOf("0"), 0);
        return visited.getOrDefault("123450", -1);
    }

    private final int[][] dir = {
        { 1, 3 },
        { 0, 2, 4 },
        { 1, 5 },
        { 0, 4 },
        { 3, 5, 1 },
        { 4, 2 },
    };

    private void bfs(String state, int zeroPos, int moves){
        if(visited.containsKey(state) && visited.get(state) <= moves) 
            return;

        visited.put(state, moves);

        for(int nextPos: dir[zeroPos]){
            String newState = swap(state, zeroPos, nextPos);
            bfs(newState, nextPos, moves+1);
        }
    }

    private String swap(String str, int i, int j){
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}