# 🩸 Blood Bank Management System

A full-stack **Blood Bank Management System** built using **React.js, Spring Boot, Java, MySQL, and Bootstrap 5**. The application provides an administrative dashboard to manage blood donors, recipients, blood requests, inventory, and donation records through real-time CRUD operations.

> **Project Scope:** This is an academic/demo project that simulates a real-world blood bank workflow. It does not currently include real payment gateways, email notifications, or advanced security features such as JWT authentication.

---

## 📌 Table of Contents

- [About the Project](#-about-the-project)
- [Key Features](#-key-features)
- [Technology Stack](#-technology-stack)
- [System Architecture](#-system-architecture)
- [Project Structure](#-project-structure)
- [Database Design](#-database-design)
- [Backend Architecture](#-backend-architecture)
- [Frontend Features](#-frontend-features)
- [REST API Reference](#-rest-api-reference)
- [Installation and Setup](#-installation-and-setup)
- [Default Login Credentials](#-default-login-credentials)
- [Known Limitations](#-known-limitations)
- [Future Enhancements](#-future-enhancements)

---

## 📖 About the Project

The Blood Bank Management System is designed to simplify the management of blood bank operations through a centralized web application.

The system allows an administrator to manage donor and recipient information, track blood requests, monitor blood inventory, and maintain donation records. The React frontend communicates with the Spring Boot REST API, which processes requests and stores data in a MySQL database using Spring Data JPA and Hibernate.

The project follows a layered backend architecture to maintain code organization, modularity, and ease of maintenance.

## ✨ Key Features

- **Admin Login:** Login interface for administrative access.
- **Interactive Dashboard:** Displays statistics such as total donors, available blood units, pending requests, and recipients.
- **Donor Management:** Add, view, update, and delete donor records.
- **Recipient Management:** Maintain recipient details and hospital information.
- **Blood Request Management:** Create and manage requests for blood.
- **Blood Inventory Management:** View available blood units by blood group.
- **Donation Records:** Maintain records of successful blood donations.
- **Real-Time CRUD Operations:** Changes made through the frontend are sent to the backend and persisted in the database.
- **Responsive UI:** Bootstrap-based layouts for a clean and accessible interface.
- **Interactive Alerts:** SweetAlert2 provides user-friendly notifications and confirmation dialogs.
- **Form Reusability:** Forms support both adding new records and updating existing records.

## 🛠️ Technology Stack

### Frontend

| Technology | Purpose |
|---|---|
| React.js | Building the user interface |
| React Hooks | State management and lifecycle handling |
| React Router | Navigation and routing |
| Axios | HTTP requests to the backend |
| Bootstrap 5 | Responsive styling and layouts |
| SweetAlert2 | Alerts and confirmation dialogs |
| React Icons | UI icons and visual elements |

### Backend

| Technology | Purpose |
|---|---|
| Java 17+ | Backend programming language |
| Spring Boot | Backend application framework |
| Spring Web | REST API development |
| Spring Data JPA | Database operations |
| Hibernate | ORM and entity mapping |
| Maven | Dependency and build management |

### Database

- **MySQL** — Relational database for storing application data.
- **MySQL Workbench** — Database management and SQL execution.

## 🏗️ System Architecture

The application follows a client-server architecture.

```text
             Admin (Web Browser)
                      |
                      v
            React.js Frontend
               Port: 3000
                      |
                      v
             Axios HTTP Requests
                JSON Data
                      |
                      v
          Spring Boot REST API
               Port: 8082
                      |
                      v
          Spring Data JPA / Hibernate
                      |
                      v
              MySQL Database
                bloodbank_db
```

### Workflow

1. The administrator logs in through the React frontend.
2. The frontend sends HTTP requests to the Spring Boot backend using Axios.
3. The backend controllers receive and process incoming requests.
4. The service layer handles application logic.
5. The repository layer communicates with MySQL through Spring Data JPA.
6. The database stores or retrieves the requested information.
7. The backend returns a response to the frontend, which updates the displayed data.

## 📂 Project Structure

The project is organized into separate frontend and backend applications.

```text
Blood-Bank-Management-System/
│
├── backend/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── .../
│           │       ├── controller/
│           │       ├── service/
│           │       ├── repository/
│           │       ├── entity/
│           │       └── BloodbankApplication.java
│           │
│           └── resources/
│               └── application.properties
│
├── frontend/
│   ├── public/
│   ├── src/
│   │   ├── api/
│   │   ├── components/
│   │   ├── App.js
│   │   └── index.js
│   └── package.json
│
└── README.md
```

> Note: This is a simplified reference structure. Actual package names, filenames, and folders may differ depending on your implementation.

## 🗄️ Database Design

The application uses a MySQL database named `bloodbank_db`. Hibernate JPA maps Java entity classes to database tables.

The database consists of six main entities:

| Entity Class | Database Table | Description |
|---|---|---|
| `Admin.java` | `admin` | Stores administrator credentials. |
| `Donor.java` | `donors` | Stores donor details, including name, blood group, age, and city. |
| `Recipient.java` | `recipients` | Stores patient details, blood group, and hospital information. |
| `BloodRequest.java` | `blood_requests` | Stores blood requests, urgency, hospital, and request status. |
| `Inventory.java` | `inventory` | Tracks available units for each blood group. |
| `Donation.java` | `donations` | Maintains records of blood donations. |

### Database Configuration

Configure the database connection in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bloodbank_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8082
```

Replace `your_password` with your local MySQL password. The Hibernate DDL setting shown above is a development configuration; use an appropriate schema migration strategy for production.

## ⚙️ Backend Architecture

The backend follows a layered architecture that separates responsibilities into different components.

### 1. Controller Layer

- Handles incoming HTTP requests.
- Defines REST API endpoints.
- Returns responses to the frontend.
- Examples: `DonorController`, `RecipientController`.

### 2. Service Layer

- Contains business logic.
- Coordinates operations between controllers and repositories.
- Helps keep controllers clean and maintainable.

### 3. Repository Layer

- Handles database access using Spring Data JPA.
- Uses interfaces extending `JpaRepository`.
- Supports standard CRUD operations.

### 4. Entity Layer

- Defines Java classes mapped to MySQL tables.
- Represents application data, such as donors, recipients, and inventory.

### Cross-Origin Resource Sharing (CORS)

The backend uses `@CrossOrigin` or equivalent CORS configuration to permit requests from the React frontend running at `http://localhost:3000`.

## 🎨 Frontend Features

The frontend is designed to provide a modern administrative experience.

- **Premium Login Page:** Split-screen layout with glassmorphism-inspired styling.
- **Dashboard Statistics:** Gradient-styled cards displaying key blood bank metrics.
- **Data Tables:** Structured tables with aligned columns and consistent spacing.
- **Add and Update Forms:** Forms switch between creation and editing modes based on the selected record.
- **CRUD Integration:** Data is fetched from and submitted to the backend API.
- **Confirmation Dialogs:** SweetAlert2 can be used for delete confirmations and success or error notifications.
- **Navigation:** React Router provides navigation between administrative sections.

## 🔌 REST API Reference

The backend base URL is:

`http://localhost:8082`

### Admin

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/admin/login` | Authenticate an administrator. |

### Donors

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/donor/all` | Fetch all donors. |
| POST | `/donor/add` | Add a donor. |
| PUT | `/donor/update` | Update a donor. |
| DELETE | `/donor/delete/{id}` | Delete a donor. |

### Recipients

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/recipient/all` | Fetch all recipients. |

### Blood Requests

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/requests/add` | Create a blood request. |

### Inventory

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/inventory/all` | Fetch blood inventory. |

Similar CRUD endpoints may be available for recipients, requests, inventory, and donations, depending on the implemented controllers.

> **Note:** Verify the exact endpoint paths, HTTP methods, and request body formats against your backend controllers. The endpoints listed above reflect the documented project configuration.

## 🚀 Installation and Setup

Follow these steps to run the project locally.

### Prerequisites

Ensure the following software is installed:

- Java Development Kit (JDK) 17 or later
- Node.js and npm
- MySQL Server
- MySQL Workbench (recommended)
- IntelliJ IDEA or another Java IDE
- Visual Studio Code or another code editor
- Git (optional)

### Step 1: Clone the Repository

If your project is hosted on GitHub, clone it using:

```bash
git clone <your-repository-url>
cd Blood-Bank-Management-System
```

Replace `<your-repository-url>` with your actual repository URL.

### Step 2: Configure the Database

1. Start your MySQL server.
2. Open MySQL Workbench.
3. Create the database:

```sql
CREATE DATABASE bloodbank_db;
```

4. Select the database:

```sql
USE bloodbank_db;
```

5. Configure your database credentials in the backend's `application.properties` file.
6. Start the Spring Boot application so Hibernate can create or update the tables if your entity mappings and DDL configuration support it.

If your project uses a separate SQL schema script, execute that script instead.

### Step 3: Insert the Default Admin

If the project uses the documented plain-text demo login implementation, insert the following record after confirming the table schema:

```sql
INSERT INTO admin (username, email, password)
VALUES ('admin', 'admin@test.com', 'admin123');
```

Ensure the table column names match your actual entity mapping. Do not use these demo credentials in a production application.

### Step 4: Run the Backend

1. Open the backend project in IntelliJ IDEA.
2. Verify the database configuration.
3. Locate `BloodbankApplication.java`.
4. Run the application.

The backend should start at:

`http://localhost:8082`

You can use the following URL to check whether the server responds, if a suitable endpoint is configured:

`http://localhost:8082`

A successful server startup does not necessarily mean the root URL has a mapped page.

### Step 5: Run the Frontend

Open a terminal in the frontend directory:

```bash
cd frontend
npm install
npm start
```

The React application should open at:

`http://localhost:3000`

If your project uses Vite instead of Create React App, start it with:

```bash
npm run dev
```

Use the command configured in your `package.json`.

### Step 6: Log In

Use the default demo credentials, provided the corresponding admin record exists and the login implementation matches the documented configuration.

- **Username:** `admin`
- **Password:** `admin123`

After logging in, navigate through the dashboard to manage the available modules.

## 🔑 Default Login Credentials

| Field | Value |
|---|---|
| Username | `admin` |
| Email | `admin@test.com` |
| Password | `admin123` |
| Frontend URL | `http://localhost:3000` |
| Backend URL | `http://localhost:8082` |
| Database | `bloodbank_db` |

> **Security Warning:** These are development-only demo credentials. Change them before sharing a deployed application, and never expose real passwords in source code or public repositories.

## ⚠️ Known Limitations

The current version is intended for academic and demonstration purposes.

- **Plain-Text Passwords:** Passwords are not hashed in the documented implementation.
- **No JWT Authentication:** The project does not currently implement JWT-based authentication.
- **Limited Authorization:** Frontend routing alone does not secure backend endpoints.
- **No Automated Notifications:** Email or SMS notifications for urgent blood requests are not implemented.
- **Inventory Synchronization:** Automatic inventory adjustments following donations or blood allocations may require additional implementation.
- **Local Development Setup:** The documented configuration uses localhost URLs and requires deployment-specific configuration before hosting.

## 🔮 Future Enhancements

Potential improvements for future versions include:

- Implement Spring Security and JWT-based authentication.
- Hash passwords using BCrypt.
- Add proper backend authorization and role-based access control.
- Automatically increase inventory after verified donations.
- Automatically decrease inventory after approved blood allocations.
- Add search and filtering by blood group, donor name, city, and request status.
- Implement email or SMS notifications for urgent requests.
- Add detailed reports and analytics for blood donations and inventory.
- Improve input validation, error handling, and audit logging.
- Deploy the frontend on Vercel and the backend on Render or another suitable hosting platform.
- Configure a production database and environment variables for deployment.

## 🎯 Conclusion

The Blood Bank Management System demonstrates how frontend technologies, backend frameworks, REST APIs, and relational databases can work together to simplify administrative workflows.

By integrating React.js, Spring Boot, and MySQL, the project provides a foundation for managing donor records, recipients, blood requests, inventory, and donation information through a centralized application. It also offers practical experience with full-stack development, layered architecture, database integration, and CRUD operations.

---

**Developed as an academic project using React.js, Spring Boot, Java, MySQL, and Bootstrap 5.**

