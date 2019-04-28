package SequenceStudy.LinkList;

/*
public class LinkList {
    public class Node{
        private Object data;
        private Node next;

        public Node(Object data){
            this.data = data;
        }
        public Node(Object data,Node next){
            this.data = data;
            this.next = next;
        }
    }
    private Node head;
    private int size;

    public void addFirst(Object data){
        Node newNode = new Node(data);
        newNode.next= head;//
        head = newNode;
        size++;
    }
    public void add(int index,Object data){
        if(index < 0||index > size){
            throw new IndexOutOfBoundsException("下标异常！");
        }
        if(index == 0){
            addFirst(data);
        }
        else{
            Node prev = head;
            for(int i = 0;i < index-1;i++){
                prev = prev.next;
            }
            Node newNode = new Node(data);
            newNode.next = prev.next;
            prev.next = newNode;
            size++;
        }
    }
}
*/
