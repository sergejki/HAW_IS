package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ai.AIPlayerImpl;


public class GameImpl extends Thread{
	
	private List<List<FieldImpl>> gameList;
	private int run = 1;
	//private boolean isOver = false;
	private int gamer = 1;
	private AIPlayerImpl aiplayer;
	
	private GameImpl(List<List<FieldImpl>> lines, AIPlayerImpl ai){
		this.gameList = lines;
		this.aiplayer = ai;
	}
	
	public static GameImpl valueOf(int lines, int columns){
		assert(lines>0 && columns>0);
		List<List<FieldImpl>> gamelist = new ArrayList<List<FieldImpl>>();
		for(int i=0;i<lines;i++){
			List<FieldImpl> line = new ArrayList<FieldImpl>();
			for(int j=0;j<columns;j++){
				FieldImpl field = FieldImpl.valueOf(j, i);
				line.add(field);
			}
			gamelist.add(line);
		}
		return new GameImpl(gamelist, new AIPlayerImpl(gamelist));
	}
	
	public void printGame(){
		for(List<FieldImpl> lines: gameList){
			for(FieldImpl field : lines){
				System.out.print(field.getValue()+" ");
			}
			System.out.println("");
		}
	}
	
	private void setValue(int x, int y, String value){
		FieldImpl f =  gameList.get(x-1).get(y-1);
		if(!f.isMarked()) f.setValue(value);
	}
	
	private String getValue(int x, int y) throws FieldNotMarkedException{
		FieldImpl f = gameList.get(x-1).get(y-1);
		if(f.isMarked()){
			return f.getValue();
		} else{
			throw new FieldNotMarkedException();
		}
	}
	
	private boolean isOver(){
		boolean result = false;
		//horizontal

		try{ result = result ? result : (getValue(1,1)==getValue(1,2) && getValue(1,2)==getValue(1,3));
		}catch(FieldNotMarkedException e){ }
		try{ result = result ? result : (getValue(1,2)==getValue(1,3) && getValue(1,3)==getValue(1,4));
		}catch(FieldNotMarkedException e){ }
		try{ result = result ? result : (getValue(2,1)==getValue(2,2) && getValue(2,2)==getValue(2,3));
		}catch(FieldNotMarkedException e){ }
		try{ result = result ? result : (getValue(2,2)==getValue(2,3) && getValue(2,3)==getValue(2,4));
		}catch(FieldNotMarkedException e){ }
		try{ result = result ? result : (getValue(3,1)==getValue(3,2) && getValue(3,2)==getValue(3,3));
		}catch(FieldNotMarkedException e){  }
		try{ result = result ? result : (getValue(3,2)==getValue(3,3) && getValue(3,3)==getValue(3,4));
		}catch(FieldNotMarkedException e){ }
		
		//vertikal
		if(!result){
			try{ result = result ? result : (getValue(1,1)==getValue(2,1) && getValue(2,1)==getValue(3,1));
			}catch(FieldNotMarkedException e){ }
			try{ result = result ? result : (getValue(1,2)==getValue(2,2) && getValue(2,2)==getValue(3,2));
			}catch(FieldNotMarkedException e){  }
			try{ result = result ? result : (getValue(1,3)==getValue(2,3) && getValue(2,3)==getValue(3,3));
			}catch(FieldNotMarkedException e){  }
			try{ result = result ? result : (getValue(1,4)==getValue(2,4) && getValue(2,4)==getValue(3,4));
			}catch(FieldNotMarkedException e){ }
		}	
			
			//diagonall
		if(!result){
			try{ result = result ? result : (getValue(1,1)==getValue(2,2) && getValue(2,2)==getValue(3,3));
			}catch(FieldNotMarkedException e){  }
			try{ result = result ? result : (getValue(1,2)==getValue(2,3) && getValue(2,3)==getValue(3,4));
			}catch(FieldNotMarkedException e){  }
			try{ result = result ? result : (getValue(3,1)==getValue(2,2) && getValue(2,2)==getValue(1,3));
			}catch(FieldNotMarkedException e){  }
			try{ result = result ? result : (getValue(3,2)==getValue(2,3) && getValue(2,3)==getValue(1,4));
			}catch(FieldNotMarkedException e){  }
		}
		return result || (run==13);
	}
	
	@Override
	public void run(){
    	printRules();
		while(!isOver()){
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    try {
		    	String separator = "==========";
				System.out.println(separator+this.run+separator);
				this.run+=1;
		    	printGame();
		    	//System.out.print("Spieler "+gamer+":");
		    	String input;
		    	char xc,yc;
		    	int x,y;
		    	if(gamer==1){
		    		System.out.print("AI: ");
		    		input = String.valueOf(aiplayer.makeMove());
		    		System.out.println(input);
		    		System.out.println();
		    		xc = input.charAt(0);
					yc = input.charAt(1);
					x = Integer.parseInt(String.valueOf(xc));
					y = Integer.parseInt(String.valueOf(yc));
		    	} else{
		    		boolean check;
		    		do{
		    		System.out.print("Mensch: ");
					input = bufferRead.readLine();
					//System.out.println(input);
					xc = input.charAt(0);
					yc = input.charAt(1);
					check = checkInput(xc,yc);
		    		}while(!check);
					x = Integer.parseInt(String.valueOf(xc));
					y = Integer.parseInt(String.valueOf(yc));
					System.out.println("");
		    	}
		    	
				//System.out.println("zeile:"+x+" spalte:"+y);
				if(gamer==1){
					setValue(x, y, "X");
					gamer=2;
				} else{
					setValue(x,y,"O");
					gamer=1;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		gamer = gamer==1 ? 2 : 1;
		printGame();
		System.out.print("Gewonnen hat: ");
		if(gamer == 1 || run==13){
			System.out.println("AI");
		} else{
			System.out.println("Spieler " +gamer);
		}
	}
	
	private void printRules(){
		System.out.println("======Spielregeln======");
		System.out.println("1) Der Rechner beginnt");
		System.out.println("2) Der Zug wird mit Zahlen eingegeben: ZeileSpalte. \n z.B für Zeile 2 Spalte 3 muss man 23 eigeben:");
		System.out.println("\t_ _ _ _ \n\t_ _ X _ \n\t_ _ _ _ ");
		System.out.println();
	}
	
	private boolean checkInput(char x, char y){
		return checkNum(x,y) && checkField(x,y);
	}
	
	private boolean checkField(char xc, char yc){
		int x = Integer.parseInt(String.valueOf(xc));
		int y = Integer.parseInt(String.valueOf(yc));
		return gameList.get(x-1).get(y-1).isFree();
	}
	
	private boolean checkNum(char x, char y){
		return x>'0' && x<'4' && y>'0' && y<'5';
	}

}
