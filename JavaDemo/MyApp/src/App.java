public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public static void fighting(Role r1, Role r2) {

    }
}

class Role {
    int hp;

    void attack(Role r) {
        r.hp -= 20;
    }
}