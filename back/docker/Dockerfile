FROM gradle:7.2.0-jdk11 AS TEMP_BUILD_IMAGE
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build.gradle.kts settings.gradle.kts $APP_HOME

COPY gradle $APP_HOME/gradle

COPY . .
RUN gradle clean build -x test

# actual container
FROM adoptopenjdk/openjdk11:alpine-jre
ENV ARTIFACT_NAME=mountainresort-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME
COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/$ARTIFACT_NAME .

EXPOSE 8080
ENTRYPOINT exec java -jar ${ARTIFACT_NAME}