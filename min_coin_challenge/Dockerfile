# Specify docker image with maven and openJDK 17
FROM maven:3.8.5-openjdk-17
# create '/app' diectory in the container, subsequent commands will be within this folder
WORKDIR /app

# Copy the pom.xml from host machine into container /app/pom.xml
COPY ./pom.xml ./pom.xml
# Run maven to fetch dependencies
RUN mvn dependency:go-offline

# Copy the source code and configuration file from host machine to container
COPY ./src ./src
COPY ./config.yml ./config.yml

# Packages app into a JAR file into `/app/target/min_coin_challenge-1.0.jar`
# clean any previously compiled files
RUN mvn clean package

# Shift the Jar file out from target to /app
RUN mv ./target/min_coin_challenge-1.0.jar /app/backend.jar

# Container to listen on port 8080
EXPOSE 8080

# Set command to run the application
CMD ["java", "-jar", "/app/backend.jar", "server", "/app/config.yml"]