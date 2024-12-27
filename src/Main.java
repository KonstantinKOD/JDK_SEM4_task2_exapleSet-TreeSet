import java.util.*;
import java.util.stream.Collectors;

/*
В рамках выполнения задачи необходимо:
1. Создайте коллекцию мужских и женских имен с помощью интерфейса List -
добавьте повторяющиеся значения
2. Получите уникальный список Set на основании List
3. Определите наименьший элемент (алфавитный порядок)
4. Определите наибольший элемент (по количеству букв в слове но в обратном
порядке)
5. Удалите все элементы содержащие букву ‘A’
 */

public class Main {
    public static void main(String[] args) {
        // N1.
        List<String> nameList = createList();
        System.out.println(nameList);

        // N2.
        Set<String> nameSet = getAsSet(nameList);
        System.out.println(nameSet);

        // N3.
        String firstName = getFirst(nameSet);
        System.out.println(firstName);

        // N4.
        String longestName = getLongest(nameSet);
        System.out.println(longestName);

        // N5.
        Set<String> cuttedSet = cut(nameSet);
        System.out.println(cuttedSet);
    }

    // N5.
    private static Set<String> cut(Set<String> nameSet) {
//        return nameSet.stream().filter(s -> !s.toLowerCase().contains("а")).collect(Collectors.toSet());
        nameSet.removeIf(s -> s.toLowerCase().contains("а"));
        return nameSet;
    }

    // N4.
    private static String getLongest(Set<String> nameSet) {
        return nameSet.stream().max((o1, o2) -> o1.length() - o2.length()).orElse(null);
    }

    // N3.
    private static String getFirst(Set<String> nameSet) {
//        TreeSet<String> tree = new TreeSet<>(nameSet);
//        return tree.first();
        return nameSet.stream().min((o1, o2) -> o1.compareTo(o2)).orElse("Нет наименьших элементов");
    }

    // N2.
    private static Set<String> getAsSet(List<String> list) {
        return new HashSet<>(list);
    }

    // N1.
    static List<String> createList() {
        List<String> list = new ArrayList<>();
        list.add("Кирилл");
        list.add("Костя");
        list.add("Мария");
        list.add("Светлана");
        list.add("Святослав");
        list.add("Игорь");
        list.add("Кирилл");
        list.add("Семен");
        list.add("Святослав");
        list.add("Игорь");
        list.add("Светлана");
        list.add("Игорь");
        return list;
    }

}