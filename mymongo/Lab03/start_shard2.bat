@echo off
echo Starting MongoDB Shard Servers for RS2...
REM mydata04 샤드 서버 시작
start mongod --shardsvr --dbpath c:\db\mydata04 --logpath c:\db\log\shard4.log --port 27040  --replSet RS2
REM mydata05 샤드 서버 시작
start mongod --shardsvr --dbpath c:\db\mydata05 --logpath c:\db\log\shard5.log --port 27041 --replSet RS2
REM mydata06 샤드 서버 시작
start mongod --shardsvr --dbpath c:\db\mydata06 --logpath c:\db\log\shard6.log --port 27042  --replSet RS2
echo MongoDB Shard RS2 Servers started.
pause