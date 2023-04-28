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
        validateNotNullValue(data);

        if (size==array.length){
            increaseSize();
        }
        array[size] = data;
        size++;
    }
    public void addAtFront(T data) throws NotNullAllowedException{
        validateNotNullValue(data);

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
        validateInvalidIndex(index);
        for (int i = index; i < (size-1); i++) {
            array[i] = array[i + 1];
        }
        array[size-1]=null;
        size--;
    }

    public void removeAll(){
        array = (T[])(new Object[INITIAL_SIZE]);
        size=0;
    }
    public void setAt(int index, T data) throws BadIndexException,NotNullAllowedException{
        validateInvalidIndex(index);
        validateNotNullValue(data);
        array[index] = data;
    }
    public T  getAt(int index) throws BadIndexException{
        validateInvalidIndex(index);
        return array[index];
    }
    public void removeAllWithValue(T data){
        for(int i=0;i<size;i++){
            if(array[i].equals(data)){
                    remove(i);
            }
        }
    }
    public int getSize(){
        return size;
    }
    public Iterator<T> getIterator(){
        return new ArrayListIterator<>(this);
    }
    public boolean isEmpty(){
        if (size==0)
            return true;
        return false;
    }

    @SuppressWarnings("unchecked")
    private void increaseSize(){
        T []newArray = (T[])(new Object[array.length * 2]);
        for(int i=0; i< array.length;i++){
            newArray[i]=array[i];
        }
        array=newArray;
    }

    private void validateNotNullValue(T data) throws NotNullAllowedException{
        if(data==null)
            throw new NotNullAllowedException();
    }
    private void validateInvalidIndex(int index) throws BadIndexException{
        if(index<0 || index>=size) {
            throw new BadIndexException("Index "+index+" out of bounds for length "+size);
        }
    }
}
