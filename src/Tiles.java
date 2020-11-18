
public enum Tiles {
	
	//Moveable Treasure
	Bat(1, "bat", 1, true),
	Dragon(2, "dragon", 1, true),
	GhostBottle(3, "ghostbottle", 1, true),
	GhostWaving(4, "ghostwaving", 1, true),
	LadyPig(5, "ladypig", 1, true),
	Sorceress(6, "sorceress", 1, true),
	Lizard(7, "lizard", 3, true),
	Moth(8, "moth", 3, true),
	Owl(9, "owl", 3, true),
	Scarab(10, "scarab", 3, true),
	Rat(11, "rat", 3, true),
	Spider(12, "spider", 3, true),
	
	//Moveable Road
	LShape1(13, "null", 3, true),
	LShape2(14, "null", 3, true),
	LShape3(15, "null", 3, true),
	LShape4(16, "null", 3, true),
	LShape5(17, "null", 3, true),
	LShape6(18, "null", 3, true),
	LShape7(19, "null", 3, true),
	LShape8(20, "null", 3, true),
	LShape9(21, "null", 3, true),
	IShape1(22, "null", 2, true),
	IShape2(23, "null", 2, true),
	IShape3(24, "null", 2, true),
	IShape4(25, "null", 2, true),
	IShape5(26, "null", 2, true),
	IShape6(27, "null", 2, true),
	IShape7(28, "null", 2, true),
	IShape8(29, "null", 2, true),
	IShape9(30, "null", 2, true),
	IShape10(31, "null", 2, true),
	IShape11(32, "null", 2, true),
	IShape12(33, "null", 2, true),
	IShape13(34, "null", 2, true),
	
	//Unmoveable Treasure
	GoldCoins(35, "goldcoins", 1, false),
	Book(36, "book", 1, false),
	Crown(37, "crown", 1, false),
	Menorah(38, "menorah", 1, false),
	Ring(39, "ring", 1, false),
	Helmet(40, "helmet", 1, false),
	Jewel(41, "jewel", 1, false),
	Keys(42, "keys", 1, false),
	Skull(43, "skull", 1, false),
	Sword(44, "sword", 1, false),
	Treasurechest(45, "treasurechest", 1, false),
	TreasureMap(46, "treasuremap", 1, false),
	//Unmoveable Starting Point
	Yellow(47, "yellow", 3, false),
	Red(48, "red", 3, false),
	Green(49, "green", 3, false),
	Blue(50, "blue", 3, false);
	
	
	
	
	
	
	
	private final int id;
	private final String object;
	private final int shape;
	private final boolean move;
	
	Tiles(int id, String object, int shape, boolean move){
		this.id=id;
		this.object=object;
		this.shape=shape;
		this.move=move;
	}

	public int getID() {
		return id;
	}

	public String getObject() {
		return object;
	}

	public int getShape() {
		
		//1=T
		//2=I
		//3=L
		return shape;
	}

	public boolean isMove() {
		return move;
	}
	
	
	
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
		

}
