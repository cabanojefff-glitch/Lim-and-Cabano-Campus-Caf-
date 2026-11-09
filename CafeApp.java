public class CafeApp {
    /**
     * Starts the Campus Cafe Ordering System.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Customer constructor overloading: two different constructors are used.
        Customer ana = new Customer("Ana Reyes", true);
        Customer ben = new Customer("Ben Cruz");

        // Parameterized constructors for the first customer's menu items.
        Beverage icedLatte = new Beverage("Iced Latte", 95.00, "B-01", "L");
        Pastry ensaymada = new Pastry("Ensaymada", 45.00, "P-01", true);
        Meal chickenAdobo = new Meal("Chicken Adobo", 110.00, "M-01", true, 1);
        Pastry cookie = new Pastry("Cookie", 30.00, "P-02", false);

        // Default constructors are also demonstrated, then values are set.
        Beverage hotChocolate = new Beverage();
        hotChocolate.setName("Hot Chocolate");
        hotChocolate.setBasePrice(80.00);
        hotChocolate.setItemCode("B-02");
        hotChocolate.setSize("M");

        Pastry defaultPastry = new Pastry();
        defaultPastry.setName("Banana Bread");
        defaultPastry.setBasePrice(40.00);
        defaultPastry.setItemCode("P-03");

        Meal beefTapa = new Meal();
        beefTapa.setName("Beef Tapa");
        beefTapa.setBasePrice(130.00);
        beefTapa.setItemCode("M-02");
        beefTapa.setUpsized(false);
        beefTapa.setExtraSides(0);

        // Create the first order and add three menu items.
        Order order1 = new Order("1001", ana);
        order1.addItem(icedLatte);
        order1.addItem(ensaymada);
        order1.addItem(chickenAdobo);

        // This fourth item demonstrates the three-item order limit.
        order1.addItem(cookie);
        order1.computeTotal();
        order1.printReceipt();

        // Demonstrate setter validation by attempting a negative base price.
        hotChocolate.setBasePrice(-5.00);
        hotChocolate.setBasePrice(80.00);

        // Create the second order and apply a voucher.
        Order order2 = new Order("1002", ben);
        order2.addItem(hotChocolate);
        order2.addItem(beefTapa);
        order2.computeTotal(20.00);
        order2.printReceipt();

        // The default pastry is created and configured to demonstrate its constructor.
        // It is not added because the exercise limits each order to three items.
        System.out.println("Default pastry created: " + defaultPastry.getDescription());
    }
}
