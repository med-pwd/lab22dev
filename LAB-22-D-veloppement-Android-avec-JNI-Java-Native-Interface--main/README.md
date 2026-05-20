#  Lab JNISemo : Maîtriser Android NDK & JNI
analyste:souaid med amine

## Présentation du Projet
**JNISemo** est un laboratoire pratique développé dans le cadre du cursus à l'**EMSI**. Ce projet explore l'intégration du code natif **C++** dans une application Android via le **JNI (Java Native Interface)**. L'objectif est de démontrer comment déléguer des tâches complexes au processeur via le NDK pour optimiser les performances, la sécurité et la manipulation de données bas niveau.

---

##  Qu'est-ce que le JNI ?
Le **JNI (Java Native Interface)** est un pont (framework) qui permet au code s'exécutant dans la Machine Virtuelle Java (JVM) d'appeler et d'être appelé par des applications natives (écrites en C, C++ ou Assembleur).

### Pourquoi utiliser JNI dans ce projet ?
1.  **Calcul Intensif** : Le C++ traite les opérations mathématiques plus rapidement que le Java.
2.  **Manipulation Bas Niveau** : Accès direct à la mémoire pour le traitement de tableaux et de chaînes.
3.  **Réutilisation** : Possibilité d'intégrer des bibliothèques C++ existantes (OpenCV, Moteurs audio, etc.).
4.  **Sécurité** : Le code compilé en bibliothèque native (`.so`) est plus difficile à rétro-concevoir que le bytecode Java.

---

##  Architecture du Laboratoire
Le projet repose sur la synchronisation de trois composants clés :
*   **Couche Haute (Java)** : `MainActivity.java` déclare les méthodes `native` et gère l'interface utilisateur.
*   **Couche Basse (C++)** : `native-lib.cpp` contient l'implémentation logique en C++.
*   **Le Pont (CMake)** : `CMakeLists.txt` configure la compilation du code C++ vers le système Android.

---

##  Fonctionnalités & Tests Guidés
L'application affiche un **Rapport de Tests JNI** dynamique à l'aide de composants Material Design, validant les scénarios suivants :

### 1. Salutation Native
*   **Méthode** : `helloFromJNI()`
*   **Résultat attendu** : "Hello from C++ via JNI !" (Vérification de la liaison).

### 2. Algorithmes Mathématiques
*   **Méthode** : `factorial(int n)`
*   **Tests implémentés** : 
    *   `factorial(10)` ➜ `3628800` (Valeur normale).
    *   `factorial(-5)` ➜ `-1` (Gestion des erreurs de valeurs négatives).
    *   `factorial(20)` ➜ `-2` (Gestion du dépassement de capacité/Overflow).

### 3. Traitement de Texte
*   **Méthode** : `reverseString(String s)`
*   **Résultat** : Inversion performante de chaînes (ex: "JNI is powerful!" devient "!lufrewop si INJ"). Gestion des chaînes vides incluse.

### 4. Analyse de Tableaux
*   **Méthode** : `sumArray(int[] values)`
*   **Résultat** : Calcul de la somme totale d'un tableau d'entiers en accès mémoire direct (Gestion des tableaux vides incluse).


<img width="353" height="800" alt="image" src="https://github.com/user-attachments/assets/6c47eee1-9098-4447-92b5-b486c6139096" />


![WhatsApp Image 2026-03-25 at 03 24 08](https://github.com/user-attachments/assets/1e9e62ed-f44f-4915-8b35-42fc960c2f4e)

---

##  Diagnostic & Logs (Logcat)
Le projet intègre la bibliothèque `<android/log.h>` pour un diagnostic en temps réel.
*   **Tag de recherche** : `JNI_DEMO`
*   **Observation** : Dans Android Studio, via `View -> Tool Windows -> Logcat`, on peut observer les traces de calcul envoyées par le moteur C++ (ex: "Factoriel de 10 calcule en natif = 3628800").

---

##  Bonnes Pratiques Appliquées
*   **Réduction des transitions** : Regroupement des appels pour minimiser l'overhead JNI.
*   **Gestion Mémoire** : Libération systématique des ressources (`ReleaseStringUTFChars`, `ReleaseIntArrayElements`) pour éviter les fuites de mémoire.
*   **Design "Humain"** : Interface moderne basée sur `MaterialCardView` pour une lecture claire et ergonomique des résultats de tests.

---

##  Configuration Technique
*   **IDE** : Android Studio
*   **Outils** : NDK (Side by side), CMake 3.22.1
*   **Langages** : Java, C++, CMake
*   **Dépendances UI** : `com.google.android.material:material:1.13.0`

---


