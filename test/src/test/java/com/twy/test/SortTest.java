package com.twy.test;

import com.twy.test.entity.User;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * Java中文排序及多个字段排序
 *
 * @author gongpeng
 * @date 2020/11/26 16:03
 */
public class SortTest {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User u1 = new User("王心心", "南京");
        User u2 = new User("唐万言", "杭州");
        User u3 = new User("王哈哈", "芜湖");
        User u4 = new User("测试", "虎扑");
        User u5 = new User("奥奥", "澳洲");
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        users.add(u5);
        //排序前
        System.out.println(users);
        Comparator<User> byAddress = Comparator.comparing(User::getAddress, Collator.getInstance(Locale.CHINA));
        Comparator<User> byName = Comparator.comparing(User::getName, Collator.getInstance(Locale.CHINA));
        users.sort(byAddress.thenComparing(byName));
        //排序后
        System.out.println(users);
    }
}
