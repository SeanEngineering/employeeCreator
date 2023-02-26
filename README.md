# About
This is a full stack application used to manage an employee database.

## Built With
### Front End
![Vite]
[![React][React.js]][React-url]
![TypeScript]
![SASS]
![React Router]
![React Query]

### Back End
![Spring]
![Java]
![Apache Maven]
![AWS]
[![MySQL][MySQL]][MySQL-url]


### Testing
![Selenium]

# Getting Started

### Prerequisites

Update npm to the latest version

* npm
  ```sh
  npm install npm@latest -g
  ```

### Installation

To setup and run the application

1. Clone the repo
   ```sh
   git clone https://github.com/seanengineering/employeeCreator.git
   ```
2. Install NPM packages
   ```sh
   npm install
   ```
3. Run frontend application
   ```sh
   npm run dev
   ```
4. Setup MySQL to your preferences and create the employees db. 
   ```sh
    CREATE DATABASE employees
   ```
5. Edit the application.properties in the java application
    ```sh
    spring.datasource.url=jdbc:mysql://localhost:<YOUR MYSQL SERVER PORT>/employees
    spring.datasource.username=<YOUR USERNAME>
    spring.datasource.password=<YOUR PASSWORD>

    # update the database automatically when the code changes
    spring.jpa.hibernate.ddl-auto=update

    # allow better sql queries through the repository
    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
    logging.level.org.hibernate.SQL=DEBUG
    logging.level.org.hibernate.type=TRACE
    server.port=8080
   ```
   
## Backend CRUD Operations
- POST: '/employees' -> Creates Employee
- POST: '/employees/seed' -> Seeds employee database
- GET: '/employees/' -> List of employees
- GET: '/employees/{id}' -> Gets employee
- PATCH: '/employees/{id}' -> Updates employee
- DELETE: '/Employee/{id}' -> Deleted employee

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[MYSQL]: https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white
[MySQL-url]: https://www.mysql.com/
[React Router]: https://img.shields.io/badge/React_Router-CA4245?style=for-the-badge&logo=react-router&logoColor=white
[React Query]: https://img.shields.io/badge/-React%20Query-FF4154?style=for-the-badge&logo=react%20query&logoColor=white
[SASS]: https://img.shields.io/badge/SASS-hotpink.svg?style=for-the-badge&logo=SASS&logoColor=white
[Spring]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[Vite]: https://img.shields.io/badge/vite-%23646CFF.svg?style=for-the-badge&logo=vite&logoColor=white
[Apache Maven]: https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white
[Java]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white
[TypeScript]: https://img.shields.io/badge/typescript-%23007ACC.svg?style=for-the-badge&logo=typescript&logoColor=white
[Selenium]: https://img.shields.io/badge/-selenium-%43B02A?style=for-the-badge&logo=selenium&logoColor=white
[AWS]: https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white
