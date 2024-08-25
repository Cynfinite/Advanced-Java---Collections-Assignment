import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

class Card {
    String rank;
    String suit;

    Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

public class StackProgram {
    public static void main(String[] args) {
        String[] ranks = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Heart", "Spade", "Diamond", "Clubs"};

        // Create a deck of cards
        Card[] deck = new Card[14 * 4];
        int index = 0;
        for (String rank : ranks) {
            for (String suit : suits) {
                deck[index++] = new Card(rank, suit);
            }
        }

        // Create a stack
        Stack<Card> cardStack = new Stack<>();

        // Randomly pick a card from the deck and push onto the stack 5 times
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(deck.length);
            Card pickedCard = deck[randomIndex];
            cardStack.push(pickedCard);
        }

        // Take cards off the top of the stack (pop) and reveal the values
        System.out.println("Revealing card values from the stack:");
        while (!cardStack.isEmpty()) {
            Card revealedCard = cardStack.pop();
            System.out.println(revealedCard);
        }
    }
}
