package model;

public class Hotel {
    private static int id;
    private String hotelName;
    private int rating;
    private String address;
    private String city;
    private String state;
    private String country;
    private int pincode;
    private String phoneNumber;

    // Constructor
    public Hotel(int id, String hotelName, int rating, String address, String city, String state, String country, int pincode, String phoneNumber) {
        this.id = id;
        this.hotelName = hotelName;
        this.rating = rating;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public static int getId() { return id; }
    public String getHotelName() { return hotelName; }
    public int getRating() { return rating; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getCountry() { return country; }
    public int getPincode() { return pincode; }
    public String getPhoneNumber() { return phoneNumber; }
}
