FROM openjdk:8
ENV JAVA_APP_JAR boot-postgres-0.0.1.jar
WORKDIR /app/

RUN apt-get update && apt-get install -y maven

EXPOSE 8080
CMD java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap $JAVA_OPTIONS -jar $JAVA_APP_JAR
