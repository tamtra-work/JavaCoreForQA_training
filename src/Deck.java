import java.util.Random;

public class Deck {

	private static int numbOfRanks = Rank.values().length;
	private static int numbOfSuits = Suit.values().length;
	private static int numbOfCardsLeft = numbOfRanks*numbOfSuits;
	private static Random random = new Random();
	private static Card[][] arrayOfCards = new Card[numbOfSuits][numbOfRanks];
	static {
		for (Suit suits : Suit.values()) {
			for (Rank ranks : Rank.values()) {
				arrayOfCards[suits.ordinal()][ranks.ordinal()] = new Card(suits, ranks);	
			}
		}
	}
	
	public static void resetDeck() {
		numbOfCardsLeft = numbOfRanks*numbOfSuits;
		for (Suit suits : Suit.values()) {
			for (Rank ranks : Rank.values()) {
				arrayOfCards[suits.ordinal()][ranks.ordinal()] = new Card(suits, ranks);	
			}
		}
	}
	
	public static void printDeck() {
		for (int i=0; i<numbOfSuits; i++) {
			for (int j=0; j<numbOfRanks; j++) {
				System.out.print(arrayOfCards[i][j].rank+" "+arrayOfCards[i][j].suit+"; ");
			}
			System.out.println(); 
		}
		System.out.println(); 
	}
	
	public static void Shuffle() {
		int numberOfShuffles = random.nextInt(100);
		while(numberOfShuffles > 0) {
			int indexFrom1 = random.nextInt(numbOfSuits);
			int indexFrom2 = random.nextInt(numbOfRanks);
			int indexTo1 = random.nextInt(numbOfSuits);
			int indexTo2 = random.nextInt(numbOfRanks);
			Card bufferCard = arrayOfCards[indexFrom1][indexFrom2];
			arrayOfCards[indexFrom1][indexFrom2] = arrayOfCards[indexTo1][indexTo2];
			arrayOfCards[indexTo1][indexTo2] = bufferCard;
			numberOfShuffles--;
		}
	}
	
	public static void giveOneCard() {
		int indexInSuits;
		int indexInRanks;
		boolean cardWasReturned = false;
		
		if(numbOfCardsLeft==0) {
			System.out.println("No cards left in deck. Reset the deck");
		}
		else {
			while (!cardWasReturned){
				indexInSuits = random.nextInt(numbOfSuits);
				indexInRanks = random.nextInt(numbOfRanks);
				Card cardToReturn = arrayOfCards[indexInSuits][indexInRanks];
				if (arrayOfCards[indexInSuits][indexInRanks]!=null) {
					System.out.println("Returned card is "+cardToReturn.suit+" "+cardToReturn.rank);
					System.out.println(numbOfCardsLeft+" card left in deck");
					arrayOfCards[indexInSuits][indexInRanks]=null;
					numbOfCardsLeft--;
					cardWasReturned = true;
				}
			}
		}
	}
}
