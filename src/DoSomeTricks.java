
public class DoSomeTricks {

	public static void main(String[] args) {
	
		// Simple shuffle
		System.out.println("*** Source deck ***");
		Deck.printDeck();
		Deck.Shuffle();
		System.out.println("*** Shuffled deck ***");
		Deck.printDeck();
		
		// Complex shuffle
		System.out.println("*** Source complex deck ***");
		ComplexDeck.printDeck();
		ComplexDeck.Shuffle();
		System.out.println("*** Shuffled complex deck ***");
		ComplexDeck.printDeck();
		
		// Return card from deck
		System.out.println("*** Returning several cards from deck ***");
		Deck.giveOneCard();
		Deck.giveOneCard();
		
		// Return card from complex deck		
		System.out.println("*** Returning several cards from complex deck ***");
		ComplexDeck.giveOneCard();
		ComplexDeck.giveOneCard();

	}
	
}
