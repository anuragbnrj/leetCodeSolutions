class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int rows = box[0].length;
        int cols = box.length;

        char[][] rotatedBox = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                rotatedBox[r][c] = box[cols - 1 - c][r];
            }
        }

        // for (int r = 0; r < rows; r++) {
        //     for (int c = 0; c < cols; c++) {
        //         System.out.print(rotatedBox[r][c] + "\t");
        //     }
        //     System.out.println();
        // }

        for (int r = rows - 1; r >= 0; r--) {
            for (int c = 0; c < cols; c++) {
                int currRow = r;
                if (rotatedBox[currRow][c] != '#') continue;

                while ((currRow + 1) < rows && rotatedBox[currRow + 1][c] == '.') {
                    char temp = rotatedBox[currRow + 1][c];
                    rotatedBox[currRow + 1][c] = rotatedBox[currRow][c];
                    rotatedBox[currRow][c] = temp;

                    currRow += 1;
                }
            }
        }
        
        return rotatedBox;
    }
}