package com.algorithmic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wenqiang
 * @date: 2019-12-16 19:53
 * Z 字形变换
 */
public class A_6 {

    public String convert(String s, int numRows) {
        if(numRows <= 1 || s.length() <= 1){
            return s;
        }
        char[][] chars = new char[numRows][s.length()];
        int col = 0;
        int row = 0;
        for(int i = 0; i < s.length(); i++){
            if(col % (numRows - 1) == 0 && row < numRows){
                chars[row++][col] = s.charAt(i);
            }else {
                chars[row--][col++] = s.charAt(i);
            }
            if(row == numRows){
                row = numRows - 2;
                col = col + 1;
            }
        }
        StringBuffer sb =  new StringBuffer();
        for(int i = 0; i < chars.length;i++){
            for(int j = 0; j < chars[i].length; j++){
                if(chars[i][j] != '\u0000'){
                    sb.append(chars[i][j]);
                }
            }
        }
        return sb.toString();
    }


    public String convert2(String s, int numRows){
        if(numRows == 1){
            return s;
        }
        List<StringBuffer> rows =  new ArrayList<>();
        for(int i = 0; i < Math.min(numRows,s.length()); i++){
            rows.add(new StringBuffer());
        }
        int currRow = 0;
        boolean goingDown = false;

        for(char c : s.toCharArray()){
            rows.get(currRow).append(c);
            if(currRow == 0 || currRow ==  numRows - 1){
                goingDown = !goingDown; //控制行数的上移和下移
            }
            currRow += goingDown ? 1 : -1;
        }
        StringBuffer ret =  new StringBuffer();
        for(StringBuffer row : rows){
            ret.append(row);
        }
        return ret.toString();
    }
}
