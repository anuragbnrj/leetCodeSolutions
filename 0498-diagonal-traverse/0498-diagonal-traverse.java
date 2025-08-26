class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int r, c = 0, sum, i, j, k, ctr = 0;
        r = matrix.length;
        if(r>0){c = matrix[0].length;}
        int arr[] = new int[r*c];
        sum = r + c - 2;
        for(k = 0; k<=sum ; k++){
            
            if(k%2 == 1){
                for(i = 0; i<r; i++){
                    for(j = 0; j<c; j++){
                        if(i+j == k){
                            arr[ctr++] = matrix[i][j];
                        }
                    }
                }
            }
            
            if(k%2 == 0){
                for(i = r-1; i>=0; i--){
                    for(j = c-1; j>=0; j--){
                        if(i+j == k){
                            arr[ctr++] = matrix[i][j];
                        }
                    }
                }
            }
            
        } 
        return arr;
    }
}