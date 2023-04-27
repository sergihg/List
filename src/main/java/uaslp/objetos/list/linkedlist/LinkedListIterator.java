package uaslp.objetos.list.linkedlist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.exceptions.BadIndexException;

public class LinkedListIterator<K> implements Iterator <K>{
    private Node<K> currentNode;
    LinkedListIterator(Node<K> head){
        currentNode = head;
    }
    public boolean hasNext() {
        if(currentNode == null)
            return false;
        return true;
    }
    public K next(){
        K data = currentNode.getData();
        currentNode = currentNode.getNext();
        return data;
    }
}
