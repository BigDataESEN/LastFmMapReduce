# Olympix MapReduce

## Présentation

* Ce projet présente l'implémentation d'un job MapReduce permettant d'analyser le contenu du dataset `lastfm.csv`. Ce job calcule pour chaque chanson le nombre d'utilisateurs uniques qui l'ont écouté.

## Prérequis

* Installer Apache Hadoop sur votre machine
* Installer Java JDK version 1.8

## Utilisation

* Télécharger le fichier de données disponible sur ce lien [https://github.com/BigDataESEN/datasets/blob/main/lastfm.csv](https://github.com/BigDataESEN/datasets/blob/main/lastfm.csv)

* Envoyer le fichier `lastfm.csv` à votre cluster hdfs.
  ```
  hdfs dfs -mkdir input
  hdfs dfs -put lastfm.csv input/lastfm.csv
  ```

* Placer le fichier `LastFM-1.jar` (qui se trouve dans le dossier __target__) dans votre répertoire de travail, puis lancer la commande suivante :

  ```
  hadoop jar LastFM-1.jar LastFm input/lastfm.csv repertoire_destination
  ```

  par exemple :

  ```
  hadoop jar LastFM-1.jar LastFm input/lastfm.csv output
  ```

  Le résultat de ce job est le suivant :

  ```
  hdfs dfs -cat output/part-r-00000
  ```

  ![screenshot](https://www.nassimbahri.ovh/docs/bigdata/documentations/lastfm/result.png)
