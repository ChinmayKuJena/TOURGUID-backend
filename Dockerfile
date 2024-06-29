# Use a base image with Java runtime
FROM openjdk:17-jdk-slim



# Copy the application jar file to the container
COPY build/libs/tourroadmap-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the application will run on
EXPOSE 3030

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/postgres
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=chinmay09
ENV SPRING_KAFKA_BOOTSTRAP_SERVERS=host.docker.internal:9092

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]
