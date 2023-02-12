package uaslp.objetos.list.linkedlist;
 class Node {
    String data;
    Node next;
    Node previous;

     public String getData() {
         return data;
     }

     public Node getNext() {
         return next;
     }

     public Node getPrevious() {
         return previous;
     }

     public void setData(String data) {
         this.data = data;
     }

     public void setNext(Node next) {
         this.next = next;
     }

     public void setPrevious(Node previous) {
         this.previous = previous;
     }
 }
