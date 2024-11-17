# Imagem base com a JDK
FROM maven:3.8.5-openjdk-17

# Diretório onde a aplicação será copiada dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR para o contêiner
COPY target/dummyjson-client-1.0-SNAPSHOT.jar app.jar

# Expõe a porta que a aplicação irá rodar
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]