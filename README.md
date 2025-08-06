# Workforce Management API

This is a **Spring Boot** (in-memory) REST API that helps manage workforce tasks.  
It supports task assignment, priority management, activity history, and user comments — all without using a database.

---

## ✨ What’s Inside

### 🐛 Bug Fixes
- **Duplicate tasks on reassignment** → Fixed so that when you reassign, the old task gets **cancelled** instead of duplicated.
- **Cancelled tasks showing up in lists** → They’re now filtered out when fetching tasks.
- **Smarter “Today’s Work” view** → You now see:
  - All active tasks created **within** your date range.
  - All active tasks created **before** your date range but still open.

---

### 🚀 New Features
1. **Task Priority**
   - Priorities: `HIGH`, `MEDIUM`, `LOW`.
   - Change priority any time.
   - Fetch tasks filtered by priority.

2. **Activity History**
   - Logs key actions: creation, reassignment, priority changes, cancellations.

3. **User Comments**
   - Add free-text comments to any task.
   - Task details include both **activity history** and **comments**, sorted by time.

---

## 🛠 Tech Stack
- Java 17
- Spring Boot
- Gradle
- Lombok
- In-memory storage (no DB required)

---

## 📌 API Endpoints

### Task Assignment
```http
POST /tasks/assign-by-ref
```
Assign tasks for a reference type and cancel the old ones.

---

### Priority Management
```http
PUT /tasks/{id}/priority?priority=HIGH
GET /tasks/priority/{priority}
```

---

### Comments
```http
POST /tasks/{id}/comments?userId=1&text=Please+complete+soon
```

---

### Fetch Tasks by Date Range
```http
GET /tasks/date-range
```
- Shows all active tasks in the range.
- Also includes still-open tasks that started before the range.
- Cancelled tasks are excluded.

---

### Task Details
```http
GET /tasks/{id}
```
- Full activity history + all comments in chronological order.

---

## ▶ How to Run

### 1. Clone the repo
```bash
git clone https://github.com/lakshaybxt/workforce-management-api.git
cd workforce-management-api
```

### 2. Run the app
```bash
./gradlew bootRun
```

---

## 📦 Example Task JSON
```json
{
  "id": 1,
  "referenceId": 101,
  "referenceType": "CUSTOMER",
  "task": "ARRANGE_PICKUP",
  "description": "Pickup arrangement for order #101",
  "status": "ASSIGNED",
  "assigneeId": 5,
  "priority": "HIGH",
  "taskDeadlineTime": 1728200000000,
  "activityHistory": [
    { "message": "Task created by User A", "timestamp": 1728200000000 },
    { "message": "Priority changed to HIGH", "timestamp": 1728205000000 }
  ],
  "comments": [
    { "userId": 101, "text": "This needs to be done ASAP", "timestamp": 1728207000000 }
  ]
}
```

---

## 👤 Author
**Lakshay Bisht**  
[GitHub](https://github.com/lakshaybxt)
