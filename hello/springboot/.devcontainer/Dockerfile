FROM openjdk:8u151
ENV JAVA_APP_JAR boot-demo-0.0.1.jar

## Ensure maven is installed
RUN apt-get update -y && apt-get install maven -y

WORKDIR /app/
EXPOSE 8080
CMD java -XX:+PrintFlagsFinal -XX:+PrintGCDetails $JAVA_OPTIONS -jar $JAVA_APP_JAR
