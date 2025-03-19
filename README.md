# Todo List Java Application

## 📌 Overview
This is a simple **Todo List** application built using **Java** and **H2 Database**. The application allows users to:
- Add tasks
- View tasks
- Remove tasks
- Exit the application

It is a **command-line interface (CLI) application**, making it lightweight and easy to use.

---

## 🛠️ Tech Stack
- **Java 17**
- **Maven** (for dependency management)
- **H2 Database** (for storing tasks locally)

---

## 📂 Project Structure
```
project/
│-- src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── example/
│   │   │   │   │   ├── todolist/
│   │   │   │   │   │   ├── TodoListApplication.java
│   │   │   │   │   │   ├── TaskManager.java
│   ├── resources/
│-- pom.xml
│-- README.md
```

---

## 🚀 Getting Started
### 1️⃣ Prerequisites
Make sure you have the following installed on your system:
- **Java 17** ([Download](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html))
- **Apache Maven** ([Download](https://maven.apache.org/download.cgi))
- **Git** ([Download](https://git-scm.com/downloads))

### 2️⃣ Clone the Repository
```sh
git clone https://github.com/yourusername/todo-list-java.git
cd todo-list-java
```

### 3️⃣ Build the Project
```sh
mvn clean package
```

### 4️⃣ Run the Application
```sh
mvn exec:java
```

---

## 📝 Features
1️⃣ **Add Task**: Allows users to add tasks to the list.
2️⃣ **View Tasks**: Displays all added tasks.
3️⃣ **Remove Task**: Users can remove completed tasks.
4️⃣ **Exit**: Safely exits the application while saving tasks.

---

## 🏗️ How It Works
1. The user is presented with a **menu**:
   ```
   1. Add Task
   2. View Tasks
   3. Remove Task
   4. Exit
   Choose an option:
   ```
2. Selecting **1** prompts the user to enter a task.
3. Selecting **2** displays all saved tasks.
4. Selecting **3** allows the user to remove a task by entering its number.
5. Selecting **4** exits the application.

---

## 🛠️ Configuration
### **Maven Dependencies (pom.xml)**
```xml
<dependencies>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <version>2.2.224</version>
    </dependency>
</dependencies>
```

### **H2 Database File Location**
The H2 database file is stored in:
```
C:\Users\srini\todolist.mv.db
```
If you wish to reset the database, delete this file.

---

## 📌 Troubleshooting
### **Common Issues & Fixes**
1️⃣ **Error: `java.lang.NoClassDefFoundError: org/h2/api/ErrorCode`**
   - Ensure the H2 database dependency is correctly included in `pom.xml`.
   - Run:
     ```sh
     mvn clean package
     mvn exec:java
     ```

2️⃣ **Tasks Not Saving?**
   - Ensure you exit the application properly using option **4 (Exit)** to commit changes.

3️⃣ **Maven Build Failing?**
   - Run:
     ```sh
     mvn clean install
     ```

---

## 📜 License
This project is **open-source** and available under the **MIT License**.

---

## 🤝 Contributing
Want to improve the project? Follow these steps:
1. **Fork** the repository.
2. Create a **new branch** (`feature-branch`):
   ```sh
   git checkout -b feature-branch
   ```
3. Commit your changes:
   ```sh
   git commit -m "Added new feature"
   ```
4. **Push** the changes:
   ```sh
   git push origin feature-branch
   ```
5. Open a **Pull Request (PR)**.

---

#Thank You
