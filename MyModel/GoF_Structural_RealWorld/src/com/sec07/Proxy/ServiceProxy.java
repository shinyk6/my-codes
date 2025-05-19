package com.sec07.Proxy;

//대리자 (다른 객체의 접근제어를 함)
public class ServiceProxy {
	
	private RealService realService = new RealService();

	public void request() {
		System.out.println("[Proxy] Logging access...");
		realService.request();
	}
}
