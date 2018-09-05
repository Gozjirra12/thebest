package advCS;

public class Pd5JustinKrisandaArrayBasedPoly implements Pd5JustinKrisandaPolynomial {
	private double [] poly; //value is coefficient, index is exponent
	
	public Pd5JustinKrisandaArrayBasedPoly(double [] poly) {
		this.poly=poly;
	}
	public Pd5JustinKrisandaArrayBasedPoly(double coeff,int exponent) {
		this.poly=new double [exponent+1]; 
		for(int i=0;i<=exponent;i++)
			poly[i]=0;
		poly[exponent]=coeff;
	}
	public int getDegree() {
		return poly.length-1;
	}
	public double getCoefficient(int exp) {
		return poly[exp];
	}
	public double evaluate(int x) {
		double sum=0;
		for(int i=0;i<poly.length;i++)
			sum+=Math.pow(x, i)*poly[i];
		return sum;
	}
	public Pd5JustinKrisandaPolynomial addPoly(Pd5JustinKrisandaPolynomial p) {
		int pSmall=0;
		int pLarge=0;
		if(this.getDegree()<=p.getDegree()) {
			pSmall=this.getDegree();
			pLarge=p.getDegree();
		}
		else if(this.getDegree()>p.getDegree()){
			pSmall=p.getDegree();
			pLarge=this.getDegree();
		}
		double [] poly2 = new double [pLarge+1];
		for(int i=0;i<=pSmall;i++) {
			poly2[i]=this.poly[i]+p.getCoefficient(i);
		}
		if(pLarge==this.getDegree()) {
			for(int j=pSmall+1;j<=pLarge;j++) {
				poly2[j]=this.getCoefficient(j);
			}
		} else {
			for(int k=pSmall;k<=pLarge;k++) {
				poly2[k]=p.getCoefficient(k);
			}
		}
		Pd5JustinKrisandaArrayBasedPoly plus = new Pd5JustinKrisandaArrayBasedPoly(poly2);
		return plus;
		
	}
	public Pd5JustinKrisandaPolynomial subtractPoly(Pd5JustinKrisandaPolynomial p) {
		int pSmall=0;
		int pLarge=0;
		if(this.getDegree()<=p.getDegree()) {
			pSmall=this.getDegree();
			pLarge=p.getDegree();
		}
		else if(this.getDegree()>p.getDegree()){
			pSmall=p.getDegree();
			pLarge=this.getDegree();
		}
		double [] poly2 = new double [pLarge+1];
		for(int i=0;i<=pSmall;i++) {
			poly2[i]=this.poly[i]-p.getCoefficient(i);
		}
		if(pLarge==this.getDegree()) {
			for(int j=pSmall+1;j<=pLarge;j++) {
				poly2[j]=this.getCoefficient(j);
			}
		} else {
			for(int k=pSmall;k<=pLarge;k++) {
				poly2[k]=p.getCoefficient(k);
			}
		}
		Pd5JustinKrisandaArrayBasedPoly minus = new Pd5JustinKrisandaArrayBasedPoly(poly2);
		return minus;
	}
	public Pd5JustinKrisandaPolynomial getDerivative() {
		double [] deriv = new double [this.getDegree()];
		for(int i=1;i<=this.getDegree();i++) {
			deriv[i-1]=this.poly[i]*i;
		}
		Pd5JustinKrisandaArrayBasedPoly derivative = new Pd5JustinKrisandaArrayBasedPoly(deriv);
		return derivative;
	}
	
	public String toString() {
		String s=""+this.getCoefficient(this.getDegree())+"x^"+this.getDegree();
		for(int i=this.getDegree()-1;i>=1;i--) {
			if(this.getCoefficient(i)!=0) {
				if(this.getCoefficient(i)<0)
					s+=" - "+Math.abs(this.getCoefficient(i))+"x^"+i;
				else if(this.getCoefficient(i)>0)
					s+=" + "+this.getCoefficient(i)+"x^"+i;
			}
		}
		if(this.getCoefficient(0)>0) 
			s+=" + "+this.getCoefficient(0);
		else if(this.getCoefficient(0)<0)
			s+=" - "+Math.abs(this.getCoefficient(0));
		return s;
	}
}
