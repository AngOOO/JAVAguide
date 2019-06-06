package BinTree;

import BinTree.Heap.Heap;
import BinTree.SearchTree.SearchTree;

public class Test {
    public static void main(String[] args) {
        SearchTree<Integer> searchTree = new SearchTree<>();
        searchTree.add(5);
        searchTree.add(8);
        searchTree.add(9);
        searchTree.add(1);
        searchTree.add(3);
        searchTree.add(7);
        searchTree.add(4);
        searchTree.remove(4);
        searchTree.levelOrder();
        Heap<Integer> a = new Heap<>();
    }
}
