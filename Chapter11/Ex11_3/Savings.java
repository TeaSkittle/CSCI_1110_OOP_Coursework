// (c) Travis Dowd
// (d) 6-1-2020

package Ex11_3;

public class Savings extends Account {
	public Savings() { 
		super();
	}
	public Savings( int id, double balance ) {
		this.setId( id );
		this.setBalance( balance );
	}
	@Override
	public double withdraw( double amount ) {
		double total = getBalance();
		if (( total - amount ) >= 0 ) {
			total -= amount;
			setBalance( total );
			return total;
		} else { return 0; }
	}
	
}
