# Service Discovery ( Eureka Technology)
1. There is one Eureka Server and all Microservices workes as a Eureka Client.
1. All Eureka clients registered themselves with Eureka Server.
1. All Eureka clients send heart beats to Eureka Server to let Eureka Server know that they are alive.
1. We just need to add Eureka client dependency in microservice and that's it.
1. We don't need to hardcode other microservice url for communication, application name suffice.

# Circut Breaker Pattern (Hystrix Technology)

## Why Circut Breaker?
1. Failing fast
1. Fallback functionality
1. Automatic recovery

## When does the circut breaks?
1. Last n requests to consider for decision.
1. How many of should fail?
1. Timeout duration?

## What to do when circut breaks?
1. Throw an Error
1. Return a fallback "default" response.
1. Save previous response (cache) and use that when possible.

## When to resume requests?
1. How long to wait before circut breaker tries again?

> https://github.com/Netflix/Hystrix/wiki/Configuration

# Questions

## 1) How to design database in microservice architecture?
Here we can use one DB for Customer master data and another one for Product master data but third table that maintain the relationship (many-to-many) where to keep that table?

## 2) When microservice A communicates with microservice B then we need model classes of Microservice B in Microservice A also, what is best approach to handle this code duplication?
Can we create one common project and add dependency in both microservices?

## 3) How big one microservice should be? or How many endpoints we can keep in one microservice?

