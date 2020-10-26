package com.example.demo.test;

import java.util.*;

/**
 * 给定一个元素个数为N的集合（其中元素互不相同），在其中选择M个元素组成子集，共有多少种选法。
 * 举例：输入[A,B,C] ，M=2，输出[[A,B],[A,C],[B,C]]
 *
 * createTime：2020-10-23 10:56
 */
public class Test2 {

    public static void main(String[] args) {
        System.out.println("请输入一个元素集合（其中元素互不相同），以,隔开：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        List<String> list = new ArrayList<>();
        if (str.contains(",")) {
            String[] split = str.split(",");
            list = Arrays.asList(split);
        }
        System.out.println("请输入选择其中的n个元素作为子集：");
        Scanner scanner1 = new Scanner(System.in);
        int sum = scanner1.nextInt();
        List<List<String>> compose = compose(list, sum);
        System.out.println(compose);
    }

    private static List<List<String>> compose(List<String> list, int sum){
        List<List<String>> resultList = new ArrayList<>();
        //如果传过来集合元素个数大于等于选取个数，才做组合操作
//        if (list != null && list.size() >= sum && sum > 0) {
            generate(list,new Stack<>(),resultList,sum);
//        }
        return resultList;
    }

    private static void generate(List<String> list, Stack<String> usedStack, List<List<String>> resultList,int sum){
        //判断当前栈的长度是否等于规定长度，如果是，则证明当前组合完成，跳出方法
        if(usedStack.size() == sum) {
            //将栈的元素放到集合中
            List<String> list1 = new ArrayList<>(usedStack);
            //将集合放入结果集中
            resultList.add(list1);
            return;
        }
        for(int i = 0; i < list.size(); i++){
            //取出字符，作为当前字符
            String s = list.get(i);
            //判断栈中是否有该字符
            if (!usedStack.contains(s)) {
                //将字符放到栈中
                usedStack.push(s);
                //调用递归方法
                generate(list,usedStack,resultList,sum);
                //将最后添加进去的字符移除
                usedStack.pop();
            }
        }
    }



}
