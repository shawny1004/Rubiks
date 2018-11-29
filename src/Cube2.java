import java.util.Random;

public class Cube2 {

  //stores the 2*2*2 cube status

  int[][] status;
  String[] actionList;

  public Cube2() {
    status = new int[4][6];
    for (int f = 0; f < 6; f++) {
      for (int c = 0; c < 4; c++) {
        status[c][f] = f + 1;
      }
    }
    actionList = new String[]{"R","R'","L","L'","F","F'","U","U'","B","B'","D","D'"};
  }


  public void shuffle(){
    Random ran = new Random();
    for(int i=0;i<50;i++){
      int index = ran.nextInt(12);
      this.shift(actionList[index]);
    }
  }

  public void shift(String action){
    switch(action.toUpperCase()){
      case("R"):

        int Rfront1 = status[1][2];
        int Rfront3 = status[3][2];

        status[1][2]=status[1][5];
        status[3][2]=status[3][5];

        status[1][5]=status[2][4];
        status[3][5]=status[0][4];

        status[2][4]=status[1][0];
        status[0][4]=status[3][0];

        status[1][0]=Rfront1;
        status[3][0]=Rfront3;

        int Rside1 = status[0][3];
        status[0][3] = status[2][3];
        status[2][3] = status[3][3];
        status[3][3] = status[1][3];
        status[1][3] = Rside1;

        break;

      case("R'"):

        int Rpfront1 = status[1][2];
        int Rpfront3 = status[3][2];

        status[1][2]=status[1][0];
        status[3][2]=status[3][0];

        status[1][0]=status[2][4];
        status[3][0]=status[0][4];

        status[2][4]=status[1][5];
        status[0][4]=status[3][5];

        status[1][5]=Rpfront1;
        status[3][5]=Rpfront3;

        int Rpside1 = status[0][3];
        status[0][3] = status[1][3];
        status[1][3] = status[3][3];
        status[3][3] = status[2][3];
        status[2][3] = Rpside1;
        break;

      case("L"):
        int Lfront0 = status[0][2];
        int Lfront2 = status[2][2];

        status[0][2]=status[0][0];
        status[2][2]=status[2][0];

        status[0][0]=status[3][4];
        status[2][0]=status[1][4];

        status[3][4]=status[0][5];
        status[1][4]=status[2][5];

        status[0][5]=Lfront0;
        status[2][5]=Lfront2;

        int Lside1 = status[0][1];
        status[0][3] = status[2][3];
        status[2][3] = status[3][3];
        status[3][3] = status[1][3];
        status[1][3] = Lside1;
        break;

      case("L'"):

        int Lfront0 = status[0][2];
        int Lfront2 = status[2][2];

        status[0][2]=status[0][0];
        status[2][2]=status[2][0];

        status[0][0]=status[3][4];
        status[2][0]=status[1][4];

        status[3][4]=status[0][5];
        status[1][4]=status[2][5];

        status[0][5]=Lfront0;
        status[2][5]=Lfront2;

        int Lside1 = status[0][1];
        status[0][3] = status[2][3];
        status[2][3] = status[3][3];
        status[3][3] = status[1][3];
        status[1][3] = Lside1;

        break;

      case("U"):
        break;

      case("U'"):
        break;

      case("F"):
        break;

      case("F'"):
        break;

      case("B"):
        break;

      case("B'"):
        break;

      case("D"):
        break;

      case("D'"):
        break;
    }
  }


}

