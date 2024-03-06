package A1;

import java.time.LocalDateTime;

public class BookNCT implements BookNCTWeb {

    private static int bookingID;
    private String regNo;
    private TestCentre centre;
    private LocalDateTime dateTime;
    private static int nextBookingID = 1;
    private BookNCTWeb slot;

    public void setSlot(BookNCTWeb service) {
        this.slot = service;
    }

    public void BookNCTWeb(String regNo, TestCentre centre, LocalDateTime dateTime) throws InvalidDateTimeException {
        if(dateTime.isBefore((LocalDateTime.now()))) {
            throw new InvalidDateTimeException("Cant change the past");
        }
        this.regNo = regNo;
        this.centre = centre;
        this.dateTime = dateTime;
        this.bookingID = nextBookingID++;
    }

    public BookNCT(String regNo, TestCentre testCentre) {
        this.regNo = regNo;
        this.centre = centre;
        this.bookingID = nextBookingID++;
    }

    //method to get the date and time from external API web service
    public void setDateTimeExternal()
    {
        this.dateTime = slot.getBookingDateTime(this.centre);
    }

    @Override
    public LocalDateTime getBookingDateTime(TestCentre testCentre)
    {
        return LocalDateTime.of(2021, Month.OCTOBER, 30, 12, 0);
    }

    public TestCentre queryTestCentre()
    {
        return centre;
    }

    public String queryRegNum()
    {
        return regNo;
    }

    public void editRegNum(String newRegNo)
    {
        regNo = newRegNo;
    }

    public LocalDateTime queryDateTime()
    {
        return dateTime;
    }

    public int getBookingID()
    {
        return bookingID;
    }

    @Override
    public String toString()
    {
        return "Booking ID Number: " + bookingID + "\n" +
                "Registration Number: " + regNo + "\n" +
                "Centre: " + centre.getName() + "\n" +
                "Address: " + centre.getAddress() + "\n"  +
                "Date & Time: " + dateTime + "\n";
    }
}
