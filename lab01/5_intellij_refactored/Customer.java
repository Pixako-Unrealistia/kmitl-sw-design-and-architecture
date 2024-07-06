import java.util.Enumeration;
import java.util.Vector;

class Customer extends DomainObject {
    public Customer(String name) {
        _name = name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals;

        rentals = _rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + name() + "\n");
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = rentals.nextElement();

            // determine amounts for each line
            switch (each.tape().movie().priceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.daysRented() > 2)
                        thisAmount += (each.daysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.daysRented() * 3;
                    break;
                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if (each.daysRented() > 3)
                        thisAmount += (each.daysRented() - 3) * 1.5;
                    break;
            }

            totalAmount += thisAmount;

            // add frequent renter points
            frequentRenterPoints++;

            // add bonus for a two-day new release rental
            if ((each.tape().movie().priceCode() == Movie.NEW_RELEASE) && each.daysRented() > 1)
                frequentRenterPoints++;

            // show figures for this rental
            result.append("\t").append(each.tape().movie().name()).append("\t").append(thisAmount).append("\n");
        }

        // add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public static Customer get(String name) {
        return (Customer) Registrar.get("Customers", name);
    }

    public void persist() {
        Registrar.add("Customers", this);
    }

    private final Vector<Rental> _rentals = new Vector<>();
}