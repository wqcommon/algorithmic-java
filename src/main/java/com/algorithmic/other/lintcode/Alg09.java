package com.algorithmic.other.lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wenqiang
 * @date: 2019-05-31 18:11
 */
public class Alg09 {


    public List<String> fizzBuzz(int n) {
        // write your code here
        List<String> retList = new ArrayList<String>(n);
        for(int i = 1; i <= n; i++){

            if(i % 3 != 0 && i % 5 != 0){
                retList.add(String.valueOf(i));
            }else {
                String str = i % 15 == 0?"fizz buzz": i%3==0?"fizz":"buzz";
                retList.add(str);
            }
        }
        return retList;
    }
}
