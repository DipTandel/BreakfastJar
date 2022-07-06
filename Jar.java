//Jar
//ICS4U1, Dip Tandel
//Nov 3, 2021

public class Jar {
  //Instance Variables
  private String type;
  private int volumeTotal;
  private int volumeRemaining;
  private Boolean glass;

  //Default constructor if there are no parameters inputted
  public Jar() {
    type = "mystery";
    volumeTotal = 0;
    volumeRemaining = 0;
    glass = true;
  }

  //Constructor that makes Object of Jar with given parameters
  public Jar(String type, int volumeTotal, int volumeRemaining, Boolean glass) {
    this.type = type;
    this.volumeTotal = volumeTotal;
    this.volumeRemaining = volumeRemaining;
    this.glass = glass;
  }

  //mutators
  public void spread(int eat) {
    volumeRemaining = volumeRemaining - eat;
  }

  public void refill(int add) {
    volumeRemaining = volumeRemaining + add;
  }

  public void glass(Boolean change) {
    glass = change;
  }

  //accessors
  public String getType() {
    return type;
  }

  public int getVolumeRemaining() {
    return volumeRemaining;
  }

  public int getVolumeTotal() {
    return volumeTotal;
  }

  public Boolean getGlass() {
    return glass;
  }

  //toString
  public String toString() {
    String glas;
    if (glass == true) {
      glas = "Shiny Glass";
    } else {
      glas = "Dusty Plastic";
    }
    return (
      glas +
      " jar of " +
      type +
      ", " +
      volumeRemaining +
      "/" +
      volumeTotal +
      "ml remaining"
    );
  }
}
