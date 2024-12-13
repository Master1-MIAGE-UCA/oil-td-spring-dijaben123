# Projet "Dice" - Gestion de lancés de dés avec Spring Boot

## Description
Dans ce projet, j'ai créé une application avec Spring Boot pour simuler des lancés de dés et gérer l'historique des résultats dans une base de données. L'application utilise les principes fondamentaux de Spring Boot, comme l'injection de dépendances, les services RESTful, les entités JPA et les repositories.

## Étapes de réalisation

### 1. Création du projet Spring Boot
- J'ai utilisé [Spring Initializr](https://start.spring.io/) pour créer le projet.
- J'ai choisi la dernière version de Spring Boot disponible (LTS) et j'ai opté pour **Maven** comme outil de gestion de dépendances.
- J'ai ajouté les dépendances nécessaires : **Spring Web**, **Spring Data JPA**, **H2 Database**.

### 2. Configuration du projet
- J'ai configuré l'application pour qu'elle utilise le port **8081**.
- J'ai donné le nom **dice** au projet dans le fichier de configuration (application.properties).

### 3. Création de la classe `Dice`
- J'ai implémenté une classe représentant un dé avec les méthodes nécessaires pour effectuer un lancé.
- Cette classe est marquée avec l'annotation `@Component`, afin de pouvoir l'injecter où nécessaire.

### 4. Création de l'entité `DiceRollLog`
- J'ai modélisé l'entité JPA `DiceRollLog` avec les champs suivants :
  - **`id`** : Identifiant unique.
  - **`diceCount`** : Nombre de dés lancés.
  - **`results`** : Liste ou chaîne des valeurs obtenues. J'ai choisi d'utiliser un `String` pour stocker les résultats des dés.
  - **`timestamp`** : Horodatage du lancé.
- J'ai utilisé des annotations JPA comme `@Entity`, `@Id`, et `@GeneratedValue`.

### 5. Création du `Repository`
- J'ai créé un repository en implémentant une interface héritant de `JpaRepository<DiceRollLog, Long>` pour gérer les interactions avec la base de données.

### 6. Création du contrôleur REST pour lancer les dés
- J'ai créé un contrôleur REST annoté avec `@RestController` pour gérer les requêtes de lancement de dés.
- Les endpoints suivants ont été ajoutés :
  - **`GET /rollDice`** : Pour lancer un seul dé.
  - **`GET /rollDices/{X}`** : Pour lancer X dés, où X est un paramètre dynamique.

### 7. Création du `Service`
- J'ai développé un service marqué avec `@Service`, qui contient une méthode pour :
  - Prendre en paramètre le nombre de dés à lancer.
  - Retourner les résultats des lancés au contrôleur.
  - Enregistrer l'historique des lancés dans la base via le `Repository`.

### 8. Contrôleur pour afficher les historiques
- J'ai ajouté un autre contrôleur REST permettant d'afficher l'historique des lancés :
  - **`GET /diceLogs`** : Ce point de terminaison retourne tous les enregistrements de `DiceRollLog` au format JSON.

### 9. Tests et validation
- J'ai démarré l'application et testé les endpoints pour vérifier leur bon fonctionnement.
- J'ai aussi vérifié les résultats dans la base de données et les réponses JSON renvoyées par l'application.

---

## Livrables
- Le code complet du projet est accessible via un dépôt GitHub.
- Ce fichier `README.md` décrit les étapes réalisées dans le cadre de ce projet.

## Technologies
- **Framework principal** : Spring Boot
- **Base de données** : H2
