import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = Database.getData();
        //employeeList.forEach(System.out::println);


        // unique address from the list of employees
        Stream<Address> addressStream = employeeList.stream().flatMap(s -> s.getAddressList().stream());
        addressStream.forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");
        System.out.println("unique address from the list of employees");
        System.out.println("---------------------------------------------------------------");
        LinkedHashMap<String, Address> collect = employeeList.stream()
                .flatMap(s -> s.getAddressList().stream()).collect(Collectors.toMap(address -> address.getCity(), Function.identity(), (a, b) -> a, LinkedHashMap::new));
        /*for (Map.Entry<String, Address> i:collect.entrySet() ) {
            System.out.println(i.getValue());
        }*/


        // sorting employee according to their address
        System.out.println("---------------------------------------------------------------");
        System.out.println("sorting employee according to their address");
        System.out.println("---------------------------------------------------------------");
        Stream<Employee> employeeStream = employeeList.stream()
                .flatMap(s -> s.getAddressList().stream()
                        .sorted(Comparator.comparing(Address::getId).thenComparing(Address::getCity)
                                .thenComparing(Address::getState)).map(a -> a.getEmployee()).distinct());
        employeeStream.forEach(System.out::println);


        // all employee city-wise
        System.out.println("---------------------------------------------------------------");
        System.out.println("all employee city-wise");
        System.out.println("---------------------------------------------------------------");
        Stream<Map<String, List<Address>>> mapStream = employeeList.stream().map(e -> e.getAddressList().stream().collect(Collectors.groupingBy(a -> a.getCity())));
        mapStream.forEach(System.out::println);

        // employee salary year wise
        System.out.println("---------------------------------------------------------------");
        System.out.println("employee salary year wise");
        System.out.println("---------------------------------------------------------------");
        Stream<Map<Integer, Integer>> mapStream1 =
                employeeList.stream()
                .map(e -> e.getSalaryMap().entrySet().stream()
                        .collect(Collectors.groupingBy(s -> s.getValue().getId(), Collectors
                                .summingInt(s1 -> s1.getValue().getSalary()))));
        mapStream1.forEach(System.out::println);


        // employee salary city wise
        System.out.println("---------------------------------------------------------------");
        System.out.println("employee salary city wise");
        System.out.println("---------------------------------------------------------------");
        Stream<Map<String, Integer>> mapStream2 = employeeList.stream().map(e -> e.getAddressList().stream()
                .collect(Collectors.groupingBy(a -> a.getCity(), Collectors
                        .summingInt(st -> st.getEmployee().getSalaryMap().values().stream()
                                .collect(Collectors.summingInt(f -> f.getSalary()))))));
        mapStream2.forEach(System.out::println);


        // how many employees live together
        System.out.println("---------------------------------------------------------------");
        System.out.println("employee salary range wise");
        System.out.println("---------------------------------------------------------------");
        /*Stream<Map<Address, Long>> mapStream3 = employeeList.stream().map(e -> e.getAddressList().stream().collect(Collectors.groupingBy(a -> a, Collectors.counting())));
        mapStream3.forEach(System.out::println);*/

        employeeList.stream().map(a->a.getSalaryMap()
                .entrySet().stream()
                .collect(Collectors.groupingBy(b->b.getValue().getId(),Collectors.averagingInt(st->st.getValue().getSalary())))).forEach(System.out::println);
    }
}