public class QuadraticEquation {
    private double quadraticCoEff;
    private double linearCoEff;
    private double constant;

    public QuadraticEquation(double quadraticCoEff, double linearCoEff, double constant) {
        this.quadraticCoEff = quadraticCoEff;
        this.linearCoEff = linearCoEff;
        this.constant = constant;
    }

    public String solver() {

        //solver code copied from https://www.geeksforgeeks.org/java-program-to-find-the-roots-of-quadratic-equation/

        // declared the two roots
         double firstRoot, secondRoot;
  
         // determinant (b^2 - 4ac)
         double det = linearCoEff * linearCoEff - 4 * quadraticCoEff * constant;
  
         // check if determinant is greater than 0
         if (det > 0) {
  
             // two real and distinct roots
             firstRoot = (-linearCoEff + Math.sqrt(det)) / (2 * quadraticCoEff);
             secondRoot = (-linearCoEff - Math.sqrt(det)) / (2 * quadraticCoEff);
  
             return String.format(
                 "First Root = %.2f and Second Root = %.2f",
                 firstRoot, secondRoot);
         }
  
         // check if determinant is equal to 0
         else if (det == 0) {
  
             // two real and equal roots
             // determinant is equal to 0
             // so -b + 0 == -b
             firstRoot = secondRoot = -linearCoEff / (2 * quadraticCoEff);
  
             return String.format(
                 "First Root = Second Root = %.2f;",
                 firstRoot);
         }
  
         // if determinant is less than zero
         else {
  
             // roots are complex number and distinct
             double real = -linearCoEff / (2 * quadraticCoEff);
  
             double imaginary = Math.sqrt(-det) / (2 * quadraticCoEff);
  
             return String.format("First Root = %1$.2f+%2$.2fi%nSecond Root = %1$.2f-%2$.2fi", real, imaginary);
         }
     }
 }
