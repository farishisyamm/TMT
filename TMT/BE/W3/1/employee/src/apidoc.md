# Employee API Documentation

## Base URL
```
http://localhost:8080/api
```

## Endpoints

### 1. Get List of Employees
#### GET /employees
Fetch all employees

#### Request Parameters:
| Parameter | Type   | Required | 
|-----------|--------|----------|
| keyword   | String | No       |

#### Example Request:
```
GET /employees
```

#### Example Response:
```json
[
  {
    "id": 1,
    "name": "Faris",
    "position": "Backend Engineer",
    "salary": 5.0E7,
    "formattedSalary": "50.000.000,00"
  },
  {
    "id": 2,
    "name": "Razan",
    "position": "Backend Engineer",
    "salary": 5.0E7,
    "formattedSalary": "50.000.000,00"
  },
  {
    "id": 3,
    "name": "Adil",
    "position": "Frontend Engineer",
    "salary": 5.0E7,
    "formattedSalary": "50.000.000,00"
  },
  {
    "id": 4,
    "name": "Kevin",
    "position": "Mobile Engineer",
    "salary": 5.0E7,
    "formattedSalary": "50.000.000,00"
  },
  {
    "id": 5,
    "name": "Gilang",
    "position": "QA Engineer",
    "salary": 5.0E7,
    "formattedSalary": "50.000.000,00"
  },
  {
    "id": 7,
    "name": "Fajar",
    "position": "Senior Backend Engineer",
    "salary": 1.0E8,
    "formattedSalary": "100.000.000,00"
  }
]
```

---

### 2. Get Employee Details by ID
#### GET `/employee/{id}`
Fetch details of a specific employees by its ID.

#### Path Parameters:
| Parameter | Type | Required | Description        |
|-----------|------|----------|--------------------|
| id        | Long | Yes      | ID of the employee |

#### Example Request:
```
GET /employee/5
```

#### Example Response:
```json
{
  "id": 5,
  "name": "Gilang",
  "position": "QA Engineer",
  "salary": 5.0E7,
  "formattedSalary": "50.000.000,00"
}
```

---

### 3. Add a New Employee
#### POST `/employee`
Add a new employee to the list.

#### Request Body:
| Field    | Type   | Required |                          |
|----------|--------|----------|--------------------------|
| name     | String | Yes      | Name of the employee     |
| position | String | Yes      | Position of the employee |
| salary   | Double | Yes      | Salary of the employee   |

#### Example Request:
```json
{
  "name": "Fajar",
  "position": "Backend Engineer",
  "salary": "100000000"
}
```

### 4. Update an Existing Employee
#### PUT `/employee/{id}`
Update an existing employee by its ID.

#### Path Parameters:
| Parameter | Type | Required | Description        |
|-----------|------|----------|--------------------|
| id        | Long | Yes      | ID of the employee |

#### Request Body:
| Field    | Type   | Required | Description              |
|----------|--------|----------|--------------------------|
| name     | String | Yes      | name of the employee     |
| position | String | Yes      | position of the employee |
| salary   | Double | Yes      | salary of the employee   |

#### Example Request:
```json
{
  "name": "Fajar",
  "position": "Backend Engineer",
  "salary": 120000000
}
```

---

### 5. Update Partially an Existing Employee
#### PATCH `/employee/{id}`
Update partially an existing employee by its ID.

#### Path Parameters:
| Parameter | Type | Required | Description        |
|-----------|------|----------|--------------------|
| id        | Long | Yes      | ID of the employee |

#### Request Body:
| Field    | Type   | Required | Description              |
|----------|--------|----------|--------------------------|
| name     | String | no       | name of the employee     |
| position | String | no       | position of the employee |
| salary   | Double | no       | salary of the employee   |

#### Example Request:
```json
{
  "position": "Senior Backend Engineer"
}
```
---
### 6. Delete a Employee by ID
#### DELETE `/employee/{id}`
Delete an employee from the list by its ID.

#### Path Parameters:
| Parameter | Type | Required | Description        |
|-----------|------|----------|--------------------|
| id        | Long | Yes      | ID of the employee |

#### Example Request:
```
DELETE /employee/7
```
