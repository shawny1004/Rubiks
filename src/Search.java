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
    switch(action.toUpperCase()){
      case("R"):

        int Rfront1 = cube.status[1][2];
        int Rfront3 = cube.status[3][2];

        cube.status[1][2]=cube.status[1][5];
        cube.status[3][2]=cube.status[3][5];

        cube.status[1][5]=cube.status[2][4];
        cube.status[3][5]=cube.status[0][4];

        cube.status[2][4]=cube.status[1][0];
        cube.status[0][4]=cube.status[3][0];

        cube.status[1][0]=Rfront1;
        cube.status[3][0]=Rfront3;

        int Rside1 = cube.status[0][3];
        cube.status[0][3] = cube.status[2][3];
        cube.status[2][3] = cube.status[3][3];
        cube.status[3][3] = cube.status[1][3];
        cube.status[1][3] = Rside1;

        break;

      case("R'"):

        int Rpfront1 = cube.status[1][2];
        int Rpfront3 = cube.status[3][2];

        cube.status[1][2]=cube.status[1][0];
        cube.status[3][2]=cube.status[3][0];

        cube.status[1][0]=cube.status[2][4];
        cube.status[3][0]=cube.status[0][4];

        cube.status[2][4]=cube.status[1][5];
        cube.status[0][4]=cube.status[3][5];

        cube.status[1][5]=Rpfront1;
        cube.status[3][5]=Rpfront3;

        int Rpside1 = cube.status[0][3];
        cube.status[0][3] = cube.status[1][3];
        cube.status[1][3] = cube.status[3][3];
        cube.status[3][3] = cube.status[2][3];
        cube.status[2][3] = Rpside1;
        break;

      case("L"):
        int Lfront0 = cube.status[0][2];
        int Lfront2 = cube.status[2][2];

        cube.status[0][2]=cube.status[0][0];
        cube.status[2][2]=cube.status[2][0];

        cube.status[0][0]=cube.status[3][4];
        cube.status[2][0]=cube.status[1][4];

        cube.status[3][4]=cube.status[0][5];
        cube.status[1][4]=cube.status[2][5];

        cube.status[0][5]=Lfront0;
        cube.status[2][5]=Lfront2;

        int Lside1 = cube.status[0][1];
        cube.status[0][1] = cube.status[2][1];
        cube.status[2][1] = cube.status[3][1];
        cube.status[3][1] = cube.status[1][1];
        cube.status[1][1] = Lside1;
        break;

      case("L'"): //////

        int Lpfront0 = cube.status[0][2];
        int Lpfront2 = cube.status[2][2];

        cube.status[0][2]=cube.status[0][5];
        cube.status[2][2]=cube.status[2][5];

        cube.status[0][5]=cube.status[3][4];
        cube.status[2][5]=cube.status[1][4];

        cube.status[3][4]=cube.status[0][0];
        cube.status[1][4]=cube.status[2][0];

        cube.status[0][0]=Lpfront0;
        cube.status[2][0]=Lpfront2;

        int Lpside1 = cube.status[0][1];
        cube.status[0][1] = cube.status[2][1];
        cube.status[2][1] = cube.status[3][1];
        cube.status[3][1] = cube.status[4][1];
        cube.status[4][1] = Lpside1;

        break;

      case("U"):
        int Ufront0 = cube.status[0][2];
        int Ufront1 = cube.status[1][2];

        cube.status[0][2]=cube.status[0][3];
        cube.status[1][2]=cube.status[1][3];

        cube.status[0][3]=cube.status[0][4];
        cube.status[1][3]=cube.status[1][4];

        cube.status[0][4]=cube.status[0][1];
        cube.status[1][4]=cube.status[1][1];

        cube.status[0][1]=Ufront0;
        cube.status[1][1]=Ufront1;

        int Uside0 = cube.status[1][0];
        cube.status[1][0] = cube.status[0][0];
        cube.status[0][0] = cube.status[2][0];
        cube.status[2][0] = cube.status[3][0];
        cube.status[3][0] = Uside0;
        break;



      case("U'"):
        int Upfront0 = cube.status[0][2];
        int Upfront1 = cube.status[1][2];

        cube.status[0][2]=cube.status[1][1];
        cube.status[1][2]=cube.status[0][1];

        cube.status[1][1]=cube.status[1][4];
        cube.status[0][1]=cube.status[0][4];

        cube.status[1][4]=cube.status[1][3];
        cube.status[0][4]=cube.status[0][3];

        cube.status[1][3]=Upfront1;
        cube.status[0][3]=Upfront0;

        int Upside0 = cube.status[1][0];
        cube.status[1][0] = cube.status[3][0];
        cube.status[3][0] = cube.status[2][0];
        cube.status[2][0] = cube.status[0][0];
        cube.status[0][0] = Upside0;
        break;

      case("F"):
        int Ffront2 = cube.status[2][0];
        int Ffront3 = cube.status[3][0];

        cube.status[2][0]=cube.status[3][1];
        cube.status[3][0]=cube.status[1][1];

        cube.status[3][1]=cube.status[1][5];
        cube.status[1][1]=cube.status[0][5];

        cube.status[1][5]=cube.status[0][3];
        cube.status[0][5]=cube.status[2][3];

        cube.status[0][3]=Ffront2;
        cube.status[2][3]=Ffront3;

        int Fside2 = cube.status[0][2];
        cube.status[0][2] = cube.status[2][2];
        cube.status[2][2] = cube.status[3][2];
        cube.status[3][2] = cube.status[1][2];
        cube.status[1][2] = Fside2;
        break;

      case("F'"):
        int Fpfront2 = cube.status[2][0];
        int Fpfront3 = cube.status[3][0];

        cube.status[2][0]=cube.status[0][3];
        cube.status[3][0]=cube.status[2][3];

        cube.status[0][3]=cube.status[1][5];
        cube.status[2][3]=cube.status[0][5];

        cube.status[1][5]=cube.status[3][1];
        cube.status[0][5]=cube.status[1][1];

        cube.status[3][1]=Fpfront2;
        cube.status[1][1]=Fpfront3;

        int Fpside2 = cube.status[0][2];
        cube.status[0][2] = cube.status[1][2];
        cube.status[1][2] = cube.status[3][2];
        cube.status[3][2] = cube.status[2][2];
        cube.status[2][2] = Fpside2;
        break;

      case("B"):
        int Bfront0 = cube.status[0][0];
        int Bfront1 = cube.status[1][0];

        cube.status[0][0]=cube.status[1][3];
        cube.status[1][0]=cube.status[3][3];

        cube.status[1][3]=cube.status[3][5];
        cube.status[3][3]=cube.status[2][5];

        cube.status[3][5]=cube.status[2][1];
        cube.status[2][5]=cube.status[0][1];

        cube.status[2][1]=Bfront0;
        cube.status[0][1]=Bfront1;

        int Bside4 = cube.status[0][4];
        cube.status[0][4] = cube.status[2][4];
        cube.status[2][4] = cube.status[3][4];
        cube.status[3][4] = cube.status[1][4];
        cube.status[1][4] = Bside4;

        break;

      case("B'"):
        int Bpfront0 = cube.status[0][0];
        int Bpfront1 = cube.status[1][0];

        cube.status[0][0]=cube.status[2][1];
        cube.status[1][0]=cube.status[0][1];

        cube.status[2][1]=cube.status[2][5];
        cube.status[0][1]=cube.status[3][5];

        cube.status[2][5]=cube.status[3][3];
        cube.status[3][5]=cube.status[1][3];

        cube.status[3][3]=Bpfront1;
        cube.status[1][3]=Bpfront0;

        int Bpside4 = cube.status[0][4];
        cube.status[0][4] = cube.status[1][4];
        cube.status[1][4] = cube.status[3][4];
        cube.status[3][4] = cube.status[2][4];
        cube.status[2][4] = Bpside4;
        break;

      case("D"):
        int Dfront2 = cube.status[2][2];
        int Dfront3 = cube.status[3][2];

        cube.status[2][2]=cube.status[2][1];
        cube.status[3][2]=cube.status[3][1];

        cube.status[2][1]=cube.status[2][4];
        cube.status[3][1]=cube.status[3][4];

        cube.status[2][4]=cube.status[2][3];
        cube.status[3][4]=cube.status[3][3];

        cube.status[2][3]=Dfront2;
        cube.status[3][3]=Dfront3;

        int Dside5 = cube.status[0][5];
        cube.status[0][5] = cube.status[2][5];
        cube.status[2][5] = cube.status[3][5];
        cube.status[3][5] = cube.status[1][5];
        cube.status[1][5] = Dside5;
        break;

      case("D'"):
        int Dpfront2 = cube.status[2][2];
        int Dpfront3 = cube.status[3][2];

        cube.status[2][2]=cube.status[2][3];
        cube.status[3][2]=cube.status[3][3];

        cube.status[2][3]=cube.status[2][4];
        cube.status[3][3]=cube.status[3][4];

        cube.status[2][4]=cube.status[2][1];
        cube.status[3][4]=cube.status[3][1];

        cube.status[2][1]=Dpfront2;
        cube.status[3][1]=Dpfront3;

        int Dpside5 = cube.status[0][5];
        cube.status[0][5] = cube.status[1][5];
        cube.status[1][5] = cube.status[3][5];
        cube.status[3][5] = cube.status[2][5];
        cube.status[2][5] = Dpside5;
        break;
    }
  }

  public String OptmisticSearch() {
    return "";
  }
}
