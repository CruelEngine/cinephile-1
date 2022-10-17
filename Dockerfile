FROM mcr.microsoft.com/java/jdk:11-zulu-ubuntu
CMD  java ${JAVA_OPTS} -jar cinephile-0.1-all.jar
COPY build/libs/*-all.jar cinephile-0.1-all.jar
COPY wait-for wait-for