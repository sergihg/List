package uaslp.objetos.list.linkedlist;
 class Node <T>{
    T data;
    Node<T> next;
    Node<T> previous;

     public T getData() {
         return data;
     }

     public Node<T> getNext() {
         return next;
     }

     public Node<T> getPrevious() {
         return previous;
     }

     public void setData(T data) {
         this.data = data;
     }

     public void setNext(Node<T> next) {
         this.next = next;
     }

     public void setPrevious(Node<T> previous) {
         this.previous = previous;
     }
 }
