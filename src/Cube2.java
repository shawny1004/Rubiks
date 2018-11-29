import java.util.Random;

public class Cube2 {

  //stores the 2*2*2 cube status

  int[][] status;

  String actions;

  public Cube2() {
    status = new int[4][6];
    for (int f = 0; f < 6; f++) {
      for (int c = 0; c < 4; c++) {
        status[c][f] = f + 1;
      }
    }
    actions = "";
  }


}

