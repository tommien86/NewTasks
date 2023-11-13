import java.util.*;

public class Tasks {


    public static void main(String[] args) {
        task5();
    }
    public static <T> List<T> removeDuplicates(Collection<T> collection) {
        Set<T> uniqueSet = new HashSet<>();
        List<T> resultCollection = new ArrayList<>();
        for (T item : collection) {
            if (uniqueSet.add(item)) {
                resultCollection.add(item);
            }
        }

        return resultCollection;
    }
    public static void task1()
    {
        System.out.println("Задание 1");
        Collection<Object> inputCollection = List.of(1, 2, 2, 3, 4, 4, 5, 5, 4, 7, 6, 1, 9, 2, "asdas", "asdas");
        Collection<Object> result = removeDuplicates(inputCollection);
        System.out.println("Исходная коллекция:" + inputCollection);
        System.out.println("Коллекция без дубликатов:" + result);
    }
    public static void fillList(ArrayList<Integer> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }
    public static void fillList(LinkedList<Integer> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }
    public static void getRandomElements(ArrayList<Integer> list, int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int index = random.nextInt(list.size());
            list.get(index);
        }
    }
    public static void getRandomElements(LinkedList<Integer> list, int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int index = random.nextInt(list.size());
            list.get(index);
        }
    }
    public static void task2(){
        System.out.println("Задание 2");
        int size = 1000000;
        int randomAccessCount = 100000;

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        long startTime = System.nanoTime();
        fillList(arrayList, size);
        long fillArrayListTime = System.nanoTime() - startTime;
        System.out.println("ArrayList был заполнен за: " + fillArrayListTime / 1e6 + " миллисекунд");

        startTime = System.nanoTime();
        fillList(linkedList, size);
        long fillLinkedListTime = System.nanoTime() - startTime;
        System.out.println("LinkedList был заполнен за: " + fillLinkedListTime / 1e6 + " миллисекунд");

        startTime = System.nanoTime();
        getRandomElements(arrayList, randomAccessCount);
        long randomAccessArrayListTime = System.nanoTime() - startTime;
        System.out.println("Доступ к данным ArrayList был осуществлён: " + randomAccessArrayListTime / 1e6 + " миллисекунд");

        startTime = System.nanoTime();
        getRandomElements(linkedList, randomAccessCount);
        long randomAccessLinkedListTime = System.nanoTime() - startTime;
        System.out.println("Доступ к данным LinkedList был осуществлён: " + randomAccessLinkedListTime / 1e6 + " миллисекунд");
    }
    public static class School {
        private int numberOfStudents;
        private Season currentSeason;
        public enum Season {
            Winter("Зима"),
            Spring("Весна"),
            Summer("Лето"),
            Autumn("Осень");

            private String russianName;

            Season(String russianName) {
                this.russianName = russianName;
            }

            public String getRussianName() {
                return russianName;
            }
        }

        public School(int numberOfStudents, Season currentSeason) {
            this.numberOfStudents = numberOfStudents;
            this.currentSeason = currentSeason;
        }
        private int generateRandomSchoolNumber() {
            Random random = new Random();
            return 100 + random.nextInt(900);
        }
        public void displaySchoolInfo() {
            String activity = (currentSeason == Season.Summer) ? "отдыхаем" : "учимся";
            System.out.println("Школа №" + generateRandomSchoolNumber() + " учащихся " + numberOfStudents + ", сейчас мы " + activity);
        }
    }
    public static void task3(){
        System.out.println("Задание 3");
        School winterSchool = new School(513, School.Season.Winter);
        School summerSchool = new School(123, School.Season.Summer);

        System.out.println("Информация о зимней школе:");
        winterSchool.displaySchoolInfo();

        System.out.println("\nИнформация о летней школе:");
        summerSchool.displaySchoolInfo();
    }
    public static void task4(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Что это такое: синий, большой, с усами и полностью набит зайцами?");
        System.out.println("У вас есть 3 попытки. Введите ваш ответ:");

        int attempts = 3;

        do {
            String answer = scanner.nextLine();

            switch (answer.toLowerCase()) {
                case "троллейбус":
                    System.out.println("Правильно!");
                    return;
                case "сдаюсь":
                    System.out.println("Правильный ответ: троллейбус.");
                    return;
                default:
                    if(attempts > 1) {
                        System.out.println("Подумай еще.");
                    }
                    else {
                        System.out.println("Были исчерпаны все попытки");
                    }
                    attempts--;
                    if (attempts > 0) {
                        System.out.println("У вас осталось " + attempts + " попыток. Введите ваш ответ:");
                    }
            }
        } while (attempts > 0);

        scanner.close();
    }
    public static <K, V> Map<V, Collection<K>> swapKeysAndValues(Map<K, V> inputMap) {
        Map<V, Collection<K>> result = new HashMap<>();

        for (Map.Entry<K, V> entry : inputMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            result.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        return result;
    }
    public static void task5()
    {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("one", 1);
        inputMap.put("two", 2);
        inputMap.put("three", 3);
        inputMap.put("four", 2);

        Map<Integer, Collection<String>> result = swapKeysAndValues(inputMap);

        for (Map.Entry<Integer, Collection<String>> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}