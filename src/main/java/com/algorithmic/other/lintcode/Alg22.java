package com.algorithmic.other.lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * lintcode 算法 22题
 */
public class Alg22 {

    public List<Integer> flatten(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0){
            return null;
        }
        List<Integer> retList = new ArrayList<>();
        Stack<NestedInteger> stack = new Stack<>();
        for(int i = nestedList.size() -1; i>=0; i--){
            stack.push(nestedList.get(i));
        }
        while (!stack.isEmpty()){
            NestedInteger in = stack.pop();
            if(in.isInteger()){
                retList.add(in.getInteger());
            }
            List<NestedInteger> nins = in.getList();
            if(nins != null && nins.size() != 0){
                for(int i = nins.size() -1; i>=0; i--){
                    stack.push(nins.get(i));
                }
            }
        }
        return retList;
    }

    public interface NestedInteger {
          public boolean isInteger();
          public Integer getInteger();
          public List<NestedInteger> getList();
    }

    private static class NInt implements NestedInteger{

        private int value;

        private List<NestedInteger> list;

        public NInt(int value,List<NestedInteger> list){
            this.value = value;
            this.list = list;
        }


        @Override
        public boolean isInteger() {
            return true;
        }

        @Override
        public Integer getInteger() {
            return value;
        }

        @Override
        public List<NestedInteger> getList() {
            return list;
        }
    }
}
