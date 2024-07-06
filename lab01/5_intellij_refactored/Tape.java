class Tape extends DomainObject {
    public Movie movie() {
        return _movie;
    }

    public Tape(String serialNumber, Movie movie) {
        _movie = movie;
    }

    private final Movie _movie;
}