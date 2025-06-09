package com.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // DB의 Auto_increment대응
	public Long id;
	
	//public Long postId; 
	public String writer; 
	public String content; 

	//연관관계 설정
	@ManyToOne //단방향 Comment → Post로만 접근 가능
	@JoinColumn(name="post_Id") //DB컬럼 post_id컬럼을 생성해서 매핑해줌 
	private Post post; //연관된 Post엔티티 자체를 들고 있게 됨
	
}
