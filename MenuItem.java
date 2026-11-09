public abstract class MenuItem {
    protected String name;
    protected double basePrice;
    private String itemCode;

    /** 
     * Creates an unnamed menu item with default values.
     */
    public MenuItem() {
        this.name = "Unnamed Item";
        this.basePrice = 0.0;
        this.itemCode = "N/A";
    }

    /**
     * Creates a menu item with the supplied details.
     *
     * @param name the item name
     * @param basePrice the starting price
     * @param itemCode the item's code
     */
    public MenuItem(String name, double basePrice, String itemCode) {
        this();
        setName(name);
        setBasePrice(basePrice);
        setItemCode(itemCode);
    }

    /**
     * Computes the final price of the menu item.
     *
     * @return the computed item price
     */
    public abstract double computePrice();

    /**
     * Returns the basic description of this item.
     *
     * @return the item name and item code
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /**
     * Gets the item name.
     *
     * @return the item name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the item name when the value is not blank.
     *
     * @param name the new item name
     */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: item name cannot be blank.");
        }
    }

    /**
     * Gets the base price.
     *
     * @return the base price
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the base price and rejects negative values.
     *
     * @param basePrice the new base price
     */
    public void setBasePrice(double basePrice) {
        // A menu item cannot have a negative base price.
        if (basePrice >= 0) {
            this.basePrice = basePrice;
        } else {
            System.out.println("Error: base price cannot be negative.");
        }
    }

    /**
     * Gets the item code.
     *
     * @return the item code
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * Sets the item code when the value is not blank.
     *
     * @param itemCode the new item code
     */
    public void setItemCode(String itemCode) {
        if (itemCode != null && !itemCode.trim().isEmpty()) {
            this.itemCode = itemCode;
        } else {
            System.out.println("Error: item code cannot be blank.");
        }
    }
}
