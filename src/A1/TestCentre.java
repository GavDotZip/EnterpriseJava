package A1;

// Class representing a test centre
public class TestCentre {

    // Name and address of the test centre
    private String name;
    private String address;

    // Constructor to initialize the test centre with name and address
    public TestCentre(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter method to retrieve the name of the test centre
    public String getName() {
        return name;
    }

    // Getter method to retrieve the address of the test centre
    public String getAddress() {
        return address;
    }
}
