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
        if(data == null) {
            throw new NotNullAllowedException();
        }
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
        if(data == null) {
            throw new NotNullAllowedException();
        }
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
        else throw new BadIndexException();
    }
    public void removeAll(){
        head = null;
        tail = null;
        size = 0;
    }
    public void setAt(int index, T data) throws BadIndexException,NotNullAllowedException{
        if(index <= size) {
            if(data==null)
                throw new NotNullAllowedException();
            Node<T> nodo = head;
            for (int currentIndex = 0; currentIndex < index; currentIndex++) {
                nodo = nodo.next;
            }
            nodo.setData(data);
        }
        else throw new BadIndexException();
    }
    public T getAt(int index) throws BadIndexException{
        if(index<0 || index>=size) {
            throw new BadIndexException();
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
                try{
                    remove(currentIndex);
                }catch (BadIndexException ignored){
                }
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
