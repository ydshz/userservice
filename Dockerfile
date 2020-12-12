FROM openjdk:15-jdk-alpine
WORKDIR /app
COPY . /app
RUN ./gradlew bootJar

FROM openjdk:15-jdk-alpine
WORKDIR /app
COPY --from=0 /app/build/libs/userservice-0.0.1-SNAPSHOT.jar .
CMD java -jar -Dspring.profiles.active=docker userservice-0.0.1-SNAPSHOT.jar
