# 기존 openjdk:17-jdk 대신 Java 21 사용
FROM openjdk:21-jdk

# 작업 디렉토리 설정
WORKDIR /app

# JAR 파일 복사
COPY ../build/libs/demo-0.0.1-SNAPSHOT.jar app.jar

# 실행 명령어
CMD ["java", "-jar", "app.jar"]
