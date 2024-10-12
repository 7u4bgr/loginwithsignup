# 1. Aşama: Uygulamayı derleme
FROM maven:3.8.5-openjdk-17 AS build

# Çalışma dizinini ayarlama
WORKDIR /app

# Maven pom.xml ve kaynak dosyalarını kopyalama
COPY pom.xml .
COPY src ./src

# Maven ile projeyi derleme
RUN mvn clean package -DskipTests

# 2. Aşama: Çalıştırma ortamı
FROM openjdk:17-jdk-slim

# Çalışma dizinini ayarlama
WORKDIR /app

# JAR dosyasını kopyalama
COPY --from=build /app/target/newdockersql-0.0.1-SNAPSHOT.jar /app/newdockersql.jar

# Uygulamayı çalıştırma
ENTRYPOINT ["java", "-jar", "newdockersql.jar"]
