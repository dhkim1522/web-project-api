FROM openjdk:11
LABEL maintainer="dhkim1522 <dh.kim3@okestro.com>"

RUN mkdir -p /app/web-project-api
RUN chmod -R +w /app/web-project-api

ADD ./target/web-project-api-0.0.1-SNAPSHOT.jar /app/web-project-api

WORKDIR /app/web-project-api

ENV LC_ALL ko_KR.UTF-8

EXPOSE 3000
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=local", "web-project-api-0.0.1-SNAPSHOT.jar"]