import static java.util.Objects.hash;

import java.util.Random;

public class Cube2 {
  //stores the 2*2*2 cube status
  int[][] status;
  //initialize with
  //f:face c: cube
  //1111,2222,3333,4444,5555,6666
  public Cube2() {
    status = new int[4][6];
    for (int f = 0; f < 6; f++) {
      for (int c = 0; c < 4; c++) {
        status[c][f] = f + 1;
      }
    }
  }

  public Cube2(int i) {
    status = new int[4][6];
  }

  public boolean equals(Object o) {
    if (!(o instanceof Cube2)) {
      return false;
    }
    Cube2 another = (Cube2) o;
    return transferToBasic(this).status.equals(transferToBasic(another).status);
  }

  public int hashCode() {
    return hash(transferToBasic(this).status);
  }

  public static Cube2 transferToBasic(Cube2 cube) {
    Cube2 cubebasic = new Cube2();
    int[] temp = new int[]{0, 0, 0, 0, 0, 0};
    int count = 0;
    for (int f = 0; f < 6; f++) {
      for (int c = 0; c < 4; c++) {
        if (temp[cube.status[c][f] - 1] == 0) {
          count++;
          temp[cube.status[c][f] - 1] = count;
          cube.status[c][f] = count;
        } else {
          cube.status[c][f] = temp[cube.status[c][f] - 1];
        }
      }
    }
    cubebasic.status = cube.status;

    return cubebasic;
  }


  public static void printCube(Cube2 cube) {
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 4; j++) {
        System.out.print(cube.status[j][i]);
      }
      System.out.println();
    }
  }

}