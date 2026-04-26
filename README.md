# 🍕 PizzaRecipes — Catalogue de Recettes Complet

> **LAB 6 — Programmation Mobile : Android avec Java** > Application de gestion de catalogue avec architecture en couches, ListView personnalisée et passage d'objets.


https://github.com/user-attachments/assets/effb8ab9-ce29-4121-8208-704491ce9802


---

## 📸 Aperçu

| Écran 1 — Splash | Écran 2 — Liste | Écran 3 — Détails |
|:---:|:---:|:---:|
| Logo animé (2s) | Liste des pizzas | Recette complète |

---

## 🛠️ Technologies utilisées

- **Langage** : Java
- **Plateforme** : Android (Min SDK 24+)
- **IDE** : Android Studio (Kotlin DSL / Groovy)
- **UI** : XML Layouts (ListView, ScrollView, RelativeLayout)
- **Architecture** : Pattern DAO & Service (In-Memory)
- **Navigation** : Intent explicite avec transmission d'ID

---

## 📁 Structure du projet (Packages)

```
com.example.pizzarecipes/
├── adapter/
│   └── PizzaAdapter.java          # Adaptateur personnalisé pour la ListView
├── classes/
│   └── Produit.java               # Modèle de données (Entité Pizza)
├── dao/
│   └── IDao.java                  # Interface générique CRUD
├── service/
│   └── ProduitService.java        # Gestion des données (Singleton)
├── ui/
│   ├── SplashActivity.java        # Écran de démarrage temporisé
│   ├── ListPizzaActivity.java     # Liste principale des recettes
│   └── PizzaDetailActivity.java   # Vue détaillée d'une pizza
└── res/layout/
    ├── activity_splash.xml        # Design du Splash Screen
    ├── activity_list_pizza.xml    # Design avec ListView
    ├── row_pizza.xml              # Design d'une ligne (Item)
    └── activity_pizza_detail.xml  # Design de la fiche complète
```

---

## ✨ Fonctionnalités

- ✅ **Splash Screen** : Écran d'accueil avec temporisation de 2 secondes via un Thread.
- ✅ **Architecture Propre** : Séparation stricte entre les données (Service), l'affichage (UI) et la logique de liaison (Adapter).
- ✅ **ListView Personnalisée** : Affichage d'images, titres et métadonnées (prix/durée) via un `BaseAdapter`.
- ✅ **Gestion In-Memory** : Utilisation du pattern **Singleton** pour maintenir une liste de 10 pizzas durant toute la session.
- ✅ **Navigation Dynamique** : Clic sur un élément de la liste pour charger les détails spécifiques via l'ID.
- ✅ **UI Responsive** : Utilisation de `ScrollView` pour garantir que les recettes longues restent lisibles sur tous les écrans.

---

## 🚀 Comment lancer le projet

1. Clone le dépôt :
   ```bash
   git clone https://github.com/3SS1L4/pizzarecipes.git
   ```
2. Ouvre le projet dans **Android Studio**.
3. Assure-toi que les images (`pizza1` à `pizza10`) sont présentes dans `res/mipmap`.
4. Effectue une synchronisation **Gradle** (Sync Project).
5. Lance sur un émulateur (**API 24+**).

---

## 🧠 Concepts appris

| Concept | Description |
|---|---|
| `BaseAdapter` | Création d'un adaptateur sur mesure pour lier des objets complexes à une vue. |
| `Pattern Singleton` | Garantir une instance unique de `ProduitService` pour partager les données. |
| `Pattern DAO` | Abstraction des accès aux données pour faciliter une future migration (SQLite/API). |
| `Threads` | Utilisation de `Thread.sleep()` pour gérer le délai du Splash Screen. |
| `Intent extras` | Passage de l'identifiant (long) pour récupérer l'objet précis dans l'activité cible. |
| `LayoutInflater` | Transformation dynamique d'un fichier XML (`row_pizza`) en objet View. |

---

## 📝 Détail technique des couches

### 📦 Couche Données (Service & DAO)
Le `ProduitService` implémente `IDao<Produit>`. Il contient la méthode `seed()` qui initialise les 10 recettes demandées avec leurs ingrédients et étapes de préparation. Le Singleton évite de recharger les données à chaque changement d'écran.

### 🎨 Couche Présentation (UI)
- **`PizzaAdapter`** : Utilise le fichier `row_pizza.xml` pour injecter dynamiquement le nom, le prix et l'image de chaque pizza dans la liste.
- **`PizzaDetailActivity`** : Récupère l'ID envoyé, interroge le service via `findById(id)` et remplit les champs texte et image.

---

## 👨‍💻 Auteur

**AMSOU ISMAIL** - Lab de développement mobile 
