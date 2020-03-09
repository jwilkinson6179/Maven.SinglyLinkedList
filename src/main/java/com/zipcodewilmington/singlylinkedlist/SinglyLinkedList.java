package com.zipcodewilmington.singlylinkedlist;

import java.util.StringJoiner;

public class SinglyLinkedList<D extends Comparable<D>> {
    class Node<D extends Comparable<D>>
    {
        private D value;
        private Node<D> nextNode;

        public Node(D initValue, Node<D> initNextNode)
        {
            this.value = initValue;
            this.nextNode = initNextNode;
        }

        public Node()
        {
            this(null, null);
        }

        public Node<D> getNextNode()
        {
            return nextNode;
        }

        public void setNextNode(Node<D> pointedToNode)
        {
            nextNode = pointedToNode;
        }

        public D getValue()
        {
            return value;
        }

        public void setValue(D updatedValue)
        {
            value = updatedValue;
        }

        public int compareTo(Node<D> o) {
            return this.value.compareTo(o.getValue());
        }
    }

    private Integer size;
    private Node<D> head;
    private Node<D> tail;

    public SinglyLinkedList()
    {
        size = 0;
        head = new Node<>();
        tail = head;
    }

    private Node<D> getNode(Integer idx)
    {
        Integer currentIdx = 0;
        Node<D> currentNode = head.getNextNode();

        while(currentIdx < idx)
        {
            currentNode = currentNode.getNextNode();
            currentIdx++;
        }

        return currentNode;
    }

    public void add(Integer idx, D value)
    {
        if(idx > size || idx < 0)
        {
            throw new IndexOutOfBoundsException();
        }

        Node<D> addedNode;
        if(idx.equals(size)) // Add to the end
        {
            addedNode = new Node<>(value, null);
            head.setNextNode(addedNode);
            tail = addedNode;
            size++;
        }
        else // Add to end
        {
            Node<D> existingNode = head.getNextNode();
            addedNode = new Node<>(value, existingNode);
            head.setNextNode(addedNode);
            size++;
        }
    }

    public void add(D value)
    {
        Node<D> addedNode = new Node<>(value, null);
        tail.setNextNode(addedNode);
        tail = addedNode;
        size++;
    }

    public void remove(Integer idx)
    {
        if(size - 1 > idx || idx < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        else if(size.equals(1))
        {
            head.setNextNode(null);
            tail = head;
            size--;
        }
        else if(idx == (size - 1))
        {
            Node<D> currentNode = getNode(idx - 1);
            currentNode.setNextNode(null);
            tail = currentNode;
            size--;
        }
        else
        {
            Node<D> currentNode = getNode(idx - 1);
            Node<D> updatedNextNode = currentNode.getNextNode().getNextNode();
            currentNode.setNextNode(updatedNextNode);
            size--;
        }
    }

    public Boolean contains(D value)
    {
        Node<D> currentNode = head.getNextNode();

        while(currentNode != null)
        {
            if(currentNode.getValue().equals(value))
            {
                return true;
            }
            currentNode = currentNode.getNextNode();
        }

        return false;
    }

    public Integer find(D value)
    {
        Integer currentLocation = 0;
        Node<D> currentNode = head.getNextNode();

        while(currentNode != null)
        {
            if(currentNode.getValue().equals(value))
            {
                return currentLocation;
            }
            currentLocation++;
        }

        return -1;
    }

    public Integer size()
    {
        return size;
    }

    public D get(Integer idx)
    {
        return getNode(idx).getValue();
    }

    public SinglyLinkedList<D> copy()
    {
        SinglyLinkedList<D> copiedList = slice(0, size);

        return copiedList;
    }

    public void sort()
    {
        for(Integer i = 0; i < size - 1; i++)
        {
            Node<D> cursor = head;
            for(Integer k = 0; k < size - i - 1; k++)
            {
                Node<D> current = cursor.getNextNode();
                Node<D> next = current.getNextNode();
                if(current.getValue().compareTo(next.getValue()) > 0)
                {
                    current.setNextNode(next.getNextNode());
                    next.setNextNode(current);
                    cursor.setNextNode(next);
                }
                cursor = cursor.getNextNode();
            }
        }
    }

    public void reverse()
    {
        SinglyLinkedList<D> reverseList = new SinglyLinkedList<D>();
        Node<D> currentNode = head.getNextNode();

        while(currentNode != null)
        {
            reverseList.add(0, currentNode.getValue());

            currentNode = currentNode.getNextNode();
        }

        reverseList.tail = this.tail;
        this.head.setNextNode(reverseList.getNode(0));
    }

    public SinglyLinkedList<D> slice(Integer startIdx, Integer endIdx)
    {
        SinglyLinkedList<D> subList = new SinglyLinkedList<D>();

        Node<D> currentNode = getNode(startIdx);
        Integer currentIdx = startIdx;

        while(currentNode != null && currentIdx < endIdx)
        {
            subList.add(currentNode.getValue());
            currentNode = currentNode.getNextNode();
            currentIdx++;
        }

        return subList;
    }

    @Override
    public String toString()
    {
        StringJoiner result = new StringJoiner(", ", "{ ", " }");

        Node<D> currentNode = head.getNextNode();
        while(currentNode != null)
        {
            result.add(currentNode.value.toString());
            currentNode = currentNode.getNextNode();
        }

        return result.toString();
    }
}