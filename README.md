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
