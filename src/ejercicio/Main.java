package ejercicio;

import uaslp.objetos.list.arraylist.ArrayList;
import uaslp.objetos.list.arraylist.ArrayListIterator;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        int option,index;
        String data;
        Scanner scanner = new Scanner(System.in);
        ArrayList array = new ArrayList();
        ArrayListIterator iterator;

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
                    array.addAtTail(data);
                    break;
                case 2:
                    System.out.println("data: ");
                    data = scanner.next();
                    array.addAtFront(data);
                    break;
                case 3:
                    System.out.println("index: ");
                    index = scanner.nextInt();
                    array.remove(index);
                    break;
                case 4:
                    array.removeAll();
                    break;
                case 5:
                    System.out.println("data: ");
                    data = scanner.next();
                    System.out.println("index: ");
                    index = scanner.nextInt();
                    array.setAt(index,data);
                    break;
                case 6:
                    System.out.println("index: ");
                    index = scanner.nextInt();
                    data= array.getAt(index);
                    System.out.println(data);
                    break;
                case 7:
                    System.out.println("data: ");
                    data = scanner.next();
                    array.removeAllWithValue(data);
                    break;
                case 8:
                    index = array.getSize();
                    System.out.println("size: "+ index);
                    break;
                case 9:
                    iterator = array.getIterator();
                    while(iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                    break;
            }
        }while(option!=0);

    }

}