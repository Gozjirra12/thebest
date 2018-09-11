
public class Pd5JustinKrisandaRationalNum {
	private int numer, denom;

	public Pd5JustinKrisandaRationalNum(int numer, int denom) { 
		this.numer=numer;
		this.denom=denom;
	}
	public Pd5JustinKrisandaRationalNum(Pd5JustinKrisandaRationalNum copy) {
		this.numer=copy.numer;
		this.denom=copy.denom;
	}
	public static Pd5JustinKrisandaRationalNum simplify(Pd5JustinKrisandaRationalNum param) {
		int n=param.getNumer();
		int d=param.getDenom();
		int g=gcd(n,d);	
		param.setNumer(n/g);
		param.setDenom(d/g);
		return param;		
	}
	public int getNumer() {
		return numer;
	}
	public int getDenom() {
		return denom;
	}
	public void setNumer(int num) {
		this.numer=num;
	}
	public void setDenom(int den) {
		this.denom=den;
	}
	public static int gcd(int a,int b) {
		if(b==0)
			return a;
		else
			return gcd(b,a%b);
	}
	public Pd5JustinKrisandaRationalNum add(Pd5JustinKrisandaRationalNum other) {
		int newNumer = this.numer*other.denom+other.numer;
		int newDenom = this.denom*other.denom;
		Pd5JustinKrisandaRationalNum r3 = new Pd5JustinKrisandaRationalNum(newNumer,newDenom); 
		return simplify(r3); 
	}
	public Pd5JustinKrisandaRationalNum subtract(Pd5JustinKrisandaRationalNum other) {
		Pd5JustinKrisandaRationalNum r3 = new Pd5JustinKrisandaRationalNum(this.numer * other.denom - other.numer * this.denom, this.denom * other.denom);
		return simplify(r3);
	}
	public Pd5JustinKrisandaRationalNum multiply(Pd5JustinKrisandaRationalNum other) {
		Pd5JustinKrisandaRationalNum r3 = new Pd5JustinKrisandaRationalNum(this.numer * other.numer, this.denom * other.denom);
		return simplify(r3);
	}
	public Pd5JustinKrisandaRationalNum divide(Pd5JustinKrisandaRationalNum other) {
		Pd5JustinKrisandaRationalNum r3 = new Pd5JustinKrisandaRationalNum(this.numer * other.denom, this.denom * other.numer);
		return simplify(r3);
	}
	public boolean equals(Object other) {
		if (this == other)
			return true;
		return false;
	}
	public String toString() {
		return numer + "/" + denom;
	}
}
