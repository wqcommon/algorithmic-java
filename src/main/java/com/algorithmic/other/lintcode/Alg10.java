package com.algorithmic.other.lintcode;

import java.util.*;

/**
 * @author: wenqiang
 * @date: 2019-07-06 16:42
 * 10.字符串的不同排列
 */
public class Alg10 {

    public static void main(String[] args) {
        Alg10 alg10 = new Alg10();
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
            rets.add("");
            return rets;
        }
        //按字符升序排序
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        str = String.valueOf(chars);
        //DFS
        boolean[] visited = new boolean[str.length()];//存储某个字符是否被访问
        Set<String> strSet = new HashSet<>();//用于判断是否有字符串重复
        String tmpStr = "";//临时存储字符串
        DFS(str,rets,visited,strSet,tmpStr);//深度优先遍历
        return rets;
    }

    /**
     *
     * @param str
     * @param rets
     * @param visited
     * @param strSet
     * @param tmpStr
     */
    private void DFS(String str, List<String> rets, boolean[] visited, Set<String> strSet, String tmpStr) {

        if(tmpStr.length() == str.length()){
            rets.add(tmpStr);
            return;
        }
        for(int i = 0; i < str.length(); i++){
            char  c = str.charAt(i);
            if(visited[i] || (i != 0 && !visited[i-1] && c == str.charAt(i - 1))){
                /**
                 * (i != 0 && !visited[i-1] && c == str.charAt(i - 1)) == true
                 * 该判断条件用于防止首字母相同的情况
                 */
                continue;
            }
            tmpStr = tmpStr + c;
            if(strSet.contains(tmpStr)){
                continue;
            }
            strSet.add(tmpStr);
            visited[i] = true;
            DFS(str,rets,visited,strSet,tmpStr);

            tmpStr = tmpStr.substring(0,tmpStr.length() - 1);
            strSet.remove(tmpStr);
            visited[i] = false;
        }
    }
}
