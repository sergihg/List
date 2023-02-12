package uaslp.objetos.list.linkedlist;

public class LinkedListIterator {
    private Node currentNode;
    LinkedListIterator(Node head){
        currentNode = head;
    }
    public boolean hasNext() {
        if(currentNode.next == null){
            return false;
        }
        return true;
    }
    public String next(){
        String data = currentNode.getData();
        currentNode = currentNode.next;
        return data;
    }
}
