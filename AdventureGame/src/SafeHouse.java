
public class SafeHouse extends NormalLoc{

	public SafeHouse(Player player) {
		super(player, "Güvenli ev");
		
	}
	
	public boolean getLocation(){
		player.setHealthP(player.getrHealth());
		System.out.println("iyileþtiniz...");
		System.out.println("Þuan güvenli ev adlý yerdesiniz.");
		return true;
	}

}
