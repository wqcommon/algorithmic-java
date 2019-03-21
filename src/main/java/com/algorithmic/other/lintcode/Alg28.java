package com.algorithmic.other.lintcode;

/**
 * lintcode 第28题
 *  搜索二维矩阵
 *
 *  写出一个高效的算法来搜索 m × n矩阵中的值。
 *  这个矩阵具有以下特性：
 *  每行中的整数从左到右是排序的。
 *  每行的第一个数大于上一行的最后一个整数。
 */
public class Alg28 {


    public static void main(String[] args) {
        int[][] matrix = {{1,8,15,22,29,35,37,39,44,50,57,60,61,62,69,70,71,78,80},{96,113,137,150,162,183,193,203,222,243,255,279,301,312,324,344,359,381,397},{407,417,428,453,469,482,498,521,537,553,564,575,592,613,634,658,675,693,714},{738,761,775,785,795,812,833,850,868,890,910,934,955,966,976,996,1014,1037,1052},{1073,1085,1096,1121,1135,1159,1182,1196,1210,1221,1241,1262,1279,1298,1318,1330,1347,1365,1386},{1398,1423,1444,1459,1483,1507,1517,1528,1542,1558,1568,1583,1605,1630,1641,1651,1665,1690,1714}};
        System.out.println(searchMatrix(matrix,1888));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int rS = 0;
        int rE = matrix.length - 1;
        while (rS < rE){
            if(matrix[(rE + rS)/2][0] > target){
                rE = (rE + rS)/2 - 1;
            }else if(matrix[(rE + rS)/2][0] < target){
                rS = (rE + rS)/2 + 1;
            }else {
                //相等
                return true;
            }
        }
        if(matrix[rS][0] > target && rS > 0 && matrix[rS - 1][0] <= target){
            rS = rS - 1;
        }
        if(matrix[rS][0] == target){
            return true;
        }else if(matrix[rS][0] > target){
            return false;
        }
        //否则 rs是目标行
        int colS = 0;
        int colE = matrix[rS].length - 1;
        while (colS < colE){
            if(matrix[rS][(colS + colE)/2] < target){
                colS = (colS + colE) / 2 + 1;
            }else if(matrix[rS][(colS + colE)/2] > target){
                colE = (colS + colE) / 2 - 1;
            }else {
                return true;
            }
        }
        if(matrix[rS][colS] == target){
            return true;
        }
        return false;
    }


    /**
     * 逻辑上转换为一个有序数组
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0){
            return false;
        }

        if(matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        int start = 0, end = row * column - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int number = matrix[mid / column][mid % column];
            if(number == target){
                return true;
            }else if(number > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return false;

    }
}
