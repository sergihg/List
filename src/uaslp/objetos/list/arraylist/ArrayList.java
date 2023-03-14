package uaslp.objetos.list.arraylist;


import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;

public class ArrayList<T> implements List<T> {
    private static final int INITIAL_SIZE = 2;
    private int size;
    private T []array;

    @SuppressWarnings("unchecked")
    public ArrayList(){
        array = (T[])(new Object[INITIAL_SIZE]);
    }
    public void addAtTail(T data){
        if(size==array.length){
            increaseSize();
        }
        array[size] = data;
        size++;
    }
    public void addAtFront(T data){
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
    @SuppressWarnings("unchecked")
    public void removeAll(){
        array = (T[])(new Object[INITIAL_SIZE]);
        size=0;
    }
    public void setAt(int index, T data){
        if(index<size){
            array[index] = data;
        }
    }
    public T  getAt(int index){
        if(index<size){
            return array[index];
        }
        return null;
    }
    public void removeAllWithValue(T data){
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
    public Iterator<T> getIterator(){
        return new ArrayListIterator<>(this);
    }

    @SuppressWarnings("unchecked")
    private void increaseSize(){
        T []newArray = (T[])(new Object[array.length * 2]);
        for(int i=0; i< array.length;i++){
            newArray[i]=array[i];
        }
        array=newArray;
    }
}
