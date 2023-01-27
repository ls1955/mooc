/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cheong
 */
public class MyList<T> {
    private T[] values;
    private int head;

    public MyList() {
        values = (T[]) new Object[10];
        head = 0;
    }
    
    public void add(T value) {
        if (head == values.length) growList();
        
        values[head++] = value;
    }
    
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }
    
    public int indexOf(T value) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == value || values[i].equals(value)) return i;
        }
        
        return -1;
    }
    
    public void remove(T value) {
        int index = indexOf(value);
        
        if (index == -1) return;
        
        compactLeft(index);
        
        if (head < values.length / 3) shrinkList();
    }
    
    public int size() {
        return head;
    }
    
    public T value(int index) {
        if (index < 0 || index >= head) throw new ArrayOutOfBoundsException("The index is outside of the bound.");
        
        return values[index];
    }
    
    private void compactLeft(int startIndex) {
        for (int i = startIndex; i < head - 1; i++) {
            values[i] = values[i + 1];
        }
        
        startIndex--;
    }
    
    private void growList() {
        int newLength = values.length + values.length / 2;
        T[] newValues = (T[]) new Object[newLength];
        
        for (int i = 0; i < values.length; i++) {
            newValues[i] = values[i];
        }
        
        values = newValues;
    }
    
    private void shrinkList() {
        int newLength = values.length / 2;
        T[] newValues = (T[]) new Object[newLength];
        
        for (int i = 0; i < values.length; i++) {
            newValues[i] = values[i];
        }
        
        values = newValues;
    }
}
