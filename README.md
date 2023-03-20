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
-Xms1024m
-Xmx1024m
-Xss256k
-Xmn512m
-XX:SurvivorRatio=8
-XX:NewRatio=4
-XX:MetaspaceSize
-XX:MaxMetaspaceSize
-XX:+UseParNewGC
-XX:+UseConcMarkSweepGC
-Xloggc:./gc-%t.log
-XX:+PrintGCDetails
-XX:+PrintGCDateStamps
-XX:+PrintGCCause
-XX:+HeapDumpOnOutOfMemoryError
-XX:HeapDumpPath=./jvm.dump
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

## jvm参数
```
//设置堆初始值
-Xms1g
-XX:InitialHeapSize=2048m

//设置堆区最大值
-Xmx1g
-XX:MaxHeapSize=2048m

//设置线程栈的大小
-Xss256k
-XX:ThreadStackSize=256k

//新生代内存配置
-Xmn512m
-XX:MaxNewSize=512m

//缩小堆内存的时机
-XX:MaxHeapFreeRatio=70//堆内存使用率大于70时扩张堆内存，如果最大堆内存=初始堆内存时该参数无效，默认值70
//扩张堆内存的时机
-XX:MinHeapFreeRatio=40//堆内存使用率小于40时缩减堆内存，如果最大堆内存=初始堆内存时该参数无效，默认值40

//survivor区和Eden区大小比率
-XX:SurvivorRatio=8  //Eden区占新生代比率；Eden:s0:s1=8:1:1； 默认值=8

//新生代和老年代的占比
-XX:NewRatio=4  //老年代占比率；新生代:老年代 = 1:4 即老年代占整个堆的4/5；默认值=2

//初始化的Metaspace大小，
-XX:MetaspaceSize
//Metaspace最大值
-XX:MaxMetaspaceSize

Serial垃圾收集器（新生代）
-XX:+UseSerialGC
-XX:-UseSerialGC
//新生代使用Serial  老年代则使用SerialOld

ParNew垃圾收集器（新生代）
-XX:+UseParNewGC
-XX:-UseParNewGC
//新生代使用功能ParNew 老年代则使用功能CMS

Parallel Scavenge收集器（新生代）
-XX:+UseParallelOldGC
-XX:-UseParallelOldGC
//新生代使用功能Parallel Scavenge 老年代将会使用Parallel Old收集器

ParallelOl垃圾收集器（老年代）
-XX:+UseParallelGC
-XX:-UseParallelGC
//新生代使用功能Parallel Scavenge 老年代将会使用Parallel Old收集器

CMS垃圾收集器（老年代）
-XX:+UseConcMarkSweepGC
-XX:-UseConcMarkSweepGC

G1垃圾收集器
-XX:+UseG1GC
-XX:-UseG1GC

GC日志
-Xloggc:gc-%t.log                   设置日志目录和日志名称
-XX:+UseGCLogFileRotation           开启滚动生成日志
-XX:NumberOfGCLogFiles=5            滚动GC日志文件数，默认0，不滚动
-XX:GCLogFileSize=20M               GC文件滚动大小，需开启UseGCLogFileRotation
-XX:+PrintGCDetails                 开启记录GC日志详细信息（包括GC类型、各个操作使用的时间）,并且在程序运行结束打印出JVM的内存占用情况
-XX:+PrintGCDateStamps              记录系统的GC时间           
-XX:+PrintGCCause                   产生GC的原因(默认开启)

-XX:+HeapDumpOnOutOfMemoryError     异常后打印堆内存信息
-XX:HeapDumpPath=jvm.dump           生成的堆内存日志的路径
```