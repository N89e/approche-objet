#1 Créer le personnage
- lorsqu’on choisit cette option, un personnage va être créé avec 4 attributs :
    - nom : il faudrat indiquer le nom qu vous voulez donner à votre personnage.
    - force : (entre 12 et 18) tirée aléatoirement
    - points de santé : (entre 20 et 50) tirés aléatoirement
    - score : commence à 0
- Le personnage débute avec un inventaire de 3 potions : 
  - une potion de soin
  - une potion d’attaque mineure
  - une potion de robustesse  
- Les potions ne peuvent être consommées qu’entre 2 combats.
  - Potion de soin (+5 à 10 points de santé).
  - Potion d’attaque mineure (+3 points en attaque) valable uniquement pendant la durée du prochain combat
  - Potion d’attaque majeure (+5 points en attaque) valable pendant 2 combats

2. Combattre une créature
- Le choix de cette option va permettre au personnage d’engager un combat.
- Ce combat n’est possible que si votre personnage a un nombre de points de santé > 0, sinon un message est affiché :  
« Votre personnage est décédé. Il a obtenu le score de X points. Veuillez créer un nouveau personnage ». 
- Lorsqu’on choisit cette option, le personnage doit combattre une créature du bestiaire choisit au hasard :
  - Un loup : force (entre 3 et 8) et points de santé (entre 5 et 10)
  - Un gobelin : force (entre 5 et 10) et points de santé (entre 10 et 15)
  - Un troll : force (entre 10 et 15) et points de santé (entre 20 et 30).
3. Le combat commence par l’affichage de la créature rencontrée.

- Le combat est constitué de différents tours :
  - A chaque tour, on calcule l’attaque des 2 protagonistes. 
  - L’attaque est calculée de la manière suivante :  
  force + nombre aléatoire entre 1 et 10.
  - Celui dont l’attaque est la plus forte remporte le tour.
  - Celui qui remporte le tour inflige une quantité de dégâts égale à la différence entre les 2 valeurs d’attaque calculées précédemment.
  - Cette quantité de dégâts se soustrait au nombre de points de santé de celui qui a perdu le tour.
  - Si le nombre de points de santé de votre personnage est nul ou négatif le combat est terminé, la partie est finie et le score du personnage est affiché.
  - Si votre personnage gagne le combat, son score augmente de : 1 si c’est un loup, 2 si c’est un gobelin et 5 si c’est un troll.  
  A l'issue du combat un message affiche le nouveau score.
  - Vous pouvez engager un nouveau combat tant que votre personnage est encore en vie.  
  - L’objectif du jeu étant d’atteindre le plus haut score.
  - A la fin d’un combat gagné vous avez 50% de chance de récupérer une récompense :  
    - Potion de soin (+5 à 10 points de santé).
    - Potion d’attaque mineure (+3 points en attaque) valable uniquement pendant la durée du prochain combat
    - Potion d’attaque majeure (+5 points en attaque) valable pendant 2 combats
    - Ou score+5

3. Prendre une potion  
Vous pouvez consommer 1 des potions que vous possédez.  
  

4. Afficher score  
Cette méthode affiche le score.
  

5. Sortir