package ejercicio;

import uaslp.objetos.list.linkedlist.LinkedList;
import uaslp.objetos.list.linkedlist.LinkedListIterator;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        int option,index;
        String data;
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();
        LinkedListIterator iterator;

        do{
            System.out.println("Opcion 1: addAtTail");
            System.out.println("Opcion 2: addAtFront");
            System.out.println("Opcion 3: remove");
            System.out.println("Opcion 4: removeAll");
            System.out.println("Opcion 5: setAt");
            System.out.println("Opcion 6: getAt");
            System.out.println("Opcion 7: removeAllWithValue");
            System.out.println("Opcion 8: getSize");
            System.out.println("Opcion 9: getIterator\n");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    System.out.println("data: ");
                    data = scanner.next();
                    list.addAtTail(data);
                    break;
                case 2:
                    System.out.println("data: ");
                    data = scanner.next();
                    list.addAtFront(data);
                    break;
                case 3:
                    System.out.println("index: ");
                    index = scanner.nextInt();
                    list.remove(index);
                    break;
                case 4:
                    list.removeAll();
                    break;
                case 5:
                    System.out.println("data: ");
                    data = scanner.next();
                    System.out.println("index: ");
                    index = scanner.nextInt();
                    list.setAt(index,data);
                    break;
                case 6:
                    System.out.println("index: ");
                    index = scanner.nextInt();
                    data= list.getAt(index);
                    System.out.println(data);
                    break;
                case 7:
                    System.out.println("data: ");
                    data = scanner.next();
                    list.removeAllWithValue(data);
                    break;
                case 8:
                    index = list.getSize();
                    System.out.println("size: "+ index);
                    break;
                case 9:
                    iterator = list.getIterator();
                    do{
                        System.out.println(iterator.next());
                    }while(iterator.hasNext());
                    break;
            }
        }while(option!=0);

    }

}