package BinTree;

public interface BinTree<E> {
    void add(E e);
    boolean contain(E e);
    E getMax();
    E getMin();
    void remove(E e);
    void removeMax();
    void removeMin();
    void preOrder();
    void inOrder();
    void postOrder();
    void levelOrder();
    int getSize();
}
