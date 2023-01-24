import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * INFO 6205 RUNLIN LIU
 * This MyBag.java took 2 materials for reference. I took the idea of a general Bag data structure and
 * no code was copied from originate pages.
 * Links:
 * https://algs4.cs.princeton.edu/13stacks/Bag.java.html
 * https://blog.csdn.net/TTCCAAA/article/details/45065885
 */
public class MyBag<E extends Object> implements Iterable<E>{
    private Node<E> root;

    private Node<E> current;
    private int size;

    public MyBag(){
        root = new Node<>(null);
        current = root;
        size = 0;
    }

    public MyBag(E val){
        new MyBag();
        this.add(val);
    }

    /**
     * Basic interface - add
     * @param e : A value of generic type E
     */
    public void add(E e){
        current.next = new Node(e);
        current = current.next;

        size++;
    }

    /**
     * Basic interface - isEmpty
     * @return true if no element exists inside the MyBag instance;
     */

    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * Basic interface - size
     * @return the amount of elements inside this MyBag instance
     */
    public int getSize() {
        return size;
    }


    @Override
    public Iterator<E> iterator() {

        return new Iterator() {
            Node<E> start = root;

            @Override
            public boolean hasNext() {
                return start.next != null;
            }

            @Override
            public E next() {
                start = start.next;
                return start.getVal();
            }
        };
    }


    //Requirement for the assignment
    public void clear(){
        root.next = null;
        size = 0;
    }

    public boolean contains(E val){
        for(E e: this){
            if(e.equals(val)) return true;
        }
        return false;
    }

    public E grab(){
        int seed = (int)(Math.random() * getSize());
        Node<E> pointer = root;
        for(int i = 0; i< seed; i++){
            pointer = pointer.next;
        }
        return pointer.val;
    }

    public void remove(E element){
        if(size == 0 || element == null) return;
        Node pointer = root;
        while (pointer.next.val != null){
            if(pointer.next.val == element){
                pointer.next = pointer.next.next;
                return;
            }
        }
    }

    public E[] toArray(){
        if(size == 0) return null;
        Object[] list = new Object[size];

        int idx = 0;
        Node<E> pointer = root;
        for(E e: this){
            list[idx++] = pointer.next;
            pointer = pointer.next;
        }
        return (E[])list;
    }

    public String toString(){

        String res = "";
        int idx = 0;
        for(E e: this){
            res += "" + idx++ + ": ";
            res += e.toString();
            if(idx < size)  res += ", ";
        }
        return res;

    }
    private static class Node<E>{
        E val;

        Node next;
        Node(E val){
            this.val = val;
        }

        public E getVal() {
            return val;
        }
    }


}
