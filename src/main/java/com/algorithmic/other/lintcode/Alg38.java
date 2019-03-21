package com.algorithmic.other.lintcode;

public class Alg38 {

    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        if(matrix[0] == null || matrix[0].length == 0){
            return 0;
        }
        int r = matrix.length;
        int c = matrix[0].length;

        int x = r - 1;
        int y = 0;
        int count = 0;
        while (x >= 0 && y < c){
            if(matrix[x][y] == target){
                count++;
                x--;
                y++;
            }else if(matrix[x][y] > target){
                x--;
            }else {
                y++;
            }
        }
        return count;
    }
}
