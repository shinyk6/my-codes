package com.test01.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public @Data class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에 위임하겠다 (db에서 autoincrement를 함)
    private Long id;
    @Column(nullable = false, unique = true) //null값 X , 데이터 유일값(중복x)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role = "ROLE_USER";
    private LocalDateTime createdAt = LocalDateTime.now(); //최초 생성 시점 
}
