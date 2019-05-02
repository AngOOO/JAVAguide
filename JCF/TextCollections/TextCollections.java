package TextCollections;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextCollections {
    public static void TextCollections1() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "MJY", "MXM", "ZW");
        System.out.println(list);
        System.out.println("列表反转->");
        Collections.reverse(list);
        System.out.println(list);
    }

    public static void TextCollections2() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        Collections.addAll(list1, "JAVA", "C", "C++");
        System.out.println("list1:" + list1);
        Collections.addAll(list2, null, null, null);
        System.out.println("after   list2:" + list2);
        Collections.copy(list2, list1);
        System.out.println("before  list2:" + list2);

    }

    public static void TextCollections3() {
        //创建空链表
        // List<String> list = Collections.emptyList();
        List<String> data = new ArrayList<>();
        Collections.addAll(data, "java", "c", "c++");
        //创建不可修改的集合
        List<String> list = Collections.unmodifiableList(data);
        //UnsupportedOperationException
        //Collections.addAll(list,"666");
        System.out.println(list);
    }

    public static void TextCollections4() {
        //获取线程安全的集合
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        Collections.addAll(list, "JAVA", "C++", "C");
        //SynchronizedRandomAccessList
        System.out.println(list.getClass());
        list.forEach((s) -> System.out.print(s + "、"));
        list.forEach(System.out::println);
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    public static void TextCollections5() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Java", "c", "c++", "JavaScript");
        //通过Stream筛选集合中数据
        List<String> resultList = list.stream().
                filter((s) -> s.contains("Java")).
                collect(Collectors.toList());
        long count = list.stream().
                filter((s) -> s.contains("Java")).
                count();
        System.out.println(resultList + ":" + count);
        //通过Stream并行流处理数据
        List<String> resultList1 = list.stream().
                //并行流
                        parallel().
                        map((s) -> {
                            if (s.contains("Java")) {
                                s = s.toLowerCase();
                            }
                            return s;
                        }).
                        collect(Collectors.toList());
        System.out.println(resultList1);
    }

    public static void TextCollections6() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Java","C","C++","Python","JavaScript","PHP");
        List<String> list1 = list.stream().
                skip(1).//跳过数据量
                filter((s)->s.contains("J")||s.contains("C")).
                limit(2).//取出最大数据
                collect(Collectors.toList());
        System.out.println(list1);
    }

    public static void main(String[] args) {
        //TextCollections1();
        //TextCollections2();
        //TextCollections3();
        //TextCollections4();
        //TextCollections5();
        TextCollections6();
    }
}
