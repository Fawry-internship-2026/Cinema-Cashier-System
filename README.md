# 🎬 Cinema Cashier System

A cashier solution designed to streamline the ticketing process for movie theaters. This system allows theater staff to view showtimes, check seat availability in real-time, and process bookings seamlessly.

## 🚀 Key Features
- **Real-time Seat Mapping:** Visual 5x5 matrix interface for quick seat selection.
- **Conflict Prevention:** Uses Pessimistic Locking to prevent double bookings.
- **Smart History Management:** Implements Soft Deletes to maintain reservation records for audit trails.
- **Automatic Scheduling:** Daily automated generation of showtimes (1 PM, 4 PM, 7 PM).
- **Auto-Registration:** Seamless customer creation based on email input during booking.

## 🛠️ Technical Stack
- **Backend:** Java, Spring Boot 3.5, Spring Data JPA, Hibernate.
- **Database:** MS SQL Server.
- **Frontend:** Thymeleaf (MVC), Bootstrap 5, Vanilla JavaScript.
- **Tools:** IntelliJ IDEA, Maven, Git.

## 👤 Target Audience
This system is designed for **Cinema Cashier Staff** who need a fast, reliable tool to manage walk-in customers and seat bookings on-site.

## 📋 Assumptions & Logic
1. **User Identity:** The system assumes customers are identified by their unique email. If an email is not in the system, it is automatically registered.
2. **Access Model:** This is an internal PoS (Point of Sale) system; it does not currently include public customer-facing authentication (no passwords required for staff speed).
3. **Capacity:** The theater hall is assumed to be a static 5x5 matrix for this prototype.

---
*Built with passion for the Fawry 2026 Internship.*
