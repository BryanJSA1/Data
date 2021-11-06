FROM openjdk:8-jdk-alpine
COPY "/target/primera-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]