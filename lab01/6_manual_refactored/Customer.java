import java.util.ArrayList;
import java.util.List;

class Customer extends DomainObject {
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        super(name);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + name() + "\n");

        for (Rental rental : rentals) {
            double rentalAmount = rental.calculateAmount();
            frequentRenterPoints += rental.calculateFrequentRenterPoints();

            result.append("\t").append(rental.getTape().getMovie().name())
                    .append("\t").append(rentalAmount).append("\n");

            totalAmount += rentalAmount;
        }

        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public static Customer get(String name) {
        return (Customer) Registrar.get("Customers", name);
    }

    public void persist() {
        Registrar.add("Customers", this);
    }
}