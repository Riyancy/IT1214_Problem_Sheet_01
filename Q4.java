import java.util.*;

class Ticket {
    private int ticketNumber;
    private String customerName;
    private int seatNumber;
    
    public Ticket(int ticketNumber, String customerName, int seatNumber) {
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
    }
    
    public int getTicketNumber() {
        return ticketNumber;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public int getSeatNumber() {
        return seatNumber;
    }
}

class BookingSystem {
    private Ticket[] tickets;
    private boolean[] seats;
    private int count;
    private int nextTicketNumber;
    
    public BookingSystem() {
        tickets = new Ticket[10];
        seats = new boolean[10]; 
        count = 0;
        nextTicketNumber = 1;
    }
    
    public void bookTicket(String customerName, int seatNumber) {
        if (count >= tickets.length) {
            System.out.println("All seats are booked.");
            return;
        }
        
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number. Please choose between 1-10.");
            return;
        }
        
        if (seats[seatNumber - 1]) {
            System.out.println("Seat " + seatNumber + " is already booked.");
            return;
        }
        
        Ticket newTicket = new Ticket(nextTicketNumber++, customerName, seatNumber);
        tickets[count++] = newTicket;
        seats[seatNumber - 1] = true;
        System.out.println("Ticket booked successfully. Ticket Number: " + newTicket.getTicketNumber());
    }
    
    public void cancelTicket(int ticketNumber) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (tickets[i].getTicketNumber() == ticketNumber) {
                
                seats[tickets[i].getSeatNumber() - 1] = false;
                
                
                for (int j = i; j < count - 1; j++) {
                    tickets[j] = tickets[j + 1];
                }
                tickets[--count] = null;
                found = true;
                System.out.println("Ticket Number " + ticketNumber + " has been cancelled.");
                break;
            }
        }
        if (!found) {
            System.out.println("Ticket Number " + ticketNumber + " not found.");
        }
    }
    
    public void displayAvailableSeats() {
        System.out.println("\nAvailable Seats:");
        for (int i = 0; i < seats.length; i++) {
            if (!seats[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }
    
    public void displayAllBookings() {
        if (count == 0) {
            System.out.println("No tickets have been booked yet.");
            return;
        }
        
        System.out.println("\nCurrent Bookings:");
        System.out.println("------------------------------------------------");
        System.out.printf("%-15s %-20s %-15s%n", "Ticket Number", "Customer Name", "Seat Number");
        System.out.println("------------------------------------------------");
        
        for (int i = 0; i < count; i++) {
            System.out.printf("%-15d %-20s %-15d%n",
                tickets[i].getTicketNumber(),
                tickets[i].getCustomerName(),
                tickets[i].getSeatNumber());
        }
        System.out.println("------------------------------------------------");
        System.out.println("Total bookings: " + count + "/10");
    }
}

class Main {
    public static void main(String[] args) {
        BookingSystem bs = new BookingSystem();
        
       
        bs.bookTicket("John", 1);
        bs.bookTicket("Boe", 2);
        bs.bookTicket("Alice", 3);
        
       
        bs.bookTicket("Bob", 2);
        bs.bookTicket("Charlie", 15);
        bs.displayAvailableSeats();
        bs.displayAllBookings();
        bs.cancelTicket(2);
        bs.cancelTicket(99);
        bs.displayAllBookings();
        bs.bookTicket("Diana", 2);
         bs.displayAllBookings();
	}
}
        
        
        
        
        
        
        
       
       
 