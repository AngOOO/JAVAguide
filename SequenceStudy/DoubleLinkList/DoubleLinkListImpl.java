package SequenceStudy.DoubleLinkList;

import SequenceStudy.SequenceArray.Sequence;

public class DoubleLinkListImpl implements Sequence {
    public class Node{
        Object data;
        Node prev;
        Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Node(Object data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    private Node head = null;
    private Node tail = null;
    private int size;

    @Override
    //尾插法
    public void add(Object data) {
        Node newNode = new Node(data,tail,null);
        if(head == null){
            head = newNode;
        }
        else{
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public Object remove(int index) {
        rangeCheck(index);
        Node remNode = node(index);
        Node prev = remNode.prev;
        Node next = remNode.next;
        if(prev == null){
            head = remNode.next;
        }
        else{
            prev.next = remNode.next;
            remNode.next = null;
        }
        if(next == null){
            tail = remNode.prev;
        }
        else{
            next.prev = remNode.prev;
            remNode.prev = null;
        }
        size--;
        return false;
    }

    @Override
    public Object get(int index) {
        rangeCheck(index);
        return node(index).data;
    }

    @Override
    public boolean contains(Object data) {
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        rangeCheck(index);
        Node setNode = node(index);
        setNode.data = newData;
        return setNode.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for(Node tmp = head;tmp != null;){
            Node next = tmp.next;
            tmp.data = null;
            tmp.prev = null;
            tmp.next = null;
            tmp = next;
            size--;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] data = new Object[size];
        int i = 0;
        for(Node tmp = head;tmp != null;tmp = tmp.next){
            data[i++] = tmp.data;
        }
        return data;
    }

    public boolean rangeCheck (int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("下标越界！");
        }
        return true;
    }
    public Node node (int index){
        if(index < (size>>2)){
            Node tmp = head;
            for(int i = 0;i < index;i++){
                tmp = tmp.next;
            }
            return tmp;
        }
        else if(index > (size>>2)){
            Node tmp = tail;
            for(int i = size-1;i > index;i--){
                tmp = tmp.prev;
            }
            return tmp;
        }
        return null;
    }
}
