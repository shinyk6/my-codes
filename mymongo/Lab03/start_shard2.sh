#!/bin/bash
echo "Starting MongoDB Shard Servers for RS2..."
# mydata04 샤드 서버 시작
mongod --shardsvr --dbpath /db/mydata04 --logpath /db/log/shard4.log --port 27040 --replSet RS2 &
# mydata05 샤드 서버 시작
mongod --shardsvr --dbpath /db/mydata05 --logpath /db/log/shard5.log --port 27041 --replSet RS2 &
# mydata06 샤드 서버 시작
mongod --shardsvr --dbpath /db/mydata06 --logpath /db/log/shard6.log --port 27042 --replSet RS2 &
echo "MongoDB Shard RS2 Servers started."