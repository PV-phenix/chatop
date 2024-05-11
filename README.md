# OlympicGamesStarter

Ce projet a été généré avec Angular CLI (https://github.com/angular/angular-cli) version 14.2.13.La version de Angular est 17.3.1.

N'oubliez pas d'installer vos node_modules avant de commencer (`npm install`).

# La branche par défaut est "main"

## Serveur de développement

Lancez `ng serve` pour un serveur de développement. Naviguez vers `http://localhost:4200/`. L'application sera automatiquement rechargée si vous changez l'un des fichiers sources.

## Construction

Lancez `ng build` pour construire le projet. Les artefacts de construction seront stockés dans le répertoire `dist/`.

## Où commencer

Comme vous pouvez le voir, une architecture a déjà été définie pour le projet. Ce n'est qu'une suggestion, vous pouvez choisir d'utiliser la vôtre. L'architecture prédéfinie inclut (en plus de l'architecture angulaire par défaut) ce qui suit :

- Dossier `components` : contient tous les composants réutilisables.
- `pages` folder : contient les composants utilisés pour le routage
- Dossier `core` : contient la logique métier (dossiers `services` et `models`).

Je vous suggère de commencer par comprendre ce code de départ. Portez une attention particulière à `app-routing.module.ts` et à `olympic.service.ts`.

Une fois maîtrisé, vous devriez continuer en créant les interfaces typescript à l'intérieur du dossier `models`. Comme vous pouvez le voir, j'ai déjà créé deux fichiers correspondant aux données incluses dans le `olympic.json`. Avec vos interfaces, améliorez le code en remplaçant chaque `any` par l'interface correspondante.

Vous êtes maintenant prêt à implémenter les fonctionnalités demandées.

Nous vous souhaitons bonne chance !


Traduit avec DeepL.com (version gratuite)
