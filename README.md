# TaskManagerPro
Made with ❤️ by Alexandra Zamfir
https://github.com/marcie0603

A simple, testable, and extensible **Java-based CLI Task Manager** built with:

- ⚙️ Gradle for project build and dependency management
- 📦 Gson for JSON-based task persistence
- 🧪 JUnit 5 for unit testing
- ☕ Java 17+ compatible
- 💻 Command-line user interface (CLI)

---

## 🚀 Features

- ✅ Add, delete, and complete tasks
- ✅ Assign due dates
- ✅ Filter by completed / pending tasks
- ✅ Search tasks by keyword
- ✅ Persist tasks in `tasks.json`
- ✅ Fully tested with JUnit

---

## 📂 Project Structure

TaskManagerPro/
├── src/
│ ├── main/java/com/example/
│ │ ├── Task.java
│ │ ├── TaskManager.java
│ │ ├── TaskStorage.java
│ │ └── Main.java
│ └── test/java/com/example/
│ └── TaskManagerTest.java
├── build.gradle
├── settings.gradle
├── tasks.json

---

| Tool    | Role                     |
| ------- | ------------------------ |
| Java    | Main language            |
| Gradle  | Build tool               |
| Gson    | JSON serialization       |
| JUnit 5 | Testing framework        |
| GitHub  | Source control & hosting |

---

## 🧪 Run Tests

```bash
./gradlew.bat test