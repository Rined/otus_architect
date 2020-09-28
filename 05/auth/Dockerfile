FROM gradle:6.5.1-jdk8

ENV PROJECT_DIR=/opt/project
WORKDIR $PROJECT_DIR

ADD ./src/ $PROJECT_DIR/src
ADD ./build.gradle $PROJECT_DIR
ADD ./settings.gradle $PROJECT_DIR
RUN gradle build -x test


FROM openjdk:8-jdk-alpine

ENV PROJECT_DIR=/opt/project
WORKDIR $PROJECT_DIR

COPY --from=0 $PROJECT_DIR/build/libs/auth.jar $PROJECT_DIR/

EXPOSE 8000

CMD ["java", "-jar", "auth.jar"]