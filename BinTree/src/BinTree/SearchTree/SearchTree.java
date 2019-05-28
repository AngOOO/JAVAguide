package BinTree.SearchTree;

import BinTree.BinTree;

public class SearchTree<E extends Comparable<E>> implements BinTree<E> {
    private class Node{
        E data;
        Node right;
        Node left;

        public Node(E data) {
            this.data = data;
        }
    }
    private Node root;
    private int size;
    @Override
    public void add(E e) {
        if (root == null){
            Node newNode = new Node(e);
            root = newNode;
        }
        add(root,e);
        size++;
    }
    private void add(Node node,E e){
        if (e.compareTo(root.data) == 0){
            return;
        }else if (e.compareTo(node.data) < 0 && node.left == null){
            Node newNode = new Node(e);
            node.left = newNode;
        }else if (e.compareTo(node.data) > 0 && node.right == null){
            Node newNode = new Node(e);
            node.right = newNode;
        }
        if (e.compareTo(node.data) < 0){
            add(node.left,e);
        }else if (e.compareTo(node.data) > 0){
            add(node.right,e);
        }
    }

    @Override
    public boolean contain(E e) {
        if (e.compareTo(root.data) == 0){
            return true;
        }
        return contain(root,e);
    }
    private boolean contain(Node node,E e){
        if (node == null){
            return false;
        }
        if (e.compareTo(node.data) == 0){
            return true;
        }else if (e.compareTo(node.data) < 0){
            return contain(node.left,e);
        }
        return contain(node.right,e);
    }

    @Override
    public E getMax() {
        return null;
    }

    @Override
    public E getMin() {
        return null;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public boolean removeMax() {
        return false;
    }

    @Override
    public boolean removeMin() {
        return false;
    }

    @Override
    public void preOrder() {

    }

    @Override
    public void inOrder() {

    }

    @Override
    public void postOrder() {

    }

    @Override
    public int getSize() {
        return size;
    }
}
