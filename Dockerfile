FROM gradle:jdk16 as builder
WORKDIR /app
COPY gradle ./gradle
COPY src ./src
COPY gradlew ./gradlew
COPY build.gradle ./build.gradle
COPY settings.gradle ./settings.gradle
RUN ./gradlew clean build -x test --no-daemon --console=plain

FROM adoptopenjdk/openjdk16:alpine-jre
RUN addgroup --system spring && \
    adduser -D -H -S spring spring
USER spring:spring

COPY --from=builder /app/build/libs/*.jar /app/app.jar
WORKDIR /app

ENTRYPOINT ["java", "-Dfile.encoding=UTF-8", "-jar", "./app.jar"]