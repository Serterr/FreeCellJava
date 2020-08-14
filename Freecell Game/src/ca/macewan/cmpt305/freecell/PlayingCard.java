package ca.macewan.cmpt305.freecell;

import java.util.Objects;

/**
 * Represents a playing card.
 */
public class PlayingCard {
    private final Suit suit;
    private final Rank rank;

    public PlayingCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;

    }

    @Override
    public String toString() {
        return rank.toString() + suit.toString();
    }

    /**
     * Compares the value of this card and another card.
     * @param card
     * @return the difference of this card's value and another card's value
     */
    public int compareValueTo(PlayingCard card) {
        if (card == null) throw new NullPointerException("card can't be null");
        int rank1 = this.rank.getValue();
        int rank2 = card.rank.getValue();
        return rank1 - rank2;
    }

    /**
     * Checks if the suit colour of this card is red.
     * @return true if the suit colour is red, false otherwise
     */
    public boolean isRed() {
        if (this.suit.toString().equals("\u2661") || this.suit.toString().equals("\u2662")) {
            return true;

        }
        else{
            return false;
        }
    }

    /**
     * Checks if the suit colour of this card is black.
     * @return true if the suit colour is black, false otherwise.
     */
    public boolean isBlack() {
        if (this.suit.toString().equals("\u2663") || this.suit.toString().equals("\u2660")){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Get the suit of this card.
     * @return the suit of this card
     */
    public Suit getSuit() {
        return this.suit;
    }

    /**
     * Get the rank of this card.
     * @return the rank of this card
     */
    public Rank getRank() {
        return this.rank;
    }

    /**
     * Checks if this card equals to another object.
     * @param o - object to check
     * @return true if this card equals to the given object, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if (!(o instanceof PlayingCard)){
            return false;
        }
        PlayingCard pc = (PlayingCard)o;
        return pc.rank == rank && pc.suit == suit;

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.suit);
        hash = 97 * hash + Objects.hashCode(this.rank);
        return hash;
    }
}
