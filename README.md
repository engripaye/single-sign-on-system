# SINGLE-SIGN-ON-SYSTEM-APPLICATION

<img width="1536" height="1024" alt="sso" src="https://github.com/user-attachments/assets/b9d16193-a572-4a8d-9a63-c14b050d714e" />

Single Sign-On (SSO) system using Java 21, Spring Boot 3.5, and Spring Security with OAuth2/OpenID Connect. The solution will include a central Authorization Server and a client application that trusts it. For simplicity, we'll use Spring Authorization Server as the OAuth2 provider, but you can swap it for external providers like Google or Okta later.

## Overview

Authorization Server: A Spring Boot app that issues access tokens and ID tokens using OAuth2 + OIDC.
Client Application: A Spring Boot app that authenticates users via the Authorization Server.
Flow: Users log in once through the Authorization Server, and client apps validate tokens for access.

## Step 1: Set Up the Authorization Server
1.1 Create a New Spring Boot Project
Use Spring Initializr with:

Java: 21
Spring Boot: 3.5.x
Dependencies:

Spring Web
Spring Security
Spring Authorization Server

## Step 2: Set Up the Client Application
2.1 Create a New Spring Boot Project
Use Spring Initializr with:

Java: 21
Spring Boot: 3.5.x
Dependencies:

Spring Web
Spring Security
Spring OAuth2 Client
Thymeleaf (optional, for UI)

## Step 3: Testing the SSO Flow

Start the Authorization Server (port: 9000).
Start the Client Application (port: 8080).
Access http://localhost:8080 and click "Login."
Log in via http://localhost:9000/login with user:password.
Verify redirection to http://localhost:8080/home with user details.
Open another client app (on a different port, e.g., 8081, with the same OAuth2 config). You should be logged in automatically without re-entering credentials.


Step 4: Scaling to Multiple Applications
To add more client apps:

Create additional Spring Boot apps with the same OAuth2 client configuration, updating redirect-uri and server.port as needed.
Register each client in the Authorization Server's RegisteredClientRepository with unique client-id and redirect-uri.
Users will only log in once, and all apps will trust the same tokens.


Step 5: Security and Production Considerations

HTTPS: Use HTTPS in production to secure token exchanges.
Client Secret: Store secrets securely (e.g., Spring Vault or environment variables).
User Store: Replace InMemoryUserDetailsManager with a database (e.g., JDBC or LDAP).
Token Customization: Customize JWT claims in the Authorization Server if needed.
External Providers: Swap the Authorization Server for Okta/Google by updating application.yml with their endpoints.


Real-World Impact

Improved UX: Users log in once and access all apps seamlessly.
Centralized Management: User accounts and sessions are managed in one place.
Scalability: Easily add new apps without changing the login flow.

This setup provides a robust, secure SSO system using Spring Boot 3.5 and Java 21
