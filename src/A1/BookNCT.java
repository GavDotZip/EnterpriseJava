package A1;

import java.time.LocalDateTime;
import java.time.Month;


// BookNCT class implementing BookNCTWeb interface
public class BookNCT implements BookNCTWeb {

    // Static variable to track booking IDs
    private static int bookingID;
    private String regNo; // Registration number of the vehicle
    private TestCentre centre; // Test centre where the booking is made
    private LocalDateTime dateTime; // Date and time of the booking
    private static int nextBookingID = 1; // Counter for next booking ID
    private BookNCTWeb slot; // Slot for the booking

    // Setter method for the slot
    public void setSlot(BookNCTWeb service) {
        this.slot = service;
    }

    // Constructor for booking with specified date and time
    public void BookNCTWeb(String regNo, TestCentre centre, LocalDateTime dateTime) throws InvalidDateTimeException {
        // Validate if the provided date and time are not in the past
        if(dateTime.isBefore((LocalDateTime.now()))) {
            throw new InvalidDateTimeException("Can't book in the past");
        }
        this.regNo = regNo;
        this.centre = centre;
        this.dateTime = dateTime;
        this.bookingID = nextBookingID++; // Assign a unique booking ID
    }

    // Constructor for booking without specifying date and time
    public BookNCT(String regNo, TestCentre testCentre) {
        this.regNo = regNo;
        this.centre = centre;
        this.bookingID = nextBookingID++; // Assign a unique booking ID
    }

    // Method to retrieve date and time from external API web service
    public void setDateTimeExternal() {
        this.dateTime = slot.getBookingDateTime(this.centre);
    }

    // Override method to get booking date and time
    @Override
    public LocalDateTime getBookingDateTime(TestCentre testCentre) {
        return LocalDateTime.of(2021, Month.OCTOBER, 30, 12, 0); // Sample date and time
    }

    // Method to query test centre
    public TestCentre queryTestCentre() {
        return centre;
    }

    // Method to query registration number
    public String queryRegNum() {
        return regNo;
    }

    // Method to edit registration number
    public void editRegNum(String newRegNo) {
        regNo = newRegNo;
    }

    // Method to query date and time
    public LocalDateTime queryDateTime() {
        return dateTime;
    }

    // Method to get booking ID
    public int getBookingID() {
        return bookingID;
    }

    // Override toString method to represent object as a string
    @Override
    public String toString() {
        return "Booking ID Number: " + bookingID + "\n" +
                "Registration Number: " + regNo + "\n" +
                "Centre: " + centre.getName() + "\n" +
                "Address: " + centre.getAddress() + "\n"  +
                "Date & Time: " + dateTime + "\n";
    }
}
