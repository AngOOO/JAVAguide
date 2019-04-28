package SequenceStudy.LinkList;

import SequenceStudy.SequenceArray.Sequence;

public class LinkListImpl implements Sequence {
    private class Node{
        Object data;
        Node next;

        public Node(Object data){
            this.data = data;
        }
        public Node(Object data,Node next){
            this.data = data;
            this.next = next;
        }
    }
    int size = 0;
    private Node dummyHead = new Node(null,null);
    @Override
    //尾插法
    public void add(Object data) {
        add(size,data);
    }
    private void add(int index,Object data){
        rangeCheck(index);
        Node prev = dummyHead;
        for(int i = 0;i < index;i++){
            prev = prev.next;
        }
        Node newNode = new Node(data);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    @Override
    public Object remove(int index) {
        rangeCheck(index);
        Node node = node(index);
        Node prev = dummyHead;
        for(int i = 0;i < index;i++){
            prev = prev.next;
        }
        prev.next = node.next;
        node.next = node = null;
        size--;
        return true;
    }

    @Override
    public Object get(int index) {
        rangeCheck(index);
        return node(index).data;
    }

    @Override
    public boolean contains(Object data) {
        Object[] array = toArray();
        if(data == null){
            for(int i = 0;i < array.length;i++){
                if(array[i] == null){
                    return true;
                }
            }
        }
        else{
            for(int i = 0;i < array.length;i++){
                if(data.equals(array[i])){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        rangeCheck(index);
        Node node = node(index);
        node.data = newData;
        return node.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for(Node tmp = dummyHead.next;tmp != null;){
            Node node = tmp.next;
            tmp.data = null;
            tmp.next = null;
            tmp = node;
            size--;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for(Node tmp = dummyHead.next;tmp != null;tmp = tmp.next){
            array[i++] = tmp.data;
        }
        return array;
    }

    public void rangeCheck(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("下标异常！");
        }
    }

    public Node node(int index){
        Node findNode = dummyHead.next;
        for(int i = 0;i < index;i++){
            findNode = findNode.next;
        }
        return findNode;
    }
}