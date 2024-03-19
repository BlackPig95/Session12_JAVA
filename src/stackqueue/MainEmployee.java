package stackqueue;

import java.util.*;

public class MainEmployee
{
    public static void main(String[] args)
    {
        List<Employee> employeeList = new ArrayList<>();
//        Employee[] employeeList = new Employee[7];
        for (int i = 0; i < 7; i++)
        {
            Employee newEm = new Employee();
            newEm.setId(i);
            newEm.setFullName("Employee " + (7 - i));
            newEm.setAddress("Address " + i);
            newEm.setSalary(1000 * (i + 1));
            newEm.setRate(1.5f * (7 - i));
            employeeList.add(newEm);
//            employeeList[i] = newEm;
        }
        for (Employee e : employeeList)
        {
            System.out.println("ID " + e.getId());
            System.out.println("Full name " + e.getFullName());
            System.out.println("Salary " + e.getSalary());
            System.out.println("Rate " + e.getRate());
            System.out.println("-------------------------");
        }
        Collections.sort(employeeList, (e1, e2) -> e1.getFullName().compareTo(e2.getFullName()));
//        Arrays.sort(employeeList, (e1, e2) -> e1.getFullName().compareTo(e2.getFullName()));
        Collections.sort(employeeList, (e1, e2) ->
                Double.compare(e1.getRate() * e1.getSalary(), e2.getSalary() * e2.getRate()));
        Collections.sort(employeeList,
                Comparator.comparingDouble(e -> (e.getRate() * e.getSalary()))); //.reversed lỗi??
        Collections.sort(employeeList, (e1, e2) ->
        {
            if (e1.getFullName().compareTo(e2.getFullName()) != 0)
            {
                return e1.getFullName().compareTo(e2.getFullName());
            } else return Integer.compare(e1.getId(), e2.getId());
        });
        System.out.println("After sort");
        System.out.println(employeeList);
//        for (Employee e : employeeList)
//        {
//            System.out.println("ID " + e.getId());
//            System.out.println("Full name" + e.getFullName());
//            System.out.println("Salary " + e.getSalary());
//            System.out.println("Rate " + e.getRate());
//            System.out.println("-------------------------");
//        }
    }
}
