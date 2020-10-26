package com.twy.test.service;

import cn.hutool.core.util.ObjectUtil;
import com.twy.test.entity.User;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author gongpeng
 * @date 2020/10/25 15:37
 * @description 浅拷贝、深拷贝
 */
public class CopyService {

    public static void main(String[] args) {
        List<User> list1 = new ArrayList<>();
        User u1 = new User("唐万言", "杭州");
        User u2 = new User("王心心", "芜湖");
        list1.add(u1);
        list1.add(u2);
        List<User> list2 = new ArrayList<>(list1);
        //使用工具类进行深拷贝
        List<User> list3 = ObjectUtil.cloneByStream(list1);
        List<User> list4 = new ArrayList<>();
        CollectionUtils.addAll(list4, new User[list1.size()]);
        Collections.copy(list4, list1);
        System.out.println("list1修改元素前——————————————————————————");
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(list4);
        System.out.println("list1修改元素后———————————————————————————");
        list1.get(0).setAddress("芜湖");
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(list4);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        //list深度拷贝
        List<String> newList = new ArrayList<>(list);
//        CollectionUtils.addAll(newList, new Integer[list.size()]);
//        Collections.copy(newList, list);
//        newList.addAll(list);
        list.set(0, "10");

        System.out.println("原list值：" + list);
        System.out.println("新list值：" + newList);
    }

}
