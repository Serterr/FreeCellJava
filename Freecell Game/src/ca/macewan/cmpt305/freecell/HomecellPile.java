package ca.macewan.cmpt305.freecell;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Represents a homecell pile.
 */
public class HomecellPile implements Pile {
    private Deque<PlayingCard> homecell = new ArrayDeque<>();

    public int size() {
        return this.homecell.size();
    }

    public boolean canPop() {
        return false;
    }

    public PlayingCard pop() {
        throw new IllegalStateException("The Homecell pile may not be taken from");
    }

    public boolean canPush(PlayingCard card) {
        /**
         *If the homecell pile is empty, and the card to be pushed is an ace, then return true
         *Else if the card to be pushed is 1 greater than the top card on the pile, and their suits match, return true
         *Else return false
         */
        if(this.homecell.size()==0&&card.getRank()==Rank.ACE){
            return true;
        }
        else if(homecell.size()!=0&&homecell.peekLast().compareValueTo(card)==-1&&homecell.peekLast().getSuit().equals(card.getSuit())){
            return true;
        }
        else
            return false;
    }

    public void push(PlayingCard card) {
        if(this.canPush(card)){
            homecell.addLast(card);
        }
        else
            throw new IllegalStateException("Cannot place card on that pile");
    }

    public PlayingCard peek() {
        return this.homecell.peekLast();
    }

    public Deque<PlayingCard> getCards() {
        return this.homecell;
    }
}
