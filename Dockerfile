FROM openjdk:11
ADD target/lacosina.jar lacosina.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "lacosina.jar"]
