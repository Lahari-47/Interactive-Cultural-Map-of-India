# 🗺️ Interactive Cultural Map of India

A full-stack Java-based web application that showcases India's cultural diversity by state, featuring art forms, festivals, cuisine, and famous artists. Users can select a state from the dropdown menu to view dynamic cultural details pulled from a MySQL database.

---

## 🚀 Features

- View cultural data (art, food, festivals, artists) for major Indian states
- Real-time data fetching from MySQL using Java backend
- Lightweight and fast Spark Java framework
- Clean and responsive UI with HTML, CSS, and JavaScript
- JDBC-based database interaction without servlets

---

## 🛠️ Tech Stack

- **Backend:** Java (Spark Framework)
- **Frontend:** HTML, CSS, JavaScript
- **Database:** MySQL
- **Build Tool:** Maven

---

## 📂 Project Structure

```
culturalmap/
├── pom.xml
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── lorry/
│                   └── culturalmap/
│                       ├── CulturalServer.java
│                       └── DBUtil.java
├── static/
│   ├── index.html
│   └── script.js
```

---

## 🧑‍💻 Setup Instructions

### 📦 Prerequisites

- Java 8 or higher
- Maven
- MySQL
- Eclipse or IntelliJ IDE

---

### ⚙️ MySQL Setup

```sql
CREATE DATABASE culturalmap;

USE culturalmap;

CREATE TABLE state_culture (
    id INT AUTO_INCREMENT PRIMARY KEY,
    state_name VARCHAR(50) NOT NULL,
    art_form VARCHAR(100),
    festival VARCHAR(100),
    famous_food VARCHAR(100),
    artist_name VARCHAR(100)
);

INSERT INTO state_culture (state_name, art_form, festival, famous_food, artist_name)
VALUES 
('Andhra Pradesh', 'Kuchipudi', 'Ugadi', 'Pesarattu', 'Siddhendra Yogi'),
('Tamil Nadu', 'Bharatanatyam', 'Pongal', 'Sambar', 'Rukmini Devi Arundale'),
('Rajasthan', 'Kathputli', 'Teej', 'Dal Baati', 'Bhopa Singers'),
('Punjab', 'Bhangra', 'Lohri', 'Makki di Roti', 'Gurdas Maan');

CREATE USER 'lorry'@'localhost' IDENTIFIED BY 'Lorry@123';
GRANT ALL PRIVILEGES ON culturalmap.* TO 'lorry'@'localhost';
FLUSH PRIVILEGES;
```

---

### 🔧 Run Project

1. Clone the repo or download ZIP
2. Import into Eclipse as a **Maven Project**
3. Ensure the folder `static/` (with `index.html` and `script.js`) is placed outside `src`
4. Add Spark and MySQL dependencies via `pom.xml`:
    ```xml
    <dependency>
        <groupId>com.sparkjava</groupId>
        <artifactId>spark-core</artifactId>
        <version>2.9.4</version>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>
    ```
5. Run `CulturalServer.java`
6. Open browser and go to:  
   👉 `http://localhost:8080/index.html`
7. Select a state to view cultural details!

---

