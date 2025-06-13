@echo off 
echo Starting MongoDB Config Servers... 
REM mongoc1 Config 서버 시작 
start mongod --configsvr --dbpath c:\db\mongoc1 --logpath c:\db\log\mongoc1.log --port 27011 --replSet CRS 
REM mongoc2 Config 서버 시작 
start mongod --configsvr --dbpath c:\db\mongoc2 --logpath c:\db\log\mongoc2.log --port 27012 --replSet CRS
REM mongoc3 Config 서버 시작 
start mongod --configsvr --dbpath c:\db\mongoc3 --logpath c:\db\log\mongoc3.log --port 27013 --replSet CRS  
echo MongoDB Config Servers started. 
pause 