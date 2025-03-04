package engine.board;
import model.Colour;
import java.util.ArrayList;

public class SafeZone {
private final Colour colour;
private final ArrayList<Cell> cells;
	
	public 	SafeZone(Colour colour){
		this.colour=colour;
        cells=new ArrayList<Cell>(4);
		for(int i=0;i<4;i++)
			{cells.add(new Cell(CellType.SAFE));}
	}
	
public Colour getColour() {
    return colour;}

public void getCells() {
    for(int i=0;i<4;i++)
    {System.out.println(cells.get(i));}
}
public String toString() {
	return "SafeZone{" +
			"colour=" + colour +
			", Safe=" + cells +
			'}';}	
}
