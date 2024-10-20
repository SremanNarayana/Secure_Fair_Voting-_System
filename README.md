# Secure Voting System

A secure voting system developed using **Spring Boot** and **H2 Database** that allows users to create voting rooms, add candidates, register voters, cast votes, and view voting results. The project is designed to be modular and can be easily extended to support additional voting-related functionalities.

## Table of Contents

1. [Tech Stack](#tech-stack)
2. [Prerequisites](#prerequisites)
3. [Setup Instructions](#setup-instructions)
   - [Clone the Repository](#clone-the-repository)
   - [Build the Project](#build-the-project)
   - [Run the Project](#run-the-project)
4. [Testing Using Postman](#testing-using-postman)
   - [Create a Voting Room](#1-create-a-voting-room)
   - [Add a Candidate to a Voting Room](#2-add-a-candidate-to-a-voting-room)
   - [Add a Voter](#3-add-a-voter)
   - [Cast a Vote](#4-cast-a-vote)
   - [Check Voting Results](#5-check-voting-results)
5. [H2 Database Console](#h2-database-console)
6. [Switching to MySQL](#switching-to-mysql)
7. [Common Issues](#common-issues)
8. [License](#license)

---

## Tech Stack

- **Backend**: Spring Boot (Java), Spring MVC, Spring Data JPA
- **Database**: H2 (In-memory for development), MySQL (For production deployment)
- **API Documentation**: Swagger
- **Testing**: Postman (For API testing)

---

## Prerequisites

- **Java 17** or higher installed
- **Maven** (for managing dependencies)
- **Postman** (for API testing)

---

## Setup Instructions

### Clone the Repository

To start working with the project, clone the repository to your local machine:

```bash
git clone https://github.com/yourusername/secure-voting-system.git
cd secure-voting-system
