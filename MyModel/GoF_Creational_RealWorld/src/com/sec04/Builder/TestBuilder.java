package com.sec04.Builder;

// 빌더패턴 : 복잡한 객체의 생성과정을 단계별로 분리한다. -> 객체 생성을 여러개로 나누었다.
// 빌더 객체 생성 -> 빌더의 메소드를 호출 -> 메소드 체이닝 -> .build() 라는 메소드로 최종 객체를 리턴 받음
public class TestBuilder {
    public static void main(String[] args) {
        Report report = new ReportBuilder()
            .setHeader("=== Report ===") //객체.setHeader / 객체.setBody / 객체.setFooter를 한번에 작성 
            .setBody("Data goes here")
            .setFooter("End of Report")
            .build();
        report.print();
        // String, StringBuffer  .append("a").append("b").toString() , StringBuilder 등 - builder패턴
        
        System.out.println(new StringBuffer().append("abc").append("ddd").toString());
    }
}
