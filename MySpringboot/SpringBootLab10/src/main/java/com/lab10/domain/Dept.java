package com.lab10.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("dept") 
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class Dept {
	@Id 
    private Integer deptno; // _id 매핑 
    private String dname;        
    private String loc;          
 
    //  지도 API 마커 표시를 위한 위도/경도 정보 
    private Double latitude;     // 위도  위도경도는 Double로 처리
    private Double longitude;    // 경도   네이버 지도에서 마커 표시용 위치 좌표로 사용
}
