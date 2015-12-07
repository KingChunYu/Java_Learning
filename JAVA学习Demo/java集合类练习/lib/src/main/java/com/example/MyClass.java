package com.example;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//集合练习
public class MyClass {
    public static void main(String args[]) {
        //List +Iterator  练习
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("c");
        list.add("d");
        list.add("e");
        list.remove(0);
        //Iterator 简单使用
        Iterator<String> iter = list.iterator();

        while (iter.hasNext()) {
            String str = iter.next();
            if ("B".equals(str)) {
                iter.remove();
            } else {
                System.out.println(str);
            }
        }
        //map的简单使用
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "xiaoyu");
        map.put("key2", "xiaomingg");

        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
}
