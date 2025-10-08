# -Premier League Team Stats Dashboard API
A comprehensive RESTful API built with Spring Boot for managing Premier League team statistics, player information, and external API integration.
Features
Full CRUD Operations for league standings data
External API Integration with Premier League data sources
MySQL Database Integration with JPA/Hibernate
RESTful API Design following industry best practices
Comprehensive Entity Management (Teams, Players, Team Info)
Technology Stack
Backend: Java 17, Spring Boot 3.5.4
Database: MySQL with JPA/Hibernate
Build Tool: Maven
External APIs: TheSportsDB API integration
Testing: Postman-ready endpoints
Prerequisites
Java 17 or higher
MySQL 8.0+
Maven 3.6+
IDE (Eclipse, IntelliJ IDEA, or VS Code)
Setup & Installation
1. Clone the Repository
bash
git clone <your-repository-url>
cd team-stats-dashboard
2. Database Configuration
Create a MySQL database and update src/main/resources/application.properties:
properties
spring.application.name=premierLeagueTeamStatsDashboard
spring.datasource.url=jdbc:mysql://localhost:3306/premier_league_stats
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
3. Build and Run
bash
mvn clean install
mvn spring-boot:run
The application will start on http://localhost:8080
API Endpoints
League Standings Operations
Method	Endpoint	Description
GET	/LeagueStandings/	Retrieve all team standings
POST	/LeagueStandings/	Create new team record
PUT	/LeagueStandings/{id}	Update existing team
DELETE	/LeagueStandings/{id}	Delete team record
GET	/external	Fetch data from external API
Sample API Usage
Get All Standings
http
GET http://localhost:8080/LeagueStandings/
Create New Team
http
POST http://localhost:8080/LeagueStandings/
Content-Type: application/json

{
  "name": "Arsenal",
  "point": 75,
  "wins": 24,
  "draws": 3,
  "losses": 6,
  "rank": 1
}
Update Team
http
PUT http://localhost:8080/LeagueStandings/1
Content-Type: application/json

{
  "name": "Liverpool",
  "point": 72,
  "wins": 23,
  "draws": 3,
  "losses": 7,
  "rank": 2
}
Database Schema
LeagueStandings Entity
sql
CREATE TABLE league_standings (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    point INTEGER NOT NULL,
    wins INTEGER NOT NULL,
    draws INTEGER NOT NULL,
    losses INTEGER NOT NULL,
    `rank` INTEGER
);
Additional Entities
PlayersInfo: Player statistics and information
TeamInfo: Team details (manager, stadium, squad info)
External API Integration
The application integrates with TheSportsDB API to fetch real-time Premier League data:
java
// Example external API call
GET http://localhost:8080/external
Returns live Premier League standings data from external sources.
Project Structure
src/main/java/com/premierleague/teamstats/
├── entities/
│   ├── LeagueStandings.java
│   ├── PlayersInfo.java
│   └── TeamInfo.java
├── controllers/
│   └── LeagueStandingsController.java
├── services/
│   └── LeagueStandingsService.java
├── repositories/
│   └── LeagueStandingsRepository.java
├── config/
│   └── RestTemplateConfig.java
└── PremierLeagueTeamStatsDashboardApplication.java
Testing
Using Postman
Import the following endpoints:
GET /LeagueStandings/ - Test data retrieval
POST /LeagueStandings/ - Test data creation
PUT /LeagueStandings/{id} - Test data updates
DELETE /LeagueStandings/{id} - Test data deletion
Test External API:
GET /external - Verify external data integration
Sample Test Data
json
{
  "name": "Manchester City",
  "point": 78,
  "wins": 25,
  "draws": 3,
  "losses": 5,
  "rank": 1
}
Deployment
Local Development
bash
mvn spring-boot:run
Production Build
bash
mvn clean package
java -jar target/team-stats-dashboard-0.0.1-SNAPSHOT.jar
Future Enhancements
Add authentication and authorization
Implement data validation and error handling
Add comprehensive unit and integration tests
Create frontend dashboard interface
Add data caching for improved performance
Implement real-time data updates
Contributing
Fork the repository
Create a feature branch (git checkout -b feature/new-feature)
Commit your changes (git commit -am 'Add new feature')
Push to the branch (git push origin feature/new-feature)
Create a Pull Request
License
This project is licensed under the MIT License - see the LICENSE file for details.
Developer
Project Developer: Birane Seck
LinkedIn: https://www.linkedin.com/in/birane-seck/
GitHub: https://github.com/BiraneS
Email: biraneseck44@gmail.com
Acknowledgments
Premier League for data inspiration
TheSportsDB for external API services
Spring Boot community for excellent documentation
MySQL for reliable database solution
Built with Spring Boot and Java
