package bst;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T>
{
    protected Node root;
    protected int nodeCount = 0;

    public BinarySearchTree()
    {
        // do nothing
    }

    public boolean add(T element)
    {
        if (root == null)
        {
            root = new Node(element, null, null);
            nodeCount++;
            return true;
        }
        else
        {
            // search for the spot, if it's not taken
            boolean success = add(root, element);

            if (success)
            {
                nodeCount++;
            }
            return success;
        }
    }

    private boolean add(Node current, T element)
    {
        if (current.data.equals(element))
        {
            return false; // already in the tree
        }
        else
        {
            int compare = current.data.compareTo(element);

            if (compare < 0) // new element is larger
            {
                if (current.right == null)
                {
                    current.right = new Node(element, null, null);
                    return true;
                }
                else
                {
                    return add(current.right, element);
                }
            }
            else if (compare > 0) // new element is smaller
            {
                if (current.left == null)
                {
                    current.left = new Node(element, null, null);
                    return true;
                }
                else
                {
                    return add(current.left, element);
                }
            }
            else // compare == 0
            {
                return false; // already in the tree
            }
        }
    }

    public boolean contains(Object search)
    {
        return contains(root, (T) search);
    }

    private boolean contains(Node current, T element)
    {
        if (current == null)
        {
            return false;
        }
        else
        {
            int compare = current.data.compareTo(element);

            if (compare < 0) // new element is larger
            {
                return contains(current.right, element);
            }
            else if (compare > 0) // new element is smaller
            {
                return contains(current.left, element);
            }
            else // compare == 0
            {
                return true; // found it!
            }
        }
    }

    public void remove(T search)
    {
        //start searching at the root
        root = remove(root, search);
    }

    private Node remove(Node node, T search)
    {
        //element not found in tree
        if (node == null)
        {
            return null; //assign our parent pointer to this value
        }

        //compare against the current element
        int compare = node.data.compareTo(search);

        if (compare < 0) //search to the right
        {
            node.right = remove(node.right, search);
        }
        else if (compare > 0) //search to the left
        {
            node.left = remove(node.left, search);
        }
        else //we found it!
        {
            //case #1 - no children
            if (node.left == null && node.right == null)
            {
                return null;
            }
            //case #2 - one child
            else if (node.left == null)
            {
                return node.right;
            }
            else if (node.right == null)
            {
                return node.left;
            }
            //case #3 - two children
            else
            {
                //find the smallest element in the right subtree
                Node replacement = findMin(node.right);

                //replace the data in our removed node
                node.data = replacement.data;

                //recursively remove the smallest element in the right subtree
                node.right = remove(node.right, replacement.data);
            }
        }
        //this will allow our parent to assign a reference to this node
        return node;
    }

    private Node findMin(Node search)
    {
        if (search.left == null)
        {
            return search;
        }
        return findMin(search.left);
    }

    private Node findMax(Node search)
    {
        if (search.right == null)
        {
            return search;
        }
        return findMax(search.right);
    }

    public void printTraversal(Traversal traversal)
    {
        switch (traversal)
        {
            case IN_ORDER:
                inOrder(root);
                System.out.println();
                break;
            case PRE_ORDER:
                preOrder(root);
                System.out.println();
                break;
            case POST_ORDER:
                postOrder(root);
                System.out.println();
                break;
            case BREADTH_FIRST:
                breadthFirst();
                break;
        }
    }

    private void breadthFirst()
    {
        Queue<Node> nodeQueue = new LinkedBlockingQueue<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty())
        {
            Node nextNode = nodeQueue.poll();
            System.out.print(nextNode.data + " ");

            if (nextNode.left != null)
            {
                nodeQueue.offer(nextNode.left);
            }

            if (nextNode.right != null)
            {
                nodeQueue.offer(nextNode.right);
            }
        }

        System.out.println();
    }

    private void inOrder(Node current)
    {
        if (current != null)
        {
            //print the element and recursively search for others
            inOrder(current.left);
            System.out.print(current.data + " ");
            inOrder(current.right);
        }
    }

    private void preOrder(Node current)
    {
        if (current != null)
        {
            //print the element and recursively search for others
            System.out.print(current.data + " ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }

    private void postOrder(Node current)
    {
        if (current != null)
        {
            //print the element and recursively search for others
            postOrder(current.left);
            postOrder(current.right);
            System.out.print(current.data + " ");
        }
    }

    public int getTreeHeight()
    {
        //make sure our nodes have updated height values
        calculateAllNodeHeights();

        return root.height;
    }

    public void calculateAllNodeHeights()
    {
        calculateNodeHeight(root);
    }

    private int calculateNodeHeight(Node current)
    {
        if (current == null)
        {
            return -1;
        }
        else
        {
            int height = 1 + Math.max(calculateNodeHeight(current.left),
                                      calculateNodeHeight(current.right));
            current.setHeight(height);
            return height;
        }
    }

    @Override
    public Iterator<T> iterator()
    {
        return null;
    }

    // nested classes
    public class Node
    {
        private T data;
        private Node left;
        private Node right;

        //scratch fields
        private int height;
        private int depth;

        public Node(T data, Node left, Node right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getHeight()
        {
            return height;
        }

        public void setHeight(int height)
        {
            this.height = height;
        }

        public int getDepth()
        {
            return depth;
        }

        public void setDepth(int depth)
        {
            this.depth = depth;
        }

        public T getData()
        {
            return data;
        }

        public void setData(T data)
        {
            this.data = data;
        }

        public Node getLeft()
        {
            return left;
        }

        public void setLeft(Node left)
        {
            this.left = left;
        }

        public Node getRight()
        {
            return right;
        }

        public void setRight(Node right)
        {
            this.right = right;
        }

        @Override
        public String toString()
        {
            String leftString = (left == null) ? "null" : left.data.toString();
            String rightString = (right == null) ? "null" : right.data.toString();

            return leftString + " <-- " + data.toString() + " --> " + rightString;
        }
    }
}
