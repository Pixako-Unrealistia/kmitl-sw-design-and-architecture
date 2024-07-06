public class Main {
    public static void main(String[] args) {
        // Create movies
        Movie movie1 = new Movie("The Matrix", Movie.REGULAR);
        Movie movie2 = new Movie("Frozen", Movie.CHILDREN);
        Movie movie3 = new Movie("Inception", Movie.NEW_RELEASE);

        // Persist movies
        movie1.persist();
        movie2.persist();
        movie3.persist();

        // Retrieve a movie
        Movie retrievedMovie = Movie.get("The Matrix");
        System.out.println("Retrieved Movie: " + retrievedMovie.name());

        // Create and retrieve customer
        Customer customer = getCustomer(retrievedMovie, movie2);

        // Generate and print the rental statement for the customer
        System.out.println(customer.statement());
    }

    private static Customer getCustomer(Movie retrievedMovie, Movie movie2) {
        Tape tape1 = new Tape("12345", retrievedMovie);
        Tape tape2 = new Tape("67890", movie2);

        // Create rentals
        Rental rental1 = new Rental(tape1, 3); // Renting tape1 for 3 days
        Rental rental2 = new Rental(tape2, 5); // Renting tape2 for 5 days

        // Create a customer and add rentals
        Customer customer = new Customer("John Doe");
        customer.addRental(rental1);
        customer.addRental(rental2);

        // Persist the customer
        customer.persist();

        return customer;
    }
}

/* Output

Retrieved Movie: The Matrix
Rental Record for John Doe
	The Matrix	3.5
	Frozen	4.5
Amount owed is 8.0
You earned 2 frequent renter points

*/