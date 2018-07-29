Initial pom.xml created by
mvn io.fabric8:vertx-maven-plugin:1.0.7:setup -DvertxVersion=3.4.2 -Ddependencies=web

Assumes use of CDK Minishift
https://developers.redhat.com/products/cdk/download/

mvn clean compile package

java -jar  target/vertx-demo-1.0-SNAPSHOT.jar
or
mvn vertx:run
http://localhost:8080/hello
ctrl-c

minishift ip
minishift oc-env

oc login 192.168.99.101:8443
admin
admin

(note: the admin user is created by the CDK version of Minishift only)

oc new-project vertxdemo

Note: mvn io.fabric8:fabric8-maven-plugin:3.3.5:setup
was executed to instrument the pom.xml with the F8 Maven plugin

mvn fabric8:deploy

http://vertx-demo-vertxdemo.192.168.99.101.nip.io/hello


