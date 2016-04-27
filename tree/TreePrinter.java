package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreePrinter {

    private static Node test1() {
        Node root = new Node(2);
        Node n11 = new Node(7);
        Node n12 = new Node(5);
        Node n21 = new Node(2);
        Node n22 = new Node(6);
        Node n23 = new Node(3);
        Node n24 = new Node(6);
        Node n31 = new Node(5);
        Node n32 = new Node(8);
        Node n33 = new Node(4);
        Node n34 = new Node(5);
        Node n35 = new Node(8);
        Node n36 = new Node(4);
        Node n37 = new Node(5);
        Node n38 = new Node(8);

        root.leftChild = n11;
        root.rightChild = n12;

        n11.leftChild = n21;
        n11.rightChild = n22;
        n12.leftChild = n23;
        n12.rightChild = n24;

        n21.leftChild = n31;
        n21.rightChild = n32;
        n22.leftChild = n33;
        n22.rightChild = n34;
        n23.leftChild = n35;
        n23.rightChild = n36;
        n24.leftChild = n37;
        n24.rightChild = n38;

        return root;
    }

    private static Node test2() {
        Node root = new Node(2);
        Node n11 = new Node(7);
        Node n12 = new Node(5);
        Node n21 = new Node(2);
        Node n22 = new Node(6);
        Node n23 = new Node(9);
        Node n31 = new Node(5);
        Node n32 = new Node(8);
        Node n33 = new Node(4);

        root.leftChild = n11;
        root.rightChild = n12;

        n11.leftChild = n21;
        n11.rightChild = n22;

        n12.rightChild = n23;
        n22.leftChild = n31;
        n22.rightChild = n32;

        n23.leftChild = n33;

        return root;
    }

    public static void main(String[] args) {

        BTreePrinter.printNode(test1());
        BTreePrinter.printNode(test2());

    }
}


class BTreePrinter {

    public static  void printNode(Node root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1; 

        BTreePrinter.printWhitespaces(firstSpaces - 4); 

        List<Node> newNodes = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                newNodes.add(node.leftChild);
                newNodes.add(node.rightChild);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println(""); // after printing first line of tree we go next to printing branches

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i); 
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).leftChild != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).rightChild != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(edgeLines + edgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.leftChild), BTreePrinter.maxLevel(node.rightChild)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
