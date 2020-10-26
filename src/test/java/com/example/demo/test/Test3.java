package com.example.demo.test;

import java.util.*;

/**
 * 有偶数个数相同，需要找出不同的那个数时，比如：2，3，4，4，3，5，5，6，6，7，7；找出来就是 2
 *
 * createTime：2020-10-23 10:57
 */
public class Test3 {

    public static void main(String[] args) {
        int[] arr = {2,3,4,4,3,5,5,6,6,7,7,10,50,80,50,12};
        List<Integer> onlyOne = findOnlyOne(arr);
        System.out.println(onlyOne);
//        int one = findOne(arr);
//        System.out.println(one);
    }

    private static List<Integer> findOnlyOne(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num,map.get(num)+1);
            } else {
                map.put(num,1);
            }
        }
        List<Integer> list = new ArrayList<>();
        map.forEach((num,total) -> {
            if (total == 1) {
                list.add(num);
            }
        });
        return list;
    }

    /**
     * 1、给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
     * 找出那个只出现了一次的元素。如输入: [4,1,2,1,2]，输出: 4
     * @param arr 非空整数数组
     * @return 只出现了一次的元素
     */
    private static int findOne(int[] arr) {
        int result = 0;
        for (int value : arr) {
            result ^= value;
        }
        return result;
    }


}
