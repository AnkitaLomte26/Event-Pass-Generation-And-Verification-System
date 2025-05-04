Event Registration System
Project Overview
The Event Registration System is a comprehensive web application designed to streamline the process of managing event registrations and generating digital event passes.
Built with Spring Boot and Thymeleaf, this system provides a user-friendly interface for browsing events, registering for them, and generating QR-coded event passes for verification at the venue.

Live Demo
The application is deployed and accessible at: https://event-pass-generation-and-verification.onrender.com

------------------------------------------Features----------------------------------

Event Browsing: Users can view a list of upcoming events with detailed information including dates, times, locations, and descriptions.
Event Status: Events can be marked as "Locked" or "Unlocked" for registration, with countdown timers for locked events.
Detailed Event Pages: Each event has a dedicated page showing comprehensive information, schedule, highlights, and what attendees will learn.
Registration System: Users can register for events by filling out a form with their personal details.
Payment Options: Support for multiple payment methods including Cash, UPI, and Net Banking.
Digital Event Passes: Automatically generated event passes with QR codes containing registration information.
Mobile Responsive: The application is fully responsive and works well on all device sizes.


------------------------------Technology Stack--------------------------------------

Backend: Java with Spring Boot
Frontend: Thymeleaf, HTML, CSS, JavaScript
Database: H2 (embedded)
QR Code Generation: QRCode-generator JS library
UI Design: Custom CSS with responsive design
Deployment: Render.com cloud platform
Project Structure
src/main/java/com/eventregistration/controller/ - Contains controllers for handling HTTP requests
src/main/java/com/eventregistration/model/ - Contains data models and entity classes
src/main/java/com/eventregistration/service/ - Contains business logic and service layer
src/main/java/com/eventregistration/config/ - Contains configuration classes including data initialization
src/main/resources/templates/ - Contains Thymeleaf templates for rendering HTML pages
src/main/resources/static/ - Contains static resources (CSS, JavaScript, images)
Key Features Explained
Home Page
The home page displays a grid of event cards, each showing a thumbnail image, title, date, time, location, and status. Events can be either "Locked" or "Unlocked" for registration. Locked events display a countdown timer indicating when registration will open.

------------------------------- Event Details Page -----------------------------------

Clicking on an event card takes users to a detailed page showing:

Event image and title
Date, time, and location
Registration fee and organizer
Detailed description
Learning objectives
Event highlights
Schedule of activities
Registration button (for unlocked events) or countdown timer (for locked events)
Registration Form
The registration form collects:

Full name
Email address
Mobile number
College name
Department
Year of study
Payment option (Cash, UPI, or Net Banking)
Payment proof (for UPI or Net Banking)
Event Pass
After successful registration, the system generates a digital event pass containing:

-------------------------------------- Event title and registration ID -------------------------------

QR code containing registration information
Event details (date, time, venue)
Attendee information
Instructions for using the pass
The QR code contains essential registration information in a format that can be easily scanned by standard QR readers and Google Lens.

---------------------------------------- Installation and Setup --------------------------------------

Clone the repository: git clone https://github.com/AnkitaLomte26/Event-Pass-Generation-And-Verification-System.git
Navigate to the project directory
Build the project: mvn clean install
Run the application: mvn spring-boot:run
Access the application in your browser at: http://localhost:8080
Alternatively, use the live demo at: https://event-pass-generation-and-verification.onrender.com
Mobile Access
The application can be accessed from any device with an internet connection by visiting the deployed URL. For local development, the application can be accessed from mobile devices on the same network using the server's IP address.

------------------------------------------ Security Considerations --------------------------------------

User passwords are securely hashed before storage
Form validation prevents common security issues
Session management ensures users can only access their own data
Event passes include verification features to prevent forgery
Future Enhancements
User authentication with login/signup functionality
Admin panel for event management
Email notifications for registrations
Payment gateway integration
Attendance tracking system using QR code scans
****************************Contributors*****************************************
Ankita Lomte
Sakshi Deshmukh
Snehal Jadhav
Bhargavi Maigur
License
This project is licensed under the MIT License - see the LICENSE file for details.
