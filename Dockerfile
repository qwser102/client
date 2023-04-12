FROM 192.168.132.179:31104/sw/base:v1

ADD ./target/client-0.0.1-SNAPSHOT.jar /app/
ADD skywalking.tar.gz /
RUN mkdir -p /app/servlet/logs
CMD ["sh", "-c", "cd /app; java -javaagent:/skywalking/agent/skywalking-agent.jar -jar /app/client-0.0.1-SNAPSHOT.jar"]
