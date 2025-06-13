@echo off
echo Starting MongoDB Shard Servers...
REM mydata01 샤드 서버 시작
start mongod --shardsvr --dbpath c:\db\mydata01 --logpath c:\db\log\shard1.log --port 27030 --replSet RS
REM mydata02 샤드 서버 시작
start  mongod --shardsvr --dbpath c:\db\mydata02 --logpath c:\db\log\shard2.log --port 27031 --replSet RS
REM mydata03 샤드 서버 시작
start mongod --shardsvr --dbpath c:\db\mydata03 --logpath c:\db\log\shard3.log --port 27032 --replSet RS
echo MongoDB Shard Servers started.
pause