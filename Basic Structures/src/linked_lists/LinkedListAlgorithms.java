package linked_lists;

import java.util.Stack;

public class LinkedListAlgorithms
{
    public static void main(String[] args)
    {
        //instantiate our class
        LinkedListAlgorithms algorithms = new LinkedListAlgorithms();

        //assemble a linked list
        Node head = null;
        for (int i = 1; i <= 5; i++)
        {
            if (head == null)
            {
                head = algorithms.new Node(i, null);
            }
            else
            {
                head = algorithms.new Node(i, head);
            }
        }

        //reverse the linked list using different techniques

        //head = algorithms.reverse(head);
        //head = algorithms.recursiveReverse(head);
        head = algorithms.reverseWithStack(head);

        //verify our results
        Node current = head;
        while (current != null)
        {
            //print the current element and move past it
            System.out.println(current.data);
            current = current.next;
        }
    }

    public Node reverseWithStack(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        Stack<Node> stack = new Stack<>();

        //add all nodes to the stack
        while (head != null)
        {
            stack.push(head);
            head = head.next;
        }

        //remove them one at a time
        head = stack.pop();
        Node current = head;

        while (!stack.isEmpty())
        {
            Node next = stack.pop();
            current.next = next;
            current = next;
        }
        current.next = null;

        return head;
    }

    public Node recursiveReverse(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        else
        {
            return recursiveReverse(head, null);
        }
    }

    public Node recursiveReverse(Node current, Node newList)
    {
        if (current == null)
        {
            return newList;
        }
        else
        {
            Node savedNode = current.next;
            current.next = newList;
            newList = current;

            return recursiveReverse(savedNode, newList);
        }
    }

    public Node reverse(Node head)
    {
        //precondition
        if (head == null)
        {
            return null;
        }
        else if (head.next == null) //one element
        {
            return head;
        }

        //step #1 - point a temporary variable to head
        Node newlistHead = head;

        //step #2 - save the element after head
        Node saveNextNode = head.next;

        //step #3 - remove the next pointer for temp1
        newlistHead.next = null;

        while (saveNextNode.next != null)
        {
            //step #4 - move our pointers to the next nodes
            head = saveNextNode;
            saveNextNode = saveNextNode.next;

            //move
            head.next = newlistHead;
            newlistHead = head;
        }

        saveNextNode.next = newlistHead;
        head = saveNextNode;

        return head;
    }

    private class Node
    {
        private int data;
        private Node next;

        public Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }

        public String toString()
        {
            return data + "";
        }
    }
}
