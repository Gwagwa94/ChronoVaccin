# Image de base avec JDK 21
FROM openjdk:21-jdk-slim

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le JAR de l'application dans le conteneur

COPY build/libs/*.jar app.jar
# Adaptez ce chemin si votre JAR est ailleurs

# Exposer le port 8080
EXPOSE 8080

# Commande pour exécuter l'application
CMD ["java", "-jar", "app.jar"]