# Utiliser une image Java comme image de base
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR généré dans l'image Docker
COPY target/tp-springboot-0.0.1-SNAPSHOT.jar /app/tp-springboot.jar


# Exposer le port sur lequel l'application va écouter
EXPOSE 8080

# Commande pour démarrer l'application Spring Boot
ENTRYPOINT ["java", "-jar", "tp-springboot.jar"]
