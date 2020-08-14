package ca.macewan.cmpt305.freecell;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.*;
/**
 * FreecellGame: the game engine.
 */
public class FreecellGame {
    /** Declare the necessary fields
     *
     */
    private HomecellPile H0 = new HomecellPile();
    private HomecellPile H1 = new HomecellPile();
    private HomecellPile H2 = new HomecellPile();
    private HomecellPile H3 = new HomecellPile();

    private FreecellPile F0 = new FreecellPile();
    private FreecellPile F1 = new FreecellPile();
    private FreecellPile F2 = new FreecellPile();
    private FreecellPile F3 = new FreecellPile();

    private TableauPile T0 = new TableauPile();
    private TableauPile T1 = new TableauPile();
    private TableauPile T2 = new TableauPile();
    private TableauPile T3 = new TableauPile();
    private TableauPile T4 = new TableauPile();
    private TableauPile T5 = new TableauPile();
    private TableauPile T6 = new TableauPile();
    private TableauPile T7 = new TableauPile();
    public Deck deck = new Deck();
    private PlayingCard cardholder;

    public FreecellGame() {
        //Shuffles and then initializes TableauPiles
        deck.shuffle();
        for(int i=0; i<7;i++) {
            T0.setupPush(deck.deal());
        }
        for(int i=0; i<7;i++){
            T1.setupPush(deck.deal());
        }
        for(int i=0; i<7;i++){
            T2.setupPush(deck.deal());
        }
        for(int i=0; i<7;i++){
            T3.setupPush(deck.deal());
        }
        for(int i=0; i<6;i++){
            T4.setupPush(deck.deal());
        }
        for(int i=0; i<6;i++){
            T5.setupPush(deck.deal());
        }
        for(int i=0; i<6;i++){
            T6.setupPush(deck.deal());
        }
        for(int i=0; i<6;i++){
            T7.setupPush(deck.deal());
        }
    }

    /**
     * Checks if the game is over.
     * @return true if the game is over, false otherwise.
     */
    public boolean isGameOver() {
        if(H0.size()==13&&H1.size()==13&&H2.size()==13&&H3.size()==13){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Gets the contents of a pile of cards by pile name.
     * Homecell: H0 - H3
     * Freecell: F0 - F3
     * Tableau: T0 - T7
     * @param pileName - the pile name
     * @return the requested pile
     * I altered the return value from a Pile to a Deque because the format it was printing in was all wrong
     */
    public Deque<PlayingCard> getPileContents(String pileName) {
        switch (pileName) {
            case "H0":
                return H0.getCards();
            case "H1":
                return H1.getCards();
            case "H2":
                return H2.getCards();
            case "H3":
                return H3.getCards();
            case "F0":
                return F0.getCards();
            case "F1":
                return F1.getCards();
            case "F2":
                return F2.getCards();
            case "F3":
                return F3.getCards();
            case "T0":
                return T0.getCards();
            case "T1":
                return T1.getCards();
            case "T2":
                return T2.getCards();
            case "T3":
                return T3.getCards();
            case "T4":
                return T4.getCards();
            case "T5":
                return T5.getCards();
            case "T6":
                return T6.getCards();
            case "T7":
                return T7.getCards();
        }
        throw new IllegalStateException("Pile name not recognized");

    }

    /**
     * Moves a card from a pile to another pile.
     * @param from - pile name
     * @param to - pile name
     */
    public void moveCard(String from, String to) {
        if (!isLegalMove(from, to))
            throw new IllegalStateException("Illegal move");
        switch (from) {
            case "F0":
                cardholder = F0.pop();
                break;
            case "F1":
                cardholder = F1.pop();
                break;
            case "F2":
                cardholder = F2.pop();
                break;
            case "F3":
                cardholder = F3.pop();
                break;
            case "T0":
                cardholder = T0.pop();
                break;
            case "T1":
                cardholder = T1.pop();
                break;
            case "T2":
                cardholder = T2.pop();
                break;
            case "T3":
                cardholder = T3.pop();
                break;
            case "T4":
                cardholder = T4.pop();
                break;
            case "T5":
                cardholder = T5.pop();
                break;
            case "T6":
                cardholder = T6.pop();
                break;
            case "T7":
                cardholder = T7.pop();
                break;
        }
        switch (to) {
            case "H0":
                H0.push(cardholder);
                break;
            case "H1":
                H1.push(cardholder);
                break;
            case "H2":
                H2.push(cardholder);
                break;
            case "H3":
                H3.push(cardholder);
                break;
            case "F0":
                F0.push(cardholder);
                break;
            case "F1":
                F1.push(cardholder);
                break;
            case "F2":
                F2.push(cardholder);
                break;
            case "F3":
                F3.push(cardholder);
                break;
            case "T0":
                T0.push(cardholder);
                break;
            case "T1":
                T1.push(cardholder);
                break;
            case "T2":
                T2.push(cardholder);
                break;
            case "T3":
                T3.push(cardholder);
                break;
            case "T4":
                T4.push(cardholder);
                break;
            case "T5":
                T5.push(cardholder);
                break;
            case "T6":
                T6.push(cardholder);
                break;
            case "T7":
                T7.push(cardholder);
                break;
        }


        // Move the card

    }

    /**
     * Checks if a move between piles is legal.
     * @param from - pile name
     * @param to - pile name
     * @return true if the move is legal, false otherwise.
     */
    public boolean isLegalMove(String from, String to) {
        int canpop=0;
        int canpush=0;
        switch(from){
            case "H0":
                if(H0.size()!=0)
                    cardholder = H0.peek();
                if(H0.canPop()){
                    canpop=1;
                }
                break;
            case "H1":
                if(H1.size()!=0)
                    cardholder = H1.peek();
                if(H1.canPop()) {
                    canpop = 1;
                }
                break;
            case "H2":
                if(H2.size()!=0)
                    cardholder = H2.peek();
                if(H2.canPop()){
                    canpop=1;
                }
                break;
            case "H3":
                if(H3.size()!=0)
                    cardholder = H3.peek();
                if(H3.canPop()){
                    canpop=1;
                }
                break;
            case "F0":
                if(F0.size()!=0)
                    cardholder = F0.peek();
                if(F0.canPop()){
                    canpop=1;
                }
                break;
            case "F1":
                if(F1.size()!=0)
                    cardholder = F1.peek();
                if(F1.canPop()){
                    canpop=1;
                }
                break;
            case "F2":
                if(F2.size()!=0)
                    cardholder = F2.peek();
                if(F2.canPop()){
                    canpop=1;
                }
                break;
            case "F3":
                if(F3.size()!=0)
                    cardholder = F3.peek();
                if(F3.canPop()){
                    canpop=1;
                }
                break;
            case "T0":
                if(T0.size()!=0)
                    cardholder = T0.peek();
                if(T0.canPop()){
                    canpop=1;
                }
                break;
            case "T1":
                if(T1.size()!=0)
                    cardholder = T1.peek();
                if(T1.canPop()){
                    canpop=1;
                }
                break;
            case "T2":
                if(T2.size()!=0)
                    cardholder = T2.peek();
                if(T2.canPop()){
                    canpop=1;
                }
                break;
            case "T3":
                if(T3.size()!=0)
                    cardholder = T3.peek();
                if(T3.canPop()){
                    canpop=1;
                }
                break;
            case "T4":
                if(T4.size()!=0)
                    cardholder = T4.peek();
                if(T4.canPop()){
                    canpop=1;
                }
                break;
            case "T5":
                if(T5.size()!=0)
                    cardholder = T5.peek();
                if(T5.canPop()){
                    canpop=1;
                }
                break;
            case "T6":
                if(T6.size()!=0)
                    cardholder = T6.peek();
                if(T6.canPop()){
                    canpop=1;
                }
                break;
            case "T7":
                if(T7.size()!=0)
                    cardholder = T7.peek();
                if(T7.canPop()){
                    canpop=1;
                }
                break;
        }

        switch(to){
            case "H0":
                if(H0.canPush(cardholder)){
                    canpush=1;
                }
                break;
            case "H1":
                if(H1.canPush(cardholder)) {
                    canpush = 1;
                }
                break;
            case "H2":
                if(H2.canPush(cardholder)){
                    canpush=1;
                }
                break;
            case "H3":
                if(H3.canPush(cardholder)){
                    canpush=1;
                }
                break;
            case "F0":
                if(F0.canPush(cardholder)){
                    canpush=1;
                }
                break;
            case "F1":
                if(F1.canPush(cardholder)){
                    canpush=1;
                }
                break;
            case "F2":
                if(F2.canPush(cardholder)){
                    canpush=1;
                }
                break;
            case "F3":
                if(F3.canPush(cardholder)){
                    canpush=1;
                }
                break;
            case "T0":
                if(T0.canPush(cardholder)){
                    canpush=1;
                }
                break;
            case "T1":
                if(T1.canPush(cardholder)){
                    canpush=1;
                }
                break;
            case "T2":
                if(T2.canPush(cardholder)){
                    canpush=1;
                }
                break;
            case "T3":
                if(T3.canPush(cardholder)){
                    canpush=1;
                }
                break;
            case "T4":
                if(T4.canPush(cardholder)){
                    canpush=1;
                }
                break;
            case "T5":
                if(T5.canPush(cardholder)){
                    canpush=1;
                }
                break;
            case "T6":
                if(T6.canPush(cardholder)){
                    canpush=1;
                }
                break;
            case "T7":
                if(T7.canPush(cardholder)){
                    canpush=1;
                }
                break;
        }
        if(canpop==1&&canpush==1){
            return true;
        }
        else{
            return false;
        }

    }

    // Feel free to add private helper methods if necessary
}
