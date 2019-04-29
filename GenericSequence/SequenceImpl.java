public class SequenceImpl<T> implements GenericSequence<T> {
    class Node{
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node dummyHead = new Node(null,null);
    private int size = 0;

    @Override
    public void add(T data) {
        addLast(size,data);
    }
    private void addLast(int index,T data){
        rangeCheck(index);
        Node prev = dummyHead;
        for(int i = 0;i < index;i++){
            prev = prev.next;
        }
        Node newData = new Node(data);
        newData.next = prev.next;
        prev.next = newData;
        size++;
    }
    private void rangeCheck(int index){
        if(index > size) {
            throw new IndexOutOfBoundsException("下标异常！");
        }
    }

    @Override
    public T remove(int index) {
        rangeCheck(index);
        Node remNode = node(index);
        Node prev = dummyHead;
        for(int i = 0;i < index;i++){
            prev = prev.next;
        }
        prev.next = remNode.next;
        remNode.next = remNode = null;
        size--;
        return prev.next.data;
    }
    private Node node(int index){
        Node node = dummyHead.next;
        for(int i = 0;i < index;i++){
            node = node.next;
        }
        return node;
    }

    @Override
    public T get(int index) {
        rangeCheck(index);
        return node(index).data;
    }

    @Override
    public boolean contains(T data) {
        if(data == null){
            for (Node tmp = dummyHead.next;tmp != null;tmp = tmp.next){
                if(tmp.data == null){
                    return true;
                }
            }
        }else {
            for (Node tmp = dummyHead.next;tmp != null;tmp = tmp.next){
                if(data.equals(tmp.data)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public T set(int index, T newData) {
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
        for (Node tmp = dummyHead.next;tmp != null;){
            Node node = tmp.next;
            tmp.data = null;
            tmp.next = null;
            tmp = node;
            size--;
        }
    }

    @Override
    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        int i = 0;
        for(Node tmp = dummyHead.next;tmp != null;tmp = tmp.next){
            array[i++] = tmp.data;
        }
        return array;
    }
}
