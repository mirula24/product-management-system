
# Product Management API

This is the Product Management API, which provides a set of RESTful endpoints for managing products and categories within an application.

## Overview

This API allows you to manage products and their associated categories. It provides endpoints to create, update, retrieve, and delete Inventory, Product, Sale, Shop.
![ERD.png](ERD.png)

for complete you can copy all code in *openapi.yaml* to https://editor.swagger.io/
## Base URL

```
http://localhost:8080/api
```

## Endpoints

### Endpoints for Authentication

#### a. Register
- **Endpoint**: `/auth/register`
- **Method**: `POST`
- **Description**: Register a new user.
- **Request Body**:
```
{
    "email": "mirulid@gmail.com",
    "username":"amirul",
    "password": "amirul123!Mu"
}
```
- **Response**:
    - Status: `201 Created`
    - Body: 
```
{
    "id": 1,
    "username": "amirul",
    "email": "mirulid@gmail.com"
}
```
#### b. Login
- **Endpoint**: `/auth/login`
- **Method**: `POST`
- **Description**: Authenticate a user and receive a JWT token.
- **Request Body**:
```
  {
  "username":"amirul",
  "password": "amirul123!Mu"
  }
```
- **Response**:
    - Status: `200 OK`
    - Body: 
```
{
    "accessToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbWlydWwiLCJpYXQiOjE3MjM3MDI4MDUsImV4cCI6MTcyMzcwNjQwNX0.MUvXmQL5Wphsc0fu0jNedr4w4W4cjmT18a97vQX3sD8",
    "refreshToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbWlydWwiLCJpYXQiOjE3MjM3MDI4MDUsImV4cCI6MTcyMzc4OTIwNX0.6GNDorAlRQwszLoieuJ5RVJYhfLkjJObMKi3-ozI_nk"
}
```

### 2. **Products**

#### a. Get All Products
- **Endpoint**: `/products`
- **Method**: `GET`
- **Description**: Retrieve a list of all products.
- **Response**:
  - Status: `200 OK`
  - Body: 

```
[
    {
        "id": 1,
        "inventory": {
            "id": 1,
            "name": "CPU Storage",
            "city": "Jakarta",
            "address": "Jl. Processor No. 1"
        },
        "name": "Intel Core i7-11700K",
        "category": "CPU",
        "price": 399.99,
        "stock": 50
    },
    {
        "id": 2,
        "inventory": {
            "id": 1,
            "name": "CPU Storage",
            "city": "Jakarta",
            "address": "Jl. Processor No. 1"
        },
        "name": "AMD Ryzen 9 5900X",
        "category": "CPU",
        "price": 549.99,
        "stock": 30
    },
    {
        "id": 3,
        "inventory": {
            "id": 2,
            "name": "GPU Warehouse",
            "city": "Surabaya",
            "address": "Jl. Graphics Card No. 2"
        },
        "name": "NVIDIA GeForce RTX 3080",
        "category": "GPU",
        "price": 699.99,
        "stock": 20
    },
    {
        "id": 4,
        "inventory": {
            "id": 2,
            "name": "GPU Warehouse",
            "city": "Surabaya",
            "address": "Jl. Graphics Card No. 2"
        },
        "name": "AMD Radeon RX 6800 XT",
        "category": "GPU",
        "price": 649.99,
        "stock": 25
    },
    {
        "id": 5,
        "inventory": {
            "id": 3,
            "name": "RAM Depot",
            "city": "Bandung",
            "address": "Jl. Memory Lane No. 3"
        },
        "name": "Corsair Vengeance LPX 32GB",
        "category": "RAM",
        "price": 159.99,
        "stock": 100
    },
    {
        "id": 6,
        "inventory": {
            "id": 4,
            "name": "Motherboard Center",
            "city": "Medan",
            "address": "Jl. Main Board No. 4"
        },
        "name": "ASUS ROG Strix Z590-E Gaming",
        "category": "Motherboard",
        "price": 379.99,
        "stock": 40
    },
    {
        "id": 7,
        "inventory": {
            "id": 5,
            "name": "SSD & HDD Hub",
            "city": "Makassar",
            "address": "Jl. Storage Drive No. 5"
        },
        "name": "Samsung 970 EVO Plus 1TB NVMe SSD",
        "category": "Storage",
        "price": 179.99,
        "stock": 75
    },
    {
        "id": 8,
        "inventory": {
            "id": 1,
            "name": "CPU Storage",
            "city": "Jakarta",
            "address": "Jl. Processor No. 1"
        },
        "name": "NVIDIA GeForce RTX 4090",
        "category": "GPU",
        "price": 17499000,
        "stock": 40
    }
]
```

#### b. Get Product by ID
- **Endpoint**: `/products/{id}`
- **Method**: `GET`
- **Description**: Retrieve a single product by its ID.
- **Path Parameters**:
  - `id` (integer): The ID of the product to retrieve.
- **Response**:
  - Status: `200 OK`
  - Body: 
```
{
    "inventory_id": 3,
    "name": "Corsair Vengeance LPX 32GB",
    "category": "RAM",
    "price": 159.99,
    "stock": 100
}
```

#### c. Create a Product
- **Endpoint**: `/products`
- **Method**: `POST`
- **Description**: Create a new product.
- **Request Body**:
  - JSON object containing product details.
- **Response**:
  - Status: `201 Created`
  - Body: 
```
{

    "inventory_id": 1,
    "name": "NVIDIA GeForce RTX 4090",
    "category": "GPU",
    "price": 17499000,
    "stock": 40

}
```

#### d. Update a Product
- **Endpoint**: `/products/{id}`
- **Method**: `PUT`
- **Description**: Update an existing product by its ID.
- **Path Parameters**:
  - `id` (integer): The ID of the product to update.
- **Request Body**:
  - JSON object containing updated product details.
- **Response**:
  - Status: `200 OK`
  - Body: JSON object of the updated product

#### e. Delete a Product
- **Endpoint**: `/products/{id}`
- **Method**: `DELETE`
- **Description**: Delete an existing product by its ID.
- **Path Parameters**:
  - `id` (integer): The ID of the product to delete.
- **Response**:
  - Status: `204 No Content`

### 2. **Categories**

#### a. Get All Categories
- **Endpoint**: `/categories`
- **Method**: `GET`
- **Description**: Retrieve a list of all categories.
- **Response**:
  - Status: `200 OK`
  - Body: JSON array of categories

#### b. Get Category by ID
- **Endpoint**: `/categories/{id}`
- **Method**: `GET`
- **Description**: Retrieve a single category by its ID.
- **Path Parameters**:
  - `id` (integer): The ID of the category to retrieve.
- **Response**:
  - Status: `200 OK`
  - Body: JSON object of the category

#### c. Create a Category
- **Endpoint**: `/categories`
- **Method**: `POST`
- **Description**: Create a new category.
- **Request Body**:
  - JSON object containing category details.
- **Response**:
  - Status: `201 Created`
  - Body: JSON object of the created category

#### d. Update a Category
- **Endpoint**: `/categories/{id}`
- **Method**: `PUT`
- **Description**: Update an existing category by its ID.
- **Path Parameters**:
  - `id` (integer): The ID of the category to update.
- **Request Body**:
  - JSON object containing updated category details.
- **Response**:
  - Status: `200 OK`
  - Body: JSON object of the updated category

#### e. Delete a Category
- **Endpoint**: `/categories/{id}`
- **Method**: `DELETE`
- **Description**: Delete an existing category by its ID.
- **Path Parameters**:
  - `id` (integer): The ID of the category to delete.
- **Response**:
  - Status: `204 No Content`

