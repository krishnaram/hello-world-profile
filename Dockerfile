FROM java:8
ADD /${project.build.finalName}.jar
ENTRYPOINT ["java","-Dspring.profiles.active=dev", "-jar", "/${project.build.finalName}.jar"]