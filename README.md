# StockWatch Application

## Features

### Stock Management
- **Add Stock:** Users can add stocks to their watchlist with stock symbols.
- **Edit Stock:** Users can edit existing stock information.
- **Delete Stock:** Users can remove stocks from their watchlist.
- **View Stock Details:** Users can view detailed information about each stock in their watchlist.
### User Authentication & Authorization
- **User Roles:** Differentiates between Admin and User roles.
- **Registration and Login:** New users can register, and existing users can log in to access their watchlists.
- **Watchlist Management:** Users can create and manage multiple watchlists.
- ** Stock edit and delete:** User can update their stocks

## Getting Started

### Prerequisites
Before you start, ensure you have the following installed:

- Java 17+
- Maven 3.6+
- MySQL or any preferred relational database
- A browser to view the front end

### Running the Application

1. **Clone the repository:**

   ```bash
   git clone https://github.com/charudarsh/stockwatch.git
   cd stockwatch
--Database Setup: Create a MySQL database
-- Drop and recreate the UserStockWatchList database
DROP DATABASE IF EXISTS UserStockWatchList;
CREATE DATABASE UserStockWatchList;

### Use the UserStockWatchList database
USE UserStockWatchList;


Update the Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/UserStockWatchList
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password


### Technologies Used
Backend: Java, Spring Boot (Spring MVC, Spring Data JPA, Spring Security)
Database: MySQL (JPA/Hibernate )
Frontend: Thymeleaf, HTML5, CSS
Build Tool: Maven
Authentication: Spring Security (BCrypt password encoding)

### Project Structure
StockWatch-Application/
│
├── src/                         # Source code directory
│   ├── main/                    # Main application code
│   │   ├── java/                # Java source files
│   │   │   └── com/             # Package structure
│   │   │       └── stockwatch/
│   │   │           ├── controller/     # Controllers (MVC)
│   │   │           ├── model/          # Model classes
│   │   │           ├── repository/      # Data access layer
│   │   │           ├── service/         # Business logic
│   │   │           └── config/          # Configuration classes
│   │   │
│   │   └── resources/           # Application resources
│   │       ├── static/          # Static files (CSS, JS, images)
│   │       └── templates/       # Thymeleaf templates
│   │
│   └── test/                   # Test code directory
│       ├── java/               # Test classes
│       │   └── com/
│       │       └── stockwatch/
│       │           ├── test/    # Test for controllers
│       │           ├── test/       # Test for services
│       │           └── test/     # Test for repositories
│       │
│       └── resources/          # Test resources (if needed)
│
├── docs/                       # Documentation
│   ├── requirements.md         # Requirements Analysis
│   ├── design.md               # Design documentation
│   └── user-manual.md          # User Manual
│
├── .gitignore                  # Git ignore file
├── pom.xml                     # Maven project file (or build.gradle for Gradle)
├── README.md                   # Project overview and setup instructions
└── LICENSE                     # License file

## http://localhost:8080/

********************************************
## . Make Use of SDLC/STLC (V-Model)
Plan the V-Model Approach
### Requirements Gathering: Document all the functional and non-functional requirements for your StockWatch application. Use techniques like user stories, interviews, or surveys to gather information.
Requirements: Features like user registration, watchlist management, and stock tracking.

### Design Phases: Create design documents that outline the architecture and module designs. Ensure that each design document includes a corresponding testing strategy.
Design: Diagrams showing the application architecture and data flow.

### Development and Testing: Follow the V-Model structure where coding is done in parallel with corresponding test planning (e.g., for each requirement, plan its unit and integration tests).
Testing Strategies: Test plans that specify how each requirement will be verified.

### Perform a Requirements Analysis
Identify Stakeholders: Determine who the end-users are (e.g., stock market enthusiasts, casual investors).
Gather Requirements: Use interviews, surveys, or focus groups to collect user needs.
Document Requirements: Create a clear and concise requirements document specifying functional requirements (what the system should do) and non-functional requirements (performance, security).
Functional Requirements:
Users can create multiple watchlists.
Users can add stocks to their watchlists.

Non-Functional Requirements:
The application must load in under 3 seconds.
The system should handle at least 100 concurrent users.

### Adhere to Agile Principles and the Scrum Framework
Form a Scrum Team: Assemble a small team to work on the project.
Sprint Planning: Organize work into sprints (e.g., 2-week iterations). Determine which features to work on during each sprint.
Daily Stand-ups: Hold brief daily meetings to discuss progress, impediments, and plans for the day.
Scrum Board: Use a physical board or a digital tool (JIRA) to track tasks. Columns can include:
Schedule a Sprint Review at the end of each sprint to demo what has been accomplished
Backlog:       List all planned features and tasks.
In Progress:   Tasks currently being worked on.
Testing:       Tasks ready for testing.
Done:           Completed tasks.

### Summary of Implementation Steps
Plan Your V-Model:   Clearly define the stages of your project, linking development with testing.
Conduct Requirements Analysis:    Gather and document requirements from stakeholders to ensure you meet user needs.
Implement Agile Principles:    Organize your workflow using Scrum methodologies, ensuring collaboration and adaptability.
Daily Stand-Ups:     Keep the team aligned with daily updates on progress and obstacles.
Track with JIRA/Trello:    Utilize a project management tool to visualize tasks, progress, and priorities.