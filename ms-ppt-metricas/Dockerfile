FROM eclipse-temurin:17.0.7_7-jdk-alpine

RUN  apk update && apk upgrade

ENV PORT_HOST 8080
ENV PORT_ACTU 9090
EXPOSE $PORT_HOST $PORT_ACTU

ARG VERSION

COPY ./build/libs/*.jar /opt/target/

RUN mv /opt/target/ms-ppt-metricas-0.0.1-SNAPSHOT.jar /opt/target/app.jar

WORKDIR /opt/target

# Crear usuario
RUN adduser -D dockeruser

# Asignar permisos
RUN chown -R dockeruser /opt/target/

# Se define el usuario a ejecutar
USER dockeruser

CMD ["/bin/sh", "-c", "java -Dfile.encoding=UTF-8 -Dspring.profiles.active=local -jar app.jar" ]
