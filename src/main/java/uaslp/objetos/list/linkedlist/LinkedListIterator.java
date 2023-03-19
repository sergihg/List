package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.Iterator;

public class LinkedListIterator<K> implements Iterator <K>{
    private Node<K> currentNode;
    LinkedListIterator(Node<K> head){
        currentNode = head;
    }
    public boolean hasNext() {
        if(currentNode.next == null){
            return false;
        }
        return true;
    }
    public K next(){
        K data = currentNode.getData();
        currentNode = currentNode.next;
        return data;
    }
}
