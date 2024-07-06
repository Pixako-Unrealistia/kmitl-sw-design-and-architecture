class Rental extends DomainObject {
    public int daysRented() {
        return _daysRented;
    }

    public Tape tape() {
        return _tape;
    }

    public Rental(Tape tape, int daysRented) {
        _tape = tape;
        _daysRented = daysRented;
    }

    private final Tape _tape;
    private final int _daysRented;
}