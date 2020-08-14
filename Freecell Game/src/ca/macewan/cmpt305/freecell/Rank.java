package ca.macewan.cmpt305.freecell;

/**
 * A list of valid card ranks.
 */
public enum Rank {
    ACE("A", 1), TWO("2", 2), THREE("3", 3), FOUR("4", 4),
    FIVE("5", 5), SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8),
    NINE("9", 9), TEN("10", 10), JACK("J", 11), QUEEN("Q", 12),
    KING("K", 13);

    private final String rank;
    private final int value;

    Rank(String rank, int value) {
        this.rank = rank;
        this.value = value;

    }

    @Override
    public String toString() {
        return rank;
    }

    /**
     * Get the rank value
     * @return the rank value
     */
    public int getValue() {
        return value;
    }
}
