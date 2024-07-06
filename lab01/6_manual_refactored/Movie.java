public class Movie extends DomainObject {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private final int priceCode;

    public Movie(String name, int priceCode) {
        super(name);
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public double calculateRentalAmount(int daysRented) {
        double amount = 0;
        switch (this.priceCode) {
            case REGULAR:
                amount += 2;
                if (daysRented > 2) {
                    amount += (daysRented - 2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                amount += daysRented * 3;
                break;
            case CHILDREN:
                amount += 1.5;
                if (daysRented > 3) {
                    amount += (daysRented - 3) * 1.5;
                }
                break;
        }
        return amount;
    }

    public int calculateFrequentRenterPoints(int daysRented) {
        if (priceCode == NEW_RELEASE && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }

    public void persist() {
        Registrar.add("Movies", this);
    }

    public static Movie get(String name) {
        return (Movie) Registrar.get("Movies", name);
    }
}