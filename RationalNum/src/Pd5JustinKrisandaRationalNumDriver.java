public class Pd5JustinKrisandaRationalNumDriver {
   public static void main(String [] args) {
      Pd5JustinKrisandaRationalNum r1 = new Pd5JustinKrisandaRationalNum(52, 36);
      System.out.println("r1 = " + r1);
      System.out.println("r1 simplified = " + Pd5JustinKrisandaRationalNum.simplify(r1));
      
      Pd5JustinKrisandaRationalNum r2 = new Pd5JustinKrisandaRationalNum(7, 39);
      r2.setDenom(0);
      System.out.println("r2 = " + r2 + "\n");
      r2.setDenom(14);

      System.out.println("r2 = " + r2 + "\n");
      System.out.println("r1 + r2: " + r1.add(r2));     
      System.out.println("r1 - r2: " + r1.subtract(r2));
      System.out.println("r1 * r2: " + r1.multiply(r2));
      System.out.println("r1 / r2: " + r1.divide(r2));
      System.out.println("r1 equals r2: " + r1.equals(r2));
   }
  }
