package ca.macewan.cmpt305.freecell;

import java.util.Deque;

/**
 * Represents a pile of cards.
 */
public interface Pile {
    /**
     * Returns the number of cards in this pile.
     * @return the number of cards.
     */
    int size();

    /**
     * Checks if a pop operation is valid.
     * @return  true if this pile can return the top card;
     *          false otherwise.
     */
    boolean canPop();

    /**
     * Returns  the top card of this pile.
     * @return  the top card if valid;
     *          throws IllegalStateException otherwise.
     */
    PlayingCard pop();

    /**
     * Checks if a push operation is valid.
     * @param card - the card to push onto the top of this pile.
     * @return  true if the card can be pushed onto the top of this pile;
     *          false otherwise.
     */
    boolean canPush(PlayingCard card);

    /**
     * Pushes the given card onto the top of this pile.
     * @param   card - the card to be pushed onto the top of this pile;
     *          throws IllegalStateException if push is invalid.
     */
    void push(PlayingCard card);

    /**
     * Peeks the top card of this pile.
     * @return the top card
     */
    PlayingCard peek();

    /**
     * Returns the contents of this pile.
     * @return stack of cards
     */
    Deque<PlayingCard> getCards();
}

