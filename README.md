# Online Bookstore

## Overview

**Online Bookstore** is a feature-rich dynamic web application that simplifies the process of buying books online. With a user-centric design and robust backend functionality, this platform offers a seamless shopping experience. Users can browse a comprehensive catalog of books, add items to their cart, and make secure purchases. The application includes features like user authentication, a "Forgot Password" mechanism, input validation using filters, and database connection management via listeners. Built using Java technologies like JSP, Servlets, and JDBC, the project demonstrates the integration of frontend, backend, and database functionalities effectively.

---

## Features

**Core Functionality**
1. User Authentication
   - Secure login and registration for personalized user experiences.
   - "Forgot Password" feature for recovering account access.
2. Book Browsing
   - Explore a diverse selection of books with detailed descriptions.
   - Search and filter options for finding books by keywords or categories.
3. Shopping Cart
   - Add books to the cart, view items, and proceed to secure checkout.
**Technical Enhancements**
4. Backend Validation
   - Filters are implemented to validate user input and ensure data security.
5. Database Connection Management
   - Listeners are used for establishing and managing connections to the MySQL database.
6. Dynamic Content Rendering
   - JSPs generate and render dynamic content based on user interactions.
7. Session Management
   - Ensures secure and efficient handling of user sessions.
8. Responsive Design
   - Optimized user interface with HTML, CSS, and JavaScript for cross-device compatibility.

---

## Tech Stack

- **Frontend**: HTML, CSS, JavaScript, Bootstrap
- **Backend**: Java Servlets, JSP
- **Database**: MySQL, connected via JDBC
- **Validation**: Filters for secure input validation
- **Listener**: Listener for Database Connection Establishment
- **Session Management**: HttpSession for user data and shopping cart persistence 
- **Server**: Apache Tomcat 8.5
- **Software**: Eclipse Dynamic Web Project

---

## Installation and Setup

To set up and run the project locally, follow these steps:
**Prerequisites**
   -Java Development Kit (JDK) installed
   -Apache Tomcat server configured
   -MySQL database set up

**Steps**

1. Clone the repository:

   ```bash
    git clone https://github.com/your-username/online-bookstore.git
    cd online-bookstore

   ```

2. Set up the database:
   -Create a MySQL database and configure JDBC to connect.
   -Import the provided SQL script or create tables for books, users, orders, and related entities.

3. Open in IDE
   -Open the project in an IDE like Eclipse or Visual Studio Code.

4. Configure Server
   -Deploy the application on Apache Tomcat or any servlet container.

5. Run the Application
   -Access the application at http://localhost:8080/OnlineBookstore/.

---

## How to Use

1. Open the application in your browser.
2. Log in using your credentials or register as a new user.
3. If you forget your password, use the "Forgot Password" link to reset it.
4. Browse books by category, search, or filter by various criteria.
5. Add books to your cart and proceed to Payment.
6. Logout

---

## Folder Structure

```
online-bookstore/
├── src/
│   ├── com/
│   │   ├── book/
│   │   │   ├── model/
│   │   │   │   ├── Book.java
│   │   │   │   ├── NewUser.java
│   │   │   │   ├── Payment.java
│   │   │   ├── dao/
│   │   │   │   ├── BookDao.java
│   │   │   │   ├── NewUserDAO.java
│   │   │   ├── filter/
│   │   │   │   ├── PasswordFilter1.java
│   │   │   │   ├── PasswordFilter2.java
│   │   │   │   ├── paymentValidationFilter.java
│   │   │   │   ├── ValidationLogin.java
│   │   │   ├── listener/
│   │   │   │   ├── ConnectionListener.java
│   │   │   ├── servlet/
│   │   │   │   ├── CartServlet.java
│   │   │   │   ├── ExploreServlet.java
│   │   │   │   ├── ForgotPasswordServlet.java
│   │   │   │   ├── LoginServlet.java
│   │   │   │   ├── LogoutServlet.java
│   │   │   │   ├── NewPasswordServlet.java
│   │   │   │   ├── PaymentServlet.java
│   │   │   │   ├── RegistrationServlet.java
├── WebContent/
│   ├── img/
│   │   ├── bookshelf.png
│   │   ├──...
│   ├── META-INF/
│   │   ├── MANIFEST.MF
│   ├── WEB.INF/
|   │   ├── lib/
│   │   │   ├── mysql-connector-j-8.2.0.jar
│   │   ├── web.xml
│   ├── css/
│   │   ├── card_style.css
│   │   ├── form.css
│   │   ├── home.css
│   │   ├── webpage_style.css
│   ├── js/
│   │   ├── home.js
│   │   ├── jquery.js
│   │   ├── newuser_script.js
│   ├── jsp/
│   │   ├── cart.jsp
│   │   ├── payment.jsp
│   ├── html/
│   │   ├── explore.js
│   │   ├── forgotpass.js
│   │   ├── index.js
│   │   ├── login.js
│   │   ├── newpassword.js
│   │   ├── newuser.js
│   │   ├── thankyou.js
```

---

## Configuration (web.xml)

The `WEB-INF/web.xml` file plays a crucial role as the deployment descriptor for the application. It handles the following configurations:

- **Servlets**: Maps specific URLs to corresponding servlet classes, enabling request handling for features like login, registration, and book browsing.
- **Filters**: Defines components that process incoming requests or outgoing responses to add functionalities like input validation or authentication checks.
- **Listeners**: Manages application lifecycle events, such as initializing a database connection when the application starts.
- **Error Pages**: Customizes user-friendly error messages for specific HTTP error codes, enhancing the user experience during unexpected failures.
- **Welcome Files**: Specifies the default page (like `index.html`) that loads when users access the application.

The `web.xml` file ensures the application follows a structured and centralized approach to configuration, making it easier to maintain and extend over time.

---

## Future Enhancements

- Personalized book suggestions based on user preferences and browsing history.
- Add payment gateway integration for online transactions.
- Implement an admin panel for managing books and users.
- Include pagination for better browsing experience.

---

## Contact

Maintainer: Manoj Modhale

- GitHub: [https://github.com/ManojModhale](https://github.com/ManojModhale)
- Email: [manojmodhale2001@gmail.com](mailto\:manojmodhale2001@gmail.com)

---

