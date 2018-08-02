FROM node:8

MAINTAINER Burr Sutter "burrsutter@gmail.com"

EXPOSE 8000

WORKDIR /usr/src/

COPY hello-http.js /usr/src
COPY package.json /usr/src

CMD ["/bin/bash", "-c", "npm start" ]
