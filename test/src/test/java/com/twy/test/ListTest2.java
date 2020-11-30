package com.twy.test;

import com.twy.test.entity.TestEntity;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 五种单个List去重方式
 *
 * @author gongpeng
 * @date 2020/11/16 15:59
 */
public class ListTest2 {

    /**
     * 使用两个for循环实现List去重(有序)
     *
     * @param list
     */
    public static List removeDuplicationBy2For(List<TestEntity> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                }
            }
        }
        return list;
    }

    /**
     * 使用List集合contains方法循环遍历(有序)
     *
     * @param list
     */
    public static List removeDuplicationByContains(List<TestEntity> list) {
        List<TestEntity> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            boolean isContains = newList.contains(list.get(i));
            if (!isContains) {
                newList.add(list.get(i));
            }
        }
        list.clear();
        list.addAll(newList);
        return list;
    }

    /**
     * 使用HashSet实现List去重(无序)
     *
     * @param list
     */
    public static List removeDuplicationByHashSet(List<TestEntity> list) {
        HashSet set = new HashSet(list);
        //把List集合所有元素清空
        list.clear();
        //把HashSet对象添加至List集合
        list.addAll(set);
        return list;
    }

    /**
     * 使用TreeSet实现List去重(有序)
     *
     * @param list
     */
    public static List removeDuplicationByTreeSet(List<TestEntity> list) {
        TreeSet set = new TreeSet(list);
        //把List集合所有元素清空
        list.clear();
        //把HashSet对象添加至List集合
        list.addAll(set);
        return list;
    }

    /**
     * 使用java8新特性stream实现List去重(有序)
     *
     * @param list
     */
    public static List removeDuplicationByStream(List<TestEntity> list) {
        List newList = list.stream().distinct().collect(Collectors.toList());
        return newList;
    }

    public static void main(String args[]) {
        List<TestEntity> list1 = new ArrayList<>();
        List<TestEntity> list2 = new ArrayList<>();
        List<TestEntity> list3 = new ArrayList<>();
        List<TestEntity> list4 = new ArrayList<>();
        List<TestEntity> list5 = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            int value = random.nextInt(100000);
            int index = random.nextInt(100);
            TestEntity entity = new TestEntity(value, "测试" + index);
            list1.add(entity);
            list2.add(entity);
            list3.add(entity);
            list4.add(entity);
            list5.add(entity);
        }
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        removeDuplicationByHashSet(list1);
        endTime = System.currentTimeMillis();
        System.out.println("使用HashSet实现List去重时间:" + (endTime - startTime) + "毫秒");
        startTime = System.currentTimeMillis();
        removeDuplicationByTreeSet(list2);
        endTime = System.currentTimeMillis();
        System.out.println("使用TreeSet实现List去重时间:" + (endTime - startTime) + "毫秒");
        startTime = System.currentTimeMillis();
        removeDuplicationByStream(list3);
        endTime = System.currentTimeMillis();
        System.out.println("使用java8新特性stream实现List去重:" + (endTime - startTime) + "毫秒");
        startTime = System.currentTimeMillis();
        removeDuplicationBy2For(list4);
        endTime = System.currentTimeMillis();
        System.out.println("使用两个for循环实现List去重:" + (endTime - startTime) + "毫秒");
        startTime = System.currentTimeMillis();
        removeDuplicationByContains(list5);
        endTime = System.currentTimeMillis();
        System.out.println("使用List集合contains方法循环遍历:" + (endTime - startTime) + "毫秒");
    }
}
