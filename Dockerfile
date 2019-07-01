FROM adoptopenjdk/openjdk11:alpine-slim
EXPOSE 8080
COPY build/libs/demo-* demo.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/demo.jar"]
