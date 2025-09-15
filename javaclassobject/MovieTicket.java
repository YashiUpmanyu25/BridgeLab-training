public class MovieTicket {
    private String movieName;
    private String seatNumber;
    private double price;
    private boolean isBooked;
    
    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.isBooked = false;
        this.seatNumber = "Not assigned";
        this.price = 0.0;
    }
    
    public void bookTicket(String seatNumber, double price) {
        if (!isBooked) {
            this.seatNumber = seatNumber;
            this.price = price;
            this.isBooked = true;
            System.out.println("Ticket booked successfully for " + movieName);
        } else {
            System.out.println("Ticket already booked for " + movieName);
        }
    }
    
    public void cancelTicket() {
        if (isBooked) {
            this.isBooked = false;
            this.seatNumber = "Not assigned";
            this.price = 0.0;
            System.out.println("Ticket cancelled successfully for " + movieName);
        } else {
            System.out.println("No ticket to cancel for " + movieName);
        }
    }
    
    public void displayTicketDetails() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
        System.out.println("Status: " + (isBooked ? "Booked" : "Available"));
    }
    
    public static void main(String[] args) {
        MovieTicket ticket1 = new MovieTicket("Avengers: Endgame");
        MovieTicket ticket2 = new MovieTicket("The Dark Knight");
        
        ticket1.displayTicketDetails();
        System.out.println();
        
        ticket1.bookTicket("A12", 350.0);
        System.out.println();
        
        ticket1.displayTicketDetails();
        System.out.println();
        
        ticket2.bookTicket("B7", 300.0);
        System.out.println();
        
        ticket2.displayTicketDetails();
        System.out.println();
        
        ticket1.cancelTicket();
        System.out.println();
        
        ticket1.displayTicketDetails();
    }
}