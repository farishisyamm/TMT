# Book API Documentation

## Base URL
```
http://localhost:8080/api
```

## Endpoints

### 1. Get List of Books
#### GET `/books`
Fetch all books

#### Request Parameters:
| Parameter | Type   | Required | 
|-----------|--------|----------|
| keyword   | String | No       |

#### Example Request:
```
GET /books?keyword=Java
```

#### Example Response:
```json
[
    {
        "id": 1,
        "name": "Java",
        "author": "Gilang"
    },
    {
        "id": 2,
        "name": "Golang",
        "author": "Rizky"
    }
]
```

---

### 2. Get Book Details by ID
#### GET `/book/{id}`
Fetch details of a specific book by its ID.

#### Path Parameters:
| Parameter | Type | Required | Description       |
|-----------|------|----------|-------------------|
| id        | Long | Yes      | ID of the book    |

#### Example Request:
```
GET /book/1
```

#### Example Response:
```json
{
    "id": 1,
    "name": "Java",
    "author": "Gilang"
}
```

---

### 3. Add a New Book
#### POST `/book`
Add a new book to the list.

#### Request Body:
| Field  | Type   | Required |                    |
|--------|--------|----------|--------------------|
| id     | Long   | Yes      | ID of the book     |
| name  | String | Yes      | Name of the book   |
| author | String | Yes      | Author of the book |

#### Example Request:
```json
{
    "id": 4,
    "name": "Python",
    "author": "Andi"
}
```

#### Example Response:
```json
{
    "id": 4,
    "name": "Python",
    "author": "Andi"
}
```

### 4. Update an Existing Book
#### PUT `/book/{id}`
Update an existing book by its ID.

#### Path Parameters:
| Parameter | Type | Required | Description       |
|-----------|------|----------|-------------------|
| id        | Long | Yes      | ID of the book    |

#### Request Body:
| Field  | Type   | Required | Description        |
|--------|--------|----------|--------------------|
| id     | Long   | Yes      | ID of the book     |
| name  | String | Yes      | name of the book  |
| author | String | Yes      | Author of the book |

#### Example Request:
```json
{
    "id": 4,
    "name": "Python",
    "author": "Faris"
}
```

#### Example Response:
```json
{
    "id": 4,
    "name": "Python",
    "author": "Faris"
}
```

---

### 5. Delete a Book by ID
#### DELETE `/book/{id}`
Delete a book from the list by its ID.

#### Path Parameters:
| Parameter | Type | Required | Description       |
|-----------|------|----------|-------------------|
| id        | Long | Yes      | ID of the book    |

#### Example Request:
```
DELETE /book/4
```
