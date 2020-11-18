
import java.util.*;

public class Board {
	
	private int setID=0;
	
	private int notInBoardID;
	
	private int x,y;
	
	private String name;
	
	
	
	

	//Moveable Treasure
	Tile bat=new Tile(0, "bat", 1, true, (int)(4*Math.random()));
	Tile dragon=new Tile(1, "dragon", 1, true, (int)(4*Math.random()));
	Tile ghostBottle=new Tile(2, "ghostbottle", 1, true, (int)(4*Math.random()));
	Tile ghostWaving=new Tile(3, "ghostwaving", 1, true, (int)(4*Math.random()));
	Tile ladyPig=new Tile(4, "ladypig", 1, true, (int)(4*Math.random()));
	Tile sorceress=new Tile(5, "sorceress", 1, true, (int)(4*Math.random()));
	Tile lizard=new Tile(6, "lizard", 3, true, (int)(4*Math.random()));
	Tile moth=new Tile(7, "moth", 3, true, (int)(4*Math.random()));
	Tile owl=new Tile(8, "owl", 3, true, (int)(4*Math.random()));
	Tile scarab=new Tile(9, "scarab", 3, true, (int)(4*Math.random()));
	Tile rat=new Tile(10, "rat", 3, true, (int)(4*Math.random()));
	Tile spider=new Tile(11, "spider", 3, true, (int)(4*Math.random()));
	
	//Moveable Road
	Tile lShape1=new Tile(12, "null", 3, true, (int)(4*Math.random()));
	Tile lShape2=new Tile(13, "null", 3, true, (int)(4*Math.random()));
	Tile lShape3=new Tile(14, "null", 3, true, (int)(4*Math.random()));
	Tile lShape4=new Tile(15, "null", 3, true, (int)(4*Math.random()));
	Tile lShape5=new Tile(16, "null", 3, true, (int)(4*Math.random()));
	Tile lShape6=new Tile(17, "null", 3, true, (int)(4*Math.random()));
	Tile lShape7=new Tile(18, "null", 3, true, (int)(4*Math.random()));
	Tile lShape8=new Tile(19, "null", 3, true, (int)(4*Math.random()));
	Tile lShape9=new Tile(20, "null", 3, true, (int)(4*Math.random()));
	
	
	Tile iShape1=new Tile(21, "null", 2, true, (int)(4*Math.random()));
	Tile iShape2=new Tile(22, "null", 2, true, (int)(4*Math.random()));
	Tile iShape3=new Tile(23, "null", 2, true, (int)(4*Math.random()));
	Tile iShape4=new Tile(24, "null", 2, true, (int)(4*Math.random()));
	Tile iShape5=new Tile(25, "null", 2, true, (int)(4*Math.random()));
	Tile iShape6=new Tile(26, "null", 2, true, (int)(4*Math.random()));
	Tile iShape7=new Tile(27, "null", 2, true, (int)(4*Math.random()));
	Tile iShape8=new Tile(28, "null", 2, true, (int)(4*Math.random()));
	Tile iShape9=new Tile(29, "null", 2, true, (int)(4*Math.random()));
	Tile iShape10=new Tile(30, "null", 2, true, (int)(4*Math.random()));
	Tile iShape11=new Tile(31, "null", 2, true, (int)(4*Math.random()));
	Tile iShape12=new Tile(32, "null", 2, true, (int)(4*Math.random()));
	Tile iShape13=new Tile(33, "null", 2, true, (int)(4*Math.random()));
	
	//Unmoveable Treasure
	Tile goldCoins=new Tile(34, "goldcoins", 1, false, 1);
	Tile book=new Tile(35, "book", 1, false, 0);
	Tile crown=new Tile(36, "crown", 1, false, 1);
	Tile menorah=new Tile(37, "crown", 1, false, 2);
	Tile ring=new Tile(38, "ring", 1, false, 2);
	Tile helmet=new Tile(39, "helmet", 1, false, 2);
	Tile jewel=new Tile(40, "jewel", 1, false, 3);
	Tile keys=new Tile(41, "keys", 1, false, 0);
	Tile skull=new Tile(42, "skull", 1, false, 3);
	Tile sword=new Tile(43, "sword", 1, false, 3);
	Tile treasurechest=new Tile(44, "treasurechest", 1, false, 2);
	Tile treasureMap=new Tile(45, "treasuremap", 1, false, 1);
	
	//Unmoveable Starting Point
	Tile yellow=new Tile(46, "yellow", 3, false, 2);
	Tile red=new Tile(47, "red", 3, false, 3);
	Tile green=new Tile(48, "green", 3, false, 0);
	Tile blue=new Tile(49, "blue", 3, false, 1);
	
	//Cards
	Card batCard=new Card(0, "bat", false);
	Card dragonCard=new Card(1, "dragon", false);
	Card ghostBottleCard=new Card(2, "ghostBottle", false);
	Card ghostWavingCard=new Card(3, "ghostWaving", false);
	Card ladyPigCard=new Card(4, "ladyPig", false);
	Card sorceressCard=new Card(5, "sorceress", false);
	Card lizardCard=new Card(6, "lizard", false);
	Card mothCard=new Card(7, "moth", false);
	Card owlCard=new Card(8, "owl", false);
	Card scarabCard=new Card(9, "scarab", false);
	Card ratCard=new Card(10, "rat", false);
	Card spiderCard=new Card(11, "spider", false);
	Card goldCoinsCard=new Card(12, "goldCoins", false);
	Card bookCard=new Card(13, "book", false);
	Card crownCard=new Card(14, "crown", false);
	Card menorahCard=new Card(15, "menorah", false);
	Card ringCard=new Card(16, "ring", false);
	Card helmetCard=new Card(17, "helmet", false);
	Card jewelCard=new Card(18, "jewel", false);
	Card keysCard=new Card(19, "keys", false);
	Card skullCard=new Card(20, "skull", false);
	Card swordCard=new Card(21, "sword", false);
	Card treasurechestCard=new Card(22, "treasurechest", false);
	Card treasureMapCard=new Card(23, "treasureMap", false);
	
	
	Tile board[][]=new Tile[7][7];
	
	public Board() {
		
		ArrayList<Tile> allTiles=new ArrayList<Tile>();

		allTiles.add(bat);
		allTiles.add(dragon);
		allTiles.add(ghostBottle);
		allTiles.add(ghostWaving);
		allTiles.add(ladyPig);
		allTiles.add(sorceress);
		allTiles.add(lizard);
		allTiles.add(moth);
		allTiles.add(owl);
		allTiles.add(scarab);
		allTiles.add(rat);
		allTiles.add(spider);
		
		allTiles.add(lShape1);
		allTiles.add(lShape2);
		allTiles.add(lShape3);
		allTiles.add(lShape4);
		allTiles.add(lShape5);
		allTiles.add(lShape6);
		allTiles.add(lShape7);
		allTiles.add(lShape8);
		allTiles.add(lShape9);
		
		allTiles.add(iShape1);
		allTiles.add(iShape2);
		allTiles.add(iShape3);
		allTiles.add(iShape4);
		allTiles.add(iShape5);
		allTiles.add(iShape6);
		allTiles.add(iShape7);
		allTiles.add(iShape8);
		allTiles.add(iShape9);
		allTiles.add(iShape10);
		allTiles.add(iShape11);
		allTiles.add(iShape12);
		allTiles.add(iShape13);
		
		allTiles.add(goldCoins);
		allTiles.add(book);
		allTiles.add(crown);
		allTiles.add(menorah);
		allTiles.add(ring);
		allTiles.add(helmet);
		allTiles.add(jewel);
		allTiles.add(keys);
		allTiles.add(skull);
		allTiles.add(sword);
		allTiles.add(treasurechest);
		allTiles.add(treasureMap);
		
		allTiles.add(yellow);
		allTiles.add(red);
		allTiles.add(green);
		allTiles.add(blue);
		
		//Starting Point
		board[0][0]=red;
		board[0][6]=green;
		board[6][0]=yellow;
		board[6][6]=green;
		
		//Unmoveable Treasure
		board[0][2]=book;
		board[0][4]=goldCoins;
		board[2][0]=treasureMap;
		board[2][2]=crown;
		board[2][4]=keys;
		board[2][6]=skull;
		board[4][0]=ring;
		board[4][2]=treasurechest;
		board[4][4]=jewel;
		board[4][6]=sword;
		board[6][2]=menorah;
		board[6][4]=helmet;
		
		
		
		setID=0;
		
		do {
			
			do {
				x=(int)(7*Math.random());
				y=(int)(7*Math.random());
				
				System.out.print("Success");
				if(board[x][y]==null) {
					board[x][y]=Tile.findTileWithID(allTiles, setID);
				}
				
			}while(board[x][y]!=Tile.findTileWithID(allTiles, setID));
			
			setID++;
			
		}while(setID<=33);
		
		
		
	}
	
	
	

}

