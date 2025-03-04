package model.player;
import engine.board.BoardManager;
import model.Colour;
import engine.board.BoardManager;


public class CPU extends Player {
    
    private final BoardManager boardManager;    
    
    
    public CPU(String name, Colour colour,BoardManager boardManager)        //constructor for the CPU
    {       
        super(name, colour);
        this.boardManager=boardManager; }    
}
