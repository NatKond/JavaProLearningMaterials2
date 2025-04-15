package org.tel.ran._2025_04_15.mainClass;

public class Main {
    public static void main(String[] args) {
    var optional = new DynamicArray<Integer>();
        for (int i = 0; i <= 21; i++) {
            optional.add(i);
            System.out.println(optional);
        }

        optional.remove((Integer) 7);
        System.out.println(optional);

        optional.remove(3);
        System.out.println(optional);
    }
}
