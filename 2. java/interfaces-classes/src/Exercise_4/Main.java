import model.Advisor;
import model.TechnicalSupport;
import model.User;

public class Main {

  public static void main(String[] args) {
    User advisor = new Advisor("Angel", "Mentor of Medicine");
    User technicalSupport = new TechnicalSupport("Angel", "Support of TI");

    advisor.teach();
    advisor.doSupport();
    technicalSupport.study();
    technicalSupport.doSupport();
  }
}
