# Circut Breaker Pattern

## What to do when circut breaks?
1) Throw an Error
2) Return a fallback "default" response.
3) Save previous response (cache) and use that when possible.


# Questions

## 1) How to design database in microservice architecture?
Here we can use one DB for Customer master data and another one for Product master data but third table that maintain the relationship (many-to-many) where to keep that table?

## 2) When microservice A communicates with microservice B then we need model classes of Microservice B in Microservice A also, what is best approach to handle this code duplication?
Can we create one common project and add dependency in both microservices?

## 3) How big one microservice should be? or How many endpoints we can keep in one microservice?

