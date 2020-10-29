import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class CashMachine {

    Long sum;
    int n;
    Long[] nominals;
    ArrayList<ArrayList<Long>> combinations;

    public CashMachine(Long sum, int n, Long[] nominals) {
        this.sum = sum;
        this.n = n;
        this.nominals = nominals;
    }


    public CashMachine(InputStream inputStream) throws InputMismatchException {

        Scanner sc = new Scanner(inputStream);
        //System.out.println("Введите сумму для размена");
        sum = sc.nextLong();
        //System.out.println("Введите количество купюр");
        n = sc.nextInt();
        nominals = new Long[n];
        //System.out.println("Введите номиналы купюр через пробел");
        for (int i = 0; i < n; i++) {
            nominals[i] = sc.nextLong();
        }
        Arrays.sort(nominals);

    }


    public CashMachine(Long sum, int n, Long[] nominals, String fileName) {
        this.sum = sum;
        this.n = n;
        this.nominals = nominals;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            combinations = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                ArrayList<Long> list = new ArrayList<>();
                String[] st = line.split(" ");
                for (String s : st) {
                    list.add(Long.parseLong(s));
                }
                combinations.add(list);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла.\n" + e.getMessage());
        }
    }

    public void getCombinations() throws RuntimeException {

        if (sum < 0) {
            throw new RuntimeException("Введена некорректное значение суммы");
        }

        ArrayList<Long> nominalsList = new ArrayList<>();
        Collections.addAll(nominalsList, nominals);
        Set<Long> set = new HashSet<>(nominalsList);

        if (set.size() != n) {
            throw new RuntimeException("Введены некорректные значения купюр: есть повторяющиеся номиналы");
        }

        combinations = new ArrayList<>();
        getCombinations(new int[n], sum, 0);
        if (combinations.size() == 0) {
            throw new RuntimeException("Невозможно разменять данную сумму представленными купюрами");
        }
    }

    public void getCombinations(int[] counts, long amount, int index) {
        if (amount == 0) {
            ArrayList<Long> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < counts[i]; j++){
                    list.add(nominals[i]);
                }
            }
            combinations.add(list);

        } else if (amount > 0) {
            getCombinationsLoop(counts, amount, index);
        }
    }

    public void getCombinationsLoop(int[] counts, long amount, int index) {
        counts[index]++;
        getCombinations(counts, amount - nominals[index], index);
        counts[index]--;
        if (index + 1 < n && nominals[index + 1] <= amount) {
            getCombinationsLoop(counts, amount, index + 1);
        }
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o instanceof CashMachine) {
            CashMachine cm = (CashMachine) o;

            if (combinations.size() != cm.combinations.size()) {
                return false;
            } else {
                for (int i = 0; i < combinations.size(); i++) {
                    Collections.sort(combinations.get(i));
                    Collections.sort(cm.combinations.get(i));
                }

                int k = 0;
                for (int i = 0; i < cm.combinations.size(); i++) {
                    if (!combinations.contains(cm.combinations.get(i))) {
                        k++;
                    }
                }

                return k == 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        InputStream inputStream = System.in;
        CashMachine machine = new CashMachine(inputStream);

        machine.getCombinations();

        System.out.println("Варианты комбинаций:");
        for (ArrayList<Long> x : machine.combinations) {
            System.out.println(Arrays.toString(x.toArray()));
        }
        System.out.println('\n' + "Количество комбинаций:" + machine.combinations.size());

    }

}
