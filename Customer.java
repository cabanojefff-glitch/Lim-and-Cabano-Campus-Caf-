public class Customer {
    private String name;
    private boolean student;
    private int loyaltyPoints;

    /**
     * Creates a customer with default details.
     */
    public Customer() {
        this("Guest", false);
    }

    /**
     * Creates a non-student customer with the supplied name.
     *
     * @param name the customer's name
     */
    public Customer(String name) {
        this(name, false);
    }

    /**
     * Creates a customer with a name and student status.
     *
     * @param name the customer's name
     * @param student whether the customer is a student
     */
    public Customer(String name, boolean student) {
        setName(name);
        this.student = student;
        this.loyaltyPoints = 0;
    }

    /**
     * Adds a specified number of loyalty points.
     *
     * @param points the number of points to add
     */
    public void addPoints(int points) {
        if (points >= 0) {
            loyaltyPoints += points;
        } else {
            System.out.println("Error: points cannot be negative.");
        }
    }

    /**
     * Adds one loyalty point for every 50 pesos spent.
     *
     * @param amountSpent the purchase amount
     */
    public void addPoints(double amountSpent) {
        if (amountSpent >= 0) {
            loyaltyPoints += (int) (amountSpent / 50.0);
        } else {
            System.out.println("Error: amount spent cannot be negative.");
        }
    }

    /**
     * Gets the customer's name.
     *
     * @return the customer's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the customer's name when it is not blank.
     *
     * @param name the new name
     */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: customer name cannot be blank.");
        }
    }

    /**
     * Checks whether the customer is a student.
     *
     * @return true if the customer is a student
     */
    public boolean isStudent() {
        return student;
    }

    /**
     * Sets the customer's student status.
     *
     * @param student the new student status
     */
    public void setStudent(boolean student) {
        this.student = student;
    }

    /**
     * Gets the customer's loyalty points.
     *
     * @return the current loyalty points
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * Sets loyalty points, rejecting negative values.
     *
     * @param loyaltyPoints the new loyalty point balance
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        } else {
            System.out.println("Error: loyalty points cannot be negative.");
        }
    }
}
