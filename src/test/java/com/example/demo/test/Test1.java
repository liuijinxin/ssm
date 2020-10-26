package com.example.demo.test;
import java.util.*;
/**
 * 给定一个没有重复数字的序列，返回所有的可能全排列
 * 示例
 * 输入：[1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * createTime：2020-10-23 10:56
 */
public class Test1 {

    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }

    private static List<List<Integer>> permute(int[] numbers){
        List<List<Integer>> resultList = new ArrayList<>();
        generate(numbers,new Stack<>(),resultList);
        return resultList;
    }

    private static void generate(int[] numbers, Stack<Integer> usedStack, List<List<Integer>> resultList){
        //判断当前栈的长度是否等于数组的长度，如果是，则证明当前数字组合完成，跳出方法
        if(usedStack.size() == numbers.length) {
            //将栈的元素放到集合中
            List<Integer> list = new ArrayList<>(usedStack);
            //将集合放入结果集中
            resultList.add(list);
            return;
        }
        for(int i = 0; i < numbers.length; i++){
            //取出数字，作为当前数字
            int curNumber = numbers[i];
            //判断栈中是否有该数字
            if (!usedStack.contains(curNumber)) {
                //将数字放到栈中
                usedStack.push(curNumber);
                //调用递归方法
                generate(numbers,usedStack,resultList);
                //将最后添加进去的数字移除
                usedStack.pop();
            }
        }
    }

}
