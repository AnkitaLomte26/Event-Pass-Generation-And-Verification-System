FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . .

RUN ./mvnw clean install -DskipTests

CMD ["java", "-jar", "target/Event-Pass-Generation-And-Verification-System-0.0.1-SNAPSHOT.jar"]
