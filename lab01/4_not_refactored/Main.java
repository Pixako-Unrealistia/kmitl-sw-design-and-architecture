public class Main {
    public static void main(String[] args) {
        // 1. Create movies
        Movie movie1 = new Movie("The Matrix", Movie.REGULAR);
        Movie movie2 = new Movie("Frozen", Movie.CHILDRENS);
        Movie movie3 = new Movie("Inception", Movie.NEW_RELEASE);

        // Persist movies
        movie1.persist();
        movie2.persist();
        movie3.persist();

        // Retrieve a movie
        Movie retrievedMovie = Movie.get("The Matrix");
        System.out.println("Retrieved Movie: " + retrievedMovie.name()); // Should print "The Matrix"

        // 2. Create tapes associated with movies
        Tape tape1 = new Tape("12345", retrievedMovie);
        Tape tape2 = new Tape("67890", movie2);

        // 3. Create rentals
        Rental rental1 = new Rental(tape1, 3); // Renting tape1 for 3 days
        Rental rental2 = new Rental(tape2, 5); // Renting tape2 for 5 days

        // 4. Create a customer and add rentals
        Customer customer = new Customer("John Doe");
        customer.addRental(rental1);
        customer.addRental(rental2);

        // Persist the customer
        customer.persist();

        // 5. Generate and print the rental statement for the customer
        System.out.println(customer.statement());
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