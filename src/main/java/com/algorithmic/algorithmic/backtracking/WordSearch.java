package com.algorithmic.algorithmic.backtracking;

/**
 * 单词搜索
 * 描述:
 * 给出一个二维的字母板和一个单词，寻找字母板网格中是否存在这个单词。
 * 单词可以由按顺序的相邻单元的字母组成，其中相邻单元指的是水平或者垂直方向相邻。每个单元中的字母最多只能使用一次。
 * 样例
 * 给出board =
 *
 * [
 *
 *  "ABCE",
 *
 *  "SFCS",
 *
 *  "ADEE"
 *
 * ]
 *
 * word = "ABCCED"， ->返回 true,
 * word = "SEE"，-> 返回 true,
 * word = "ABCB"， -> 返回 false.
 *
 */
public class WordSearch {


    public static void main(String[] args) {

    }

    private static boolean exist(char[][] board, String word) {
        // write your code here
        if(board == null || board.length == 0 || word == null || word.length() == 0){
            return false;
        }
        RNode head = null;
        char c = word.charAt(0);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == c){
                    RNode node = new RNode(i,j);
                    if(head != null){
                        node.next = head;
                    }
                    head = node;
                }
            }
        }
        if(head == null){
            return  false;
        }
        while (head != null){

        }
        return false;

    }

    private static class RNode{
        int i;
        int j;
        RNode next;
        RNode(int i,int j){
            this.i = i;
            this.j = j;
        }

    }
}
