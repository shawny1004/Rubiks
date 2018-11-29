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
<<<<<<< HEAD
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
        status[0][1] = status[2][1];
        status[2][1] = status[3][1];
        status[3][1] = status[1][1];
        status[1][1] = Lside1;
        break;

      case("L'"): //////

        int Lpfront0 = status[0][2];
        int Lpfront2 = status[2][2];

        status[0][2]=status[0][5];
        status[2][2]=status[2][5];

        status[0][5]=status[3][4];
        status[2][5]=status[1][4];

        status[3][4]=status[0][0];
        status[1][4]=status[2][0];

        status[0][0]=Lpfront0;
        status[2][0]=Lpfront2;

        int Lpside1 = status[0][1];
        status[0][1] = status[2][1];
        status[2][1] = status[3][1];
        status[3][1] = status[4][1];
        status[4][1] = Lpside1;

        break;

      case("U"):
        int Ufront0 = status[0][2];
        int Ufront1 = status[1][2];

        status[0][2]=status[0][3];
        status[1][2]=status[1][3];

        status[0][3]=status[0][4];
        status[1][3]=status[1][4];

        status[0][4]=status[0][1];
        status[1][4]=status[1][1];

        status[0][1]=Ufront0;
        status[1][1]=Ufront1;

        int Uside0 = status[1][0];
        status[1][0] = status[0][0];
        status[0][0] = status[2][0];
        status[2][0] = status[3][0];
        status[3][0] = Uside0;
        break;



      case("U'"):
        int Upfront0 = status[0][2];
        int Upfront1 = status[1][2];

        status[0][2]=status[1][1];
        status[1][2]=status[0][1];

        status[1][1]=status[1][4];
        status[0][1]=status[0][4];

        status[1][4]=status[1][3];
        status[0][4]=status[0][3];

        status[1][3]=Upfront1;
        status[0][3]=Upfront0;

        int Upside0 = status[1][0];
        status[1][0] = status[3][0];
        status[3][0] = status[2][0];
        status[2][0] = status[0][0];
        status[0][0] = Upside0;
        break;

      case("F"):
        int Ffront2 = status[2][0];
        int Ffront3 = status[3][0];

        status[2][0]=status[3][1];
        status[3][0]=status[1][1];

        status[3][1]=status[1][5];
        status[1][1]=status[0][5];

        status[1][5]=status[0][3];
        status[0][5]=status[2][3];

        status[0][3]=Ffront2;
        status[2][3]=Ffront3;

        int Fpside2 = status[0][2];
        status[0][2] = status[2][2];
        status[2][2] = status[3][2];
        status[3][2] = status[1][2];
        status[1][2] = Fpside2;
        break;

      case("F'"):
        int Ffront2 = status[2][0];
        int Ffront3 = status[3][0];

        status[2][0]=status[0][3];
        status[3][0]=status[2][3];

        status[0][3]=status[1][5];
        status[2][3]=status[0][5];

        status[1][5]=status[3][1];
        status[0][5]=status[1][1];

        status[3][1]=Ffront2;
        status[1][1]=Ffront3;

        int Fpside2 = status[0][2];
        status[0][2] = status[1][2];
        status[1][2] = status[3][2];
        status[3][2] = status[2][2];
        status[2][2] = Fpside2;
        break;

      case("B"):
        int Bfront0 = status[0][0];
        int Bfront1 = status[1][0];

        status[0][0]=status[1][3];
        status[1][0]=status[3][3];

        status[1][3]=status[3][5];
        status[3][3]=status[2][5];

        status[3][5]=status[2][1];
        status[2][5]=status[0][1];

        status[2][1]=Bfront0;
        status[0][1]=Bfront1;

        int Bside4 = status[0][4];
        status[0][4] = status[2][4];
        status[2][4] = status[3][4];
        status[3][4] = status[1][4];
        status[1][4] = Bside4;

        break;

      case("B'"):
        int Bpfront0 = status[0][0];
        int Bpfront1 = status[1][0];

        status[0][0]=status[2][1];
        status[1][0]=status[0][1];

        status[2][1]=status[2][5];
        status[0][1]=status[3][5];

        status[2][5]=status[3][3];
        status[3][5]=status[1][3];

        status[3][3]=Bpfront1;
        status[1][3]=Bpfront0;

        int Bpside4 = status[0][4];
        status[0][4] = status[1][4];
        status[1][4] = status[3][4];
        status[3][4] = status[2][4];
        status[2][4] = Bpside4;
        break;

      case("D"):
        int Dfront2 = status[2][2];
        int Dfront3 = status[3][2];

        status[2][2]=status[2][1];
        status[3][2]=status[3][1];

        status[2][1]=status[2][4];
        status[3][1]=status[3][4];

        status[2][4]=status[2][3];
        status[3][4]=status[3][3];

        status[2][3]=Dfront2;
        status[3][3]=Dfront3;

        int Dside5 = status[0][5];
        status[0][5] = status[2][5];
        status[2][5] = status[3][5];
        status[3][5] = status[1][5];
        status[1][5] = Dside5;
        break;

      case("D'"):
        int Dpfront2 = status[2][2];
        int Dpfront3 = status[3][2];

        status[2][2]=status[2][3];
        status[3][2]=status[3][3];

        status[2][3]=status[2][4];
        status[3][3]=status[3][4];

        status[2][4]=status[2][1];
        status[3][4]=status[3][1];

        status[2][1]=Dpfront2;
        status[3][1]=Dpfront3;

        int Dpside5 = status[0][5];
        status[0][5] = status[1][5];
        status[1][5] = status[3][5];
        status[3][5] = status[2][5];
        status[2][5] = Dpside5;
        break;
    }
=======
    actions = "";
>>>>>>> 19ba31b83b7487a89b44d9cbb44b691795e14315
  }


}

