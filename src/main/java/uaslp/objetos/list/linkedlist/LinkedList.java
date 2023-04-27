package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    public void addAtTail(T data) throws NotNullAllowedException {
        validateNotNullValue(data);
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
    public void addAtFront(T data) throws NotNullAllowedException {
        validateNotNullValue(data);

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
    public void remove(int index) throws BadIndexException{
        validateInvalidIndex(index);
        Node<T> node = head;
        for (int currentIndex = 0; currentIndex < index; currentIndex++) {
            node = node.next;
        }
        if(size==1)
        {
            head=null;
            tail=null;
        }
        else if(node==tail)
        {
            node.previous.setNext(null);
            tail=node.previous;
        }else if (node==head) {
            node.next.setPrevious(null);
            head=node.next;
        }else{
            node.previous.setNext(node.next);
            node.next.setPrevious(node.previous);
        }
        size--;
    }
    public void removeAll(){
        head = null;
        tail = null;
        size = 0;
    }
    public void setAt(int index, T data) throws BadIndexException,NotNullAllowedException{
        validateInvalidIndex(index);
        validateNotNullValue(data);
        Node<T> nodo = head;
        for (int currentIndex = 0; currentIndex < index; currentIndex++) {
            nodo = nodo.next;
        }
        nodo.setData(data);
    }
    public T getAt(int index) throws BadIndexException{
        validateInvalidIndex(index);
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
                    remove(currentIndex);
            }
            node = node.next;
        }
    }

    public int getSize() {
        return size;
    }
    public boolean isEmpty(){
        if (size==0)
            return true;
        return false;
    }
    public Iterator<T> getIterator(){
        return new LinkedListIterator<>(head);
    }
    private void validateNotNullValue(T data) throws NotNullAllowedException{
        if(data==null)
            throw new NotNullAllowedException();
    }
    private void validateInvalidIndex(int index) throws BadIndexException{
        if(index<0 || index>=size) {
            throw new BadIndexException("Index "+index+" out of bounds for length "+size);
        }
    }
}
