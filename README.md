# Online Bookstore

## Overview

**Online Bookstore** is a dynamic web application designed to provide an efficient online shopping experience for books. Built with HTML, CSS, JSP, Servlet, and JDBC, the platform allows users to browse a wide range of books, add them to their cart, and make purchases. With secure user authentication, it ensures a personalized shopping experience for every user.

---

## Features

- **User Authentication**: Secure login, registration, and "Forgot Password" functionality for users to manage their accounts.
- **Book Browsing**:  Browse a diverse selection of books with detailed information.
- **Shopping Cart**: Add books to your cart and review your purchases before checkout.
- **Seamless Navigation**: Clean and intuitive interface for easy browsing and shopping.

---

## Tech Stack

- **Frontend**: HTML, CSS, JavaScript, Bootstrap
- **Backend**: Java Servlets, JSP, JDBC
- **Database**: MySQL
- **Authentication**: User login, password reset ("Forgot Password") functionality, and session management
- **Server**: Apache Tomcat (or other servlet containers)

---

## Installation and Setup

Follow these steps to run the project locally:

1. Clone the repository:

   ```bash
    git clone https://github.com/your-username/online-bookstore.git
    cd online-bookstore

   ```

2. Open the project in your favorite code editor.

3. Set up the database:
   -Create a MySQL database and configure JDBC to connect to it.
   -Import the database schema or create the necessary tables for books, users, and orders.

5. Run the application on Apache Tomcat (or other servlet containers).

6. Open your browser and navigate to http://localhost:8080/OnlineBookstore/ to access the platform.


---

## How to Use

1. Open the application in your browser.
2. Log in using your credentials or register as a new user.
3. If you forget your password, use the "Forgot Password" link to reset it.
4. Browse books by category, search, or filter by various criteria.
5. Add books to your cart and proceed to checkout.
6. View your order history and manage your account.


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




## Future Enhancements

- Implement a recommendation system for book suggestions.
- Add payment gateway integration for online transactions.
- Implement an admin panel for managing books and users.
- Include pagination for better browsing experience.




---

## Contact

Maintainer: Manoj Modhale

- GitHub: [https://github.com/ManojModhale](https://github.com/ManojModhale)
- Email: [manojmodhale2001@gmail.com](mailto\:manojmodhale2001@gmail.com)

---

