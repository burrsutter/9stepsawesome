FROM openjdk:8
ENV JAVA_APP_JAR boot-postgres-0.0.1.jar
WORKDIR /app/
COPY target/$JAVA_APP_JAR .
EXPOSE 8080
CMD java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:+PrintFlagsFinal -XX:+PrintGCDetails $JAVA_OPTIONS -jar $JAVA_APP_JAR
