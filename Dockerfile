# Docker 이미지의 베이스로 사용할 이미지를 지정합니다.
FROM openjdk:17-jdk-slim

# 패키지 목록 업데이트 및 curl 설치
RUN apt-get update && apt-get install -y curl

# 작업 디렉토리를 지정합니다.
WORKDIR /app

# wait-for-it 스크립트를 복사합니다.
COPY wait-for-it.sh /app/wait-for-it.sh

# 스크립트에 실행 권한을 부여합니다.
RUN chmod +x /app/wait-for-it.sh

# 빌드된 JAR 파일을 현재 디렉토리로 복사합니다.
COPY build/libs/shoppingmall-0.0.1-SNAPSHOT.jar /app/shoppingmall-0.0.1-SNAPSHOT.jar

# wait-for-it.sh 스크립트를 사용하여 MongoDB와 PostgreSQL이 시작될 때까지 대기하고 애플리케이션을 실행합니다.
CMD ["/app/wait-for-it.sh", "mongodb:27017", "--timeout=60", "--strict", "--", "/app/wait-for-it.sh", "postgres:5432", "--timeout=60", "--strict", "--", "java", "-jar", "-Dspring.main.allow-bean-definition-overriding=true", "/app/shoppingmall-0.0.1-SNAPSHOT.jar"]
