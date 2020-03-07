package com.zipcodewilmington.singlylinkedlist;

import java.util.StringJoiner;

public class SinglyLinkedList<D> {
    class Node<D>
    {
        private D value;
        private Node<D> nextNode;

        public Node(D initValue, Node<D> initNextNode)
        {
            this.value = initValue;
            this.nextNode = initNextNode;
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
    }

    private Integer size;
    private Node<D> head;
    private Node<D> tail;

    public SinglyLinkedList()
    {
        size = 0;
        head = null;
        tail = null;
    }

    private Node<D> getNode(Integer idx)
    {
        Integer currentIdx = 0;
        Node<D> currentNode = head;

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
        else if(head == null)
        {
            Node<D> startingNode = new Node<D>(value, null);
            head = startingNode;
            tail = startingNode;
            size++;
        }
        else if(idx == 0)
        {
            Node<D> oldHead = head;
            Node<D> startingNode = new Node<D>(value, oldHead);
            head = startingNode;
            size++;
        }
        else
        {
            Node<D> currentNode = getNode(idx - 1);
            Node<D> oldNextNode = currentNode.getNextNode();
            currentNode.setNextNode(new Node<D>(value, oldNextNode));
            size++;
            if(tail.equals(currentNode))
            {
                tail = currentNode.getNextNode();
            }
        }
    }

    public void add(D value)
    {
        add(size, value);
    }

    public void remove(Integer idx)
    {
        if(size - 1 > idx || idx < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        else if(size == 1)
        {
            head = null;
            tail = null;
            size--;
        } else if(idx == size - 1)
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
        Node<D> currentNode = head;

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
        Node<D> currentNode = head;

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
        SinglyLinkedList<D> copiedList = new SinglyLinkedList<D>();

        Node<D> currentNode = head;

        while(currentNode != null)
        {
            copiedList.add(currentNode.getValue());
            currentNode = currentNode.getNextNode();
        }

        return copiedList;
    }

    public void sort()
    {

    }

    public void reverse()
    {
        SinglyLinkedList<D> reverseList = new SinglyLinkedList<D>();
        Node<D> currentNode = head;

        while(currentNode != null)
        {
            reverseList.add(0, currentNode.getValue());

            currentNode = currentNode.getNextNode();
        }

        reverseList.tail = this.tail;
        this.head = reverseList.getNode(0);
    }

    public SinglyLinkedList<D> slice(Integer startIdx, Integer endIdx)
    {

        return null;
    }

    @Override
    public String toString()
    {
        StringJoiner result = new StringJoiner(", ");

        Node<D> currentNode = head;
        while(currentNode != null)
        {
            result.add(currentNode.getValue().toString());
        }

        return "{ " + result + "}";
    }
}