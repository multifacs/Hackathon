FROM gradle:7.2.0-jdk11 as build

COPY ./ /build
WORKDIR /build

RUN gradle --no-daemon build

FROM openjdk:11-jre as app

COPY --from=build /build/build/libs/*.jar /app/backend.jar

WORKDIR /app
EXPOSE 8080
ENTRYPOINT java -jar ./backend.jar