FROM adoptopenjdk:16-jre-hotspot

RUN addgroup --system spring && \
    APPGROUP=`grep "spring" /etc/group|cut -d: -f3` && \
    adduser --gid $APPGROUP --system --no-create-home --disabled-login --disabled-password spring
USER spring:spring

COPY build/libs/*.jar /app/app.jar
WORKDIR /app

ENTRYPOINT ["java", "-Dfile.encoding=UTF-8", "-jar", "./app.jar"]