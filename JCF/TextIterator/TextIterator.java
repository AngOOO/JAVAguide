package TextIterator;

import java.util.*;

public class TextIterator {
    public static void main(String[] args) {
        /*List<String> data = new ArrayList<>();
        data.add("And");
        data.add("B");
        data.add("C");
        data.add("D");
        Iterator<String> iterator = data.iterator();
        *//*while(iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }*//*
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
            if (str.startsWith("A")){
                iterator.remove();
            }
        }
        System.out.println(data);

        ListIterator<String> listIterator = data.listIterator();
        System.out.println("正向输出：");
        while (listIterator.hasNext()){
            String str = listIterator.next();
            System.out.println(str);
        }
        System.out.println("逆向输出：");
        while (listIterator.hasPrevious()){
            String str = listIterator.previous();
            System.out.println(str);
        }*/
        Vector<Integer> data = new Vector<>();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        Enumeration<Integer> enumeration = data.elements();
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
        for (int i : data) {
            System.out.println(i);
        }
    }
}
