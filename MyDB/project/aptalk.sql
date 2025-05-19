#drop database aptalk;
-- 1. 데이터베이스 생성
create database if not exists aptalk;

-- 2. 사용자 계정 생성 (있으면 SKIP)
CREATE USER IF NOT EXISTS 'aptalk'@'%' IDENTIFIED BY 'aptalk12#$';

-- 3. 권한 부여
GRANT ALL PRIVILEGES ON aptalk.* TO 'aptalk'@'%';
GRANT ALL PRIVILEGES ON aptalk.* TO 'aptalk'@'localhost';
FLUSH PRIVILEGES;

-- 4. DB 사용
USE aptalk;

-- 방 테이블
CREATE TABLE IF NOT EXISTS room (
	partid VARCHAR(10) DEFAULT '000',    -- 동 (사용자 id)
    roomid VARCHAR(10),					 -- 호수 (사용자 id)
    username VARCHAR(50),                -- 사용자 이름 추가
    authcode INT default 1111,			 -- 아파트 식별자
    PRIMARY KEY (partid, roomid)
);

-- 사용자 테이블
CREATE TABLE IF NOT EXISTS USER (
	partid VARCHAR(10) DEFAULT '000',	 -- 동 (사용자 id)
    roomid VARCHAR(10),                  -- 호수 (사용자 id)
    passwd VARCHAR(255),				 -- 사용자 비밀번호
    username VARCHAR(50),				 -- 사용자 이름
    user_role enum("admin", "user"),	 -- 사용자 역할/권한
    regdate DATETIME DEFAULT CURRENT_TIMESTAMP,   	-- 가입일
    PRIMARY KEY (partid, roomid),
    FOREIGN KEY (partid, roomid) REFERENCES room(partid, roomid)
);

-- 메시지 테이블
CREATE TABLE IF NOT EXISTS MESSAGE (
    mid INT PRIMARY KEY AUTO_INCREMENT,       
    sender_partid VARCHAR(10) DEFAULT '000',					-- 유저(방) <-> 방 연동한 메시지 내역 참조
    sender_roomid VARCHAR(10),					                -- 유저(방) <-> 방 연동한 메시지 내역 참조
    message TINYTEXT,											-- 최대 255자 문자열 
    user_role enum("admin", "user"), 
    cdate DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (sender_partid, sender_roomid) REFERENCES user(partid, roomid)
);
