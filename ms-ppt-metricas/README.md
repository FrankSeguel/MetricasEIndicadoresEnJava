# MS PPT Metricas 

[SpringBoot](http://projects.spring.io/spring-boot/)

#### Prerequisite 

Installed:
[git](https://www.digitalocean.com/community/tutorials/how-to-contribute-to-open-source-getting-started-with-git)

Optional:   
[Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

[Maven 3.x](https://maven.apache.org/download.cgi)

[Gradle 8.2.1](https://gradle.org/)


#### Steps

##### Clone source code from git
```
git clone 

git checkout 

```

##### Build 
```
gradle build
```
##### Run JAVA
```
java -jar build/libs/ms-ppt-metricas-0.0.1-SNAPSHOT.jar
```


##### SWAGGER y TEST

```
http://localhost:8080/ms-ppt-metricas/swagger-ui/index.html
```
![SWAGGER](/doc/imagenes/swagger-ui.png)

```
PUT
http://localhost:8080/ms-ppt-metricas/

GET
http://localhost:8080/ms-ppt-metricas/{id}/get

DELETE
http://localhost:8080/ms-ppt-metricas/{id}/delete

GET
http://localhost:8080/ms-ppt-metricas/

```
##### JMeter - Pruebas automaticas 

![SWAGGER](/doc/imagenes/jmeter.png)

##### Health 

```
http://localhost:9090/actuator

http://localhost:9090/actuator/health

http://localhost:9090/actuator/metrics

http://localhost:9090/actuator/prometheus

```
