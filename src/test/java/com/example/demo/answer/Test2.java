package com.example.demo.answer;
import java.util.*;

/**
 * 给定一个元素个数为N的集合（其中元素互不相同），在其中选择M个元素组成子集，共有多少种选法。
 * 举例：输入[A,B,C] ，M=2，输出[[A,B],[A,C],[B,C]]
 *
 * createTime：2020-10-23 10:56
 */
public class Test2 {

    public static void main(String[] args) {
        List<List<String>> result = new ArrayList<>();
        List<String> arr = Arrays.asList("A", "B", "C", "D", "E", "F");
        getAll(result, arr, null, 0, 2);
        System.out.println(result);
    }
    /**
     * 获取所有的序列
     * @param result      结果
     * @param src         原序列值
     * @param sequence    当前的序列
     * @param index       在原序列的位置
     * @param sequenceNum 序列的长度
     */
    public static void getAll(List<List<String>> result, List<String> src, List<String> sequence, int index, int sequenceNum) {
        if (src.size() < sequenceNum) {
            return;
        }
        if (sequence == null) {
            sequence = new ArrayList<>();
        }
        if (0 == sequenceNum) {
            result.add(new ArrayList<>(sequence));
            return;
        }
        for (int i = index; i <= src.size() - sequenceNum; i++) {
            sequence.add(src.get(i));
            getAll(result, src, sequence, i + 1, sequenceNum - 1);
            sequence.remove(sequence.size() - 1);
        }
    }


    /**
     * 1、给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
     * 找出那个只出现了一次的元素。如输入: [4,1,2,1,2]，输出: 4
     * @param arr 非空整数数组
     * @return 只出现了一次的元素
     */
    public static int findOnlyOne(int[] arr) {
        int result = 0;
        for (int value : arr) {
            result ^= value;
        }
        return result;
    }

}
