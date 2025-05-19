package com.sec05.Prototype;


// Cloneable = 프로토타입 인터페이스
public class Document implements Cloneable {
    private String content;

    public Document(String content) {
        this.content = content;
    }

    public void show() {
        System.out.println("Document: " + content);
    }

    @Override
    public Document clone() { 
        return new Document(this.content); //shallow copy - 참조값만 복사
    }
}
