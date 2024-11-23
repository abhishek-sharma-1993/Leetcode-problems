class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int r = box.length;
        int c = box[0].length;
        char[][] rotate = new char[c][r];

        for(int i=0; i<c; i++){
            for(int j=0; j<r; j++){
                rotate[i][j] = box[r-1-j][i];
            }
        }

        for(int col=0; col<r; col++){
            int row = c-1;
            while(row>=0){
                int currRow = row;
                while(currRow<c
                    && rotate[currRow][col] == '#' 
                    && currRow+1<c 
                    && rotate[currRow+1][col] == '.'){
                        rotate[currRow+1][col] = rotate[currRow][col];
                        rotate[currRow][col] = '.';
                    currRow++;
                }
                row--;
            }
        }
        return rotate;
    }
}

// [["#","#","*",".","*","."],
// ["#","#","#","*",".","."],
// ["#","#","#",".","#","."]]

// # # #
// # # #
// . # *
// # * .
// . . *
// # . .