import java.util.ArrayList;
import java.util.Random;

//import javax.smartcardio.Card; 
// TODO: rename Card to some other name

public class Deck {

	// Ordered deck as array, will be used for primitive shuffle
	private static int numbOfRanks = Rank.values().length;
	private static Card[][] arrayOfCards = new Card[4][numbOfRanks];
	static {
		for (Suit suits : Suit.values()) {
			//System.out.println(); //
			for (Rank ranks : Rank.values()) {
			//System.out.print(" "+suits+suits.ordinal()+" "+ranks+ranks.ordinal()+";"); 
				//this.arrayOfCards[suits.ordinal()][ranks.ordinal()] = new Card(Suit.values()[suits.ordinal()], Rank.values()[ranks.ordinal()]);
				//System.out.print(suits+" "+ranks+" ;" ); //
				arrayOfCards[suits.ordinal()][ranks.ordinal()] = new Card(suits, ranks);	
			}
		}
	}
	
	// Ordered deck as ArrayList, will be used for complex shuffle
	private static ArrayList<Card> arrayListOfCards = new ArrayList<Card>();
	static {
		for (Suit suits : Suit.values()) {
			for (Rank ranks : Rank.values()) {
				arrayListOfCards.add(new Card(suits, ranks));
			}
		}
	}
	
	// Print all the elements of complex deck to screen
	public static void printArrayListOfCards() {
		for (Card cards : arrayListOfCards) {
			System.out.println(cards.rank+" "+cards.suit);
		}
	}
	
	
	// Complex shuffle
	public static void ShuffleTheDeck() {
		Random random = new Random();
		int numberOfShuffles = random.nextInt(50);
		while(numberOfShuffles > 0) {
			System.out.println("*******"+numberOfShuffles+" Shuffles left*******"); 
			// take upper pile of a deck, number of cards is random
			int UpperPile = random.nextInt(36);
			System.out.println("Number of cards in taken big pile is "+UpperPile);
			
			while (UpperPile > 0) {
				// take some number of cards from upperPile and put them to the deck end
				int someOfUpperPile = random.nextInt(UpperPile+1);
				System.out.println("Now I put "+someOfUpperPile+" cards of big pile to the end of the deck");
				// Gonna replace following line with its code
				// Deck.putCardsToDeckEnd();
				
				// Takes cards from deck beginning and puts them to the deck end (used in complex shuffle)
				ArrayList<Card> bufferArrayListOfCards = new ArrayList<Card>(someOfUpperPile);
				// fill buffer with someOfUpperPile elements
				for (int i=0; i<someOfUpperPile; i++) {
					bufferArrayListOfCards.add(arrayListOfCards.get(i));
				}
				arrayListOfCards.removeAll(bufferArrayListOfCards);
				arrayListOfCards.addAll(bufferArrayListOfCards);
				UpperPile = UpperPile - someOfUpperPile;
				System.out.println("And there\'s "+UpperPile+" cards left");
			}
			numberOfShuffles--;
		}
	}
	
	// Takes cards from deck beginning and puts them to the deck end (used in complex shuffle)
/*	private static void putCardsToDeckEnd() {
		ArrayList<Card> bufferArrayListOfCards = new ArrayList<Card>(someOfUpperPile);
		// fill buffer with someOfUpperPile elements
		for (int i=0; i<someOfUpperPile; i++) {
			bufferArrayListOfCards.add(arrayListOfCards.get(i));
		}
		arrayListOfCards.removeAll(bufferArrayListOfCards);
		arrayListOfCards.addAll(bufferArrayListOfCards);
	}*/
	
	public static void ReturnFirstCard() {
		System.out.println(arrayOfCards[0][0].rank.toString());
		System.out.println(arrayOfCards[0][0].suit.toString());
	}
	
	public static void ReturnCardByIndex(int suitIndex, int rankIndex) {
		System.out.println(arrayOfCards[suitIndex][rankIndex].rank.toString());
		System.out.println(arrayOfCards[suitIndex][rankIndex].suit.toString());
	}

	
	

}
