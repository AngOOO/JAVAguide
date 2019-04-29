public class DoubleLinkListImpl<T> implements GenericSequence<T> {
    class Node{
        Node prev;
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node(Node prev, T data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
    private Node head = null;
    private Node tail = null;
    int size = 0;

    @Override
    public void add(T data) {
        Node newNode = new Node(tail,data,null);
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
    public T remove(int index) {
        rangeCheck(index);
        Node remNode = node(index);
        Node prev = remNode.prev;
        Node next = remNode.next;
        if (prev == null){
            head = remNode.next;
        }else{
            prev.next = remNode.next;
            remNode.next = null;
        }
        if (next == null){
            tail = remNode.prev;
        }else {
            next.prev = remNode.prev;
            remNode.prev = null;
        }
        return null;
    }
    private void rangeCheck(int index){
        if(index > size){
            throw new IndexOutOfBoundsException("下标异常！");
        }
    }
    private Node node(int index){
        if(index < size>>2){
            Node tmp = head;
            for (int i = 0;i < index;i++){
                tmp = tmp.next;
            }
            return tmp;
        }
        else{
            Node tmp = tail;
            for (int i = size - 1;i > index;i--){
                tmp = tmp.prev;
            }
            return tmp;
        }
    }

    @Override
    public T get(int index) {
        rangeCheck(index);
        return node(index).data;
    }

    @Override
    public boolean contains(T data) {
        if(data == null){
            for(Node tmp = head;tmp != null;tmp = tmp.next){
                if (tmp.data == null){
                    return true;
                }
            }
        }
        else{
            for(Node tmp = head;tmp != null;tmp = tmp.next){
                if (data.equals(tmp.data)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public T set(int index, T newData) {
        rangeCheck(index);
        node(index).data = newData;
        return node(index).data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (Node tmp = head;tmp != null;){
            Node node = tmp.next;
            tmp.data = null;
            tmp.prev = null;
            tmp.next = null;
            tmp = node;
            size--;
        }
    }

    @Override
    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        int i = 0;
        for(Node tmp = head;tmp != null;tmp = tmp.next){
            array[i++] = tmp.data;
        }
        return array;
    }
}
