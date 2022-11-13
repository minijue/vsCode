
public class Test {

    public static void swap(int a, int b) {
        int t = a;
        a = b;
        b = t;
    }

    public static void main(String[] args) {
        Role r1 = new Role();
        Role r2 = new Role();
        r1.hp = 300;
        
        r2.hp = 200;
        r1.attack(r2.hp);
        System.out.println(r2.hp);

        r2.hp = 200;
        r1.attack(r2);
        System.out.println(r2.hp);
    }

}

class Role {
    int hp;

    void attack(int other) {
        other -= 100;
    }

    void attack(Role other) {
        other.hp -= 100;
    }
}
