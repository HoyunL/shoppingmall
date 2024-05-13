# Docker 이미지의 베이스로 사용할 이미지를 지정합니다.
FROM openjdk:17

# 작업 디렉토리를 지정합니다.
WORKDIR /app

# 빌드된 JAR 파일을 현재 디렉토리로 복사합니다.
COPY build/libs/shoppingmall-0.0.1-SNAPSHOT.jar /app/shoppingmall-0.0.1-SNAPSHOT.jar

# 애플리케이션을 실행합니다.
CMD ["java", "-jar","-Dspring.main.allow-bean-definition-overriding=true","shoppingmall-0.0.1-SNAPSHOT.jar"]