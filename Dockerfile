FROM amazoncorretto:11.0.13

ADD target/mongock.jar mongock.jar

ENTRYPOINT ["java", "-jar","/mongock.jar" ]
