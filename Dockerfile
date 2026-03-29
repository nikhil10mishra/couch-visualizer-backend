FROM maven:3.9.9-eclipse-temurin-17

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

CMD ["sh", "-c", "java -Dserver.port=$PORT -Dserver.address=0.0.0.0 -jar target/*.jar"]