Intial pom.xml created by start.spring.io

mvn clean compile package

java -jar target/boot-demo-0.0.1.jar
or
mvn spring-boot:run
curl http://localhost:8080/
ctrl-c

minishift ip
minishift oc-env

oc login $(minishift ip):8443 -u admin -p admin
admin
admin

oc new-project bootdemo

add to the pom.xml
      <plugin>
        <groupId>io.fabric8</groupId>
        <artifactId>fabric8-maven-plugin</artifactId>
        <version>3.5.40</version>
      </plugin>

mvn fabric8:deploy

Take note of the src/main/fabric8 files which insure we have the right namespace as well as the NodePort settings


