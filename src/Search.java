import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class Search {

  Cube2 startState;

  static char[] actionList1 = new char[]{'R', 'r', 'L', 'l'};
  static char[] actionList2 = new char[]{'F', 'f', 'B', 'b'};
  static char[] actionList3 = new char[]{'U', 'u', 'D', 'd'};
  static char[] actionListAll = new char[]{'R', 'r', 'L', 'l', 'F', 'f', 'B', 'b', 'U',
      'u', 'D', 'd'};

  public Search(Cube2 startState) {
    this.startState = startState;
  }

  public void shuffle() {
    Random ran = new Random();
    for (int i = 0; i < 50; i++) {
      int index = ran.nextInt(12);
      this.startState = shift(this.startState, actionListAll[index]);
    }
  }

  public static Cube2 shift(Cube2 cube1, char action) {

    Cube2 cube = new Cube2(0);
    cube.status = cube1.status;
    cube.actions += (cube1.actions + action);

    switch (action) {
      case ('R'):

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

      case ('r'):

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

      case ('L'):
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
        cube.status[0][1] = cube.status[2][1];
        cube.status[2][1] = cube.status[3][1];
        cube.status[3][1] = cube.status[1][1];
        cube.status[1][1] = Lside1;
        break;

      case ('l'): //////

        int Lpfront0 = cube.status[0][2];
        int Lpfront2 = cube.status[2][2];

        cube.status[0][2] = cube.status[0][5];
        cube.status[2][2] = cube.status[2][5];

        cube.status[0][5] = cube.status[3][4];
        cube.status[2][5] = cube.status[1][4];

        cube.status[3][4] = cube.status[0][0];
        cube.status[1][4] = cube.status[2][0];

        cube.status[0][0] = Lpfront0;
        cube.status[2][0] = Lpfront2;

        int Lpside1 = cube.status[0][1];
        cube.status[0][1] = cube.status[2][1];
        cube.status[2][1] = cube.status[3][1];
        cube.status[3][1] = cube.status[4][1];
        cube.status[4][1] = Lpside1;

        break;

      case ('U'):
        int Ufront0 = cube.status[0][2];
        int Ufront1 = cube.status[1][2];

        cube.status[0][2] = cube.status[0][3];
        cube.status[1][2] = cube.status[1][3];

        cube.status[0][3] = cube.status[0][4];
        cube.status[1][3] = cube.status[1][4];

        cube.status[0][4] = cube.status[0][1];
        cube.status[1][4] = cube.status[1][1];

        cube.status[0][1] = Ufront0;
        cube.status[1][1] = Ufront1;

        int Uside0 = cube.status[1][0];
        cube.status[1][0] = cube.status[0][0];
        cube.status[0][0] = cube.status[2][0];
        cube.status[2][0] = cube.status[3][0];
        cube.status[3][0] = Uside0;
        break;

      case ('u'):
        int Upfront0 = cube.status[0][2];
        int Upfront1 = cube.status[1][2];

        cube.status[0][2] = cube.status[1][1];
        cube.status[1][2] = cube.status[0][1];

        cube.status[1][1] = cube.status[1][4];
        cube.status[0][1] = cube.status[0][4];

        cube.status[1][4] = cube.status[1][3];
        cube.status[0][4] = cube.status[0][3];

        cube.status[1][3] = Upfront1;
        cube.status[0][3] = Upfront0;

        int Upside0 = cube.status[1][0];
        cube.status[1][0] = cube.status[3][0];
        cube.status[3][0] = cube.status[2][0];
        cube.status[2][0] = cube.status[0][0];
        cube.status[0][0] = Upside0;
        break;

      case ('F'):
        int Ffront2 = cube.status[2][0];
        int Ffront3 = cube.status[3][0];

        cube.status[2][0] = cube.status[3][1];
        cube.status[3][0] = cube.status[1][1];

        cube.status[3][1] = cube.status[1][5];
        cube.status[1][1] = cube.status[0][5];

        cube.status[1][5] = cube.status[0][3];
        cube.status[0][5] = cube.status[2][3];

        cube.status[0][3] = Ffront2;
        cube.status[2][3] = Ffront3;

        int Fside2 = cube.status[0][2];
        cube.status[0][2] = cube.status[2][2];
        cube.status[2][2] = cube.status[3][2];
        cube.status[3][2] = cube.status[1][2];
        cube.status[1][2] = Fside2;
        break;

      case ('f'):
        int Fpfront2 = cube.status[2][0];
        int Fpfront3 = cube.status[3][0];

        cube.status[2][0] = cube.status[0][3];
        cube.status[3][0] = cube.status[2][3];

        cube.status[0][3] = cube.status[1][5];
        cube.status[2][3] = cube.status[0][5];

        cube.status[1][5] = cube.status[3][1];
        cube.status[0][5] = cube.status[1][1];

        cube.status[3][1] = Fpfront2;
        cube.status[1][1] = Fpfront3;

        int Fpside2 = cube.status[0][2];
        cube.status[0][2] = cube.status[1][2];
        cube.status[1][2] = cube.status[3][2];
        cube.status[3][2] = cube.status[2][2];
        cube.status[2][2] = Fpside2;
        break;

      case ('B'):
        int Bfront0 = cube.status[0][0];
        int Bfront1 = cube.status[1][0];

        cube.status[0][0] = cube.status[1][3];
        cube.status[1][0] = cube.status[3][3];

        cube.status[1][3] = cube.status[3][5];
        cube.status[3][3] = cube.status[2][5];

        cube.status[3][5] = cube.status[2][1];
        cube.status[2][5] = cube.status[0][1];

        cube.status[2][1] = Bfront0;
        cube.status[0][1] = Bfront1;

        int Bside4 = cube.status[0][4];
        cube.status[0][4] = cube.status[2][4];
        cube.status[2][4] = cube.status[3][4];
        cube.status[3][4] = cube.status[1][4];
        cube.status[1][4] = Bside4;

        break;

      case ('b'):
        int Bpfront0 = cube.status[0][0];
        int Bpfront1 = cube.status[1][0];

        cube.status[0][0] = cube.status[2][1];
        cube.status[1][0] = cube.status[0][1];

        cube.status[2][1] = cube.status[2][5];
        cube.status[0][1] = cube.status[3][5];

        cube.status[2][5] = cube.status[3][3];
        cube.status[3][5] = cube.status[1][3];

        cube.status[3][3] = Bpfront1;
        cube.status[1][3] = Bpfront0;

        int Bpside4 = cube.status[0][4];
        cube.status[0][4] = cube.status[1][4];
        cube.status[1][4] = cube.status[3][4];
        cube.status[3][4] = cube.status[2][4];
        cube.status[2][4] = Bpside4;
        break;

      case ('D'):
        int Dfront2 = cube.status[2][2];
        int Dfront3 = cube.status[3][2];

        cube.status[2][2] = cube.status[2][1];
        cube.status[3][2] = cube.status[3][1];

        cube.status[2][1] = cube.status[2][4];
        cube.status[3][1] = cube.status[3][4];

        cube.status[2][4] = cube.status[2][3];
        cube.status[3][4] = cube.status[3][3];

        cube.status[2][3] = Dfront2;
        cube.status[3][3] = Dfront3;

        int Dside5 = cube.status[0][5];
        cube.status[0][5] = cube.status[2][5];
        cube.status[2][5] = cube.status[3][5];
        cube.status[3][5] = cube.status[1][5];
        cube.status[1][5] = Dside5;
        break;

      case ('d'):
        int Dpfront2 = cube.status[2][2];
        int Dpfront3 = cube.status[3][2];

        cube.status[2][2] = cube.status[2][3];
        cube.status[3][2] = cube.status[3][3];

        cube.status[2][3] = cube.status[2][4];
        cube.status[3][3] = cube.status[3][4];

        cube.status[2][4] = cube.status[2][1];
        cube.status[3][4] = cube.status[3][1];

        cube.status[2][1] = Dpfront2;
        cube.status[3][1] = Dpfront3;

        int Dpside5 = cube.status[0][5];
        cube.status[0][5] = cube.status[1][5];
        cube.status[1][5] = cube.status[3][5];
        cube.status[3][5] = cube.status[2][5];
        cube.status[2][5] = Dpside5;
        break;
    }

    return cube;
  }

  public static String optmisticSearch(Search search) {
    Queue<Cube2> fringe = new LinkedList<Cube2>();
    fringe.add(search.startState);
    Cube2 current = ((LinkedList<Cube2>) fringe).pollFirst();
    Set<Cube2> visited = new HashSet<>();
    int count = 0;
    char lastAction;
    while (!checkAllSuccess(current)) {
      if (visited.contains(current)) {
        continue;
      }
      lastAction = current.actions.charAt(current.actions.length() - 1);
      if (lastAction == '0') {
        for (char c : actionListAll) {
          ((LinkedList<Cube2>) fringe).add(Search.shift(current, c));
        }
      } else if (catergorizeAction(lastAction) == 1) {
        for (char c : actionList2) {
          ((LinkedList<Cube2>) fringe).add(Search.shift(current, c));
        }
        for (char c : actionList3) {
          ((LinkedList<Cube2>) fringe).add(Search.shift(current, c));
        }
      } else if (catergorizeAction(lastAction) == 2) {
        for (char c : actionList1) {
          ((LinkedList<Cube2>) fringe).add(Search.shift(current, c));
        }
        for (char c : actionList3) {
          ((LinkedList<Cube2>) fringe).add(Search.shift(current, c));
        }

      } else if (catergorizeAction(lastAction) == 3) {
        for (char c : actionList1) {
          ((LinkedList<Cube2>) fringe).add(Search.shift(current, c));
        }
        for (char c : actionList2) {
          ((LinkedList<Cube2>) fringe).add(Search.shift(current, c));
        }
      }
      current = ((LinkedList<Cube2>) fringe).pollFirst();

      count++;
      if (count % 1000 == 0) {
        System.out.println("searched " + count + " times");
      }
    }
    return current.actions;
  }


  public static boolean checkAllSuccess(Cube2 current) {
    for (int i = 0; i < 6; i++) {
      for (int j = 1; j < 4; j++) {
        if (current.status[j - 1][i] != current.status[j][i]) {
          return false;
        }
      }
    }
    return true;
  }

  public static int catergorizeAction(char c) {
    if (c == 'R' || c == 'r' || c == 'L' || c == 'l') {
      return 1;
    }
    if (c == 'F' || c == 'f' || c == 'B' || c == 'b') {
      return 2;
    }
    if (c == 'U' || c == 'u' || c == 'D' || c == 'd') {
      return 3;
    }
    return 0;
  }
}
