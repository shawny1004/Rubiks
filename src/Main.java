public class Main {

  public static void main(String[] args) {
    Cube2 c1 = new Cube2();
    c1= Search.shift(c1,'R');
    c1 = Search.shift(c1,'L');
    c1 = Cube2.transferToBasic(c1);
    Cube2.printCube(c1);

    System.out.println();
    Cube2 c2 = new Cube2();
    c2= Search.shift(c2,'F');
    c2 = Search.shift(c2,'B');
    c2 = Cube2.transferToBasic(c2);
    Cube2.printCube(c2);

  }
}
