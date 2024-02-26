Bienvenue dans le readme de la 3ème application de notre projet fil rouge concerant la modernisation des outils informatiques de la firme Pâte d'or.

**PRESENTATION :**

Cette application est à destination des équipes des restaurants.

Elle leur permet :
  - d'accepter ou refuser les demandes de réservations
  - d'enregistrer les commandes des clients
  - de génerer les factures (additions) des clients

**DOCUMENTATION :**

A des fins de documentation nous avons ajouté dans le fichier pom.xml de notre application la dépendance OpenAPI :

`<dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.2.0</version>
</dependency>`

Cette dépendance permet de consulter l'ensemble des méthodes (GET/PUT/DELETE/POST) mises à dispostion par nos différents controllers.

Afin d'accéder à cette page de documentation il faut, après avoir lancé l'application dans le terminal d'Eclipse via la commande "mvnw spring-boot:run",
se rendre sur le lien suivant : http://localhost:8080/swagger-ui/index.html#

Vous pouvez aussi consulter cette documentation via le fichier Documentation OpenAPI.pdf que nous avons mis à dispostion dans notre répertoire 
(il s'agit de l'impression en pdf des pages obtenues via le lien ci-dessus).
