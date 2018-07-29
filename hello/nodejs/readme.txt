Assumes use of CDK Minishift
https://developers.redhat.com/products/cdk/download/

minishift docker-env

docker build -t burr/mynode:v1 . 

docker images | grep mynode

docker run -d -p 8000:8000 burr/mynode:v1

docker ps | grep mynode

docker exec -it 08efa083696b /bin/bash

cat /etc/system-release

exit

docker stop 08efa083696b

docker rm 08efa083696b

