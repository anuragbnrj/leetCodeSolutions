class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        // verify rows
        for (int r = 0; r < N; r++) {
            Set<Character> stt = new HashSet<>();
            for (int c = 0; c < N; c++) {
                if (board[r][c] != '.') {
                    if (stt.contains(board[r][c])) {
                        return false;
                    }

                    stt.add(board[r][c]);
                }
            }
        }

        // verify columns
        for (int c = 0; c < N; c++) {
            Set<Character> stt = new HashSet<>();
            for (int r = 0; r < N; r++) {
                if (board[r][c] != '.') {
                    if (stt.contains(board[r][c])) {
                        return false;
                    }

                    stt.add(board[r][c]);
                }
            }
        }

        // verify boxes
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                Set<Character> stt = new HashSet<>();
                for (int r = 3 * i; r < 3 * i + 3; r++) {
                    for (int c = 3 * j; c < 3 * j + 3; c++) {
                        if (board[r][c] != '.') {
                            if (stt.contains(board[r][c])) {
                                return false;
                            }

                            stt.add(board[r][c]);
                        }
                    }
                }

            }
        }

        return true;    
    }
}