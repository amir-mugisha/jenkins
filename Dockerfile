FROM eclipse-temurin:22-jdk

WORKDIR /app

COPY target/jenkins-0.0.1-SNAPSHOT.war /app/jenkins.war

EXPOSE 8080

ENTRYPOINT ["java", "-war", "/app/jenkins.war"]