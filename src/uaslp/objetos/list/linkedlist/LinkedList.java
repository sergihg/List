package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    public void addAtTail(T data){
        Node<T> node = new Node<>();
        node.setData(data);

        if(size==0) {
            head = node;
        }else{
            node.setPrevious(tail);
            tail.setNext(node);
        }
        tail=node;
        size++;
    }
    public void addAtFront(T data){
        Node<T> node = new Node<>();
        node.setData(data);
        if(size == 0){
            tail = node;
        }else{
            node.setNext(head);
            head.setPrevious(node);
        }
        head = node;
        size++;
    }
    public void remove(int index){
        if(index < size) {
            Node<T> node = head;
            for (int currentIndex = 0; currentIndex < index; currentIndex++) {
                node = node.next;
            }
            if(node.next==null)
            {
                node.previous.setNext(null);
            }else if (node.previous == null) {
                node.next.setPrevious(null);
            }else{
                node.previous.setNext(node.next);
                node.next.setPrevious(node.previous);
            }

            size--;
        }
    }
    public void removeAll(){
        head = null;
        tail = null;
        size = 0;
    }
    public void setAt(int index, T data){
        if(index <= size) {
            Node<T> nodo = head;
            for (int currentIndex = 0; currentIndex < index; currentIndex++) {
                nodo = nodo.next;
            }
            nodo.setData(data);
        }
    }
    public T getAt(int index){
        if(index<0 || index>=size) {
            return null;
        }
        Node<T> currentNode = head;
        for (int currentIndex = 0; currentIndex < index; currentIndex++) {
            currentNode = currentNode.next;
        }
        return currentNode.getData();
    }
    public void removeAllWithValue(T data){
        Node<T> node = head;
        for (int currentIndex = 0; currentIndex < size; currentIndex++) {
            if(node.getData().equals(data)) {
                if(node.next==null)
                {
                    node.previous.setNext(null);
                    tail = node.previous;
                }else if (node.previous == null){
                    node.next.setPrevious(null);
                    head = node.next;
                }else{
                    node.previous.setNext(node.next);
                    node.next.setPrevious(node.previous);
                }
                size--;
            }
            node = node.next;
        }
    }

    public int getSize() {
        return size;
    }
    public Iterator<T> getIterator(){
        return new LinkedListIterator<>(head);
    }
}
