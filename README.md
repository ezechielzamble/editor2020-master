# editor2020-master

# Sujet
Chargé de développer un mini-éditeur de texte fondé sur les concepts et les fonctionnalités suivantes :
- Le texte à éditer est contenu dans un buffer.
- A l'intérieur de ce texte, l'utilisateur peut déterminer une sélection (avec un début et une fin).
- Tout texte saisi par l'utilisateur vient remplacer le contenu de sélection dans le buffer.
- L'utilisateur peut copier le contenu de la sélection dans le buffer dans un presse-papier clipboard.
- Le contenu de la sélection peut aussi être copié dans le presse-papier puis supprimé(cut).
- L'utilisateur peut coller le contenu du presse-papier à la place du contenu de la sélection dans le buffer.
- L'interface homme-machine peut être de type textuel (console) ou graphique.

# Versions
Nous suivrons une technique de développement en spirale qui permette de gérer trois versions successives :
  - La version 1 fournira les fonctionnalités de base indiquées ci-dessus.
  - La version 2 permettra d'enregistrer et de rejouer les actions de l'utilisateur.
  - la version 3 permettra de defaire et refaire les actions de l'utilisateur, sans limitation sur la longueur de l'historique (l'utilisateur peut ramener le contenu de l'éditeur dans son état initial).
  
## Définition de l'interface
Voir le dépôt gitlab : https://gitlab.istic.univ-rennes1.fr/plouzeau/editor2020.git

## Auteurs
Dihya Djouaher, Ezechiel ZAMBLE
