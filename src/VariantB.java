import java.math.BigInteger;
import java.util.*;

public class VariantB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();

        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            nums.add(scanner.nextInt());
        }

        showEvenAndOdd(nums);
        showMaxAndMinNumber(nums);
        showThreeOrNine(nums);
        showFiveAndSeven(nums);
        showThreeDigits(nums);
        showSimpleNums(nums);
        showSorted(nums);
        sortWithFreq(nums);
        showLuckyNums(nums);
        showPalindromes(nums);
        showHalfSum(nums);
    }

    public static void showEvenAndOdd(ArrayList<Integer> list) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for (int num : list) {
            if (num % 2 == 0) {
                even.add(num);
            }
            else {
                odd.add(num);
            }
        }
        System.out.println("Четные числа: ");
        printArrayList(even);
        System.out.println("Нечетные числа: ");
        printArrayList(odd);
    }

    public static void showMaxAndMinNumber(ArrayList<Integer> list) {
        System.out.println("Максимальное число: " + Collections.max(list));
        System.out.println("Минимальное число: " + Collections.min(list) + "\n");
    }

    public static void showThreeOrNine(ArrayList<Integer> list) {
        ArrayList<Integer> threeOrNine = new ArrayList<>();
        for (int num : list) {
            if (num % 3 == 0) {
                threeOrNine.add(num);
            }
        }
        System.out.println("Числа, которые делятся на 3 или на 9");
        printArrayList(threeOrNine);
    }

    public static void showThreeDigits(ArrayList<Integer> list) {
        ArrayList<Integer> threeDigits = new ArrayList<>();
        for (int num : list) {
            if (num > 99 && num < 1000) {
                if (!containRepeatDigits(num)) {
                    threeDigits.add(num);
                }
            }
        }
        System.out.println("Трехзначные числа, в записи которых нет одинаковых цифр:");
        printArrayList(threeDigits);
    }

    public static void showSimpleNums(ArrayList<Integer> list) {
        ArrayList<Integer> simpleNums = new ArrayList<>();
        for (int num : list) {
            BigInteger number = BigInteger.valueOf(num);
            if (number.isProbablePrime(1)) {
                simpleNums.add(num);
            }
        }
        System.out.println("Простые числа:");
        printArrayList(simpleNums);
    }

    public static void showSorted(ArrayList<Integer> list) {
        Collections.sort(list);
        System.out.println("Сортировка по возрастанию");
        printArrayList(list);

        list.sort(Collections.reverseOrder());
        System.out.println("Сортировка по убыванию");
        printArrayList(list);
    }

    public static void sortWithFreq(ArrayList<Integer> list) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : list) {
            map.put(num, Collections.frequency(list, num));
        }
        System.out.println("Сортировка по частоте");
        map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
        System.out.println("\n");
    }

    public static void showLuckyNums(ArrayList<Integer> list) {
        ArrayList<Integer> luckyNums = new ArrayList<>();
        for (int num : list) {
            if (num > 100000 && num < 1000000) {
                if (checkIfLucky(num)) {
                    luckyNums.add(num);
                }
            }
        }
        System.out.println("Счастливые числа:");
        printArrayList(luckyNums);
    }

    public static void showPalindromes(ArrayList<Integer> list) {
        ArrayList<Integer> palindromes = new ArrayList<>();
        for (int num : list) {
            if (isPalindrome(num)) {
                palindromes.add(num);
            }
        }
        System.out.println("Палиндромы:");
        printArrayList(palindromes);
    }

    public static void showHalfSum(ArrayList<Integer> list) {
        ArrayList<Integer> halfSum = new ArrayList<>();
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i) == ((list.get(i-1) + list.get(i+1)) / 2)) {
                halfSum.add(list.get(i));
            }
        }
        System.out.println("Элементы, равные полусумме соседних:");
        printArrayList(halfSum);
    }

    public static void showFiveAndSeven(ArrayList<Integer> list) {
        ArrayList<Integer> fiveAndSeven = new ArrayList<>();
        for (int num : list) {
            if (num % 5 == 0 && num % 7 == 0) {
                fiveAndSeven.add(num);
            }
        }
        System.out.println("Числа, которые деляется на 5 и 7");
        printArrayList(fiveAndSeven);
    }

    public static void printArrayList(ArrayList<Integer> list) {
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public static boolean isPalindrome(Integer x) {
        String s = x.toString();
        int len = s.length();
        for (int i = 0; i<len; i+=2) {
            if (s.charAt(i) != s.charAt(len-i-1)) return false;
        }
        return true;
    }

    static boolean checkIfLucky(int num) {
        int left = 0;
        int right = 0;

        char[] arrLeft = Integer.toString(num).substring(0, 3).toCharArray();
        char[] arrRight = Integer.toString(num).substring(3, 6).toCharArray();

        for(char c : arrLeft){
            left += Integer.parseInt(String.valueOf(c));
        }

        for(char c : arrRight){
            right += Integer.parseInt(String.valueOf(c));
        }

        return left == right;
    }

    static boolean containRepeatDigits(int n) {
        if (n < 10)
            return false;
        else {
            int last = n % 10;
            for (int prev = n / 10; prev > 0; prev /= 10)
                if ( prev % 10 == last )
                    return true;
            return containRepeatDigits(n / 10);
        }
    }
}
