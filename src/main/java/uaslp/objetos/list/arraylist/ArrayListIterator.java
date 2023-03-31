package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.exceptions.BadIndexException;

public class ArrayListIterator<T> implements Iterator<T> {
    private final ArrayList<T> iterator;
    private int currentIndex;
    public ArrayListIterator(ArrayList<T> array){
        iterator = array;
        currentIndex = 0;
    }
    public boolean hasNext() {
        if(currentIndex < iterator.getSize()){
            return true;
        }
        return false;
    }
    public T next(){

        try {
            T data = iterator.getAt(currentIndex);
            currentIndex++;
            return data;
        }catch (BadIndexException ignored){
        }
        return null;
    }
}
