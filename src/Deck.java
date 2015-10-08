
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
