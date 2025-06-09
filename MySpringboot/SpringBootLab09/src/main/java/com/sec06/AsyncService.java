package com.sec06;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

	@Async //비동기 하겠다.
	public void processAsync(String name) {
		System.out.println("비동기 처리 중: " + name + "(" + Thread.currentThread().getName() + ")");
		
		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println("비동기 처리 완료 : " + name);
	}
}
