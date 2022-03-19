
public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;
	protected String award;
	
	BattleLoc(Player player,String name,Obstacle obstacle,String award){
		super(player);
		this.obstacle=obstacle;
		this.name=name; 
		this.award=award;
	}
	
	public boolean getLocation(){
		int obsCount=obstacle.count();
		System.out.println("Þuan buradasýnýz "+this.getName());
		System.out.println("Dikkatli ol! burada "+obsCount+" tane "+obstacle.getName()+" yaþýyor.");
		System.out.println("<S>avaþ veya <K>aç");
		String selCase=scan.nextLine();
		selCase=selCase.toUpperCase();
		if(selCase.equals("S")){
			if(combat(obsCount)){
				System.out.println(this.getName()+" bölgesindeki bir düþmaný temizlediniz !");
				if(this.award.equals("Food")&&player.getInv().isFood()==false){
					System.out.println(this.award+" Kazandýnýz !");
					player.getInv().setFood(true);}
				else if(this.award.equals("Water")&&player.getInv().isWater()==false){
						System.out.println(this.award+" Kazandýnýz !");
						player.getInv().setWater(true);
					}
				else if(this.award.equals("Firewood")&&player.getInv().isFirewood()==false){
					System.out.println(this.award+" Kazandýnýz !");
					player.getInv().setFirewood(true);
				}
				return true;
			}
			if(player.getHealthP()<=0){
				System.out.println("Öldünüz !");
				return false;
			}
	}		
		return true;
	}
	
	
	
	public boolean combat(int obsCount){
		for(int i =0;i<obsCount;i++){
			int defObsHealth=obstacle.getHealth();
			playerStats();
			enemyStats();
			while(player.getHealthP()>0 && obstacle.getHealth()>0){
				System.out.print("<V>ur veya <K>aç :");
				String selCase=scan.nextLine();
				selCase=selCase.toUpperCase();
				if(selCase.equals("V")){
					System.out.println("Siz vurdunuz !");
					obstacle.setHealth(obstacle.getHealth()-player.getTotalDamage());
					afterHit();
					if(obstacle.getHealth()>0){
					System.out.println();
					System.out.println("Canavar vurdu !");
					player.setHealthP(player.getHealthP()-(obstacle.getDamage()-player.getInv().getArmor()));
					afterHit();
					}
				}else{
					return false;
				}
			}
			if(obstacle.getHealth()<player.getHealthP()){
				System.out.println("Tüm düþmanlarý yendiniz !");
				player.setMoney(player.getMoney()+obstacle.getAward());
				System.out.println("Güncel paranýz : "+player.getMoney());
				obstacle.setHealth(defObsHealth);
				
			}else{
				return false;
			}
			System.out.println("--------------------------------");
		}
		return true;
	}
	public void playerStats(){
		System.out.println("Oyuncu Deðerleri \n---------------------");
		System.out.println("Can:"+player.getHealthP());
		System.out.println("Hasar:"+player.getTotalDamage());
		System.out.println("Para:"+player.getMoney());
		if(player.getInv().getDamage()>0){
			System.out.println("Silah:"+player.getInv().getwName());
			System.out.println("Zýrh:"+player.getInv().getaName());
		}

	}
	
	public void enemyStats(){
		System.out.println("\n"+obstacle.getName()+"Deðerleri\n------------------");
		System.out.println("Can:"+obstacle.getHealth());
		System.out.println("Hasar:"+obstacle.getDamage());
		System.out.println("Ödül"+obstacle.getAward());
	}
	
	public void afterHit(){
		System.out.println("Oyuncu Caný"+player.getHealthP());
		System.out.println(obstacle.getName()+" Caný:" + obstacle.getHealth());
	}

}
