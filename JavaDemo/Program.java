import java.util.*;

public class Program {
    public static void main(String[] args) {
        Bowling game = new Bowling();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            String input = sc.nextLine();
            String[] values = input.split(" ");
            String name = values[0];
            int points = Integer.parseInt(values[1]);
            game.addPlayer(name, points);
        }
        game.getWinner();
    }
}

class Bowling {
    HashMap<String, Integer> players;

    Bowling() {
        players = new HashMap<String, Integer>();
    }

    public void addPlayer(String name, int p) {
        players.put(name, p);
    }

    void getWinner() {
        Set<String> set = players.keySet();

        Iterator<String> it = set.iterator();

        Integer before = 0;

        String bef = "";

        while (it.hasNext()) {

            String Key = it.next();

            Integer func = players.get(Key);

            if (func > before) {
                before = func;

                bef = Key;

            }

        }

        System.out.println(bef);
    }

}
