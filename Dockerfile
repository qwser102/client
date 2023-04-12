FROM 192.168.132.179:31104/sw/base:v1

ADD ./target/client-0.0.1-SNAPSHOT.jar /app/
RUN mkdir -p /app/servlet/logs
CMD ["sh", "-c", "cd /app; java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app/client-0.0.1-SNAPSHOT.jar ${RUN_ARGS}"]

EXPOSE 8002
