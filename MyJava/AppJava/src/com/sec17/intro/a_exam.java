package com.sec17.intro;

import java.net.*;

public class a_exam {

	public static void main(String[] args) {
		try {
			InetAddress[] res = Inet4Address.getAllByName("likelion.net");
			for (InetAddress address: res) {
				System.out.println(address.getHostAddress());
				System.out.println(address.getCanonicalHostName());
			}
		} catch (UnknownHostException e) {

			e.printStackTrace();
		}

	}

}
