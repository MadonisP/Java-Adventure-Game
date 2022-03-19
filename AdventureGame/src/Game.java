import java.util.Scanner;


public class Game {
	Player player;
	Location location;
	Scanner scan=new Scanner(System.in);
	public void login(){
		System.out.println("Macera oyununa hoþgeldiniz.");
		System.out.print("Oyuna baþlamadan önce isminizi giriniz:");
		String playerName=scan.nextLine();
		player=new Player(playerName);
		player.selectCha();
		start();
	}
	
	public void start(){
		while(true){
		System.out.println();
		System.out.println("=================================================");
		System.out.println();
		System.out.println("Eylem gerçekleþtirmek için bir yer seçiniz :");
		System.out.println("1. Güvenli ev --> Size ait güvenli bir mekan, düþman yok !");
		System.out.println("2. Maðara --> Karþýnýza belki zombi çýkabilir !");
		System.out.println("3. Orman --> Karþýnýza belki vampir çýkabilir !");
		System.out.println("4. Nehir --> Karþýnýza belki ayý çýkabilir !");
		System.out.println("5. Maðaza --> Silah ve zýrh	alabilirsiniz !");
		System.out.println("gitmek istediðiniz yer :");
		int selLoc=scan.nextInt();
		while(selLoc<0||selLoc>5){
			System.out.println("lütfen geçerli bir yer seçiniz :");
			selLoc=scan.nextInt();
		}
		switch(selLoc){
		case 1:
			location=new SafeHouse(player);
			break;
		case 2:
			location = new Cave(player);
			break;
		case 3:
			location=new Forest(player);
			break;
		case 4:
			location=new River(player);
			break;
		case 5:
			location =new ToolStore(player);
			break;
			default:
				location=new SafeHouse(player);
		}
		if(location.getClass().getName().equals("safeHouse")){
			if(player.getInv().isFirewood()&&player.getInv().isFood()&&player.getInv().isWater()){
				System.out.println("Tebrikler oyunu kazandýnýz !");
			}
		}
	if(!location.getLocation()){
		System.out.println("Oyun bitti !");
		break;
	}
	
	
	
	}
	}
	
}
