package uaslp.objetos.list.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

public class LinkedListTest {
    @Test
    public void whenListIsCreated_thenItIsEmpty(){
        //Inicializacion
        LinkedList<String> list = new LinkedList<>();

        //Ejecucion     que es lo que quiero probar
        boolean isEmpty = list.isEmpty();
        int size = list.getSize();

        //Validacion
        Assertions.assertTrue(isEmpty);
        Assertions.assertEquals(0,size);
    }
    @Test
    public void givenAnEmptyList_whenAddAtTail_thenElementIsInserted(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();

        //Ejecucion
        list.addAtTail("1");

        //Validacion
        Assertions.assertEquals(1,list.getSize());
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenANonEmptyList_whenAddAtTail_thenElementIsInserted(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();

        //Ejecucion
        list.addAtTail("1");
        list.addAtTail("2");
        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertEquals("2",list.getAt(1));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAnEmptyList_whenAddAtFront_thenElementIsInserted(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();

        //Ejecucion
        list.addAtFront("1");

        //Validacion
        Assertions.assertEquals(1,list.getSize());
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenANonEmptyList_whenAddAtFront_thenElementIsInserted(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();

        //Ejecucion
        list.addAtFront("2");
        list.addAtFront("1");
        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertEquals("2",list.getAt(1));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAList_whenAddAtFrontANullValue_thenExceptionIsThrown(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();

        //Ejecucion
        Assertions.assertThrows(NotNullAllowedException.class,()->list.addAtFront(null));   //lamda expresion
        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void givenAList_whenRemoveAWrongIndex_thenExceptionIsThrown(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();

        //Ejecucion
        Assertions.assertThrows(BadIndexException.class,()->list.remove(3));   //lamda expresion
        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void givenAListWithData_whenRemoveAWrongIndex_thenExceptionIsThrown(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtFront("5");

        //Ejecucion
        Assertions.assertThrows(BadIndexException.class,()->list.remove(3));   //lamda expresion
        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAListWith1Element_whenRemove_thenElementIsRemoved(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");

        //Ejecucion
        list.remove(0);

        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void givenAListWith3Element_whenRemoveAtHead_thenElementIsRemoved(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");

        //Ejecucion
        list.remove(0);

        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals("11",list.getAt(0));
    }
    @Test
    public void givenAListWith3Element_whenRemoveAtTail_thenElementIsRemoved(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");

        //Ejecucion
        list.remove(2);

        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals("11",list.getAt(list.getSize()-1));
    }
    @Test
    public void givenAListWith3Element_whenRemoveAtMiddle_thenElementIsRemoved(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");

        //Ejecucion
        list.remove(1);

        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals("12",list.getAt(1));
    }
    @Test
    public void givenAListWithElements_whenRemoveAll_thenListIsEmpty(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");

        //Ejecucion
        list.removeAll();

        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void givenAnEmptyList_whenRemoveAll_thenListIsEmpty(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();

        //Ejecucion
        list.removeAll();

        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void givenAListWithElements_whenSetAtAWrongIndex_thenExceptionIsThrown(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");

        //Ejecucion
        Assertions.assertThrows(BadIndexException.class,()->list.setAt(3,"0"));

        //Validacion
        Assertions.assertEquals(3,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAListWithElements_whenSetAtANullValue_thenExceptionIsThrown(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");

        //Ejecucion
        Assertions.assertThrows(NotNullAllowedException.class,()->list.setAt(2,null));

        //Validacion
        Assertions.assertEquals(3,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAListWithElements_whenSetAt_thenValueIsSet(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");

        //Ejecucion
        list.setAt(2,"value");

        //Validacion
        Assertions.assertEquals(3,list.getSize());
        Assertions.assertEquals("value",list.getAt(2));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAListWithElements_whenRemoveAllWithValue_withAValueInList_thenElementIsRemoved(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");

        //Ejecucion
        list.removeAllWithValue("11");

        //Validacion
        Assertions.assertEquals(2,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAListWithElements_whenGetIterator_thenFirstIteratorHasNext(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");

        //Ejecucion
        Iterator<String> iterator;
        iterator = list.getIterator();
        boolean hasNext = iterator.hasNext();

        //Validacion
        Assertions.assertTrue(hasNext);
    }
    @Test
    public void givenAnEmptyList_whenGetIterator_thenFirstIterationDoesNotHaveNext(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();

        //Ejecucion
        Iterator<String> iterator;
        iterator = list.getIterator();
        boolean hasNext = iterator.hasNext();

        //Validacion
        Assertions.assertFalse(hasNext);
    }
    @Test
    public void givenAListWithElements_whenIteratorDoesNext_thenListIsRead(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");
        Iterator<String> iterator;
        iterator = list.getIterator();

        //Ejecucion
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("10",iterator.next());
        Assertions.assertEquals("11",iterator.next());
        Assertions.assertEquals("12",iterator.next());

        //Validacion
        Assertions.assertFalse(iterator.hasNext());
    }
    @Test
    public void givenAnEmptyList_whenIteratorDoesNext_thenDoesNothing(){
        //Inicialización
        LinkedList<String> list = new LinkedList<>();
        Iterator<String> iterator;
        iterator = list.getIterator();

        //Ejecucion
        Assertions.assertThrows(java.lang.NullPointerException.class,()->iterator.next());

        //Validacion
        Assertions.assertFalse(iterator.hasNext());
    }
}
