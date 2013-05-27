package game;

public class FieldImpl {

	private int x;
	private int y;
	private String value;
	
	private FieldImpl(int x, int y){
		this.x=x;
		this.y=y;
		this.value= "_";
	}
	
	public static FieldImpl valueOf(int x, int y){
		assert(x>0 && y>0);
		return new FieldImpl(x,y);
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public boolean isMarked(){
		return value !="_";
	}
	
	public boolean isFree(){
		return !isMarked();
	}
	
	public String getValue(){
		return this.value;
	}
	
	public void setValue(String value){
		this.value = value;
	}
	
	public boolean isX(){
		return this.value == "X";
	}
	
	public boolean isO(){
		return this.value == "O";
	}
	
	@Override
	public String toString(){
		return "Field[Zeile: "+(getY()+1)+" Spalte: "+(getX()+1)+"]";
	}
	
}
