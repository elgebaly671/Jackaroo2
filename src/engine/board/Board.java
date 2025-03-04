package engine.board;
import engine.GameManager;
import model.Colour;
import java.lang.reflect.Array;
import java.util.ArrayList;
import engine.board.Cell; 
  

public class Board implements BoardManager {
    private final GameManager gameManager;
    private final ArrayList<Cell> track;
    private final ArrayList<SafeZone> safeZones;
    private int splitDistance;

    public Board(ArrayList<Colour>colourOrder,GameManager gameManager)
    {
        this.gameManager=gameManager;
        track=new ArrayList<Cell>();
        safeZones=new ArrayList<SafeZone>();
        splitDistance=3;
        track.add(new Cell(CellType.BASE));
        for(int i=1;i<100;i++)
        {if (i%25==0)                               //the base cells are seprated by 25 cells, therofore if we start counting from cell Zero and make it a base cell, then every 25th cell will be a base cell.
         {track.add(new Cell(CellType.BASE));}
        else 
            {if (i==2 || i==27 || i==52 || i==77)   //the safe cells ENTRY are at 2,27,52,77
             {track.add(new Cell(CellType.ENTRY));}
            else
                {track.add(new Cell(CellType.NORMAL));}}   //the normal cells are the rest of the cells
            }
        assignTrapCell();  //assign 8 traps to the cells
        for(int i=0;i<4;i++)    //assign safe zones to the players
        {safeZones.add(new SafeZone(colourOrder.get(i)));}   
        }
   
   
   
 private void assignTrapCell()
    {int count=0;
        while(count!=8)
        {int random=(int)(Math.random()*100);
            if (track.get(random).getCellType()==CellType.NORMAL && !track.get(random).isTrap())  //if the cell is normal and does not have a trap, assgin a trap cell to it.
            {track.get(random).setTrap(true);
            count++;}
        }
    }

public ArrayList<Cell>  getTrack()
//    {for(int i=0;i<100;i++)
//    {System.out.println(track.get(i));}}    
{
	return track;
}


public ArrayList<SafeZone> getSafeZones()
    {return safeZones;}


public int getSplitDistance()
    {return this.splitDistance;}

public void setSplitDistance(int splitDistance)
    {this.splitDistance=splitDistance;}
}

