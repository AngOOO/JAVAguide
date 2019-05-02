package TextSet;

import Person.Person;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set中元素不可以重复
 */
public class TextSet {
    public static void HashSet(){
        Set<String> hashSet = new HashSet<>();
        hashSet.add("DMW");
        hashSet.add("LOVE");
        hashSet.add("LOVE");
        hashSet.add("ZBB");
        System.out.println(hashSet);
    }

    public static void TreeSet() {
        /*Set<String> treeSet = new TreeSet<>();
        treeSet.add("ZBB");
        treeSet.add("LOVE");
        treeSet.add("LOVE");
        treeSet.add("DMW");
        System.out.println(treeSet);*/

        //有排序时需要的方法1
//        Set<Person> personSet = new TreeSet<>(new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
        //有排序时需要的方法2：让被排序类implements Compareable<类名>
        //然后覆写compareTo方法
        Set<Person> personSet = new TreeSet<>();
        personSet.add(new Person("DMW",22));
        personSet.add(new Person("ZBB",22));
        personSet.add(new Person("张三",20));
        personSet.add(new Person("张三",20));
        System.out.println(personSet);
    }
    public static void main(String[] args) {
        //HashSet();
        TreeSet();
    }
}
