package uaslp.objetos.list.arraylist;


import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.CollectionsException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

public class ArrayList<T> implements List<T> {
    private static final int INITIAL_SIZE = 2;
    private int size;
    private T []array;

    @SuppressWarnings("unchecked")
    public ArrayList(){
        array = (T[])(new Object[INITIAL_SIZE]);
    }
    public void addAtTail(T data) throws NotNullAllowedException {
        if(data == null) {
            throw new NotNullAllowedException();
        }

        if (size==array.length){
            increaseSize();
        }
        array[size] = data;
        size++;
    }
    public void addAtFront(T data) throws NotNullAllowedException{
        if(data == null) {
            throw new NotNullAllowedException();
        }

        if(size==array.length){
                increaseSize();
        }
        for(int i=size;i>0;i--){
            array[i]=array[i-1];
        }
        array[0]=data;
        size++;
    }
    public void remove(int index) throws BadIndexException {
        if(index<size){
            for (int i = index; i < (size-1); i++) {
                array[i] = array[i + 1];
            }
            array[size-1]=null;
            size--;
        }
        else throw new BadIndexException();
    }
    @SuppressWarnings("unchecked")
    public void removeAll(){
        array = (T[])(new Object[INITIAL_SIZE]);
        size=0;
    }
    public void setAt(int index, T data) throws BadIndexException,NotNullAllowedException{
        if(index<size){
            if(data==null)
                throw new NotNullAllowedException();
            else {
                array[index] = data;
            }
        }
        else throw new BadIndexException();
    }
    public T  getAt(int index) throws BadIndexException{
        if(index<size){
            return array[index];
        }
        throw new BadIndexException();
    }
    public void removeAllWithValue(T data){
        for(int i=0;i<size;i++){
            if(array[i].equals(data)){
                try {
                    remove(i);
                }catch (BadIndexException ignored){
                }
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
