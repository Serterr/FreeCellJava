package ca.macewan.cmpt305.freecell;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
/**
 * Represents a standard deck of 52 playing cards.
 */
public class Deck {
    private Deque<PlayingCard> deck = new ArrayDeque<>();
    private PlayingCard[] shufflearray = new PlayingCard[52];
    private PlayingCard tmpcard;
    public int counter = -1;

    /**
     * Construct a standard deck of 52 playing cards.
     *
     */
    public Deck() {
        // initialize cards with a standard deck of 52 cards
        //PlayingCard[] deck = new PlayingCard[52];
        for(Suit suit: Suit.values()){
            for(Rank rank : Rank.values()) {
                tmpcard = new PlayingCard(suit, rank);
                deck.push(tmpcard);
                        //= new PlayingCard(suit, rank);
            }
        }
    }

    /**
     * Shuffle this deck.
     * (Pop all of them into an array, randomize, then push back into the deck?)
     */
    public void shuffle() {
        Random rn = new Random();
        for(int i = 0; i < 51; i++){
            shufflearray[i] = deck.pop();
        }
        for(int i = 0; i < 51; i++){
            int j = rn.nextInt(51);
            PlayingCard tmp = this.shufflearray[j];
            this.shufflearray[j] = this.shufflearray[i];
            this.shufflearray[i] = tmp;

        }
        for(int i=0; i < 51; i++){
            PlayingCard tmp = this.shufflearray[i];
            deck.push(tmp);
        }

    }

    /**
     * Return the number of cards left in this deck.
     * @return number of cards left
     */
    public int size() {
        return this.deck.size();
    }

    /**
     * Return the top card in this deck.
     * @return top card
     */
    public PlayingCard deal() {
        //if (cards.isEmpty())
        if(deck.size() == 0)
            throw new IllegalStateException("Deck is empty.");
        ++counter;
        return deck.pop();
    }
}
