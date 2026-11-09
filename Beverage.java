public class Beverage extends MenuItem {
    private String size;

    /**
     * Creates a small beverage with default menu item values.
     */
    public Beverage() {
        super();
        this.size = "S";
    }

    /**
     * Creates a beverage with the supplied details.
     *
     * @param name the beverage name
     * @param basePrice the starting price
     * @param itemCode the item code
     * @param size the beverage size: S, M, or L
     */
    public Beverage(String name, double basePrice, String itemCode, String size) {
        super(name, basePrice, itemCode);
        this.size = "S";
        setSize(size);
    }

    /**
     * Computes the beverage price based on its size.
     *
     * @return the final beverage price
     */
    @Override
    public double computePrice() {
        // Large adds 25 pesos; medium adds 15 pesos; small has no extra fee.
        if (size.equals("L")) {
            return basePrice + 25;
        } else if (size.equals("M")) {
            return basePrice + 15;
        } else {
            return basePrice;
        }
    }

    /**
     * Returns the beverage description, including its size.
     *
     * @return the description with size
     */
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    /**
     * Gets the beverage size.
     *
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the size only when it is S, M, or L.
     *
     * @param size the new beverage size
     */
    public void setSize(String size) {
        if (size != null && (size.equals("S") || size.equals("M") || size.equals("L"))) {
            this.size = size;
        } else {
            System.out.println("Error: size must be S, M, or L.");
        }
    }
}
