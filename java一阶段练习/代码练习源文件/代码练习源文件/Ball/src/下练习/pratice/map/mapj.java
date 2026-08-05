package 下练习.pratice.map;

import java.util.*;

public class mapj {
    public static void main(String[] args) {
        List<zhanghao> list = new ArrayList<>();
        List<person> list1 = new ArrayList<>();
        zhanghao zhanghao = new zhanghao("156847",56987);
        list.add(zhanghao);
        person person = new person("sda",58,"男");
        list1.add(person);
        Map<List, List> map = new HashMap<>();
        map.put(list,list1);
        System.out.println(map);
        Set<Map.Entry<List, List>> entry = map.entrySet();
        for (Map.Entry<List,List> entry1:entry){
            List list2 = entry1.getKey();
            List list3 = entry1.getValue();
            System.out.println(list2);
            System.out.println(list3);
        }

    }
}
