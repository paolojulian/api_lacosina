# LaCosina API

###
Social Media for cosineros
- [Specifications](#specifications)
- [Installation](#installation)
- [Queries](#queries)
- [Mutations](#mutations)
___
### Specifications
TODO
___
### Installation
Download [JDK 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)

Install `Lombok` Plugin and `JS GraphQL` Plugin from
```
Settings > Plugins
```
___
### Queries
Get users list
```
query {
    users (limitCount: 10) {
        id
        email
        username
        profile {
            firstName
            lastName
        }
    }
}
```

Get a certain user
```
query {
    user (id: 2) {
        email
        username
        profile {
            handle
        }
    }
}
```
___
### Mutations
Register a user
```
mutation {
    register (email: "scottypipz@gmail.com", username: "chefpipz", password: "qwe123") {
        id
        email
    }
}
```
___


Docker
```
# Stop docker containers
docker stop lacosina
docker stop docker-mysql
docker start -i docker-mysql

docker run -p 2012:3306 --name mysql-pipz -e MYSQL_ROOT_PASSWORD={} -e MYSQL_DATABASE=lacosina -e MYSQL_USER={} MYSQL_PASSWORD={} mysql:8
# Start the jar server
docker run -p 8085:8085 --name lacosina --link mysql-pipz:mysql -d lacosina
```
