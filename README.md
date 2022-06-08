<h1 align="center">🧑‍🍳 CHEF CHALLENGE - BACKEND</h1>

_<h5 align="center">"An app to prove and improve your cooking skills"</h5>_

Chef Challenge is an app that generates receipes (or challenges) when you do not know what to cook. It can generate random, yet balanced receipes, but can also find receipes with what you have in your fridge.

This repository is the backend part of the Chef Challenge project.

___

**Technos :** Spring, PostgresSQL

**Authors :** [Anatole de Chauveron](https://github.com/Anatole-DC), [Tristan Six](https://github.com/Tarskan)

**Licence :** All rights reserved

___

## Services

**Chef Challenge Services**

### [🏆 Challenges](challenges)

### [📙 Receipes](receipes)

### [🥕 Ingredients](ingredients)

### [👥 Users](users)

### [🍱 Stock](stock)

**API services**

### [🔎 Eureka](eureka)

### [🚪 Gateway](gateway)

### [👮 Admin](admin)

## Getting Started

### Requirements

### Installation

Start by cloning the project on your local machine.

```bash
❯ git clone https://github.com/cybe-m1/chef_challenge_backend.git
```

### Run the project

If you are using IntelliJ, you can run each service from the `run` button.

If you are using your CLI, first place yourself in the project directory service.

For each service, run the following commands :

```bash
❯ ./mvnw clean install
❯ ./mvnw package
❯ java -jar target/*.jar
```

**Using docker-compose**

If you are using Docker, in the project directory, you can run the following command.

```bash
❯ sudo docker-compose up -d
```

> The API is first going to map all the services together, this step takes a few seconds so the all the services might not be available right away.

### Make API calls

All service's endpoints can be accessed through the [gateway](gateway).

## Contribution

You spotted a problem, feel free to raise an issue [here](https://github.com/cybe-m1/chef_challenge/issues).

_For further questions about this project, contact us at **adechauveron@gmail.com**._