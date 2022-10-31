package champsLOL;

public class Champions {
  String championName;
  String skillQ, skillW, skillE, skillR;

  public Champions(
    String championName,
    String skillQ,
    String skillW,
    String skillE,
    String skillR
  ) {
    this.championName = championName;
    this.skillQ = skillQ;
    this.skillW = skillW;
    this.skillE = skillE;
    this.skillR = skillR;
  }

  public void setDataChampion(
    String championName,
    String skillQ,
    String skillW,
    String skillE,
    String skillR
  ) {
    this.championName = championName;
    this.skillQ = skillQ;
    this.skillW = skillW;
    this.skillE = skillE;
    this.skillR = skillR;
  }

  public void getDataChampion() {
    System.out.println(
      "Skill Q: " +
      this.skillQ +
      "Skill W: " +
      this.skillW +
      "Skill E: " +
      this.skillE +
      "Skill R: " +
      this.skillR
    );
  }


  public void showDataChampion() {
    System.out.println(
      "Skill Q: " +
      this.skillQ +
      " Skill W: " +
      this.skillW +
      " Skill E: " +
      this.skillE +
      " Skill R: " +
      this.skillR
    );
  }
}
