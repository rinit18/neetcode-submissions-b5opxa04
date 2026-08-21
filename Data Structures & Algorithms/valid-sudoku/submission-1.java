class Solution {
    public boolean isValidSudoku(char[][] board) {
        // One HashSet per row/col/box (9 each) — tracks which digits
        // ('1'-'9') have already been seen in that group.
        // We only care about presence, not counts, so HashSet fits perfectly.
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        // Object arrays default every slot to null, so we must explicitly
        // create a HashSet for each of the 9 slots before using them,
        // or we'd get a NullPointerException on the first .add()/.contains().
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }

        // Single pass over every cell — check rows, cols, and boxes together
        // instead of doing three separate passes.
        for (int i = 0; i < board.length; i++) {      // i = row index
            for (int j = 0; j < board[i].length; j++) { // j = col index

                // Skip empty cells — a board doesn't need to be full to be valid.
                if (board[i][j] == '.') {
                    continue;
                }

                char val = board[i][j];

                // Flatten the (row, col) position into a single box index 0-8.
                // (i/3) picks the box "row band" (0,1,2), (j/3) picks the box
                // "col band" (0,1,2). boxRow*3 + boxCol turns that pair into
                // one number, same idea as flattening a 2D array into 1D.
                int boxIndex = (i / 3) * 3 + (j / 3);

                // If val already exists in this row, this column, OR this box,
                // we found a duplicate -> board is invalid.
                if (rows[i].contains(val) || cols[j].contains(val) || boxes[boxIndex].contains(val)) {
                    return false;
                }

                // Not a duplicate yet — record val in all three relevant sets
                // so future cells in the same row/col/box can detect it.
                rows[i].add(val);
                cols[j].add(val);
                boxes[boxIndex].add(val);
            }
        }

        // No duplicates found anywhere -> valid board.
        return true;
    }
}