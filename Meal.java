public class Meal extends MenuItem {
    private boolean upsized;
    private int extraSides;

    /**
     * Creates a regular meal with no extra sides.
     */
    public Meal() {
        super();
        this.upsized = false;
        this.extraSides = 0;
    }

    /**
     * Creates a meal with the supplied details.
     *
     * @param name the meal name
     * @param basePrice the starting price
     * @param itemCode the item code
     * @param upsized whether the meal is upsized
     * @param extraSides the number of extra sides
     */
    public Meal(String name, double basePrice, String itemCode,
                boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        this.extraSides = 0;
        setExtraSides(extraSides);
    }

    /**
     * Computes the meal price, including upsize and extra-side fees.
     *
     * @return the final meal price
     */
    @Override
    public double computePrice() {
        double price = basePrice;
        // Upsizing adds 20 pesos.
        if (upsized) {
            price += 20;
        }
        price += 12 * extraSides;
        return price;
    }

    /**
     * Returns the meal description with its options.
     *
     * @return the meal description
     */
    @Override
    public String getDescription() {
        String status;
        if (upsized) {
            status = "Upsized";
        } else {
            status = "Regular";
        }
        return super.getDescription() + " " + status + ", " + extraSides + " sides";
    }

    /**
     * Checks whether the meal is upsized.
     *
     * @return true if upsized; otherwise false
     */
    public boolean isUpsized() {
        return upsized;
    }

    /**
     * Sets the upsize status.
     *
     * @param upsized the new upsize status
     */
    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    /**
     * Gets the number of extra sides.
     *
     * @return the number of extra sides
     */
    public int getExtraSides() {
        return extraSides;
    }

    /**
     * Sets the number of extra sides and rejects negative values.
     *
     * @param extraSides the new number of extra sides
     */
    public void setExtraSides(int extraSides) {
        // Extra sides must be zero or a positive number.
        if (extraSides >= 0) {
            this.extraSides = extraSides;
        } else {
            System.out.println("Error: extra sides cannot be negative.");
        }
    }
}
