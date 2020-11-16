
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

	public int getId() {
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
	
	
	

}
