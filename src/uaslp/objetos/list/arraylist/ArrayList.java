package uaslp.objetos.list.arraylist;


import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;

public class ArrayList implements List {
    private static final int INITIAL_SIZE = 2;
    private int size;
    private String []array;
    public ArrayList(){
        array = new String[INITIAL_SIZE];
    }
    public void addAtTail(String data){
        if(size==array.length){
            increaseSize();
        }
        array[size] = data;
        size++;
    }
    public void addAtFront(String data){
        if(size==array.length){
            increaseSize();
        }
        for(int i=size;i>0;i--){
            array[i]=array[i-1];
        }
        array[0]=data;
        size++;
    }
    public void remove(int index){
        if(index<size){
            for (int i = index; i < (size-1); i++) {
                array[i] = array[i + 1];
            }
            array[size-1]=null;
            size--;
        }
    }
    public void removeAll(){
        array = new String[INITIAL_SIZE];
        size=0;
    }
    public void setAt(int index, String data){
        if(index<size){
            array[index] = data;
        }
    }
    public String  getAt(int index){
        if(index<size){
            return array[index];
        }
        return "fuera del tamaño del arreglo";
    }
    public void removeAllWithValue(String data){
        for(int i=0;i<size;i++){
            if(array[i].equals(data)){
                for (int j = i; j < (size - 1); j++) {
                    array[j] = array[j + 1];
                }
                array[size - 1] = null;
                size--;
            }
        }
    }
    public int getSize(){
        return size;
    }
    public Iterator getIterator(){
        return new ArrayListIterator(this);
    }
    private void increaseSize(){
        String []newArray = new String[array.length * 2];
        for(int i=0; i< array.length;i++){
            newArray[i]=array[i];
        }
        array=newArray;
    }
}
