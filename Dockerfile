#Start from the base image which holds JDK 8
FROM openjdk:21-jdk

#Put workmaterial where we work on the app
WORKDIR /app
# Copy Maven
COPY mvnw .
COPY .mvn .mvn

#Copy pom file and source code
COPY pom.xml .
COPY src src

#Build application
RUN ./mvnw package -DskipTests -e

#Run application
CMD ["java", "-jar", "target/spring_mysql_api-0.0.1-SNAPSHOT.jar"]