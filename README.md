# troubleshooting

## cpu_load
```
top -H
top -H -p <pid>

ps -mp <pid> -o THREAD,tid,time

printf '%x\n' <pid>

jstack <pid>|grep <tid>
```

## gc
```

```

## 网络
```
netstat  -n 打印数字端口号 -t tcp连接 -l 监听端口 -a 所有端口 -p 进程号 -s 打印统计信息|grep 进程号 or 端口号 查看进程的连接
netstat-ntap|grep <pid>
```

## 磁盘
```
iostat -k 用kb为单位 -d 监控磁盘 -x显示详情 num count 每个几秒刷新 显示次数
iostat -kdx 2 10

rkB/s和wkB/s: 分别对应读写速度
avgqu-sz: 读写队列的平均请求长度
```