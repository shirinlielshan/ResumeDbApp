# Java JDBC Database Interaction and User Skill Management

## Table of Contents
- [Introduction](#introduction)
- [Project Overview](#project-overview)
- [Database Interaction](#database-interaction)
- [User Skill Management](#user-skill-management)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Usage](#usage)


## Introduction
This GitHub project demonstrates the use of Java JDBC for interacting with a database and managing user skills. The project consists of several modules for managing user information, skills, and their associations.

## Project Overview
The project is organized into the following modules:

### Database Interaction
- `CountryDaoImpl`: Provides CRUD operations for managing country information in the database.
- `SkillDaoImpl`: Handles skills-related CRUD operations in the database.
- `UserDaoImpl`: Manages user information, including create, read, update, and delete operations.
- `UserSkillDaoImpl`: Manages the association between users and their skills, including power levels.

### Prerequisites
Before you begin, ensure you have met the following requirements:
- Java Development Kit (JDK) installed on your system.
- MySQL database server running.
- Database named `db` with appropriate tables (`users`, `country`, `skill`, `user_skill`).

## Getting Started

1. Configure the database connection details in the relevant DAO classes (`CountryDaoImpl`, `SkillDaoImpl`, `UserDaoImpl`, `UserSkillDaoImpl`) by modifying the URL, username, and password according to your database setup.

2. Compile the Java code:

3. Run the program.

## Usage
- Database Interaction:
- `CountryDaoImpl`: Manage country information (add, remove, update, view).
- `SkillDaoImpl`: Handle skills (add, remove, update, view).
- `UserDaoImpl`: Manage user information (add, remove, update, view).

- User Skill Management:
- `UserSkillDaoImpl`: Manage user skills, including their power levels (add, remove, update, view by user).

You can customize and extend these modules to suit your specific requirements.

