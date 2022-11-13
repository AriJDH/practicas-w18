package Exercise_1.interfaces;

public interface Transactions {
  public static int getRandomNumber() {
    return (int) (Math.random() * 1);
  }

  public abstract void transactionOK(String trasactionType);

  public abstract void transactionNoOK(String trasactionType);
}
