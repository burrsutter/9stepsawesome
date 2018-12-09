FROM nodeshift/centos7-s2i-nodejs:10.x

LABEL maintainer="Burr Sutter \"burrsutter@gmail.com\""

EXPOSE 8000

WORKDIR /opt/app-root/src

COPY hello-http.js .
COPY package.json .

CMD ["npm", "start"]
