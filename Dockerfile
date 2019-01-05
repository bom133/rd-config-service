# FROM senexus.pccth.com:8082/websphere-liberty:springBoot2
# ARG program_name
# LABEL Author="sanprasirt@pccth.com"
# COPY /target/${program_name}.war /config/dropins/
# COPY /server.xml /config/
# USER root
# RUN chown -R 1001:0 /config/
# USER 1001
# RUN installUtility install --acceptLicense defaultServer

FROM enxustoon.com:8082/openjdk:8u111-jdk-alpine
ARG program_name
LABEL Author="chaypon@pccth.com"
VOLUME /tmp
ADD /target/${program_name}.war app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

