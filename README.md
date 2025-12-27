# URL Shortener Backend

Backend service for shortening long URLs and redirecting users.

## Tech Stack
- Java
- Spring Boot
- PostgreSQL
- Spring Data JPA

## Features
- Generate short URLs using Base62 encoding
- Store URL mappings in PostgreSQL
- Redirect users using HTTP 302

## APIs
- POST /shorten
- GET /{shortCode}

## How to Run
1. Configure PostgreSQL
2. Update application.properties
3. Run the application
