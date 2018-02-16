package bst;

import java.util.Random;

public class BSTTest
{
    public static void main(String[] args)
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        int[] numbers = {-2, 42, 14, 1, 16, 6, 20, 100, 21, 60, 9, 0};

        for (int number : numbers)
        {
            bst.add(number);
        }

        //try out our traversals
        System.out.print("In order: ");
        bst.printTraversal(Traversal.IN_ORDER);

        System.out.print("Pre order: ");
        bst.printTraversal(Traversal.PRE_ORDER);

        System.out.print("Post order: ");
        bst.printTraversal(Traversal.POST_ORDER);

        System.out.print("Breadth-first search: ");
        bst.printTraversal(Traversal.BREADTH_FIRST);

        //test tree height or depth
        int height = bst.getTreeHeight();
        System.out.println("Tree height: " + height);

        int numElements = 1000;
        BinarySearchTree<Integer> randomTree = createRandomTree(numElements);
        System.out.println("Elements added");
        System.out.println("Random tree height: " + randomTree.getTreeHeight());

        int totalHeight = randomTree.totalNodeHeight();
        System.out.println("Total height: " + totalHeight);
        System.out.println("Avg height: " + totalHeight * 1.0 / numElements);
    }

    private static BinarySearchTree<Integer> createRandomTree(int numElementsToCreate)
    {
        Random random = new Random();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        for (int i = 1; i <= numElementsToCreate; i++)
        {
            bst.add(random.nextInt(numElementsToCreate) + 1);
        }

        return bst;
    }

    private static void testRemove()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        int[] numbers = {37, 1, 60, 45, 41, 42, 12, 119, 8,
                100, 12, 0, 47, 39, 43};

        for (int number : numbers)
        {
            bst.add(number);
        }

        //remove a node with no children - 47
        bst.remove(47);

        //remove a node with one child - 12 (left), 119 (right)
        bst.remove(12);
        bst.remove(119);

        //remove a node with two children - 37
        bst.remove(37);
    }
}
