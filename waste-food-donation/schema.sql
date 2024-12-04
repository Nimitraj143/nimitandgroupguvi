-- Create a database
CREATE DATABASE WasteFoodDonation;

-- Use the newly created database
USE WasteFoodDonation;

-- Create a table for users
CREATE TABLE Users (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    UserName VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    PasswordHash VARCHAR(255) NOT NULL,
    PhoneNumber VARCHAR(15),
    UserRole ENUM('Donor', 'Recipient', 'Admin') NOT NULL,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE FoodDonations (
    DonationID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    FoodName VARCHAR(255) NOT NULL,
    Quantity INT NOT NULL,
    ExpiryDate DATE NOT NULL,
    PickupLocation VARCHAR(255) NOT NULL,
    Status ENUM('Pending', 'Accepted', 'Completed') DEFAULT 'Pending',
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);