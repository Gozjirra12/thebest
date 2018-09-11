package advCS;

public interface Pd5JustinKrisandaPolynomial {
    int getDegree();
	double getCoefficient(int exp);
	double evaluate(int x);
	Pd5JustinKrisandaPolynomial addPoly(Pd5JustinKrisandaPolynomial p);
	Pd5JustinKrisandaPolynomial subtractPoly(Pd5JustinKrisandaPolynomial p);
	Pd5JustinKrisandaPolynomial getDerivative();
}
