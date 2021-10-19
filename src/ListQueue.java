public class ListQueue<T> implements QueueInterface<T>
{

    private SinglyLinkedList linkedList = new SinglyLinkedList();

    public ListQueue(){}

    public ListQueue(ListQueue<T> listQueue)
    {
        if(!listQueue.isEmpty())
        {
            SinglyLinkedList.Node tNode = listQueue.linkedList.head;
            this.enqueue(tNode.data);
            while(tNode.next!=null)
            {
                tNode=tNode.next;
                this.enqueue(tNode.data);
            }
        }
    }

    public boolean equals(ListQueue<T> listQueue)
    {
        boolean flag = true;
        if(this.size()!=listQueue.size())
            flag=false;
        else
        {
            if(this.isEmpty())
                return flag;
            SinglyLinkedList.Node nP1 = this.linkedList.head;
            SinglyLinkedList.Node nP2 = listQueue.linkedList.head;
            while(!nP1.data.equals(nP2.data))
                return false;
            nP1=nP1.next;
            nP2= nP2.next;
            if(nP1.next==null)
                flag = nP1.data.equals(nP2.data);
        }
        return flag;
    }

    @Override
    public String toString()
    {
        return this.linkedList.toString();
    }

    @Override
    public void enqueue(T o)
    {
        this.linkedList.append(o);
    }

    @Override
    public T dequeue()
    {
        T temp = null;
        if(!this.isEmpty())
        {
            temp = this.linkedList.head.data;
            this.linkedList.head=this.linkedList.head.next;
        }
        return temp;
    }

    @Override
    public T peek()
    {
        T temp  = null;
        if(!this.isEmpty())
            temp = this.linkedList.head.data;
        return temp;
    }

    @Override
    public boolean isEmpty()
    {
        return this.linkedList.head==null;
    }

    @Override
    public int size()
    {
        int counter =0;
        if(!this.isEmpty())
        {
            counter++;
            SinglyLinkedList.Node tNode = this.linkedList.head;
            while(tNode.next!=null)
            {
                counter++;
                tNode=tNode.next;
            }
        }
        return counter;
    }

    @Override
    public void clear()
    {
        this.linkedList = new SinglyLinkedList();
    }

    //Private inner class
    private class SinglyLinkedList
    {
        private class Node
        {
            private T data;
            private Node next;

            public Node(T data)
            {
                this.data = data;
                this.next = null;
            }
        }

        public Node head = null;

        //-------------------------------------------------------------
        public void append(T data)
        {
            // create a new node
            Node newNode = new Node(data);

            // check if the list is empty
            if (head == null)
            {
                head = newNode;
            }
            else
            {
                Node p = head;
                // traverse the list until p refers to the last node
                while (p.next != null)
                    p = p.next;
                p.next = newNode;
            }
        }

        //-------------------------------------------------------------
        public boolean equals(Object obj)
        {
            //...

            return false;
        }

        //-------------------------------------------------------------
        public String toString()
        {
            String str = "{";
            Node curr = head;
            while (curr != null)
            {
                str += (curr == head ? "" : ",") + curr.data.toString();
                curr = curr.next;
            }
            str += "}";
            return str;
        }

    }
}
