FROM tomcat:9.0.20-jre8-alpine
EXPOSE 8080
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./src/main/resources/tomcat/conf/* /usr/local/tomcat/conf/
COPY ./target/dockerfile-maven-api-1.0.war /usr/local/tomcat/webapps/smarti.war
CMD ["catalina.sh","run"]	