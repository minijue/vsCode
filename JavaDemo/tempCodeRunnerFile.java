import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class tempCodeRunnerFile {
    /**
     * @param args
     */
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        
        HashMap<String, Integer> ages = new HashMap<String, Integer>();
        ages.put("David", 22);
        ages.put("Tom", 23);
        ages.put("Robert", 32);
        ages.put("Alice", 21);
        ages.put("Sophie", 19);
        ages.put("Maria", 24);
        ages.put("John", 28);
        
        
        String[] nameArr = new String[ages.size()];
        nameArr = ages.keySet().toArray(nameArr);
        Arrays.sort(nameArr);
        
        int ageLimit = scanner.nextInt();
        
        for (String emp : nameArr){
            //your code goes here
            if (ages.get(emp)<ageLimit)
                ages.remove(emp);
            else
                System.out.println(ages.get(emp));            
        }        
    }
}