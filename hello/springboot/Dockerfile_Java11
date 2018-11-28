FROM openjdk:11
ENV JAVA_APP_JAR boot-demo-0.0.1.jar
WORKDIR /app/
COPY target/$JAVA_APP_JAR .
EXPOSE 8080
CMD java -jar $JAVA_APP_JAR
