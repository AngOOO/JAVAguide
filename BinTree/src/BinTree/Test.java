package BinTree;

import BinTree.SearchTree.SearchTree;

public class Test {
    public static void main(String[] args) {
        SearchTree<Integer> searchTree = new SearchTree<>();
        searchTree.add(5);
        searchTree.add(8);
        searchTree.add(3);
        searchTree.add(2);
        searchTree.add(10);
        searchTree.add(6);
        System.out.println();
    }
}
