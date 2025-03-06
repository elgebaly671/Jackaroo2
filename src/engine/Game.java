package engine;

import model.player.Player;
import model.player.CPU;
import model.card.Card;
import model.card.Deck;
import model.Colour;
import engine.board.Board;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Game implements GameManager {
    
    private final Board board;
    public Board getBoard() {
		return board;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	private final ArrayList<Player> players;
    private final ArrayList<Card> firePit;
    public ArrayList<Card> getFirePit() {
		return firePit;
	}

	private int currentPlayerIndex;
    private int turn;

    public Game(String playerName) throws IOException {
        //shuffle
        Colour[] colours = {Colour.RED, Colour.GREEN, Colour.BLUE, Colour.YELLOW};
        for (int i = 0; i < colours.length; i++) {
            int randomIndex = (int) (Math.random() * colours.length);
            Colour temp = colours[i];
            colours[i] = colours[randomIndex];
            colours[randomIndex] = temp;
        }

        //initialize board
        this.board = new Board(new ArrayList<>(Arrays.asList(colours)), this);
// initialise cardpool
        Deck.loadCardPool(board, this);

        //initialise players
        this.players = new ArrayList<>();
        players.add(new Player(playerName, colours[0]));

        for (int i = 1; i < colours.length; i++) {
            players.add(new CPU("CPU " + i, colours[i], board));
        }

        //Deal cards
            for (int i = 0; i < players.size(); i++) {
                players.get(i).getHand().addAll(Deck.drawCards());
            }

        //Initialise rest of game
        this.firePit = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.turn = 0;
    }
}
