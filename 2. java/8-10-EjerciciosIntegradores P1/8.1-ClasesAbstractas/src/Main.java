public class Main {
    public static void main(String[] args) {
        UI ui = new UI(0, new PrototypeOne(0.00, 0.00, 0.00), new PrototypeTwo(0,0,0));
        ui.startSystem();
    }
}