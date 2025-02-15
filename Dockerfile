# Base image of jdk
FROM openjdk:17-jdk-alpine
# Add the application's jar to the container
ARG JAR_FILE=target/*.jar
# Copy the jar to the container
COPY ${JAR_FILE} app.jar
# Run the application
ENTRYPOINT ["java","-jar","/app.jar"]
# Expose port
EXPOSE 8080

# Docker build command
# docker build -t eazybytes/accounts .

# Docker run Image command
# docker run -p 8080:8080 eazybytes/accounts:latest

# Docker push command
# docker push eazybytes/accounts:latest

# Docker pull command
# docker pull eazybytes/accounts

# Docker run command
# docker run -p 8080:8080 eazybytes/accounts

# Docker stop command
# docker stop eazybytes/accounts

# Docker rm command
# docker rm eazybytes/accounts


#BuildPacks -> chagen in pom file and add a name in buildpacks at last.
#mvn spring-boot:build-image


#Jib can also build your image directly to a Docker daemon.
# This uses the docker command line tool and requires that you have docker available on your PATH.
# mvn compile jib:dockerBuild

# DOcker iamge push commamnd
# docker image push eazybytes/accounts:latest
