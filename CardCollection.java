import java.util.*;

class Card {
    String symbol;
    String name;
    
    Card(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }
    
    public String toString() {
        return "Card: " + name + " [Symbol: " + symbol + "]";
    }
}

public class CardCollection {
    static Collection<Card> cards = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Card 2. Display Cards 3. Search by Symbol 4. Exit");
            switch (scanner.nextInt()) {
                case 1 -> addCard();
                case 2 -> displayCards();
                case 3 -> searchBySymbol();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }
    
    static void addCard() {
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Symbol: ");
        String symbol = scanner.nextLine();
        System.out.print("Enter Card Name: ");
        String name = scanner.nextLine();
        cards.add(new Card(symbol, name));
    }
    
    static void displayCards() {
        if (cards.isEmpty()) System.out.println("No cards found.");
        else cards.forEach(System.out::println);
    }
    
    static void searchBySymbol() {
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Symbol to search: ");
        String symbol = scanner.nextLine();
        cards.stream().filter(c -> c.symbol.equalsIgnoreCase(symbol))
             .forEach(System.out::println);
    }
}
