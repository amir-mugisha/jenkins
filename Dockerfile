FROM eclipse-temurin:22-jdk

WORKDIR /app

COPY target/jenkins-0.0.1-SNAPSHOT.jar /app/jenkins.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/jenkins.jar"]