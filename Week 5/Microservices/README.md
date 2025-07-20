# Microservices System with Eureka & API Gateway

This file documents my hands-on implementation for **Cognizant DN 4.0 Week 5**, where I developed a microservices ecosystem leveraging **Spring Cloud Eureka** for service discovery and **Spring Cloud Gateway** for centralized routing and global logging.

---

## Table of Contents

1. [Overview](#overview)
2. [Project Structure](#project-structure)
3. [Key Features](#key-features)
4. [Running the System](#running-the-system)
5. [API Example Usage](#api-example-usage)
6. [API Gateway Logging Filter](#api-gateway-logging-filter)
7. [Essential Configuration](#essential-configuration)
8. [Summary Table](#summary-table)
9. [Screenshots](#screenshots)

---

## Overview

For this week’s assignment, I orchestrated a set of Spring Boot microservices and infrastructure components:

- **account**: A microservice registering with Eureka
- **greet-service**: A simple RESTful service for greetings, registered with Eureka
- **eureka-server**: The Eureka discovery server
- **api-gateway**: The gateway, handling and logging all external requests

All services are dynamically discovered via Eureka, and routed centrally through the API Gateway with comprehensive request logging.

---

## Project Structure

Simplified directory structure:

```
/microservices-root
├── account            # Microservice (Eureka client)
├── api-gateway        # API Gateway
├── eureka-server      # Eureka Discovery Server
├── greet-service      # Greet microservice (Eureka client)
├── README.md
└── screenshots        # For documentation (see below)
```

---

## Key Features

- **Centralized Service Discovery:** All services self-register with Eureka, enabling discovery without static configuration.
- **Unified API Entry Point:** All external access is managed by the API Gateway.
- **Dynamic Routing:** Requests are routed using Eureka’s dynamic service registry.
- **Global Logging:** The API Gateway logs all incoming requests for observability.
- **Dashboard Monitoring:** Eureka’s dashboard provides real-time status of all microservices.

---

## Running the System

To start the ecosystem:

1. **Start the Eureka Discovery Server**  
   (Runs on `localhost:8761`)

2. **Start all microservices**  
   (e.g., `account`, `greet-service`)  
   Each service registers itself with Eureka.

3. **Start the API Gateway**  
   (Runs on `localhost:9090`)  
   The gateway will query Eureka to route requests.

---

## API Example Usage

Sample endpoints accessible through the API Gateway:

| Service         | Gateway URL                                         | Sample Response                          |
|-----------------|-----------------------------------------------------|------------------------------------------|
| Account         | `/account-service/accounts/{id}`                    | `{ "number": "...", "type": "...", ... }`|
| Greet           | `/greet-service/greet`                              | `"Hello World"`                          |

_Replace `{id}` with the relevant identifier._

---

## API Gateway Logging Filter

I have implemented a global logging filter in the API Gateway, which records method, URI, and headers for every incoming request:

```
package com.cognizant.api_gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Global filter that logs incoming HTTP request details.
 */
@Component
public class LogFilter implements GlobalFilter {
    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);
    private static final String LOG_FORMAT = "Request: method={}, uri={}, headers={}";

    @Override
    public Mono filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logRequestDetails(exchange.getRequest());
        return chain.filter(exchange);
    }

    private void logRequestDetails(ServerHttpRequest request) {
        logger.info(LOG_FORMAT,
                request.getMethod(),
                request.getURI(),
                request.getHeaders());
    }
}
```

_Log output example:_
```
INFO  [com.cognizant.api_gateway.filters.LogFilter] - Request: method=GET, uri=http://localhost:9090/greet-service/greet, headers={host=[localhost:9090], ...}
```

---

## Essential Configuration

**Eureka Server (`application.yml`):**
```
server.port: 8761
spring.application.name: eureka-server
eureka.client.fetch-registry: false
eureka.client.register-with-eureka: false
```

**Microservice (e.g. Account, Greet) (`application.yml`):**
```
spring.application.name: account-service
eureka.client.service-url.defaultZone: http://localhost:8761/eureka/
```

**API Gateway (`application.yml`):**
```
spring.application.name: api-gateway
server.port: 9090
spring.cloud.gateway.discovery.locator.enabled: true
spring.cloud.gateway.discovery.locator.lower-case-service-id: true
eureka.client.service-url.defaultZone: http://localhost:8761/eureka/
```

---

## Summary Table

| Component       | Role                    | Key Properties                       |
|-----------------|------------------------|--------------------------------------|
| account         | Microservice           | `spring.application.name` set        |
| greet-service   | Microservice           | Registers with Eureka                |
| eureka-server   | Service registry       | Port 8761, Eureka dashboard          |
| api-gateway     | API entry point        | Logging, centralized routing         |

---

## Screenshots

Below are screenshots illustrating a working system as part of the Cognizant DN 4.0 Week 5 hands-on:

### 1. **Eureka Discovery Server**
![Eureka discovery Server](/screenshots/EurekaDiscoveryServer.png)

### 2. **Greet Service Endpoints**

a. Greet Service  
![Greet Service](/screenshots/GreetService.png)  

b. Greet User  
![Greet User](/screenshots/GreetUser.png)

---

Thank you for reviewing my solution. This architecture demonstrates the core Spring Cloud microservices patterns highlighted in the Cognizant Digital Nxt 4.0 Week 5 learning module.  