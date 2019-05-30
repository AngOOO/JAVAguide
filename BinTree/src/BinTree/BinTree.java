package BinTree;

public interface BinTree<E> {
    void add(E e);
    boolean contain(E e);
    E getMax();
    E getMin();
    boolean remove(E e);
    boolean removeMax();
    boolean removeMin();
    void preOrder();
    void inOrder();
    void postOrder();
    void levelOrder();
    int getSize();
}
