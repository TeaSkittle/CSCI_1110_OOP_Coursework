// (c) Travis Dowd
// Date: 6-1-2020

package Ex11_3;

public class Checkings extends Account {
	private double overdraft = -100;
	// remember to get date from parent class
	public Checkings( double overdraft ) {
		super();
		this.dateCreated = getDateCreated();
		this.overdraft = overdraft;
	}
	public Checkings( int id, double balance, double overdraft ) {
		super( id, balance );
		this.dateCreated = getDateCreated();
		this.overdraft = overdraft;
	}
	@Override
	public double withdraw( double amount ) {
		double total = getBalance();
		if  (( total - amount ) < overdraft ) {
			total -= amount;
			setBalance( total );
			return total;
		} else { return 0; }
	}
}
