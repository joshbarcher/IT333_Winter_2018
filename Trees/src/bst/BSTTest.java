package bst;

public class BSTTest
{
    public static void main(String[] args)
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
