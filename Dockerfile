FROM 192.168.132.179:31104/sw/base:v1

ADD ./target/client-0.0.1-SNAPSHOT.jar /app/
CMD ["sh", "-c", "cd /app; java -javaagent:/skywalking/agent/skywalking-agent.jar -jar /app/client-0.0.1-SNAPSHOT.jar"]
