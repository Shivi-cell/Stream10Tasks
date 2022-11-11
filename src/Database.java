import java.util.*;
public class Database {

    public static List<Employee> getData()
    {
        // employee object
        Employee e1 = new Employee(101,"Shivam"),
                 e2 = new Employee(102,"Satyam"),
                 e3 = new Employee(103,"Sunil"),
                 e4 = new Employee(104,"Ramesh"),
                 e5 = new Employee(105,"Gaurav"),
                 e6 = new Employee(106,"Parth");

        List<Employee> employeeList = new ArrayList<>();

        // setting data for employee 1
        e1.setSalaryMap(new HashMap<>(){{
            put("2022_Jan",new Salary(1,20000));
            put("2022_Feb",new Salary(1,21000));
            put("2022_Mar",new Salary(1,25000));
            put("2022_Apr",new Salary(1,30000));
        }});
        e1.setAddressList(new ArrayList<>(){{
            add(new Address(11,"moris","Delhi","India"){{
                setEmployee(e1);
            }});
            /*add(new Address(10,"bansi","UP","India"){{
                setEmployee(e1);
            }});*/
        }});

        // setting data for employee 2
        e2.setSalaryMap(new HashMap<>(){{
            put("2022_Jan",new Salary(2,22000));
            put("2022_Feb",new Salary(2,24000));
            put("2022_Mar",new Salary(2,18000));
        }});
        e2.setAddressList(new ArrayList<>(){{
            add(new Address(13,"moris","MP","India"){{
                setEmployee(e2);
            }});
            /*add(new Address(14,"versilona","Mumbai","India"){{
                setEmployee(e2);
            }});*/
        }});

        // setting data for employee 3
        e3.setSalaryMap(new HashMap<>(){{
            put("2022_Jan",new Salary(3,30000));
            put("2022_May",new Salary(3,15000));
            put("2022_Jun",new Salary(3,28000));
        }});
        e3.setAddressList(new ArrayList<>(){{
            add(new Address(13,"gwaliyar","Bihar","India"){{
                setEmployee(e3);
            }});
            /*add(new Address(14,"shree nagar","J&K","India"){{
                setEmployee(e3);
            }});*/
        }});

        // setting data for employee 4
        e4.setSalaryMap(new HashMap<>(){{
            put("2022_Jan",new Salary(4,35000));
            put("2022_Feb",new Salary(4,38000));
            put("2022_Mar",new Salary(4,32000));
        }});
        e4.setAddressList(new ArrayList<>(){{
            add(new Address(15,"tihar","UK","India"){{
                setEmployee(e4);
            }});
        }});

        // setting data for employee 5
        e5.setSalaryMap(new HashMap<>(){{
            put("2022_Mar",new Salary(5,18000));
            put("2022_May",new Salary(5,20000));
            put("2022_Jun",new Salary(5,22000));

        }});
        e5.setAddressList(new ArrayList<>(){{
            add(new Address(16,"moris","MP","India"){{
                setEmployee(e5);
            }});
            /*add(new Address(17,"silva","AP","India"){{
                setEmployee(e5);
            }});*/
        }});

        // setting data for employee 6
        e6.setSalaryMap(new HashMap<>(){{
            put("2022_Feb",new Salary(6,50000));
            put("2022_Mar",new Salary(6,40000));
        }});
        e6.setAddressList(new ArrayList<>(){{
            add(new Address(18,"somani","Rajasthan","India"){{
                setEmployee(e6);
            }});
        }});

        // making employee list

        employeeList.add(e1);employeeList.add(e2);employeeList.add(e3);
        employeeList.add(e4);employeeList.add(e5);employeeList.add(e6);
        return employeeList;
    }

}
