FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . .

# Set permissions for mvnw and build the project
RUN chmod +x mvnw && ./mvnw clean install -DskipTests

CMD ["java", "-jar", "target/Event-Pass-Generation-And-Verification-System-0.0.1-SNAPSHOT.jar"]
