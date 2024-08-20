package com.binarysearchtree;

public class Demo {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(50);

        bst.insert(20);
        bst.insert(10);
        bst.insert(25);
        bst.insert(70);
        bst.insert(60);
        bst.insert(65);
        bst.insert(69);
        bst.insert(55);
        bst.insert(90);
        bst.insert(80);
        bst.insert(75);

        System.out.println("Before Deletion");
        BinarySearchTree.inOrder(bst.root);
        System.out.println();

        bst.delete(50);

        System.out.println("After Deletion");
        BinarySearchTree.inOrder(bst.root);

    }
}
