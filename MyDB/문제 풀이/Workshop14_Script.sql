# DROP TABLE STORE CASCADE CONSTRAINTS;
# DROP TABLE PRODUCT CASCADE CONSTRAINTS;
# DROP TABLE FACTORY CASCADE CONSTRAINTS;

drop table if exists PRODUCT;
CREATE TABLE PRODUCT(
PDNO DECIMAL(8) PRIMARY KEY,
PDNAME VARCHAR(10),
PDSUBNAME VARCHAR(10),
FACTNO VARCHAR(5),
PDDATE DATE,
PDCOST DECIMAL(12),
PDPRICE DECIMAL(12),
PDAMOUNT DECIMAL(12),
Foreign key(FACTNO) REFERENCES FACTORY(FACTNO));

desc product;

INSERT INTO PRODUCT VALUES
(20110001,'TV','INFINIA-01','98710','2010-12-17',830000,970000,200);
INSERT INTO PRODUCT VALUES
(20110002,'TV','INFINIA-02','98711','2010-01-01',1250000,1450000,0);
INSERT INTO PRODUCT VALUES
(20110003,'TV','XCANVAS-01','98711','2010-03-10',800000,1200000,null);
INSERT INTO PRODUCT VALUES
(20110004,'TV','XCANVAS-02','98712','2010-11-27',750000,770000,30);
INSERT INTO PRODUCT VALUES
(10100001,'WASHER','PA-01','98710','2009-02-17',240000,270000,null);
INSERT INTO PRODUCT VALUES
(10100002,'WASHER','PA-02','98710','2009-04-12',350000,370000,10);
INSERT INTO PRODUCT VALUES
(10100003,'WASHER','PA-03','98712','2009-03-17',450000,470000,200);
INSERT INTO PRODUCT VALUES
(10100004,'WASHER','PA-04','98713','2009-04-12',340000,390000,100);
INSERT INTO PRODUCT VALUES
(30100001,'CELLPHONE','OPTIMUS-01','98713','2010-03-18',830000,890000,20);
INSERT INTO PRODUCT VALUES
(30100002,'CELLPHONE','OPTIMUS-02','98713','2010-04-13',940000,990000,200);
INSERT INTO PRODUCT VALUES
(30100003,'CELLPHONE','OPTIMUS-03','98711','2010-04-03',630000,690000,50);
INSERT INTO PRODUCT VALUES
(30100004,'CELLPHONE','OPTIMUS-04','98710','2010-12-23',990000,1090000,300);

drop table if exists factory;
CREATE TABLE FACTORY
(FACTNO VARCHAR(5) PRIMARY KEY,
FACNAME VARCHAR(20),
FACLOC VARCHAR(13) );

INSERT INTO FACTORY VALUES (98710,'SEOUL FACTORY','SEOUL');
INSERT INTO FACTORY VALUES (98711,'PUSAN FACTORY','PUSAN');
INSERT INTO FACTORY VALUES (98712,'CHANGWON FACTORY','CHANGWON');
INSERT INTO FACTORY VALUES (98713,'OSAN FACTORY','OSAN');


drop table if exists STORE;
CREATE TABLE STORE
(STONO VARCHAR(5) PRIMARY KEY,
STONAME VARCHAR(20),
PDNO DECIMAL(8),
STAMOUNT DECIMAL(12),
STSALES DECIMAL(12),
STPRICE DECIMAL(12),
foreign key(PDNO) references PRODUCT(PDNO)
);

show tables;

INSERT INTO STORE VALUES (10710,'HI-MART',20110001,20,5,990000);
INSERT INTO STORE VALUES (10711,'HI-MART',30100001,30,1,1090000);
INSERT INTO STORE VALUES (10712,'HI-MART',10100001,50,3,470000);
INSERT INTO STORE VALUES (10713,'HI-MART',20110001,10,2,995000);
INSERT INTO STORE VALUES (10714,'HI-MART',30100001,3,6,1020000);
INSERT INTO STORE VALUES (10715,'HI-MART',10100001,5,10,490000);

INSERT INTO STORE VALUES (20710,'e-MART',20110001,3,40,1130000);
INSERT INTO STORE VALUES (20711,'e-MART',30100001,4,50,1110000);
INSERT INTO STORE VALUES (20712,'e-MART',10100001,2,90,490000);
INSERT INTO STORE VALUES (20713,'e-MART',20110001,80,20,998000);
INSERT INTO STORE VALUES (20714,'e-MART',30100001,34,23,1120000);
INSERT INTO STORE VALUES (20715,'e-MART',10100001,12,1,510000);

INSERT INTO STORE VALUES (30710,'TESCO',20110001,0,10,1240000);
INSERT INTO STORE VALUES (30711,'TESCO',30100001,0,0,1210000);
INSERT INTO STORE VALUES (30712,'TESCO',10100001,0,0,590000);
INSERT INTO STORE VALUES (30713,'TESCO',20110001,null,null,998000);
INSERT INTO STORE VALUES (30714,'TESCO',30100001,2,3,1170000);
INSERT INTO STORE VALUES (30715,'TESCO',10100001,1,1,580000);

INSERT INTO STORE VALUES (40710,'LOTTE-MART',20110001,12,0,1010000);
INSERT INTO STORE VALUES (40711,'LOTTE-MART',30100001,0,0,1110000);
INSERT INTO STORE VALUES (40712,'LOTTE-MART',10100001,1,1,595000);
INSERT INTO STORE VALUES (40713,'LOTTE-MART',20110001,4,2,998500);
INSERT INTO STORE VALUES (40714,'LOTTE-MART',30100001,2,3,1171000);
INSERT INTO STORE VALUES (40715,'LOTTE-MART',10100001,1,1,581000);

COMMIT;