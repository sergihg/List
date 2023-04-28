package uaslp.objetos.list.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.exceptions.BadIndexException;
import uaslp.objetos.list.exceptions.NotNullAllowedException;

public class ArrayListTest {
    @Test
    public void whenListIsCreated_thenItIsEmpty(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();

        //Ejecucion
        boolean isEmpty = list.isEmpty();
        int size = list.getSize();

        //Validacion
        Assertions.assertTrue(isEmpty);
        Assertions.assertEquals(0,size);
    }
    @Test
    public void givenAnEmptyList_WhenAddAtTail_thenElementIsInserted(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();

        //Ejecucion
        list.addAtTail("1");

        //Validacion
        Assertions.assertEquals(1,list.getSize());
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenANonEmptyList_whenAddAtTail_thenElementIsInserted(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();

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
    public void givenAnEmptyList_WhenAddAtFront_thenElementIsInserted(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();

        //Ejecucion
        list.addAtFront("1");

        //Validacion
        Assertions.assertEquals(1,list.getSize());
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenANonEmptyList_whenAddAtFront_thenElementIsInserted(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();

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
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();

        //Ejecucion
        Assertions.assertThrows(NotNullAllowedException.class,()->list.addAtFront(null));

        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void givenAList_whenAddAtTailANullValue_thenExceptionIsThrown(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();

        //Ejecucion
        Assertions.assertThrows(NotNullAllowedException.class,()->list.addAtTail(null));

        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void givenAListWith2Elements_whenAddAtTail_thenArraySizeIsIncreased_andElementIsInserted(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();

        //Ejecucion
        list.addAtTail("1");
        list.addAtTail("2");

        list.addAtTail("3");

        //Validacion
        Assertions.assertEquals(3,list.getSize());
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertEquals("2",list.getAt(1));
        Assertions.assertEquals("3",list.getAt(2));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAListWith2Elements_whenAddAtFront_thenArraySizeIsIncreased_andElementIsInserted(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();

        //Ejecucion
        list.addAtFront("3");
        list.addAtFront("2");

        list.addAtFront("1");

        //Validacion
        Assertions.assertEquals(3,list.getSize());
        Assertions.assertEquals("1",list.getAt(0));
        Assertions.assertEquals("2",list.getAt(1));
        Assertions.assertEquals("3",list.getAt(2));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAListWith1Element_whenRemove_thenElementIsRemoved(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();
        list.addAtFront("1");

        //Ejecucion
        list.remove(0);

        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void givenAListWith3Elements_whenRemove_thenElementIsRemoved_andRestOfTheListIsMoved(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();
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
    public void givenAListWithElements_whenRemoveAtWrongIndex_thenExceptionIsThrown(){
        //Inicializacion
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");

        //Ejecucion
        Assertions.assertThrows(BadIndexException.class,()->list.remove(3));

        //Validacion
        Assertions.assertEquals(3,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAnEmptyList_whenRemoveAWrongIndex_thenExceptionIsThrown(){
        //Inicialización
        ArrayList<String> list = new ArrayList<>();

        //Ejecucion
        Assertions.assertThrows(BadIndexException.class,()->list.remove(3));   //lamda expresion
        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void givenAListWithElements_whenRemoveAll_thenListIsEmpty(){
        //Inicialización
        ArrayList<String> list = new ArrayList<>();
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
        ArrayList<String> list = new ArrayList<>();

        //Ejecucion
        list.removeAll();

        //Validacion
        Assertions.assertEquals(0,list.getSize());
        Assertions.assertTrue(list.isEmpty());
    }
    @Test
    public void givenAListWithElements_whenSetAt_thenValueIsSet(){
        //Inicialización
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");

        //Ejecucion
        list.setAt(1,"changedValue");

        //Validacion
        Assertions.assertEquals("changedValue",list.getAt(1));
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAListWithElements_whenSetAtWrongIndex_thenExceptionIsThrown(){
        //Inicialización
        ArrayList<String> list = new ArrayList<>();
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
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");

        //Ejecucion
        Assertions.assertThrows(NotNullAllowedException.class,()->list.setAt(1,null));

        //Validacion
        Assertions.assertEquals(3,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAListWithElements_whenRemoveAllWithValue_withAValueInList_thenElementsAreRemoved(){
        //Inicialización
        ArrayList<String> list = new ArrayList<>();
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
    public void givenAListWithElements_whenRemoveAllWithValue_withAValueNotInList_thenElementsAreNotRemoved(){
        //Inicialización
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");

        //Ejecucion
        list.removeAllWithValue("value");

        //Validacion
        Assertions.assertEquals(3,list.getSize());
        Assertions.assertFalse(list.isEmpty());
    }
    @Test
    public void givenAListWithElements_whenGetIterator_thenFirstIterationHasNext(){
        //Inicialización
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");

        //Ejecucion
        Iterator<String> iterator = list.getIterator();
        boolean hasNext = iterator.hasNext();

        //Validacion
        Assertions.assertTrue(hasNext);
    }
    @Test
    public void givenAnEmptyList_whenGetIterator_thenDoesNotHaveNext(){
        //Inicialización
        ArrayList<String> list = new ArrayList<>();

        //Ejecucion
        Iterator<String> iterator = list.getIterator();
        boolean hasNext = iterator.hasNext();

        //Validacion
        Assertions.assertFalse(hasNext);
    }
    @Test
    public void givenAListWithElements_whenIteratorHasNext_andNext_thenListIsRead(){
        //Inicialización
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");

        Iterator<String> iterator = list.getIterator();

        //Ejecucion
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("10",iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("11",iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("12",iterator.next());

        //Validacion
        Assertions.assertFalse(iterator.hasNext());
    }
    @Test
    public void givenAListWithElements_whenIteratorDoesNotHaveNext_andNext_thenNullIsReturned(){
        //Inicialización
        ArrayList<String> list = new ArrayList<>();
        list.addAtTail("10");
        list.addAtTail("11");
        list.addAtTail("12");

        Iterator<String> iterator = list.getIterator();
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("10",iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("11",iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("12",iterator.next());

        //Ejecucion
        Assertions.assertFalse(iterator.hasNext());
        Assertions.assertNull(iterator.next());

        //Validacion
        Assertions.assertFalse(iterator.hasNext());
    }
    @Test
    public void givenAnEmptyList_whenIteratorDoesNext_thenNullIsReturned() {
        //Inicialización
        ArrayList<String> list = new ArrayList<>();

        Iterator<String> iterator = list.getIterator();

        //Ejecucion
        Assertions.assertFalse(iterator.hasNext());
        Assertions.assertNull(iterator.next());

        //Validacion
        Assertions.assertFalse(iterator.hasNext());
    }

}
