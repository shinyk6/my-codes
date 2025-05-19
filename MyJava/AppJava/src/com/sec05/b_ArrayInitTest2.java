package com.sec05;

import java.util.Arrays;


//java.util -> List<E>, Set<E>, Map<k,V>   ->index, value, key
//Arrays -> API 	->정렬_sort(), 검색_binarySearch(), 복사_copyOf(), copyOfRange(), 변환_toString(), fill 등을 제공
public class b_ArrayInitTest2 {
    public static void main(String[] args) {
        // 각 기본형 타입 배열 선언 및 초기화 (기본값을 확인하기 위해)
        char[] c = new char[2];
        byte[] b = new byte[2];
        boolean[] bool = new boolean[2];
        int[] i = new int[2];
        long[] l = new long[2];
        float[] f = new float[2];
        double[] d = new double[2];
        Object[] o = new Object[2];

      
        printArray("byte", b);
        printArray("char", c);
        printArray("boolean", bool);
        printArray("int", i);
        printArray("long", l);
        printArray("float", f);
        printArray("double", d);
        printArray("object", o);
    }
   
    public static void printArray(String type, Object array) {
        System.out.println("==========================");
        // 기본형 배열인지 확인 후 처리    ->instanceof를 통해 해당 객체 타입이 맞는지 확인 후 명령 수행
        if (array instanceof boolean[])			//array가 boolean이면
            System.out.println(type + " 배열: " + Arrays.toString((boolean[]) array)); //입력받은 배열을 문자열로 리턴
        else if (array instanceof byte[])
            System.out.println(type + " 배열: " + Arrays.toString((byte[]) array));
        else if (array instanceof char[])
            System.out.println(type + " 배열: " + Arrays.toString((char[]) array));
        else if (array instanceof int[])
            System.out.println(type + " 배열: " + Arrays.toString((int[]) array));
        else if (array instanceof long[])
            System.out.println(type + " 배열: " + Arrays.toString((long[]) array));
        else if (array instanceof float[])
            System.out.println(type + " 배열: " + Arrays.toString((float[]) array));
        else if (array instanceof double[])
            System.out.println(type + " 배열: " + Arrays.toString((double[]) array));
        else
            System.out.println(type + " 배열: " + Arrays.toString((Object[]) array));
    }
}
