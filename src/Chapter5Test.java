import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


class Chapter5Test {
    /**
     * default constructor.
     */
    public Chapter5Test() {
        super();
    }


    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));


        var array1 = Arrays.asList(1, 2, 3);
        var array2 = Arrays.asList(3, 4);

        var quiz5_2 = array1.stream().flatMap(a1 -> {
            return array2.stream()
                    .filter(a2 -> (a1 + a2) % 3 == 0)
                    .map(a2 -> Arrays.asList(a1, a2));
        }).collect(toList());

//        quiz5_2.forEach(System.out::println);

//        menu.stream()
//                .filter(Dish::isVegetarian)
//                .findAny()
//                .ifPresent(dish -> System.out.println(dish.getName()));

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1 Find all transactions in the year 2011 and sort them by value (small to high).
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(System.out::println);
        System.out.println();

        // 2 What are all the unique cities where the traders work?
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        // 3 Find all traders from Cambridge and sort them by name.
        List.of(raoul, mario, alan, brian).stream()
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
        System.out.println();

        // 4 Return a string of all traders’ names sorted alphabetically.
        List.of(raoul, mario, alan, brian).stream()
                .map(Trader::getName)
                .sorted(Comparator.comparing(name -> name))
                .forEach(System.out::println);
        System.out.println();

        // 5 Are any traders based in Milan?
        System.out.println(
                List.of(raoul, mario, alan, brian).stream().anyMatch(t -> t.getCity().equals("Milan"))
        );
        System.out.println();

        // 6 Print all transactions’ values from the traders living in Cambridge.
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
        System.out.println();

        // 7 What’s the highest value of all the transactions?
        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .ifPresent(System.out::println);
        System.out.println();

        // 8 Find the transaction with the smallest value.
        System.out.println(
                transactions.stream()
                        .mapToInt(Transaction::getValue)
                        .min()
        );

        System.out.println();

        IntStream.range(1, 10).forEach(System.out::println);
        System.out.println();


        // Quiz5_4 Fibonacci
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
    }
}

