import static java.util.Objects.hash;

import java.util.Random;

public class Cube2 {

  //stores the 2*2*2 cube status

  int[][] status;
  String actions;
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
    actions = "0";
  }

  public Cube2(int i){
    status = new int[4][6];
    actions = "0";
  }

  public boolean equals(Object o){
    if(!(o instanceof Cube2)){
      return false;
    }
    Cube2 another = (Cube2)o;
    return this.status.equals(another.status);
  }

  public int hashCode(){
    return hash(this.status);
  }

}

