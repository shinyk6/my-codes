package com.javastudy;

import java.util.Arrays;
import java.util.EnumSet;

public class EnumTest {

	public static void main(String[] args) {
		
		ProductCategory[] category = ProductCategory.values();
		
		System.out.println("사용 가능한 카테고리");
		for(int i=0; i<category.length; i++) {
			System.out.println("-"+category[i]);
		}

		
		EnumSet set = EnumSet.of(category[4]);

		System.out.println(set);
	}

}


class ShoppingCart{
	
	void addProduct(String[] category){
		
	}
}

enum ProductCategory{
	ELECTRONIS, COLOTHING, GROCERY, BOOKS, TOYS
}


class InvalidQuantityException extends Exception{
	
	public InvalidQuantityException(){};

	public InvalidQuantityException(String message) {
		super(message);
	}
	
	public static void exception() throws InvalidQuantityException{
		throw new InvalidQuantityException("예외 발생");
	}

}















