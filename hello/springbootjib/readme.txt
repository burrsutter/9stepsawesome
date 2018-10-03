This example builds a linux container image, without a Dockerfile, via jib

https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin#example


eval $(minishift docker-env)

mvn compile jib:dockerBuild -Dimage=9stepsawesome/myboot:v1

docker run -it -p 8080:8080 9stepsawesome/myboot:v1

curl $(minishift ip):8080

