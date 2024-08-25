import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Person {
    private String name;
    private int ticketNumber;

    public Person(String name) {
        this.name = name;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getName() {
        return name;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }
}

public class ConcertLineProgram {
    public static void main(String[] args) {
        // Create a Queue to represent the concert line
        Queue<Person> line = new LinkedList<>();

        // Create an ArrayList to store ticket numbers
        ArrayList<Integer> ticketNumbers = new ArrayList<>();

        // Populate the ArrayList with 7 random ticket numbers
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            int ticketNumber = random.nextInt(1000); // Assuming ticket numbers are integers
            ticketNumbers.add(ticketNumber);
        }

        // Create 7 people and add them randomly to the line
        String[] names = {"Sarah", "Matt", "Xion", "Lizzy", "Jose", "Alex", "Ruby"};
        for (String name : names) {
            Person person = new Person(name);
            line.add(person);
        }

        // Dequeue people from the line, assign ticket numbers, and print their information
        while (!line.isEmpty()) {
            Person person = line.poll();
            int randomIndex = random.nextInt(ticketNumbers.size());
            int assignedTicketNumber = ticketNumbers.get(randomIndex);
            person.setTicketNumber(assignedTicketNumber);
            ticketNumbers.remove(randomIndex); // Ensure no duplicate ticket numbers
            System.out.println(person.getName() + " got ticket number " + person.getTicketNumber());
        }
    }
}
