
public class SafeHouse extends NormalLoc{

	public SafeHouse(Player player) {
		super(player, "G�venli ev");
		
	}
	
	public boolean getLocation(){
		player.setHealthP(player.getrHealth());
		System.out.println("iyile�tiniz...");
		System.out.println("�uan g�venli ev adl� yerdesiniz.");
		return true;
	}

}
