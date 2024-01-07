# PROJET JEE BACKEND -SPRING-ANGULAR-SPRING SECURITY-JWT 
## Introduction

Le projet de gestion bancaire vise à développer une application 
complète permettant la gestion efficace des comptes bancaires.
Chaque compte est associé à un client et peut être sujet à diverses 
opérations telles que le débit et le crédit. Le système prend en charge
deux types de comptes : les comptes courants et les comptes épargnes.


## Architecture de l'application
<img src="captures/architectureebanking.PNG">

## Couche DAO
Dans cette section, nous avons créé un projet Spring Boot et
mis en place la couche d'accès aux données (DAO). Les entités JPA telles que Customer,
BankAccount, Saving Account, CurrentAccount, et AccountOperation ont été définies. 
Les interfaces JPA Repository basées sur Spring Data ont été mises en place pour interagir 
avec la base de données.Des tests ont été effectués pour valider le bon fonctionnement de la couche DAO.

# Entités JPA 
**H2 DATABASE**<br>
     *SINGLE TABLE
<p>générer single table</p>
<img src="captures/db_st_entity.PNG">
<p>la valeur du type Saving Account</p>
<img src="captures/db_st_entity_sa.PNG">
<p>la valeur du type Current Account</p>
<img src="captures/db_stçentity_ca.PNG">
<p>table Bank Account</p>

<img src="captures/single_table_bankAccount.PNG">
<p>table Customer</p>

<img src="captures/single_table_customer.PNG">
<p>table Account Operation</p>

<img src="captures/single_table_Account_operation.PNG">
     *PER TABLE

<p> Les autres tables restent les mêmes, sauf bankAccount qui ne sera pas présente, et à la place, nous aurons deux tables : CurrentAccount et SavingAccount.</p>
<p>générer per table Bank Account </p>
<img src="captures/per_table_entity.PNG">
<p>table Current Account</p>
<img src="captures/per_table_current_account.PNG">
<p>table Saving Account</p>
<img src="captures/per_table_saving_account.PNG">

   *Joined
<p> Les autres tables restent les mêmes, sauf bankAccount, CurrentAccount, SavingAccount qui seront modifiées.</p>
<p>générer joined table</p>
<img src="captures/joined_table_entity.PNG">
<p>table Saving Account</p>
<img src="captures/joined_saving_account.PNG">
<p>table Current Account</p>
<img src="captures/joined_current_account.PNG">
<p>table Bank Account</p>
<img src="captures/joined_bank_account.PNG">

**SQL**

<img src="captures/ebank_db_SQL.PNG">
<li>Interfaces JPA Repository :</li>

# Test de la Couche DAO
<img src="captures/view_account.PNG">
<li>Couche Service et DTOs :</li>

1. afficher la liste des clients<br>
<img src="captures/customers.PNG">

2. Afficher les Comptes<br>
<img src="captures/accounts.PNG">

3. Chercher Un compte<br>
<img src="captures/chercher_compte.PNG">

4. Afficher les Opération d'un compte<br>
<img src="captures/Operations.PNG">


## Tests et Documentation
# Swagger
Swagger a été intégré pour la documentation automatique des API REST. Cet outil génère une documentation interactive basée sur les annotations dans le code source. Grâce à Swagger, les développeurs peuvent explorer et comprendre facilement les endpoints disponibles, les paramètres requis, et les réponses attendues, tout en facilitant l'intégration avec d'autres parties du système. stp redonne moi ca en fonction de mon projet et comment j'ai pu les exploiter dans mon projet et utilise on
1. Consulter les Endpoints

    1.1 .Clients
   <img src="captures/swagger-first.PNG">
    1.2  .Banque et Sécurité
   <img src="captures/swagger1.PNG">
2. Tester les Endpoints<br>
        2.1  .Clients
 <img src="captures/swagger-first-get.PNG">
   2.2  .Comptes
<img src="captures/swagger_account.PNG">
3. Schéma de notre projet
   <img src="captures/swaggerschemas.PNG">
4. Un document json qui décrit les fonctionnalitées de notre API Restful
   <img src="captures/api-docs-1.PNG">
# Postman
Postman a été utilisé comme un outil essentiel pour tester les API exposées par l'application. Il offre une interface conviviale pour envoyer des requêtes HTTP aux endpoints spécifiés, permettant ainsi aux développeurs de tester les fonctionnalités de manière interactive. Les collections Postman peuvent être créées pour regrouper les requêtes associées à différentes fonctionnalités.
  **OpenAPI definition**
l'importation d'un fichier OpenAPI dans Postman offre une intégration fluide entre la documentation de l'API et les tests pratiques, améliorant ainsi l'efficacité du développement et de la validation de l'API.
<img src="captures/postman.PNG">
les étapes:
=> Ouvrez Postman 
=> Ouvrez Postman
=> Choisissez "OpenAPI"
=> Importez le fichier OpenAPI
## Sécurisation de l'Application avec un Système d'Authentification basé sur Spring Security et JSON Web Token
La sécurisation de l'application bancaire a été réalisée en mettant en place un système d'authentification basé sur Spring Security et l'utilisation de JSON Web Token (JWT). Cette approche renforce la sécurité de l'application en assurant un accès sécurisé aux fonctionnalités tout en prévenant les accès non autorisés.
1. Dépendance: ```spring-boot-starter-oauth2-resource-server```
<img src="captures/pring_oauth2.PNG">
La dépendance spring-boot-starter-oauth2-resource-server dans
un projet Spring Boot sert à configurer l'application en tant que
serveur de ressources OAuth 2.0. Elle permet à l'application de valider
les jetons d'accès OAuth 2.0, vérifier les autorisations et sécuriser les 
ressources sensibles. Cela est utile dans les architectures où l'authentification 
et l'autorisation sont gérées par un serveur d'authentification externe, et l'application
agit en tant que serveur de ressources sécurisé.
2. Login
   <img src="captures/login_apres.PNG">
3. Authentification Basic
   <img src="captures/login_basic.PNG">
    3.1  Utilisation d'outils Http Client
   <img src="captures/login_apres.PNG">
   <img src="captures/http_client_outil.PNG">
   À chaque fois que l'authentification de base (Basic) est utilisée, lors de l'envoi d'une requête, il est nécessaire d'inclure les informations d'identification (nom d'utilisateur et mot de passe) dans l'en-tête d'autorisation. Ces informations doivent être encodées en Base64.
        
**Consultation des Clients**
   <img src="captures/http_client_customer.PNG">
         **Consultation du profil**
  <img src="captures/http_client_profile.PNG">
4. JWT
   Avec l'approche HTTP Basic, il est nécessaire d'envoyer à chaque fois le nom d'utilisateur et le mot de passe. Pour simplifier cela, nous allons passer à l'utilisation de JSON Web Tokens (JWT).

Dans cette approche, un token est généré lors de l'authentification et deux beans sont utilisés :

  *Le bean encoder, qui signe et génère les tokens JWT.

  *Le bean decoder, un filtre qui intercepte les requêtes, récupère le JWT, vérifie la signature, et extrait les informations du token.

==>Cela permet de simplifier le processus d'authentification en utilisant des tokens signés pour transporter les informations d'identification de manière sécurisée.
  
4.1 Génération du JWT

Avec JWT, au lieu d'envoyer le nom d'utilisateur et le mot de passe à chaque requête, on envoie le token généré sous la forme d'un "Bearer".

L'utilisation du terme "Bearer" dans ce contexte signifie que le porteur (bearer) du token est authentifié. Lorsqu'on envoie une requête avec un token JWT, on inclut généralement l'en-tête Authorization avec la valeur "Bearer" suivie du token. Cela permet au serveur de comprendre que le token est utilisé pour l'authentification.
<img src="captures/jwt_generation.PNG">

4.2 Consulter le profil

La requête GET vers l'URL ```http://localhost:8085/auth/profile``` renvoie une réponse réussie avec un code HTTP 200 et un contenu au format JSON. La réponse fournit des détails complets sur le profil de l'utilisateur authentifié, comprenant ses autorités, des informations détaillées sur la requête, le statut d'authentification, les informations du principal (utilisateur), les informations d'identification associées au token JWT, le token lui-même, le nom de l'utilisateur, et les attributs du token tels que la date d'expiration et la portée. Ces informations offrent une vue détaillée du statut et des caractéristiques de l'utilisateur authentifié, fournissant une base solide pour la gestion de l'authentification dans l'application.
<img src="captures/profile1.PNG">

<img src="captures/profile2.PNG">

<img src="captures/profile3.PNG">

<img src="captures/profile4.PNG">

4.3 Consulter les clients
<img src="captures/clients.PNG">

4.4 Ajouter un client autorisé (en tant qu'administrateur)
<img src="captures/acces_authorise.PNG">

4.5 Ajouter un client non autorisé ( en tant qu'utilisateur)
<img src="captures/acces-non-authorise.PNG">

## Conclusion 
En conclusion, le projet JEE Backend, construit sur les technologies Spring, Angular, Spring Security, et JWT, a été développé dans le but de fournir une solution complète pour la gestion bancaire. La première partie de l'architecture de l'application a été détaillée, mettant en avant la mise en place de la couche DAO avec des entités JPA telles que Customer, BankAccount, Saving Account, CurrentAccount, et AccountOperation.

Les tests et la documentation ont mis en avant l'intégration réussie de Swagger pour la documentation interactive des API REST. Les tests effectués avec Postman, ainsi que l'utilisation de l'OpenAPI definition, démontrent une approche solide pour la validation des fonctionnalités de l'application.

La sécurisation de l'application, une composante cruciale, a été implémentée avec succès en intégrant Spring Security et en adoptant JSON Web Token (JWT). Les dépendances nécessaires, le processus d'authentification avec JWT, et les différentes étapes telles que la génération du JWT ont été expliqués en détail.

En plus de la partie backend, la modélisation des entités, la mise en place des repositories, l'utilisation d'énumérations et de DTOs, la gestion des exceptions, les mappers, les services, et la partie web avec les contrôleurs ont été élaborés pour garantir une application bien structurée et facile à maintenir.

Ce projet offre une solution holistique pour la gestion bancaire en mettant l'accent sur la sécurité, la documentation, et la qualité du code. L'intégration réussie de différentes technologies témoigne d'une approche moderne et efficace pour le développement d'applications robustes et sécurisées.





