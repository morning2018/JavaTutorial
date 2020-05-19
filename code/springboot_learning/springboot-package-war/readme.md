### springboot编译为war
1.使用springboot开发完成后，打包成war,用于后续部署。

打包命令：
~~~
mvn clean package spring-boot:repackage
~~~
生成war后放到tomcat的webapp目录下，运行tomcat后在访问。