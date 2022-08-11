public class Main {
    public static void main(String[] args) {
        int size = 3;
	    Transport[] buses = new Transport[size];

        Filter fl = new Filter(size);
        Bakery bl = new Bakery(size);

        Venue destination = new Venue();

        for(int i = 0; i < size; i++){
//            buses[i] = new Transport(destination,fl);
            buses[i] = new Transport(destination,bl);
        }

        for(Transport bus : buses)
            bus.start();

    }
}
