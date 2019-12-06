# JavaBot

> IUT Nancy Charlemagne - Année Spéciale Info 2019-2020.

Bot Discord. Serveur "DUT Info AS".

## Documentation

> Documentation du projet : [**Javadoc**](http://labo.dvp-web.fr/javabot/index)


![discord](src/main/assets/img/discord.png)

### JDA

Le package JDA (Java Discord API) fournit les outils nécessaires au développement
du bot : écoute d'événement, manipulations sur le serveur etc.

Pour plus d'informations, et pour commencer à appréhender les différentes
fonctionnalités que permet d'implémenter le package, voir cette suite de vidéos de
Kody Simpson sur [Youtube](https://www.youtube.com/watch?v=NxOxcgbikJo).

Pour aller plus loin :

- [La documentation Github JDA](https://github.com/DV8FromTheWorld/JDA/wiki).
- [La Javadoc du projet](https://ci.dv8tion.net/job/JDA/javadoc/).

### Maven

Maven est un framework Java permettant entre autre de gérer des dépendances et donc
d'inclure des packages extérieurs au projet. Fournit également une structure de projet et
d'autres outils, notamment de packaging et de tests.

Pour aller plus loin : 

- [Le cours OpenClassroom](https://openclassrooms.com/fr/courses/4503526-organisez-et-packagez-une-application-java-avec-apache-maven).
- [La documentation officielle](http://maven.apache.org/).

### JUnit

JUnit fournit un ensemble complet d'outils de tests.

Voir leur [documentation complète](https://junit.org/junit5/docs/current/user-guide/).

### Tomcat

L'app est hébergée sur un serveur Tomcat, via un Raspberry Pi 4.

## Environnement

### IntelliJ

IDE complet pour du développement Java. Permet l'auto-import des dépendances Maven,
l'auto-import des packages nécessaire au fonctionnement d'une classe. Outils puissant
pour l'auto-complétion, et le développement proprement dit. Interface simple pour le
versionning de projets et l'éxecution des tests également. Enormément d'autres fonctionnalités.

Pour aller plus loin : [la documentation officielle](https://www.jetbrains.com/help/idea/discover-intellij-idea.html).

### APIs

Pour l'instant, seule l'API de Discord est utilisée, mais d'autres pourront servir à terme.

- [API Discord](https://discordapp.com/developers/docs/intro) ; il est nécessaire de créer un bot de test personnel pour l'environnement de développement. Le bot final répondra avec son propre token au moment du déploiement.

Les clés des API et autres variables sensibles sont à ajouter dans des variables d'environnement.
aucun code ou clé d'identification ne doit apparaître en clair dans le projet.

## Conventions

> Cf. [**Wiki**](https://github.com/B4va/javabot/wiki).

### Participer ?

La participation au projet se fera via GitHub. Vous pouvez consulter les différents tuto
fournis par la plateforme pour mettre en place les outis nécessaires, notamment
en ce qui concerne la mise en place des clés d'authentification. Les vidéos de
[Grafikart](https://www.youtube.com/watch?v=rP3T0Ee6pLU&list=PLjwdMgw5TTLXuY5i7RW0QqGdW0NZntqiP) pourront également vous être utile pour mettre en place Git.

Pour participer :

**Première approche :** RDV dans le chan #javabot du discord pour qu'on en parle ;)

- Consulter les [issues](https://github.com/B4va/javabot/issues) : Il est possible d'en créer ou de répondre aux issues déjà
ouvertes, pour préciser un peu ce qui vous semblerait utile de modifier ou implémenter.
- Les corrections/implémentations se feront alors via pull request, que chacun pourra
consulter et commenter avant validation. Voir [ici](https://github.com/AS-Info-IUT-NC/javabot/wiki) *(en construction)* le fonctionnement.
- Dans le cas d'une plus ou moins grosse implémentation, il est possible de créer un [projet](https://github.com/B4va/javabot/projects)
afin de travailler à plusieurs et de pouvoir s'organiser plus efficacement.
- Respecter les [conventions](https://github.com/B4va/javabot/wiki) de nommage et d'organisation du projet.
