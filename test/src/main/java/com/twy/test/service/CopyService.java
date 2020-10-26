package com.twy.test.service;

import cn.hutool.core.util.ObjectUtil;
import com.twy.test.entity.Item;
import com.twy.test.entity.Subject;
import com.twy.test.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gongpeng
 * @date 2020/10/25 15:37
 * @description 浅拷贝、深拷贝
 */
public class CopyService {

    public static void main(String[] args) throws CloneNotSupportedException {
        List<Item> list1 = new ArrayList<>();
        Item item1 = new Item("唐万言", "杭州");
        Item item2 = new Item("王心心", "芜湖");
        list1.add(item1);
        list1.add(item2);
        List<Item> list2 = new ArrayList<>(list1);
        List<Item> list3 = new ArrayList<>();
        list3.addAll(list1);
        //使用工具类进行深拷贝,实体类需要实现Serializable接口
        List<Item> list4 = ObjectUtil.cloneByStream(list1);
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

        Subject subject = new Subject("主题");
        User user = new User("测试", "杭州", subject);
        User user2 = (User) user.clone();
        System.out.println("######################修改前######################");
        System.out.println(user);
        System.out.println(user2);
        System.out.println("######################修改后######################");
        user2.setName("测试2");
        user2.setAddress("芜湖");
        subject.setName("主题2");
        System.out.println(user);
        System.out.println(user2);
    }

}
