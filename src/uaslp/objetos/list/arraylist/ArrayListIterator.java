package uaslp.objetos.list.arraylist;

public class ArrayListIterator {
    private String []iterator;
    private int currentIndex;
    public ArrayListIterator(String []array){
        iterator = new String[array.length];
        for(int i=0;i< iterator.length;i++){
            iterator[i]=array[i];
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
