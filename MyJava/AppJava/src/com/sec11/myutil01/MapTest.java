package com.sec11.myutil01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {

		Map<String, String> hm = new HashMap<>();

		hm.put("name", "밀로"); //Entry<k, v>
		hm.put("addr", "Toronto"); //Entry<String, String>
		hm.put("tel", "02-000-000"); //Entry<String, String>

		System.out.println("전체출력 : " + hm);

		System.out.println("\n  entrySet()을 이용한 View");
		
		//Set<Map.Entry<K,V>> entrySet()  //k 따로 v따로 관리
		Set<Entry<String, String>> entires = hm.entrySet();   // Entry<String, String> : 하나의 타입

		for (Entry<String, String> ent : entires) { //for를 이용하여 각각의 타입을 푼다.
			System.out.println(ent.getKey() + " ==> " + ent.getValue()); //각각의 k v를 리턴
		}
		
		///////////////////////////////////////////

		System.out.println("\n  keySet()을 이용한 View");
		Set<String> keys = hm.keySet(); //키만 가지고 옴 

		for (String key : keys) {
			System.out.println("Value of " + key + " is: " + hm.get(key));
		}

		System.out.println("\n  values()을 이용한 View");
		Collection<String> con = hm.values();	//값을 String으로 리턴
		for (String value : con) {
			System.out.println("Value is :" + value);
		}

		System.out.println("\n  키와 값을 찾아 값을 변경 ");
		if (hm.containsKey("name") && hm.containsValue("밀로")) {	//키와 값을 찾아 값 변경
			hm.replace("name", "루리");
		}

		System.out.println(hm);
	}

}
