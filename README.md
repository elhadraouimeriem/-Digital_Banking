<h1>PROJET JEE -SPRING-ANGULAR-SPRING SECURITY-JWT</h1> 
<h2>Introduction<h2>

<p>Le projet de gestion bancaire vise à développer une application 
complète permettant la gestion efficace des comptes bancaires.
Chaque compte est associé à un client et peut être sujet à diverses 
opérations telles que le débit et le crédit. Le système prend en charge
deux types de comptes : les comptes courants et les comptes épargnes.</p>

<h2>Architecture de l'application</h2>
<img src="captures/architectureebanking.PNG">
<h2>Partie 1 : Couche DAO</h2>
<p>Dans cette section, nous avons créé un projet Spring Boot et
mis en place la couche d'accès aux données (DAO). Les entités JPA telles que Customer,
BankAccount, Saving Account, CurrentAccount, et AccountOperation ont été définies. 
Les interfaces JPA Repository basées sur Spring Data ont été mises en place pour interagir 
avec la base de données.Des tests ont été effectués pour valider le bon fonctionnement de la couche DAO.</p>

<ol>
<li><h2>Entités JPA :</h2></li>
<h4>H2 DATABASE</h4>
     <h4>SINGLE TABLE</h4>
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
<h4>PER TABLE</h4>
<p> Les autres tables restent les mêmes, sauf bankAccount qui ne sera pas présente, et à la place, nous aurons deux tables : CurrentAccount et SavingAccount.</p>
<p>générer per table Bank Account </p>
<img src="captures/per_table_entity.PNG">
<p>table Current Account</p>
<img src="captures/per_table_current_account.PNG">
<p>table Saving Account</p>
<img src="captures/per_table_saving_account.PNG">

<h4>Joined</h4>
<p> Les autres tables restent les mêmes, sauf bankAccount, CurrentAccount, SavingAccount qui seront modifiées.</p>
<p>générer joined table</p>
<img src="captures/joined_table_entity.PNG">
<p>table Saving Account</p>
<img src="captures/joined_saving_account.PNG">
<p>table Current Account</p>
<img src="captures/joined_current_account.PNG">
<p>table Bank Account</p>
<img src="captures/joined_bank_account.PNG">

<h3>SQL</h3>

<img src="captures/ebank_db_SQL.PNG">
<li>Interfaces JPA Repository :</li>

<li><h2>Test de la Couche DAO :</h2></li>
<img src="captures/view_account.PNG">
<li>Couche Service et DTOs :</li>
<p>On a afficher la liste des customers </p>
<img src="captures/customers.PNG">

</ol>
