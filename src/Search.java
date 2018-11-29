import java.util.Random;

public class Search {

  Cube2 startState;

  static String[] actionList = new String[]{"R", "R'", "L", "L'", "F", "F'", "U", "U'", "B", "B'",
      "D", "D'"};
  ;

  public Search(Cube2 startState) {
    this.startState = startState;
  }

  public void shuffle() {
    Random ran = new Random();
    for (int i = 0; i < 50; i++) {
      int index = ran.nextInt(12);
      this.shift(this.startState, actionList[index]);
    }
  }

  public void shift(Cube2 cube, String action) {
    switch (action.toUpperCase()) {
      case ("R"):

        int Rfront1 = cube.status[1][2];
        int Rfront3 = cube.status[3][2];

        cube.status[1][2] = cube.status[1][5];
        cube.status[3][2] = cube.status[3][5];

        cube.status[1][5] = cube.status[2][4];
        cube.status[3][5] = cube.status[0][4];

        cube.status[2][4] = cube.status[1][0];
        cube.status[0][4] = cube.status[3][0];

        cube.status[1][0] = Rfront1;
        cube.status[3][0] = Rfront3;

        int Rside1 = cube.status[0][3];
        cube.status[0][3] = cube.status[2][3];
        cube.status[2][3] = cube.status[3][3];
        cube.status[3][3] = cube.status[1][3];
        cube.status[1][3] = Rside1;

        break;

      case ("R'"):

        int Rpfront1 = cube.status[1][2];
        int Rpfront3 = cube.status[3][2];

        cube.status[1][2] = cube.status[1][0];
        cube.status[3][2] = cube.status[3][0];

        cube.status[1][0] = cube.status[2][4];
        cube.status[3][0] = cube.status[0][4];

        cube.status[2][4] = cube.status[1][5];
        cube.status[0][4] = cube.status[3][5];

        cube.status[1][5] = Rpfront1;
        cube.status[3][5] = Rpfront3;

        int Rpside1 = cube.status[0][3];
        cube.status[0][3] = cube.status[1][3];
        cube.status[1][3] = cube.status[3][3];
        cube.status[3][3] = cube.status[2][3];
        cube.status[2][3] = Rpside1;
        break;

      case ("L"):
        int Lfront0 = cube.status[0][2];
        int Lfront2 = cube.status[2][2];

        cube.status[0][2] = cube.status[0][0];
        cube.status[2][2] = cube.status[2][0];

        cube.status[0][0] = cube.status[3][4];
        cube.status[2][0] = cube.status[1][4];

        cube.status[3][4] = cube.status[0][5];
        cube.status[1][4] = cube.status[2][5];

        cube.status[0][5] = Lfront0;
        cube.status[2][5] = Lfront2;

        int Lside1 = cube.status[0][1];
        cube.status[0][3] = cube.status[2][3];
        cube.status[2][3] = cube.status[3][3];
        cube.status[3][3] = cube.status[1][3];
        cube.status[1][3] = Lside1;
        break;

      case ("L'"):

        break;

      case ("U"):
        break;

      case ("U'"):
        break;

      case ("F"):
        break;

      case ("F'"):
        break;

      case ("B"):
        break;

      case ("B'"):
        break;

      case ("D"):
        break;

      case ("D'"):
        break;
    }
  }

  public String OptmisticSearch() {
    return "";
  }
}
