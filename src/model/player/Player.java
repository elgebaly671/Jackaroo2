package model.player;
import model.card.Card;
import model.Colour;
import java.util.ArrayList;

public class Player {
    private final String name;  //name of the player
    private final Colour colour;    //colour of the player
    private ArrayList<Card> hand;       //cards in the hand
    private ArrayList<Marble> marbles;      //marbles in the base
    private Card selectedCard;  //selected card for the turn
    private final ArrayList<Marble> selectedMarbles; //selected marbles for the selected card


    public Player(String name, Colour colour)
    {this.name=name;
    this.colour=colour;
    hand = new ArrayList<Card>();
    marbles = new ArrayList<Marble>();
    for(int i = 0; i < 4; i++){
    	marbles.add(new Marble(this.colour));
    }
    selectedMarbles = new ArrayList<Marble>();
    selectedCard= null;}

    public String getName()         //get the name of the player
    {return this.name;}

    public Colour getColour()       //get the colour of the player
    {return this.colour;}

    public ArrayList<Card> getHand()        //get the hand of the player
    {return this.hand;}

    public void setHand(ArrayList<Card> hand)       //set the hand of the player
    {this.hand=hand;}

    public ArrayList<Marble> getMarbles()      //get the marbles of the player
    {return this.marbles;}

    public Card getSelectedCard()       //get the selected card of the player
    {return this.selectedCard;}

 }
    
