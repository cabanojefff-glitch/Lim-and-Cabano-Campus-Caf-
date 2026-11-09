public class Pastry extends MenuItem {
    private boolean warmed;

    /**
     * Creates a pastry that is not warmed.
     */
    public Pastry() {
        super();
        this.warmed = false;
    }

    /**
     * Creates a pastry with the supplied details.
     *
     * @param name the pastry name
     * @param basePrice the starting price
     * @param itemCode the item code
     * @param warmed whether the pastry is warmed
     */
    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    /**
     * Computes the pastry price, adding a warming fee when needed.
     *
     * @return the final pastry price
     */
    @Override
    public double computePrice() {
        double price = basePrice;
        // Warming adds a fixed fee of 10 pesos.
        if (warmed) {
            price += 10;
        }
        return price;
    }

    /**
     * Returns the pastry description and warming status.
     *
     * @return the pastry description
     */
    @Override
    public String getDescription() {
        if (warmed) {
            return super.getDescription() + " (Warmed)";
        }
        return super.getDescription();
    }

    /**
     * Checks whether the pastry is warmed.
     *
     * @return true if warmed; otherwise false
     */
    public boolean isWarmed() {
        return warmed;
    }

    /**
     * Sets whether the pastry is warmed.
     *
     * @param warmed the warming status
     */
    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}
