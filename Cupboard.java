//Cupboard
//ICS4U1, Dip Tandel
//Nov 4, 2021

public class Cupboard {
  //Instance Variables
  private Jar j1;
  private Jar j2;
  private Jar j3;

  //constructor
  public Cupboard(Jar jar1, Jar jar2, Jar jar3) {
    j1 = jar1;
    j2 = jar2;
    j3 = jar3;
  }

  //accessors
  public Jar getPos(int pos) {
    if (pos == 1) {
      return j1;
    } else if (pos == 2) {
      return j2;
    } else if (pos == 3) {
      return j3;
    } else {
      return null;
    }
  }

  //mutators
  public void replace(int pos, Jar j4) {
    if (pos == 1) {
      j1 = j4;
    } else if (pos == 2) {
      j2 = j4;
    } else if (pos == 3) {
      j3 = j4;
    }
  }

  //toString
  public String toString() {
    return "1) " + j1 + "\n2) " + j2 + "\n3) " + j3;
  }
}
