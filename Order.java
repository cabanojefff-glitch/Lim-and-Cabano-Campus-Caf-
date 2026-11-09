public class Order {
    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;
    private double lastVoucher;
    private boolean pointsAwarded;

    /**
     * Creates an order for the specified customer.
     *
     * @param orderId the order identification number
     * @param customer the customer placing the order
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.itemCount = 0;
        this.lastVoucher = 0.0;
        this.pointsAwarded = false;
    }

    /**
     * Adds an item to the first available item field.
     *
     * @param item the menu item to add
     * @return true if added; otherwise false
     */
    public boolean addItem(MenuItem item) {
        if (item == null) {
            System.out.println("Cannot add an empty item.");
            return false;
        } else if (itemCount == 0) {
            item1 = item;
        } else if (itemCount == 1) {
            item2 = item;
        } else if (itemCount == 2) {
            item3 = item;
        } else {
            System.out.println("Order is full. Cannot add " + item.getDescription() + ".");
            return false;
        }
        itemCount++;
        return true;
    }

    /**
     * Computes the subtotal of all items in this order.
     *
     * @return the subtotal
     */
    public double computeSubtotal() {
        double subtotal = 0.0;
        if (item1 != null) {
            subtotal += item1.computePrice();
        }
        if (item2 != null) {
            subtotal += item2.computePrice();
        }
        if (item3 != null) {
            subtotal += item3.computePrice();
        }
        return subtotal;
    }

    /**
     * Computes the total after applying the student discount, if applicable.
     *
     * @return the total after discount
     */
    public double computeTotal() {
        lastVoucher = 0.0;
        double subtotal = computeSubtotal();
        double discount = 0.0;

        // Student customers receive a 10 percent discount.
        if (customer.isStudent()) {
            discount = subtotal * 0.10;
        } else {
            discount = 0.0;
        }
        return subtotal - discount;
    }

    /**
     * Computes the total after student discount and voucher deduction.
     *
     * @param voucher the voucher amount to subtract
     * @return the final total, never below zero
     */
    public double computeTotal(double voucher) {
        double subtotal = computeSubtotal();
        double discount = 0.0;

        // Apply the student discount before subtracting the voucher.
        if (customer.isStudent()) {
            discount = subtotal * 0.10;
        }
        if (voucher < 0) {
            System.out.println("Error: voucher cannot be negative.");
            voucher = 0.0;
        }
        lastVoucher = voucher;
        double total = subtotal - discount - voucher;

        // The customer should never be charged a negative total.
        if (total < 0) {
            total = 0.0;
        }
        return total;
    }

    /**
     * Prints the receipt and awards loyalty points once.
     */
    public void printReceipt() {
        double subtotal = computeSubtotal();
        double discount = 0.0;
        if (customer.isStudent()) {
            discount = subtotal * 0.10;
        }

        double total = subtotal - discount - lastVoucher;
        if (total < 0) {
            total = 0.0;
        }

        System.out.println("Order #" + orderId + " — " + customer.getName()
                + (customer.isStudent() ? " (Student)" : ""));
        printItem(item1);
        printItem(item2);
        printItem(item3);
        System.out.printf("  Subtotal: %.2f%n", subtotal);
        if (customer.isStudent()) {
            System.out.printf("  Student discount (10%%): -%.2f%n", discount);
        }
        if (lastVoucher > 0) {
            System.out.printf("  Voucher: -%.2f%n", lastVoucher);
        }
        System.out.printf("  TOTAL: %.2f%n", total);

        // Award points only once, using the final amount actually paid.
        if (!pointsAwarded) {
            customer.addPoints(total);
            pointsAwarded = true;
        }
        System.out.println("  Loyalty points: " + customer.getLoyaltyPoints());
        System.out.println();
    }

    /**
     * Prints one item line when the item exists.
     *
     * @param item the item to display
     */
    private void printItem(MenuItem item) {
        if (item != null) {
            System.out.printf("  %-42s %.2f%n", item.getDescription(), item.computePrice());
        }
    }

    /**
     * Gets the customer associated with this order.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Gets the order identification number.
     *
     * @return the order ID
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Gets the number of items in this order.
     *
     * @return the item count
     */
    public int getItemCount() {
        return itemCount;
    }
}
