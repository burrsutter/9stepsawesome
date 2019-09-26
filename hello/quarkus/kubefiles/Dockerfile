FROM registry.access.redhat.com/ubi7-dev-preview/ubi-minimal
WORKDIR /work/
COPY target/quarkus-demo-1.0.0-runner /work/quarkus-demo-1.0.0-runner
RUN chmod 775 /work
EXPOSE 8080
ENTRYPOINT [ "./quarkus-demo-1.0.0-runner", "-Xmx8m", "-Xmn8m", "-Xms8m" ]
