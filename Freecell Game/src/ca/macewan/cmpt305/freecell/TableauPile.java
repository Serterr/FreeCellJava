package ca.macewan.cmpt305.freecell;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Deque;
import java.util.*;
/**
 * Represents a tableau pile.
 */
public class TableauPile implements Pile {
    private Deque<PlayingCard> tableau = new ArrayDeque<>();

    public int size() {
        return this.tableau.size();
    }

    public boolean canPop() {
        if(this.tableau.size()>0){
            return true;
        }
        throw new IllegalStateException("Cannot take from an empty pile");
    }

    public PlayingCard pop() {
        return this.tableau.removeLast();
    }

    public boolean canPush(PlayingCard card) {
        if (tableau.size() == 0)
            return true;
        else if (tableau.peekLast().compareValueTo(card) == 1) {
            if (card.isBlack()) {
                if (tableau.peekLast().isRed()) {
                    return true;
                }
            } else if (card.isRed()) {
                if (tableau.peekLast().isBlack()) {
                    return true;
                }
            }
        }
        return false;
    }
    public void push(PlayingCard card) {
        if(this.canPush(card)){
            tableau.addLast(card);
        }
        else
            throw new IllegalStateException("Cannot place card on that pile");
    }

    /**
     *
     * @param card
     * setupPush is used for initializing the game; It ignores the normal restrictions on pushing into a tableau Pile
     */
    public void setupPush(PlayingCard card) {
        tableau.addLast(card);
    }
    public PlayingCard peek() {
        return this.tableau.peekLast();
    }

    public Deque<PlayingCard> getCards() {
        return this.tableau;
    }
}
