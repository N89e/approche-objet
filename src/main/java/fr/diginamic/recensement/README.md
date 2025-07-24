# Projet Recensement Population - Application Java

## Description

Ce projet est une application Java orientée objet permettant de traiter, analyser et interagir avec des données de recensement de la population française, à partir d’un fichier CSV contenant la liste exhaustive des villes, départements et régions.

L’application permet notamment :
- La lecture d’un fichier CSV avec toutes les villes et leurs informations démographiques.
- La modélisation des entités **Ville**, **Département** et **Région** en classes Java.
- La recherche et l’affichage de la population d’une ville spécifique.
- La recherche et l’affichage de la population totale d’un département.
- La recherche et l’affichage de la population totale d’une région.
- Une architecture propre et modulaire, avec un menu utilisateur et des classes de service dédiées.
- La validation interactive des saisies utilisateur (codes départements, noms de villes, etc.).

Le projet met en pratique la programmation orientée objet, la gestion des fichiers, les collections Java, et les bonnes pratiques d’architecture logicielle.

---


## Fonctionnalités principales

- **Lecture CSV** : chargement des villes à partir d’un fichier CSV (séparateur `;`), extraction des champs pertinents (code région, nom région, code département, code commune, nom commune, population).
- **Modélisation** : représentation claire des villes, départements, régions ; agrégation des populations par niveau géographique.
- **Menu utilisateur** : propose des options :  
  - Recherche population ville  
  - Recherche population département  
  - Recherche population région  
  - Afficher les 10 régions les plus peuplées  
  - Afficher les 10 départements les plus peuplés 
  - Afficher les 10 villes les plus peuplées d’un département 
  - Afficher les 10 villes les plus peuplées d’une région 
  - Afficher les 10 villes les plus peuplées de France 
  - Sortie
- **Saisie validée** : saisie des codes départements, noms villes validés avec feedback en cas d’erreur.
- **Calculs** : cumul des populations par département ou ville, avec anticipation sur la présence possible de données en double.

---

## Installation et exécution

1. **Prérequis** :
    - Java 21.
    - IDE recommandé (IntelliJ IDEA) 
2. **Compilation** :  
   Place le projet dans un dossier source et compile via ton IDE ou en ligne de commande :

javac -d bin src/main/java/fr/diginamic/recensement/**/*.java

texte

3. **Exécution** :  
   Depuis la racine du projet compilé, lance :

java fr.diginamic.recensement.ApplicationRecensement

texte

4. **Fichier CSV** :  
   Place le fichier du recensement (`recensement.csv`) dans le répertoire `src/main/java/fr/diginamic/recensement/src/main/java/fr/diginamic/recensement/`.

---

## Exemple d’utilisation

--- MENU ---

Rechercher la population d'une ville

Rechercher la population d'un département

Quitter
Choisissez une option : 1

Entrez le nom de la ville recherchée : Lyon
Population de Lyon : 515695


---

## Classe principale

La classe `ApplicationRecensement.java` contient la méthode `main` qui initialise la lecture des données et affiche le menu pour interagir avec l’utilisateur.

---
