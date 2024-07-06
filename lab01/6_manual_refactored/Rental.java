class Rental extends DomainObject {
    private final Tape tape;
    private final int daysRented;

    public Rental(Tape tape, int daysRented) {
        this.tape = tape;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Tape getTape() {
        return tape;
    }

    public double calculateAmount() {
        return tape.getMovie().calculateRentalAmount(daysRented);
    }

    public int calculateFrequentRenterPoints() {
        return tape.getMovie().calculateFrequentRenterPoints(daysRented);
    }
}