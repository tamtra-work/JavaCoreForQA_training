import java.util.Random;

public class Deck {

	// Ordered deck
	private static int numbOfRanks = Rank.values().length;
	private static Card arrayOfCards[][] = new Card[4][numbOfRanks];
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
				int someOfUpperPile= random.nextInt(UpperPile)+1;
				System.out.println("Now I put "+someOfUpperPile+" cards of big pile to the end of the deck");
				UpperPile = UpperPile - someOfUpperPile;
				System.out.println("And there\'s "+UpperPile+" cards left");
			}
			numberOfShuffles--;
		}
	}
	// TODO
	private void swapCards() {
		
		
	}
	public static void ReturnFirstCard() {
		System.out.println(arrayOfCards[0][0].rank.toString());
		System.out.println(arrayOfCards[0][0].suit.toString());
	}
	
	public static void ReturnCardByIndex(int suitIndex, int rankIndex) {
		System.out.println(arrayOfCards[suitIndex][rankIndex].rank.toString());
		System.out.println(arrayOfCards[suitIndex][rankIndex].suit.toString());
	}

	
	

}
