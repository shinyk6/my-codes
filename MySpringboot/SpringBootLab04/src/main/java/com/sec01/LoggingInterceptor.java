package com.sec01;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//HandlerInterceptor -> MVC 요청, 시작, 종료의 흐름을 가로채기해서 로그를 출력해보자.
@Component // 1.가로 채기 코드 작성 2. WebMvcConfiguerer (WebConfig)
public class LoggingInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println(">>>> 요청 URL: "+request.getRequestURI());
		return true; //계속 진행할거야
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("<<<< 요청 완료 했어!!!!!");
	}
}
