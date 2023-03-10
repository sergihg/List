package uaslp.objetos.list.arraylist;

import uaslp.objetos.list.Iterator;

public class ArrayListIterator implements Iterator {
    private String []iterator;
    private int currentIndex;
    public ArrayListIterator(ArrayList array){
        iterator = new String[array.getSize()];
        for(int i=0;i< iterator.length;i++){
            iterator[i]=array.getAt(i);
        }
    }
    public boolean hasNext() {
        if(currentIndex < iterator.length){
            return true;
        }
        return false;
    }
    public String next(){

        String data = iterator[currentIndex];
        currentIndex++;
        return data;
    }
}
