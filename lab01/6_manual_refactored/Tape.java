class Tape extends DomainObject {
    private final Movie movie;

    public Tape(String serialNumber, Movie movie) {
        super(serialNumber);
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }
}