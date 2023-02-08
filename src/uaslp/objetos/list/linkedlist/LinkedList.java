package uaslp.objetos.list.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;
    public void addAtTail(String data){
        Node node = new Node();
        node.data = data;
        node.previous = tail;
        if(head==null) {
            head = node;
        }else{
            tail.next = node;
        }
        tail = node;
        size++;
    }
    public void addAtFront(String data){
        Node node = new Node();
        node.data = data;
        node.next = head;
        if(tail == null){
            tail = node;
        }else{
            head.previous=node;
        }
        head = node;
        size++;
    }
    public void remove(int index){
        if(index < size) {
            Node node = head;
            for (int currentIndex = 0; currentIndex < index; currentIndex++) {
                node = node.next;
            }
            if(node.next==null)
            {
                node.previous.next = null;
            }else if (node.previous == null){
                node.next.previous = null;
            }else{
                node.previous.next = node.next;
                node.next.previous = node.previous;
            }

            size--;
        }
    }
    public void removeAll(){
        head = null;
        tail = null;
        size = 0;
    }
    public void setAt(int index, String data){
        if(index <= size) {
            Node nodo = head;
            for (int currentIndex = 0; currentIndex < index; currentIndex++) {
                nodo = nodo.next;
            }
            nodo.data = data;
        }
    }
    public String getAt(int index){
        if(index<0 || index>=size) {
            return null;
        }
        Node currentNode = head;
        for (int currentIndex = 0; currentIndex < index; currentIndex++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }
    public void removeAllWithValue(String data){
        Node node = head;
        for (int currentIndex = 0; currentIndex < size; currentIndex++) {
            if(node.data == data) {
                if(node.next==null)
                {
                    node.previous.next = null;
                }else if (node.previous == null){
                    node.next.previous = null;
                }else{
                    node.previous.next = node.next;
                    node.next.previous = node.previous;
                }
                size--;
            }
            node = node.next;
        }
    }

    public int getSize() {
        return size;
    }
    public LinkedListIterator getIterator(){
        return new LinkedListIterator(head);
    }
}
