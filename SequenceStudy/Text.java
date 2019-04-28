package SequenceStudy;

import SequenceStudy.DoubleLinkList.DoubleLinkListImpl;
import SequenceStudy.LinkList.LinkListImpl;
import SequenceStudy.SequenceArray.SequenceArrayImpl;

import java.util.Arrays;


public class Text {
    public static void main(String[] args){
        DoubleLinkListImpl doubleLinkList = new DoubleLinkListImpl();
        doubleLinkList.add(899);
        doubleLinkList.add(003);
        doubleLinkList.add("dsaf");
        doubleLinkList.remove(1);
        Object[] data = doubleLinkList.toArray();
        int size = doubleLinkList.size();
        for (int i = 0;i < size;i++){
            System.out.print(data[i] + "、");
        }
    }
}