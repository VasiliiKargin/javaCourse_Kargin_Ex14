import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(new User("Каргин Василий Сергеевич",29 ,"KVS","Екатеринбург", "M"),
                new User("Антонов Антон Антонович",15 ,"AAA","Москва", "M"),
                new User("Алаева Алла Ивановна",68 ,"AAI","Ставрополь", "F"),
                new User("Киреева Лариса Сергееевна",31 ,"KLS","Сыктывкарs", "F"),
                new User("Семенов Семен Семенович",71 ,"SSS","Кунашак", "M"),
                new User("Сергеев Сергей Борисович",25 ,"SSB","Екатеринбург", "M"));

        System.out.println("Вывести отсортированную коллекцию по возрастанию!\n");
        users.stream().sorted(Comparator.comparing(User::getAge)).forEach(System.out::println);

        System.out.println("\nВывести отсортированную коллекцию по убыванию!\n");
        users.stream().sorted(Comparator.comparing(User::getAge).reversed()).forEach(System.out::println);

        System.out.println("\nОтфильтровать коллекцию по полю\n");
        users.stream().filter(x -> x.getCity()=="Екатеринбург").forEach(System.out::println);

        System.out.println("\nОтсортировать коллекцию из полей и сгруппировать получившийся результат по одному из полей и вывести группу.\n");
        Map<String, List<User>> groupUserByAge= users.stream().filter(x-> x.getAge()>18 && x.getAge()<60).collect(Collectors.groupingBy(User::getCity));
        groupUserByAge.forEach((k,v)-> {
            System.out.println("\nГород : " + k);
            for (User user: v){
                System.out.println(user);
            }
        });

        System.out.println("\nВыбрать минимальный объект логину\n");
        users.stream().min(Comparator.comparing(User::getLogin)).ifPresent(System.out::println);

        System.out.println("\nВыбрать максимальный объект возрасту\n");
        users.stream().max(Comparator.comparing(User::getAge)).ifPresent(System.out::println);

        System.out.println("\nИспользовать AllMatch\n");
        System.out.println("Все пользователи получили паспорт( достигли 14 лет) - " + users.stream().allMatch(x->x.getAge()>=14));

        System.out.println("\nИспользовать AnyMatch\n");
        System.out.println("Есть ли пользователи из Уфы - " + users.stream().anyMatch(x->x.getCity()=="Уфа"));

        System.out.println("\nИспользовать NoneMatch\n");
        System.out.println("Нет пользователей без логина - " + users.stream().noneMatch(x->(x.getLogin()==null)));
    }
}
