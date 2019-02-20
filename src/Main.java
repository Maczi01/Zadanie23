import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args){
        checkHowManyContains();
    }

    static List<Integer> loadFile() {
        Scanner scanner = null;
        List<Integer> numbersList = new ArrayList<>();
        try {
            scanner = new Scanner(new File("num.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()) {
            numbersList.add(scanner.nextInt());
        }
        return numbersList;
    }

    static int checkIfContains(int numToCheck, List<Integer> list) {
        int count = 0;
        for (Integer i : list) {
            if (i == numToCheck) {
                count++;
            }
        }
        return count;
    }

    static Set<Integer> createSet(List<Integer> list){
        Set<Integer> numbersSet = new TreeSet<>(loadFile());
        return numbersSet;
    }

    static void checkHowManyContains(){
        Set<Integer> set = createSet(loadFile());
        for (Integer i : set) {
            if (checkIfContains(i, loadFile()) == 1)
                System.out.println("Liczba " + i + " wystepuje w pliku " + checkIfContains(i, loadFile()) + " raz.");
            else
                System.out.println("Liczba " + i + " wystepuje w pliku " + checkIfContains(i, loadFile()) + " razy.");
        }
    }
}
