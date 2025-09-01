class Solution {
    /**
     * The main method that initiates the Sudoku solving process.
     * The input board is modified in-place to contain the solution.
     *
     * @param board The 9x9 grid representing the Sudoku puzzle, with '.' for empty cells.
     */
    public void solveSudoku(char[][] board) {
        // Start the recursive solving process.
        solve(board);
    }

    /**
     * The recursive backtracking helper method.
     * It tries to fill the board and returns true if a solution is found.
     *
     * @param board The Sudoku grid.
     * @return true if the board is solved, false otherwise.
     */
    private boolean solve(char[][] board) {
        // Iterate through each cell of the board.
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Find an empty cell represented by '.'.
                if (board[row][col] == '.') {
                    // Try placing numbers '1' through '9' in the empty cell.
                    for (char num = '1'; num <= '9'; num++) {
                        // Check if the current number placement is valid.
                        if (canBePlaced(board, row, col, num)) {
                            // If valid, place the number.
                            board[row][col] = num;

                            // Recursively call solve() for the next empty cell.
                            // If the recursive call returns true, a solution was found.
                            if (solve(board)) {
                                return true;
                            } else {
                                // If not, backtrack: undo the move and try the next number.
                                board[row][col] = '.';
                            }
                        }
                    }
                    // If no number ('1'-'9') works for this cell, trigger backtracking.
                    return false;
                }
            }
        }
        // If the entire board is filled (no empty cells found), a solution is found.
        return true;
    }

    /**
     * Checks if a given number can be placed in a specific cell without
     * violating Sudoku rules.
     *
     * @param board The Sudoku grid.
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     * @param num The character ('1'-'9') to check.
     * @return true if the placement is valid, false otherwise.
     */
    private boolean canBePlaced(char[][] board, int row, int col, char num) {
        // Check for the same number in the same row and column.
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false; // Check row
            }
            if (board[i][col] == num) {
                return false; // Check column
            }
        }

        // Check for the same number in the 3x3 sub-box.
        int boxStartRow = (row / 3) * 3;
        int boxStartCol = (col / 3) * 3;

        for (int r = boxStartRow; r < boxStartRow + 3; r++) {
            for (int c = boxStartCol; c < boxStartCol + 3; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }

        // If all checks pass, the number can be placed.
        return true;
    }
}