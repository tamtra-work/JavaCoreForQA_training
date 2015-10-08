import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ComplexDeck {
	
		private static ArrayList<Card> arrayListOfCards = new ArrayList<Card>();
		static {
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
		
		public static void ShuffleTheDeck() {
			System.out.println("### Printing source deck... ###");
			ComplexDeck.printDeck();
			
			Random random = new Random();
			int numberOfShuffles = random.nextInt(50);
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
					
					// Takes cards from deck beginning and puts them to the deck end
					ArrayList<Card> bufferArrayListOfCards = new ArrayList<Card>();
					// fill buffer with someOfUpperPile cards
					for (int i=(upperPile-someOfUpperPile); i<upperPile; i++) {
						bufferArrayListOfCards.add(arrayListOfCards.get(i));
					}
					ComplexDeck.arrayListOfCards.removeAll(bufferArrayListOfCards);
					ComplexDeck.arrayListOfCards.removeAll(Collections.singleton(null));
					ComplexDeck.arrayListOfCards.addAll(bufferArrayListOfCards);
					upperPile = upperPile - someOfUpperPile;
					
					System.out.println("And there\'s "+upperPile+" cards left");
				}
				numberOfShuffles--;
				
				System.out.println("### Printing the whole deck... ###");
				ComplexDeck.printDeck();
			}
		}

}
