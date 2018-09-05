package advCS;

public class Pd5JustinKrisandaArrayBasedPolyDriver {
	public static void main (String [] args) {
		double [] c = {1, 0, 3, 4};
		double [] c1 = {-2, -5};
		Pd5JustinKrisandaPolynomial p1 = new Pd5JustinKrisandaArrayBasedPoly (c); // 4x^3 + 3x^2 + 1
		System.out.println("p1(x) = " + p1);
		Pd5JustinKrisandaPolynomial p2 = new Pd5JustinKrisandaArrayBasedPoly (c1); // - 5x – 2
		System.out.println("p2(x) = " + p2); // p2(x) = - 5x^1 – 2
		Pd5JustinKrisandaPolynomial p3 = new Pd5JustinKrisandaArrayBasedPoly(-4, 1); // coeff, exp = -4x
		System.out.println("p3(x) = " + p3);
		Pd5JustinKrisandaPolynomial p = p1.addPoly(p2).addPoly(p2); // 4x^3 + 3x^2 - 10x – 3
		System.out.println("p(x) = " + p); // p(x) = 4x^3 + 3x^2 - 10x^1 – 3
		Pd5JustinKrisandaPolynomial p4 = p.subtractPoly(p3); // 4x^3 + 3x^2 - 5x^1 – 1
		System.out.println("p4(x) = " + p4);
		Pd5JustinKrisandaPolynomial p5 = p4.getDerivative(); // 12x^2 + 6x^1 - 5
		System.out.println("p5(x) = " + p5);
		System.out.println ("p5(0) = " + p5.evaluate(0));
		System.out.println ("p5(1) = " + p5.evaluate(1));
	}
}

//OUTPUT
/*p1(x) = 4.0x^3 + 3.0x^2 + 1.0
p2(x) = -5.0x^1 -2.0
p3(x) = -4.0x^1
p(x) = 4.0x^3 + 3.0x^2 -10.0x^1 -3.0
p4(x) = 4.0x^3 + 3.0x^2 -6.0x^1 -3.0
p5(x) = 12.0x^2 + 6.0x^1 -6.0
p5(0) = -6.0
p5(1) = 12.0
*/
