public class Transport extends Thread {
    Venue destination;
	public static Filter fl;
	public static Bakery bl;

	public Transport(Venue dest,Filter fl){
		destination = dest;
		this.fl = fl;
	}

	public Transport(Venue dest,Bakery bl){
		destination = dest;
		this.bl = bl;
	}

	@Override
	public void run()
	{
		/*------------FILTER LOCK--------------*/ //btw this a shit lock regards
		if(fl != null){

			for(int i= 0; i < 5;i++){
				int load = i +1;
			System.out.println("BUS " + this.getName() + " is waiting to drop-off: Load " + load);
				fl.lock();
				try{
					destination.dropOff(this,load);
//
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				} finally {
					fl.unlock();
				}
			}
		}

		if(bl != null) {
			/*------------BAKERY LOCK-----------------*/
			for (int i = 0; i < 5; i++) {
				int load = i + 1;
				System.out.println("BUS " + this.getName() + " is waiting to drop-off: Load " + load);
				bl.lock();
				try {
					destination.dropOff(this, load);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				} finally {
					bl.unlock();
				}
			}
		}

	}
}
