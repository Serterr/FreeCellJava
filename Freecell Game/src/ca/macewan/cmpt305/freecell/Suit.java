package ca.macewan.cmpt305.freecell;

/**
 * A list of valid card suites.
 */
public enum Suit {
    CLUB("\u2663"),
    DIAMOND("\u2662"),
    HEART("\u2661"),
    SPADE("\u2660");

    private final String suit;

    Suit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return suit;
    }
}
