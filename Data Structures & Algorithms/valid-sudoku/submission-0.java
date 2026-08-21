class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet [9];
        HashSet<Character>[] cols  = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

    for (int i = 0; i < 9; i++) {
    rows[i] = new HashSet <Character>();
    cols[i] = new HashSet <Character>();
    boxes[i] = new HashSet <Character>();


         }

         for(int i =0; i < board.length; i++){

            for(int j = 0; j < board[i].length; j++){

                if (board[i][j] == '.') {
                    continue;
                }

                char val = board[i][j];
                int boxIndex = (i / 3) * 3 + (j / 3);

                if(rows[i].contains(val) || cols[j].contains(val) || boxes[boxIndex].contains(val) ){

                    return false;
                }

                rows[i].add(val);
                cols[j].add(val);
                boxes[boxIndex].add(val);


            }

         }

         return true;
    }
}
