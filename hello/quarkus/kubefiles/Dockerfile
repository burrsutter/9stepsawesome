FROM registry.access.redhat.com/ubi8/ubi-minimal
WORKDIR /work/
RUN chgrp -R 0 /work && \ 
    chmod -R g=u /work
COPY target/*-runner /work/application
# RUN chmod 775 /work
EXPOSE 8080
ENTRYPOINT [ "./application", "-Xmx8m", "-Xmn8m", "-Xms8m" ]
