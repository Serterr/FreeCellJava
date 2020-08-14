package ca.macewan.cmpt305.freecell;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Represents a freecell pile.
 */
public class FreecellPile implements Pile {
    /**
    / Removed "final" from all 3 of the piles. Seemed they needed to be mutable
     */
    private Deque<PlayingCard> freecell = new ArrayDeque<>();

    public int size() {
        return this.freecell.size();
    }

    public boolean canPop() {
        if(this.freecell.size()>0){
            return true;
        }
        throw new IllegalStateException("Cannot take from an empty pile");
    }

    public PlayingCard pop() {
        return this.freecell.removeLast();
    }

    public boolean canPush(PlayingCard card) {
        if( this.freecell.size()==0)
            return true;
        else
            return false;
    }

    public void push(PlayingCard card) {
        if(this.canPush(card)){
            freecell.addLast(card);
        }
        else
            throw new IllegalStateException("Cannot place card on that pile");
    }

    public PlayingCard peek() {
        return this.freecell.peekLast();
    }

    public Deque<PlayingCard> getCards() {
        return this.freecell;
    }
}


