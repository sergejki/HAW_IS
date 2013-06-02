package ai;

import game.FieldImpl;

import java.util.List;


public class AIPlayerImpl {
	
	private List<List<FieldImpl>> gameBoard;
	
	private AIPlayerImpl(){}
	
	public AIPlayerImpl(List<List<FieldImpl>> gameBoard){
		this.gameBoard = gameBoard;
	}

	public int makeMove(){
		
            //diagonal 100% gewinnen (\)
		for(int line=0; line<3; line++){
			for(int column=0; column<4;column++){
				if(getField(line, column).isX()){
					//System.out.println("Akt X-Feld: "+getField(line+1, column+1));
					if(checkDiagonalWin(line, column)){
						if(getField(line+1,column+1).isX()){
							return (line)*10+column;
						} else{
							return (line+2)*10+column+2;
						}
					}
				}
			}
		}
		
		//diagonal 100% gewinnen (/)
		for(int line=0; line<3; line++){
			for(int column=0; column<4;column++){
				if(getField(line, column).isX()){
					//System.out.println("Akt X-Feld: "+getField(line+1, column+1));
					if(checkDiagonalWin2(line, column)){
						if(getField(line+1,column-1).isX()){
							return (line)*10+column+2;
						} else{
							return (line+2)*10+column;
						}
					}
				}
			}
		}
		//diagonal 100% gewinnen (\)
		for(int line=0; line<3; line++){
			for(int column=0; column<4;column++){
				if(getField(line, column).isX()){
					//System.out.println("Akt X-Feld: "+getField(line+1, column+1));
					if(checkDiagonalWin(line, column)){
						if(getField(line+1,column+1).isX()){
							return (line)*10+column;
						} else{
							return (line+2)*10+column+2;
						}
					}
				}
			}
		}
		
		//diagonal 100% gewinnen (/)
		for(int line=0; line<3; line++){
			for(int column=0; column<4;column++){
				if(getField(line, column).isX()){
					//System.out.println("Akt X-Feld: "+getField(line+1, column+1));
					if(checkDiagonalWin2(line, column)){
						if(getField(line+1,column-1).isX()){
							return (line)*10+column+2;
						} else{
							return (line+2)*10+column;
						}
					}
				}
			}
		}
		
		//horizontal 100% gewinnen (_XX) || (XX_)
		for(int line=0; line<3; line++){
			for(int column=0; column<4;column++){
				if(getField(line, column).isX()){
					//System.out.println("Akt X-Feld: "+getField(line+1, column+1));
					if(checkHorizontalWin(line, column)){
                                            if(getField(line,column-1).isX()){
							return (line+1)*10+column+2;
						} else{
							return (line+1)*10+column;
						}
					}
				}
			}
		}
                
                //horizontal 100% gewinnen (X_X)
		for(int line=0; line<3; line++){
			for(int column=0; column<4;column++){
				if(getField(line, column).isFree()){
					//System.out.println("Akt X-Feld: "+getField(line+1, column+1));
					if(checkHorizontalWin2(line, column)){
                                            return (line+1)*10+column+1;
					}
				}
			}
		}
		
		//vertikal  100% gewinnen
		for(int line=0; line<3; line++){
			for(int column=0; column<4;column++){
				if(getField(line, column).isX()){
					//System.out.println("Akt X-Feld: "+getField(line+1, column+1));
					if(checkVertikalWin(line, column)){
						if(getField(line-1,column).isX()){
							return (line+2)*10+column+1;
						} else{
							return line*10+column+1;
						}
					}
				}
			}
		}
		
		//horizontal verlieren verhindern
		for(int line=0; line<3; line++){
			for(int column=0; column<4;column++){
				if(getField(line, column).isO()){
					//System.out.println("Akt X-Feld: "+getField(line+1, column+1));
					if(checkHorizontalO(line, column)){
						if(getField(line, column-1).isO()){
							return (line+1)*10+column+2;
						} else{
							return (line+1)*10+column;
						}
					}
				}
			}
		}
		
		//vertikal verlieren verhindern
		for(int line=0; line<3; line++){
			for(int column=0; column<4;column++){
                            if(getField(line,column).isFree()){
					//System.out.println("Akt X-Feld: "+getField(line+1, column+1));
					if(checkVertikalO(line, column)){
                                     System.out.println("Vertikal verhindern");
//						System.out.println("Akt Feld: "+" Zeile: "+(line+1)+"Spalte: "+(column+1));
						if(getField(line-1, column).isO()){
//							System.out.println("hier");
							return (line+1)*10+column+1;
						} else{
							return (line)*10+column+1;
						}
					}
                            }
				
			}
		}
		
		//diagonal verlieren verhindern (/)
		for(int line=0; line<3; line++){
			for(int column=0; column<4;column++){
				if(getField(line, column).isO()){
					//System.out.println("Akt X-Feld: "+getField(line+1, column+1));
					if(checkDiagonalO(line, column)){
                                     System.out.println("Diagonall Verhindern //");
//						System.out.println("Akt Feld: "+" Zeile: "+(line+1)+"Spalte: "+(column+1));
						if(getField(line-1, column+1).isO()){
							return (line+2)*10+column;
						} else{
							return (line)*10+column+2;
						}
					}
				}
			}
		}
		
           
                
		//diagonal verlieren verhindern (\)
				for(int line=0; line<3; line++){
					for(int column=0; column<4;column++){
						if(getField(line, column).isO()){
							//System.out.println("Akt X-Feld: "+getField(line+1, column+1));
							if(checkDiagonalO2(line, column)){
                                     System.out.println("Diagonal verhindern \\");
//								System.out.println("Akt Feld: "+" Zeile: "+(line+1)+"Spalte: "+(column+1));
								if(getField(line-1, column-1).isO()){
									return (line+2)*10+column+2;
								} else{
									return (line)*10+column;
								}
							}
						}
					}
				}
                                
                   //horizontal gewinnenchance erhöhen
//		for(int line=0; line<3; line++){
//			for(int column=0; column<4;column++){
//				if(getField(line, column).isX()){
//					//System.out.println("Akt X-Feld: "+getField(line+1, column+1));
//					if(checkHorizontalX(line, column)){
//                                            
//                                     System.out.println("Horizontal erhöhen");
//						if(getField(line, column+1).isX()){
//						//	System.out.println("Result: zeile: "+(line)+" spalte: "+(column));
//							return (line+1)*10+(column);
//						}else{
//							//System.out.println("Result: zeile: "+(line+1)+" spalte: "+(column+2));
//							return (line+1)*10+(column+2);
//						}
//					}
//				}
//			}
//		}             
//                   //diagonall gewinnchance erhöhen (\)
//                     for(int line=0; line<3;line++){
//                         for(int column=0; column<4;column++){
//                             if(getField(line,column).isX()){
//                                 if(checkDiagonalX2(line, column)){
//                                     System.out.println("diagonall \\");
//                                     if(getField(line-1,column-1).isX()){
//                                         return (line+2)*10+column+2;
//                                     }else{
//                                         return line*10+column;
//                                     }
//                                 }
//                             }
//                         }
//                     } 
		
//                //diagonall gewinnchance erhöhen (/)
//                     for(int line=0; line<3;line++){
//                         for(int column=0; column<4;column++){
//                             if(getField(line,column).isX()){
//                                 if(checkDiagonalX(line, column)){
//                                     System.out.println("Diagonall //");
//                                     if(getField(line-1,column+1).isX()){
//                                         return (line+2)*10+column;
//                                     }else{
//                                         return line*10+column+2;
//                                     }
//                                 }
//                             }
//                         }
//                     }          
//                     
                   
                                
		
//		//vertiakal gewinnchance erhöhen
//		for(int line=0; line<3; line++){
//			for(int column=0; column<4;column++){
//				if(getField(line, column).isX()){
//					if(checkVertikalX(line, column)){
//                                     System.out.println("Vertikal erhöhen");
//						if(getField(line-1, column).isX()){
//							return (line+2)*10+column+1;
//						}else{
//							return (line)*10+column+1;
//						}
//					}
//				}
//			}
//		}
		//System.out.println("bestMove");
		int[] bm = getBestMove();
		return (bm[0]+1)*10+bm[1]+1;
	}
	
	private boolean checkHorizontalWin(int line, int column){
		if(isField(line,column-1) && isField(line,column+1)){
			FieldImpl left = getField(line,column-1);
			FieldImpl right = getField(line, column+1);
			return (left.isX() && right.isFree()) || (right.isX() && left.isFree());
		} return false;
	}
        
        private boolean checkHorizontalWin2(int line, int column){
            if(isField(line,column-1) && isField(line,column+1)){
			FieldImpl left = getField(line,column-1);
			FieldImpl right = getField(line, column+1);
			return left.isX() && right.isX();
		} return false;
        }
	
	private boolean checkVertikalWin(int line, int column){
		if(isField(line-1,column) && isField(line+1,column)){
			FieldImpl above = getField(line-1,column);
			FieldImpl below = getField(line+1,column);
			return (above.isX() && below.isFree()) || (below.isX() && above.isFree());
		} return false;
	}
	
	private boolean checkDiagonalWin(int line, int column){
		if(isField(line-1,column-1) && isField(line+1,column+1)){
			FieldImpl left_above = getField(line-1,column-1);
			FieldImpl right_below = getField(line+1,column+1);
			return (left_above.isX() && right_below.isFree()) || (right_below.isX() && left_above.isFree());
		}return false;
	}
	
	private boolean checkDiagonalWin2(int line, int column){
		if(isField(line-1,column+1) && isField(line+1,column-1)){
			FieldImpl left_below = getField(line+1,column-1);
			FieldImpl right_above = getField(line-1,column+1);
			return (left_below.isX() && right_above.isFree()) || (right_above.isX() && left_below.isFree());
		}return false;
	}
	
	private boolean checkDiagonalO(int line, int column){
		if(isField(line-1,column+1) && isField(line+1,column-1)){
			FieldImpl right_above = getField(line-1,column+1);
			FieldImpl left_below = getField(line+1,column-1);
			return (right_above.isO() || left_below.isO()) && !(right_above.isX() || left_below.isX());
		} return false;
	}
	
	private boolean checkDiagonalO2(int line, int column){
		if(isField(line-1,column-1) && isField(line+1,column+1)){
			FieldImpl right_below = getField(line+1,column+1);
			FieldImpl left_above = getField(line-1,column-1);
			return (right_below.isO() || left_above.isO()) && !(right_below.isX() || left_above.isX());
		}return false;
	}
	
	private boolean checkHorizontalO(int line, int column){
		if(isField(line,column-1)&&isField(line,column+1)){
//			System.out.println("check");
			FieldImpl left = getField(line, column-1);
			FieldImpl right = getField(line,column+1);
			return (left.isO() || right.isO()) && !(left.isX() || right.isX());
		} return false;
	}
	
	private boolean checkVertikalO(int line, int column){
		if(isField(line-1,column) && isField(line+1,column)){
//			System.out.println("check");
			FieldImpl above = getField(line-1,column);
			FieldImpl below = getField(line+1,column);
			return (above.isO() && below.isO()) && !(above.isX() || below.isX());
		}return false;
	}
	
	private FieldImpl getField(int line, int column){
		return gameBoard.get(line).get(column);
	}
	
	private boolean checkAbove(int line, int column){
		if(isField(line-1,column)){
			return !getField(line-1, column).isMarked();
		} return false;
	}
	
	private boolean checkHorizontalX(int line, int column){
		//System.out.println("CHECK");
		if(isField(line,column-1)&&isField(line,column+1)){
			FieldImpl left = getField(line, column-1);
			FieldImpl right = getField(line,column+1);
			return ((left.isFree() || left.isX()) && (right.isFree() || right.isX())) || (left.isX() && right.isX());
		} return false;
	}
	
	private boolean checkVertikalX(int line, int column){
		if(isField(line-1,column) && isField(line+1,column)){
			FieldImpl above = getField(line-1,column);
			FieldImpl below = getField(line+1,column);
			return (above.isFree() || above.isX()) && (below.isFree() || below.isX());
		} return false;
	}
        
        private boolean checkDiagonalX(int line, int column){
            if(isField(line-1,column+1) && isField(line+1,column-1)){
                FieldImpl right_above = getField(line-1,column+1);
                FieldImpl left_below = getField(line+1,column-1);
                return (right_above.isFree() || right_above.isX()) && (left_below.isFree() || left_below.isX());
            } return false;
        }
        
        private boolean checkDiagonalX2(int line, int column){
            if(isField(line-1,column-1) && isField(line+1,column+1)){
                FieldImpl right_below = getField(line+1,column+1);
                FieldImpl left_above = getField(line-1,column-1);
                return (right_below.isFree() || right_below.isX()) && (left_above.isFree() || left_above.isX());
            } return false;
        }
	
	private boolean isField(int line, int column){
		return line>=0 && line <=2 && column>=0 && column<=3;
	}
	
	private int[] getBestMove(){
            //System.out.println("getbestMove");
		int[] result = new int[2];
		int mark = 0;
		for(int line=0; line<3; line++){
			for(int column=0; column<4;column++){
				if(getField(line,column).isFree()){
					int temp_mark = 0;
					if(isField(line,column-1) && getField(line,column-1).isFree()){System.out.println("\t Frei1"); temp_mark++;}
					if(isField(line,column+1) && getField(line,column+1).isFree()){System.out.println("\t Frei2"); temp_mark++;}
					if(isField(line-1,column-1) && getField(line-1,column-1).isFree()){System.out.println("\t Frei3"); temp_mark++;}
					if(isField(line-1,column+1) && getField(line-1,column+1).isFree()){System.out.println("\t Frei4"); temp_mark++;}
					if(isField(line+1,column-1) && getField(line+1,column-1).isFree()){System.out.println("\t Frei5"); temp_mark++;}
					if(isField(line+1,column+1) && getField(line+1,column+1).isFree()){System.out.println("\t Frei6"); temp_mark++;}
					if(isField(line-1,column) && getField(line-1,column).isFree()){System.out.println("\t Frei7"); temp_mark++;}
					if(isField(line+1,column) && getField(line+1,column).isFree()){System.out.println("\t Frei8"); temp_mark++;}
					
					//Oben-Bonus
					if(isField(line-1,column) && getField(line-1,column).isX()){System.out.println("\t Oben5");temp_mark++;}
					if(isField(line+1,column) && getField(line+1,column).isX()){System.out.println("\t Oben5");temp_mark++;}
					
					//Unten-Bonus
					if(isField(line,column-1) && getField(line,column-1).isX()){System.out.println("\t Unten1");temp_mark++;}
					if(isField(line,column+1) && getField(line,column+1).isX()){System.out.println("\t Unten2");temp_mark++;}
					
					//Diagonal-Bonus
					if(isField(line-1,column+1) && isField(line+1,column-1) && getField(line-1,column+1).isX()){System.out.println("\t Diagonal1"); temp_mark++;}
					if(isField(line-1,column-1) && isField(line+1,column+1) && getField(line-1,column-1).isX()){System.out.println("\t Diagonal2"); temp_mark++;}
					if(isField(line+1,column+1) && isField(line-1,column-1) && getField(line+1,column+1).isX()){System.out.println("\t Diagonal3"); temp_mark++;}
					if(isField(line+1,column-1) && isField(line-1,column+1)&& getField(line+1,column-1).isX()){System.out.println("\t Diagonal4"); temp_mark++;}
                                        if(isField(line+1,column-1) && getField(line+1,column-1).isX()){ System.out.println("\t Diagonal5"); temp_mark++;}
                                        if(isField(line+2,column-2) && isField(line+1,column-1) && getField(line+2,column-2).isFree() && getField(line+1,column-1).isX()) {System.out.println("\t Diagonal6"); temp_mark++;}
					
					//Mögliche Reihe -Bonus
					if(isField(line-1,column) && isField(line+1,column) && (getField(line-1,column).isX() || getField(line+1,column).isX())){System.out.println("\t Reihe1"); temp_mark++;}
					
					System.out.println(getField(line, column) + "Bewertung: "+temp_mark);
					if(temp_mark>mark){
						mark = temp_mark;
						result[0] = getField(line, column).getY();
						result[1] = getField(line, column).getX();
					}
				}
			}
		}
		return result;
	}
}
