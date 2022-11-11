import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employee {
    private int id;
    private String name;
    private List<Address> addressList;
    private HashMap<String, Salary> salaryMap;

    public Employee() {
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(int id, String name, List<Address> addressList, HashMap<String, Salary> salaryMap) {
        this.id = id;
        this.name = name;
        this.addressList = addressList;
        this.salaryMap = salaryMap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Map<String, Salary> getSalaryMap() {
        return salaryMap;
    }

    public void setSalaryMap(HashMap<String, Salary> salaryMap) {
        this.salaryMap = salaryMap;
    }

    @Override
    public String toString() {
        return "Employee(" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressList=" + addressList +
                ", salaryMap=" + salaryMap +
                ')';
    }

}
