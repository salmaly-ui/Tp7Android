# StarsGallery - Android App

## Description

StarsGallery est une application Android qui affiche une liste de célébrités avec leurs images et leurs notes.
L’utilisateur peut rechercher une célébrité et modifier sa note.

---

## Fonctionnalités

* Affichage d’une liste de célébrités (RecyclerView)
* Recherche en temps réel (SearchView)
* Modification de la note via une boîte de dialogue
* Affichage d’images locales (drawable)
* Partage de l’application
* Interface simple avec Toolbar

---

## Technologies utilisées

* Java
* Android SDK
* RecyclerView
* Material Design
* Architecture simple (Model - Service - Adapter)

---

## Structure du projet

```
com.example.mystars
│
├── adapters
│   └── CelebrityAdapter.java
│
├── models
│   └── Celebrity.java
│
├── services
│   └── CelebrityService.java
│
├── ui
│   ├── MainActivity.java
│   └── SplashActivity.java
│
└── database
    └── ICrud.java
```

---

## Installation

1. Cloner le projet :

```bash
git clone https://github.com/ton-username/StarsGallery.git
```

2. Ouvrir avec Android Studio
3. Lancer l’application

---

# demo 


https://github.com/user-attachments/assets/506eb85c-0046-43d2-95f7-691da7567809



## Remarques

* Les images doivent être placées dans :

```
res/drawable/
```

* Les noms des images doivent être en minuscules sans espaces :

```
zendaya.png
ryan_reynolds.png
```

---

## Auteur

Salma Laouy
Étudiante en 2ème année Informatique
École Normale Supérieure - Marrakech

---

## Licence

Projet réalisé dans un cadre éducatif.
