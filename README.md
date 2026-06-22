# E-Commerce Backend Application

## Overview

A full-featured E-Commerce Backend Application built using Java Spring Boot, Spring Security, JWT Authentication, MySQL, JPA/Hibernate, and Cloudinary.

## Features

### Authentication

* User Registration
* User Login
* JWT Authentication
* Role-Based Authorization

### Product Management

* Add Product
* Update Product
* Delete Product
* Product Search
* Pagination
* Sorting
* Price Filtering
* Category Filtering
* Low Stock Alerts

### Category Management

* Add Category
* View Categories
* Product Count By Category

### Cart Management

* Add To Cart
* View Cart
* Remove From Cart

### Order Management

* Place Order
* View Orders
* Order History
* Order Status Updates

### Coupons

* Create Coupons
* Apply Coupons

### Wishlist

* Add To Wishlist
* View Wishlist

### Reviews

* Add Reviews
* Product Ratings
* Top Rated Products

### Address Management

* Add Address
* View Address

### Payments

* Payment Processing APIs

### Image Upload

* Cloudinary Integration

## Tech Stack

* Java 21
* Spring Boot
* Spring Security
* JWT
* Spring Data JPA
* Hibernate
* MySQL
* Cloudinary
* Maven

## Database

Tables:

* users
* categories
* products
* cart
* cart_items
* orders
* order_items
* coupons
* wishlist
* reviews
* addresses
* payments

## API Endpoints

Authentication:

* POST /auth/register
* POST /auth/login

Products:

* GET /products
* POST /products
* PUT /products/{id}
* DELETE /products/{id}

Categories:

* GET /categories
* POST /categories

Orders:

* GET /orders
* POST /orders

Wishlist:

* GET /wishlist
* POST /wishlist

Reviews:

* GET /reviews
* POST /reviews

## Cloudinary Integration

Product images are uploaded to Cloudinary and only image URLs are stored in the database.

## Author

Jhansi
