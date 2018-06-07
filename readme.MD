http://10.170.1.182:7904/hystrix
1、默认的集群监控
   通过URL http://turbine-hostname:port/turbine.stream开启,实现对集群的监控
   
2、指定集群监控
   通过URL http://turbine-hostname:port/turbine.stream?cluster=[clusterName]开启,实现对clusterName集群的监控
3、单体应用的监控
   通过URL http://hystrix-app:port/hystrix.stream开启,实现对具体某个服务实例的监控   
   
   http://10.170.1.182:7904/hystrix.stream
   http://10.170.1.182:8031/turbine.stream