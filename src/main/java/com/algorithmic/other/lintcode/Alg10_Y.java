package com.algorithmic.other.lintcode;

import java.util.*;

/**
 * @author: wenqiang
 * @date: 2019-07-06 16:42
 * 10.字符串的不同排列
 * 优化方案
 */
public class Alg10_Y {

    public static void main(String[] args) {
        Alg10_Y alg10 = new Alg10_Y();
        List<String> r1 = alg10.stringPermutation2("aabb");
        r1.stream().forEach(s ->{
            System.out.print(s + ",");
        });
        System.out.println();
    }



    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> rets = new ArrayList<>();
        if(str == null || str == ""){
            return rets;
        }
        //按字符升序排序
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        //DFS
        DFS(chars,new boolean[str.length()],new ArrayList<Character>(),rets);//深度优先遍历
        return rets;
    }

    //深度优先遍历
    private void DFS(char[] chars, boolean[] visited, List<Character> perlist, List<String> rets) {
        if(perlist.size() == chars.length){
            char[] chs = new char[perlist.size()];
            for(int i = 0; i < perlist.size(); i++){
                chs[i] = perlist.get(i).charValue();
            }
            rets.add(String.valueOf(chs));
            return;
        }
        for(int i = 0; i < chars.length; i++){
            if(visited[i] || (i > 0 && !visited[i - 1] && chars[i] == chars[i - 1])){
                continue;
            }
            visited[i] = true;
            perlist.add(chars[i]);
            DFS(chars,visited,perlist,rets);
            visited[i] = false;
            perlist.remove(perlist.size() - 1);
        }
    }
}
