package com.edison.algorithm.struct;

/**
 * @Description TODO
 * @Date 2020/2/27下午4:30
 * @Created by edsiongeng
 */

public class MyArray {
    private int[] intArray;

    private int elems;

    private int length;

    public int[] getIntArray() {
        return intArray;
    }

    public void setIntArray(int[] intArray) {
        this.intArray = intArray;
    }

    public int getElems() {
        return elems;
    }

    public void setElems(int elems) {
        this.elems = elems;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public MyArray() {
        elems = 0;
        length = 50;
        intArray = new int[length];
    }

    public MyArray(int length) {
        elems = 0;
        this.length = length;
        intArray = new int[length];
    }

    public int getSize() {
        return elems;
    }

    public void display() {
        for (int i = 0; i < elems; i++) {
            System.out.print(intArray[i] + " ");
        }
        System.out.println();
    }

    public boolean add(int value) {
        if (elems == length) {
            return false;
        } else {
            intArray[elems] = value;
            elems++;
        }
        return true;
    }

    public int get(int i) {
        if (i < 0 || i > elems) {
            System.out.println("index out");

        }
        return intArray[i];
    }

    public int find(int searchValue) {
        int j;
        for (j = 0; j < elems; j++) {
            if (intArray[j] == searchValue) {
                break;
            }
        }
        if (j == elems) {
            return -1;
        }
        return j;
    }

    public boolean delete(int value) {
        int k = find(value);
        if (k == -1) {

            return false;
        } else {
            if (k == elems - 1) {
                elems--;
            } else {
                for (int i = k; i < elems - 1; i++) {
                    intArray[i] = intArray[i + 1];

                }
                elems--;
            }
        }
        return true;
    }

    public boolean modify(int oldValue, int newValue) {
        int i = find(oldValue);
        if (i == -1) {
            return false;
        } else {
            intArray[i] = newValue;
        }
        return true;
    }

    public static void main(String[] args) {
        MyArray array = new MyArray(4);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        System.out.println(array.find(5));
    }


}
