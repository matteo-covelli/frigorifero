FROM eclipse-temurin:17-alpine
COPY ./target/frigorifero-0.0.1-SNAPSHOT.jar /frigorifero-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/frigorifero-0.0.1-SNAPSHOT.jar"]