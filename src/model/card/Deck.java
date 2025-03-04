package model.card;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.net.http.HttpResponse.BodyHandler;
import java.util.ArrayList;
import java.util.Queue;

import engine.GameManager;
import engine.board.BoardManager;
import model.Colour;
import model.card.standard.Ace;
import model.card.standard.Five;
import model.card.standard.Four;
import model.card.standard.Jack;
import model.card.standard.King;
import model.card.standard.Queen;
import model.card.standard.Seven;
import model.card.standard.Standard;
import model.card.standard.Suit;
import model.card.standard.Ten;
import model.card.wild.Burner;
import model.card.wild.Saver;
import java.util.Collections;
public class Deck {
    private final static String CARDS_FILE = "Cards.csv";
    private static ArrayList<Card> cardsPool;

    // reads the csv file and instantiates the right card based on the code
    public static void loadCardPool(BoardManager boardManager, GameManager gameManager)
            throws IOException {
    	cardsPool = new ArrayList<Card>();
        // preparing the data to be read
        BufferedReader reader = new BufferedReader(new FileReader(CARDS_FILE));
        String line = "";

        // as long as there is a new line containing data, the while loop will be
        // executed
        while ((line = reader.readLine()) != null) {

            /*
             * since the data is separated by a comma, we split them each time we see a
             * comma unless the comma
             * is a part of the data itself
             */
            //String[] row = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        	String[] row = line.split(",");

            // getting the frequency of each card
            int freq = Integer.parseInt(row[1]);

            /*
             * The following switch statement checks the "code" column and according to this
             * code an object of the card corresponding to this
             * code is intiallized
             * The card's object is then added to the "cardspool" arraylist which represents
             * the Deck from which cards are distriputed
             * Frequency of each card is taken into considerations. Meaning that if the
             * card's frequency is 4 then 4 instances of the card's
             * object will be added to the cardspool.
             */
            switch (Integer.parseInt(row[0])) {

                case 0:

                    for (int f = 0; f < freq; f++) {
                        Standard standard = new Standard(row[2], row[3], Integer.parseInt(row[4]), Suit.valueOf(row[5]),
                                boardManager, gameManager);
                        cardsPool.add(standard);
                    }
                    break;
                case 1:

                    for (int f = 0; f < freq; f++) {
                        Ace ace = new Ace(row[2], row[3], Suit.valueOf(row[5]), boardManager, gameManager);
                        cardsPool.add(ace);
                    }

                    break;
                case 13:

                    for (int f = 0; f < freq; f++) {
                        King king = new King(row[2], row[3], Suit.valueOf(row[5]), boardManager, gameManager);
                        cardsPool.add(king);
                    }

                    break;
                case 12:

                    for (int f = 0; f < freq; f++) {
                        Queen q = new Queen(row[2], row[3], Suit.valueOf(row[5]), boardManager, gameManager);
                        cardsPool.add(q);
                    }

                    break;
                case 11:

                    for (int f = 0; f < freq; f++) {
                        Jack jack = new Jack(row[2], row[3], Suit.valueOf(row[5]), boardManager, gameManager);
                        cardsPool.add(jack);
                    }
                    break;
                case 4:

                    for (int f = 0; f < freq; f++) {
                        Four four = new Four(row[2], row[3], Suit.valueOf(row[5]), boardManager, gameManager);
                        cardsPool.add(four);
                    }

                    break;
                case 5:

                    for (int f = 0; f < freq; f++) {
                        Five five = new Five(row[2], row[3], Suit.valueOf(row[5]), boardManager, gameManager);
                        cardsPool.add(five);
                    }

                    break;
                case 7:

                    for (int f = 0; f < freq; f++) {
                        Seven seven = new Seven(row[2], row[3], Suit.valueOf(row[5]), boardManager, gameManager);
                        cardsPool.add(seven);
                    }

                    break;
                case 10:

                    for (int f = 0; f < freq; f++) {
                        Ten ten = new Ten(row[2], row[3], Suit.valueOf(row[5]), boardManager, gameManager);
                        cardsPool.add(ten);
                    }

                    break;
                case 14:

                    for (int f = 0; f < freq; f++) {
                        Burner burner = new Burner(row[2], row[3], boardManager, gameManager);
                        cardsPool.add(burner);
                    }

                    break;
                case 15:

                    for (int f = 0; f < freq; f++) {
                        Saver saver = new Saver(row[2], row[3], boardManager, gameManager);
                        cardsPool.add(saver);
                    }

                default:
                    break;
            }

        }
        reader.close();
    }

    /*
     * Shuffles the cardsPool, then removes and re-
     * turns the first four cards from it
     */
    public static ArrayList<Card> drawCards() {
    	
        Collections.shuffle(cardsPool);
        ArrayList<Card> newCards = new ArrayList<>();
        
        for(int i =0; i < 4;i++){
        	if(cardsPool.size() == 0)
        		return newCards;
        	newCards.add(cardsPool.remove(0));
        }
        return newCards;
    }

}