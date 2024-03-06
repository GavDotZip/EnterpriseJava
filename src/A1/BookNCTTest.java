package A1;

import java.time.LocalDateTime;
import java.time.Month;
public class BookNCTTest implements BookNCTWeb{

    private int bookingID;
    private TestCentre testCentre;
    private static int nextbookingID = 1;
    private LocalDateTime dateTime;
    private BookNCTWeb bookWeb;

    public void setBookService(BookNCTWeb book){
        this.bookWeb = book;
    }
}
