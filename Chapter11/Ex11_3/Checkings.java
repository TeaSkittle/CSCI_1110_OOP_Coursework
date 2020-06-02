// (c) Travis Dowd
// (d) 6-1-2020

package Ex11_3;

public class Checkings extends Account {
	private double overdraft;
	public Checkings( double o ) {
		super();
		this.overdraft = o;
	}
	public Checkings( int id, double balance, double overdraft ) {
		super( id, balance );
		this.overdraft = overdraft;
	}
	@Override
	public double withdraw( double amount ) {
		double total = getBalance();
		if ( amount < ( total + overdraft ) ) {
			total -= amount;
			setBalance( total );
			return total;
		} else { return 0; }
	}
	public double getOverdraft() {
		return overdraft;
	}
}
