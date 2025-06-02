# Imagem base otimizada para Java 21
FROM eclipse-temurin:21-jdk-jammy

# Diretório de trabalho no container
WORKDIR /app

# Copia o arquivo JAR para o container
COPY codeconnect-api.jar app.jar

# Expõe a porta da aplicação
EXPOSE 8080

# Comando de execução
ENTRYPOINT ["java", "-jar", "app.jar"]