package com.example.wastefooddonation.dao;

import com.example.wastefooddonation.model.FoodDonation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDonationDAO {
    private Connection connection;

    public FoodDonationDAO(Connection connection) {
        this.connection = connection;
    }

    public void addFoodDonation(FoodDonation donation) throws SQLException {
        String query = "INSERT INTO FoodDonations (UserID, FoodName, Quantity, ExpiryDate, PickupLocation, Status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, donation.getUserId());
            stmt.setString(2, donation.getFoodName());
            stmt.setInt(3, donation.getQuantity());
            stmt.setDate(4, new java.sql.Date(donation.getExpiryDate().getTime()));
            stmt.setString(5, donation.getPickupLocation());
            stmt.setString(6, donation.getStatus());
            stmt.executeUpdate();
        }
    }

    public List<FoodDonation> getAllFoodDonations() throws SQLException {
        List<FoodDonation> donations = new ArrayList<>();
        String query = "SELECT * FROM FoodDonations";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                FoodDonation donation = new FoodDonation();
                donation.setDonationId(rs.getInt("DonationID"));
                donation.setUserId(rs.getInt("UserID"));
                donation.setFoodName(rs.getString("FoodName"));
                donation.setQuantity(rs.getInt("Quantity"));
                donation.setExpiryDate(rs.getDate("ExpiryDate"));
                donation.setPickupLocation(rs.getString("PickupLocation"));
                donation.setStatus(rs.getString("Status"));
                donation.setCreatedAt(rs.getTimestamp("CreatedAt"));
                donations.add(donation);
            }
        }
        return donations;
    }
}
