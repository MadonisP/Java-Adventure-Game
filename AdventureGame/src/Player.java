import java.util.Scanner;


public class Player {
	private int damage,healthP,money,rHealth;
	private String name,cName;
	private Inventory inv;
	Scanner scan=new Scanner(System.in);
	
	public Player(String name) {
		this.name = name;
		this.inv=new Inventory();
	}
	
	public void selectCha(){
		switch(chaMenu()){
		case 1:
			initPlayer("Samuray",5,21,15);
			break;
		case 2:
			initPlayer("Okçu",7,18,20);
			break;
		case 3:
			initPlayer("Þovalye",8,24,5);
			break;
			default:
				initPlayer("Samuray",5,21,15);
			break;
		}
		System.out.println("Karakter:"+getcName()+" ,hasar:"+getDamage()+" ,Saðlýk:"+getHealthP()+" ,Para:"+getMoney());
	}
	
	public int chaMenu(){
		System.out.println("lütfen bir karekter seçiniz:");
		System.out.println("1- Samuray \t Hasar:5 \t Saðlýk:21 \t Para:15");
		System.out.println("2- Okçu \t Hasar:7 \t Saðlýk:18 \t Para:20");
		System.out.println("3- Þovalye \t Hasar:8 \t Saðlýk:24 \t Para:5");
		System.out.print("Karakter seçiniz :");
		int chaID= scan.nextInt();
		
		while(chaID<1 ||chaID>3){
			System.out.println("lütfen geçerli bir karakter seçiniz");
			chaID=scan.nextInt();
		}
		
		
		return chaID;

	}
	
	public int getTotalDamage(){
		return this.getDamage()+this.getInv().getDamage();
	}
	
	public void initPlayer(String cName,int dmg,int hp,int mny){
		setcName(cName);
		setDamage(dmg);
		setHealthP(hp);
		setMoney(mny);
		setrHealth(hp);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealthP() {
		return healthP;
	}

	public void setHealthP(int healthP) {
		this.healthP = healthP;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	public int getrHealth() {
		return rHealth;
	}

	public void setrHealth(int rHealth) {
		this.rHealth = rHealth;
	}
	
	
	

}
