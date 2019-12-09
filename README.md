# League of Legends Worlds 2019 Official App

Il s'agit de l'application mobile des Worlds de League of Legends où l'on peut voir les différentes équipes participantes ainsi que les joueurs de chacune d'elles.

## L'application
L'objectif de l'application est de permettre à l'utilisateur de se renseigner sur les équipes participantes.
Le fragment home affiche le logo officiel du tournoi ainsi qu'un texte d'explication (Image 1).
 
Le fragment Team permet d’afficher une liste déroulante des équipes participantes avec leur logo, leur nom et leur seed (Image 2 et 3).
Le seed permet de savoir de quelle région vient l’équipe ainsi que son classement dans celle-ci.

 
 

En cliquant sur le logo d’une équipe, l’utilisateur a accès aux détails de l’équipe, à savoir une image des joueurs ainsi que leurs noms et postes (Image 4 et 5).
 
 
## L’aspect technique
Toutes les pages affichées sont des fragments.
Toutes les informations concernant les équipes proviennent d’une API, à savoir le nom, le logo, l’image de l’équipe et le nom des joueurs.
L’application créait elle-même la liste déroulante lorsqu’elle fait appel à l’API.
L’API est stocké sur un autre dépôt github avec le .json et tous les .png et .jpeg

## Connaissances apprises
Il s’agit de ma première application mobile car je n’étais pas là au 2ème semestre de 3A.
Je peux donc dire que je n’ai cessé d’apprendre de nouvelles choses.
Voici une liste des connaissances que j’ai apprise pour réaliser cette application :
-	Utiliser Android studio
-	Créer un fragment
-	Créer une API (Créer .json)
-	Faire appel à une API (Trouver les données stocké sur github)
-	Récupérer et stocker les informations de l’API
-	Afficher les informations de l’API (texte et image)
-	Modifier les .xml
-	Créer une recyclerview + utiliser le retour de l’API
-	Créer un nouveau fragment quand on clique sur un élément de la recyclerview

## Difficultés rencontrées
J’ai rencontré pas mal de difficultés pour la réalisation de cette application.
J’ai décidé de m’attaquer dès le départ à l’API ce qui fut un bon choix car c’était plutôt compliqué.
-	J’ai eu du mal à trouver comment récupérer les informations du mon .json qui était stocké sur un dépôt git. Il n’y a quasiment aucun tutoriel en rapport avec l’utilisation d’un json présent dans un git. Après pas mal de recherches, j’ai trouvé une URL qui m’emmenait bien sur les données de mon json.

-	Pour récupérer et afficher le nom d’une équipe sur mon application fut aussi compliqué. Mais le plus dur restera l’affichage d’une image qui m’a demandé beaucoup de temps. Entre des librairies introuvables et des fonctions qui ne marchent pas, c’était difficile mais j’ai fini par trouver la commande picasso qui m’a sauvé.

-	J’avais réalisé un tuto recyclerview au préalable et il me restait à l’implémenter aux données récupérer depuis l’API mais impossible de trouver comment faire le lien. Il y avait pas mal de différences car l’application est uniquement composé de fragment alors que mes autres applications étaient avec des activités. Après pas mal de galères et de recherches, j’ai réussi à obtenir ma viewrecycler avec les équipes dans un fragment.

## Images du projet
Image 1 : Menu Home
![Image 1](https://raw.githubusercontent.com/Seb-Ber/repository-premier-app/master/Screenshot1.jpg)
Image 2 et 3 : Liste des équipes
![Image 2](https://raw.githubusercontent.com/Seb-Ber/repository-premier-app/master/Screenshot2.jpg)
![Image 3](https://raw.githubusercontent.com/Seb-Ber/repository-premier-app/master/Screenshot3.jpg)
Image 4 et 5 : Détails de l'équipe
![Image 4](https://raw.githubusercontent.com/Seb-Ber/repository-premier-app/master/Screenshot4.jpg)
![Image 5](https://raw.githubusercontent.com/Seb-Ber/repository-premier-app/master/Screenshot5.jpg)
