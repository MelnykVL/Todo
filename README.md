[![Build Status](https://travis-ci.com/MelnykVL/Todo.svg?branch=master)](https://travis-ci.com/MelnykVL/Todo)

# todo

## Overview

Todo web app with a personal account for each user that allows you to make a list of your tasks.

## Prerequisites

- Install the latest version of Java and set up environment variables *(if necessary)*.

  > [JDK](https://www.oracle.com/java/technologies/javase-downloads.html) <br>
  > **or**<br>
  > [OpenJDK](https://openjdk.java.net/install/)

- Install the Git.

  > [Git](https://git-scm.com/downloads)

- Install the PostgreSQL server.

  > [PostgreSQL](https://www.postgresql.org/download/)

- Install a Java IDE (for example: Intellij IDEA, Eclipse, NetBeans).

  > [Intellij IDEA](https://www.jetbrains.com/idea/download/#section=windows) (recommended) <br>
  > [Eclipse](https://www.eclipse.org/downloads/) <br>
  > [NetBeans](https://netbeans.apache.org/download/)

## Run the example

1. Clone the repository.<br>

    `git clone https://github.com/MelnykVL/Todo.git`

2. Open the project with the Intellij IDEA.
3. Load Maven changes.
4. Set your settings in **flyway.poperties** and **persistence.xml** files.
5. Create the database called ***todo***.
6. Using Maven in Intellij IDEA, run `flyway:migrate` to create tables in the database.
7. Run `mvn tomcat7:run` command to run the project.
8. Change the address in the browser's address bar to `localhost:8080`.
