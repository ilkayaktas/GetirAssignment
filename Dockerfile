FROM openjdk:13-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENV MYSQL_IP={MYSQL_IP}
ENTRYPOINT ["java","-jar","/app.jar"]

# docker build --build-arg JAR_FILE=build/libs/\*.jar -t ilkayaktas/readingisgood-getir .
# docker run --name readingisgood-getir --restart=unless-stopped -p 8080:8080 ilkayaktas/readingisgood-getir