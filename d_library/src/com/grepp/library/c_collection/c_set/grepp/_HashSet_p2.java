package com.grepp.library.c_collection.c_set.grepp;

public class _HashSet_p2 <E>{

    private static final int DEFAULT_CAPACITY= 10;
    private int arraySize = 10;
    private Object[] elementData;
    private int size;

    public _HashSet_p2() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private int hash(E e){
        // hashCode : -21억 ~ +21억
        // 0 ~ 21 억 사이의 값 반환
        int hashCode = Math.abs(e.hashCode());
        return hashCode % arraySize;
    }

    private void resize() {
        arraySize *= 2;
        Object[] temp = new Object[arraySize];

        for (int i = 0; i < arraySize; i++) {
            if(elementData[i] == null) continue;
            int newIndex = hash((E) elementData[i]);
            temp[newIndex] = elementData[i];
        }

        elementData = temp;
    }
}
