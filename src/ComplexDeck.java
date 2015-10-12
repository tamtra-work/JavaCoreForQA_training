import java.util.ArrayList;
import java.util.Random;

public class ComplexDeck {
	
	private static int numbOfRanks = Rank.values().length;
	private static int numbOfSuits = Suit.values().length;
	private static int numbOfCards = numbOfRanks*numbOfSuits;
	private static Random random = new Random();
	private static ArrayList<Card> arrayListOfCards = new ArrayList<Card>();
	static {
		for (Suit suits : Suit.values()) {
			for (Rank ranks : Rank.values()) {
				arrayListOfCards.add(new Card(suits, ranks));
			}
		}
	}
	
	// Resets deck to its initial sorted state
	public static void resetDeck() {
		for (Suit suits : Suit.values()) {
			for (Rank ranks : Rank.values()) {
				arrayListOfCards.add(new Card(suits, ranks));				
			}
		}
	}
	
	public static void printDeck() {
		for (Card cards : arrayListOfCards) {
			System.out.print(cards.rank+" "+cards.suit+"; ");
		}
		System.out.println("");
		System.out.println("");
	}
	
	public static void Shuffle() {
		int numberOfShuffles = random.nextInt(100);
		while(numberOfShuffles > 0) {
			// take upper pile of a deck, number of cards is random
			int upperPile = random.nextInt(numbOfCards);
			// take some number of cards from upperPile's end and put them to the deck end;
			// repeat until there's no cards left in upperPile
			while (upperPile > 0) {
				int someOfUpperPile = random.nextInt(upperPile+1);
				ArrayList<Card> bufferArrayListOfCards = new ArrayList<Card>();
				for (int i=(upperPile-someOfUpperPile); i<upperPile; i++) {
					bufferArrayListOfCards.add(arrayListOfCards.get(i));
				}
				arrayListOfCards.removeAll(bufferArrayListOfCards); 
				arrayListOfCards.addAll(bufferArrayListOfCards);
				arrayListOfCards.trimToSize();
				upperPile = upperPile - someOfUpperPile;
			}
			numberOfShuffles--;
		}
	}
	
	// This is the same method as Shuffle(), just with additional messaging
	// Messaging was used to better understand what I was writing :)
	public static void ShuffleWithDebugMsg() {
		System.out.println("### Printing source deck... ###");
		ComplexDeck.printDeck();
		
		Random random = new Random();
		int numberOfShuffles = random.nextInt(100);
		while(numberOfShuffles > 0) {
			System.out.println("*******"+numberOfShuffles+" Shuffles left*******"); 
			// take upper pile of a deck, number of cards is random
			int upperPile = random.nextInt(36);
			System.out.println("Number of cards in taken big pile is "+upperPile);
			
			// take some number of cards from upperPile's end and put them to the deck end;
			// repeat until there's no cards left in upperPile
			while (upperPile > 0) {
				int someOfUpperPile = random.nextInt(upperPile+1);
				System.out.println("Now I put "+someOfUpperPile+" cards of big pile to the end of the deck");
				ArrayList<Card> bufferArrayListOfCards = new ArrayList<Card>();
				for (int i=(upperPile-someOfUpperPile); i<upperPile; i++) {
					bufferArrayListOfCards.add(arrayListOfCards.get(i));
				}
				arrayListOfCards.removeAll(bufferArrayListOfCards);
				arrayListOfCards.addAll(bufferArrayListOfCards);
				arrayListOfCards.trimToSize();
				upperPile = upperPile - someOfUpperPile;
				
				System.out.println("And there\'s "+upperPile+" cards left");
			}
			numberOfShuffles--;
			
			System.out.println("### Printing the whole deck... ###");
			ComplexDeck.printDeck();
		}
	}
	
	public static void giveOneCard() {
		int indexToReturn;
		Card cardToReturn;
		
		if(arrayListOfCards.isEmpty()) {
			System.out.println("No cards left in deck. Reset the deck");
		}
		else {
			indexToReturn = random.nextInt(arrayListOfCards.size());
			cardToReturn = arrayListOfCards.get(indexToReturn);
			System.out.println("Returned card is "+cardToReturn.suit+" "+cardToReturn.rank);
			arrayListOfCards.remove(indexToReturn);
			}
		}
	
				
}
