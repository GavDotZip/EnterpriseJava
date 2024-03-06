package A1;

import java.time.LocalDateTime;
import java.time.Month;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
public class BookNCTTest{

    @Test
    public void testCentre() throws InvalidDateTimeException {
        TestCentre centre1 = new TestCentre("Ballinasloe", "Unit 9, Pollboy Industrial Estate, Ballinasloe, Galway H53 NW94");
        BookNCT booking1 = new BookNCT("16-WH-59741", centre1, LocalDateTime.of(2021, Month.OCTOBER, 22, 8, 0));
        TestCentre centreFromBooking = booking1.queryTestCentre();
        assertEquals(centreFromBooking, centre1, "Test centre query successful");
    }

    @Test
    public void testRegNO_NoEditRegNO() throws InvalidDateTimeException {
        String regNumQueryInput = "16-WH-59741";
        TestCentre centre1 = new TestCentre("Ballinasloe", "Unit 9, Pollboy Industrial Estate, Ballinasloe, Galway H53 NW94");
        NCTBooking booking1 = new BookNCT(regNumQueryInput, centre1, LocalDateTime.of(2021, Month.OCTOBER, 22, 8, 0));
        String regNumQueryResult = booking1.queryRegNum();
        assertEquals(regNumQueryResult, regNumQueryInput, "Registration number query successful");
    }


}
