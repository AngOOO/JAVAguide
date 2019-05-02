package TextList;

import java.util.LinkedList;
import java.util.List;

public class TextList {
    public static void main(String[] args) {
        /*//延时初始化，第一次增加元素时初始化为10
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(1,999);
        System.out.println(list);
        //初始化为自定义的大小，一般最好大于10
        List<Integer> list1 = new ArrayList<>(15);
        list1.add(2019);
        System.out.println(list1);
        //参数可为collection
        List<Integer> list2 = new ArrayList<>(list);
        list2.addAll(list1);
        System.out.println(list2);

        System.out.println("list是否为空：" + list.isEmpty());
        System.out.println("list是否包含999：" + list.contains(999));
        System.out.println("list2是否包含list：" + list2.containsAll(list));
        System.out.println("删除list2中“2019”元素：" + list2.remove("2019"));
        //remove()参数本可以为下标或是元素，但当元素为数字时，无法识别是元素还是下标
        System.out.println("获取list下标为2的元素：" + list.get(2));
        System.out.println("修改list1中元素：" + list1.set(0,1997));
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(Arrays.toString(list1.toArray()));
        System.out.println(Arrays.toString(list2.toArray()));*/

/*//        Person.Person per1 = new Person.Person("张三",20);
//        Person.Person per2 = new Person.Person("李四",22);
        List<Person.Person> personList = new ArrayList<>();
        personList.add(new Person.Person("张三",20));
        personList.add(new Person.Person("李四",22));
        for (Person.Person p : personList) {
            System.out.println(p);
        }
        System.out.println("是否存在“李四”：" +
                personList.contains(new Person.Person("李四",22)));*/

        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        ((LinkedList<String>) list).addFirst("DMW");
        ((LinkedList<String>) list).addLast("ZBB");
        System.out.println(list);
    }
}
