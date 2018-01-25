package linked_lists;

public class LinkedListAlgorithms
{
    public static void main(String[] args)
    {
        //instantiate our class
        LinkedListAlgorithms algorithms = new LinkedListAlgorithms();

        //assemble a linked list
        Node head = null;
        for (int i = 1; i <= 500; i++)
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

        //reverse it
        head = algorithms.reverse(head);

        //verify our results
        Node current = head;
        while (current != null)
        {
            //print the current element and move past it
            System.out.println(current.data);
            current = current.next;
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
