FROM openjdk:8-jdk-alpine
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /bar-service/lib
COPY ${DEPENDENCY}/META-INF /bar-service/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /bar-service
ENTRYPOINT ["java","-cp","bar-service:bar-service/lib/*","org.martseniuk.diploma.bar.BarApplication"]