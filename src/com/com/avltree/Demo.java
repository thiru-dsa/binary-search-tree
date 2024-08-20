package com.com.avltree;

public class Demo {

    public static void main(String[] args) {
        AVLBinarySearchTree avlTree = new AVLBinarySearchTree();
        int[] values = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190};

        for (int value : values) {
            System.out.println("Inserting: " + value);
            avlTree.insert(value);
            System.out.println("After inserting " + value + ":");
            printTree(avlTree.root, "", true);
            System.out.println("--------------------------------------------------\n");
        }
    }

    public static void printTree(AVLBinarySearchTree.Node node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            System.out.println("Key: " + node.key + " (Height: " + node.height + ")");

            printTree(node.left, indent, false);
            printTree(node.right, indent, true);
        }
    }
}
