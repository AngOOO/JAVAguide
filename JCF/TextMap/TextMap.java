package TextMap;

import java.util.*;

public class TextMap {
    public static void HashMap(){
        //key与value都可以为null
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"MJY");
        map.put(2,"ZW");
        map.put(3,"ZQN");
        map.put(4,"WSN");
        map.put(5,"LYJ");
        map.put(6,"BXG");
        map.put(null,"MXM");
        System.out.println("map数据：" + map);
        System.out.println("map数据量：" + map.size());
        System.out.println("map获取3：" + map.get(3));
        System.out.println("map所有value：" + map.values());
        System.out.println("map所有key：" + map.keySet());

        System.out.println("遍历map");
        System.out.println("1,");
        for (Map.Entry<Integer,String> e : map.entrySet()) {
            Integer key = e.getKey();
            String value = e.getValue();
            System.out.println(key + "=" + value);
        }
        System.out.println("2,");
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Integer key = iterator.next();
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }
    }

    public static void HashTable(){
        //key与value都不能为null
        Map<Integer,String> map = new Hashtable<>();
        map.put(1,"MJY");
        map.put(2,"ZW");
        map.put(3,"ZQN");
        map.put(4,"WSN");
        map.put(5,"LYJ");
        map.put(6,"BXG");
        //map.put(null,"MXM");NullPointerException
    }
    public static void TreeMap(){
        Map<Integer,String> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2) * -1;
            }
        });
        map.put(6,"BXG");
        map.put(1,"MJY");
        map.put(2,"ZW");
        map.put(5,"LYJ");
        map.put(3,"ZQN");
        map.put(4,"WSN");
        for (Map.Entry<Integer,String> e : map.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }
    }
    public static void main(String[] args) {
        //HashMap();
        //HashTable();
        TreeMap();
    }
}
