package com.sec04;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sec01.MyAddress;

public class MyCollection {
	
	private List<String> items;
	private String[] myarray;
	private Set<String> myset;
	private Map<String, String> mymap;
	
	private Map<String, MyAddress> myaddr;
	
	//setter 메소드
	public void setItems(List<String> items) { //setter주입 - List객체 (value가 여러개 들어감)
		this.items = items;
	}
	
	public void setMyarray(String[] items) {
		this.myarray = items;
	}
	
	public void setMyset(Set<String> items) {
		this.myset = items;
	}
	
	public void setMymap(Map<String, String> items) {
		this.mymap = items;
	}
	
	public void setMyaddr(Map<String, MyAddress> item) {
		this.myaddr = item;
	}
	
	
	
	// 호출 메소드
	public void printItems() {
		System.out.println("Items in List:");
		for(String item : items) {
			System.out.println("- " + item);
		}
	}
	
	public void printArray() {
		System.out.println("Items in Array:");
		for(String item : myarray) {
			System.out.println("- " + item);
		}
	}
	
	public void printSet() {
		System.out.println("Items in Set:");
		for(String item : myset) {
			System.out.println("- " + item);
		}
	}
	
	public void printMap() {
		System.out.println("Items in Map:");
		
		for(Map.Entry<String, String> entry : mymap.entrySet()) {
			System.out.println(" -KEY : " + entry.getKey() + " -Value : " + entry.getValue());
		}
	}
	
	public void printMyaddr() {
		for(Map.Entry<String, MyAddress> entry : myaddr.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
	
}
