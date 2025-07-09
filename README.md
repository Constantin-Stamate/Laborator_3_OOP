# 🏨 Reservation System – OOP Lab 3

This Java application simulates a **Reservation Management System**, capable of handling hotel and event reservations. It showcases important **Object-Oriented Programming (OOP)** concepts like inheritance, interfaces, polymorphism, and service-based architecture.

---

## 💻 Project Context

This project was developed as part of the **Object-Oriented Programming** course at the **Technical University of Moldova (UTM)**. The system reads reservation data from files, processes modifications, and displays results based on specific rules and types.

---

## 🧩 Structure

The project is organized as follows:

```
src/
├── main/
│   ├── java/
│   │   ├── constants/           # Enums for reservation types and statuses
│   │   │   ├── ReservationStatus.java
│   │   │   └── ReservationType.java
│   │   │
│   │   ├── dto/                # Core data transfer objects
│   │   │   ├── Reservation.java
│   │   │   ├── EventReservation.java
│   │   │   └── HotelReservation.java
│   │   │
│   │   ├── repository/         # In-memory repository for reservations
│   │   │   └── ReservationRepository.java
│   │   │
│   │   ├── service/            # Logic for processing reservations
│   │   │   ├── ReservationService.java
│   │   │   ├── EventReservationService.java
│   │   │   └── HotelReservationService.java
│   │   │
│   │   └── Main.java           # Entry point of the application
│
└── resources/
    ├── reservations.txt        # Input data for reservations
    └── modifications.txt       # Input data for reservation updates
```

---

## 🧠 Features Implemented

- Parse and load reservation data from text files
- Apply modifications to existing reservations
- Support for multiple reservation types:
    - Hotel reservations
    - Event reservations
- Separate service logic for each type
- Repository pattern for managing reservation state
- Output updated reservation information

---

## ⚙️ How to Run the Project

1. **Install Java (JDK 8 or later)**  
   Download and install from: [https://www.oracle.com/java/technologies/javase-downloads.html](https://www.oracle.com/java/technologies/javase-downloads.html)


2. **Clone the project**

```bash
  git clone https://github.com/Constantin-Stamate/Laborator_3_OOP.git
```

3. **Navigate into the project folder**

```bash
  cd Laborator_3_OOP
```

4. **Compile all Java files**

```bash
  javac src/main/java/**/*.java
```

5. **Run the application**

```bash
  java -cp src/main/java Main
```

> ⚠️ Ensure that `reservations.txt` and `modifications.txt` are placed in the `resources/` folder and that file-reading logic is correctly configured to find them.

---

## 📚 Useful Links

- [Java Official Documentation](https://docs.oracle.com/en/java/javase/)
- [Java File Reading (I/O)](https://docs.oracle.com/javase/tutorial/essential/io/)
- [OOP in Java](https://www.geeksforgeeks.org/object-oriented-programming-oops-concept-in-java/)

---

## 👨‍💻 Author

This project was developed by **Constantin Stamate** as part of the **Object-Oriented Programming** course at **UTM**.

- GitHub: [Constantin-Stamate](https://github.com/Constantin-Stamate)
- Email: [constantinstamate.r@gmail.com](mailto:constantinstamate.r@gmail.com)