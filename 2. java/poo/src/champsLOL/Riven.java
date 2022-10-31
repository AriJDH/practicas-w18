package champsLOL;

public class Riven extends Champions {
  private String description;

  public Riven(
    String name,
    String skillQ,
    String skillW,
    String skillE,
    String skillR,
    String description
  ) {
    super(name, skillQ, skillW, skillE, skillR);
    this.description = description;
  }

  @Override
  public void showDataChampion() {
      // TODO Auto-generated method stub
      System.out.println("Champion description is: " + description);
      super.showDataChampion();
      
  }
}
