# Motor de Cuotas 

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


http://localhost:8080/ms-ppt-metricas/add

http://localhost:8080/ms-ppt-metricas/{id}/get

http://localhost:8080/ms-ppt-metricas/{id}/delete

http://localhost:8080/ms-ppt-metricas/getAll

```

##### Health 

```
http://localhost:9090/actuator

http://localhost:9090/actuator/health

http://localhost:9090/actuator/metrics

http://localhost:9090/actuator/prometheus

```
