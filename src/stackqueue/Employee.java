package stackqueue;

import java.util.Date;

public class Employee
{
    private int id;
    private String fullName;
    private String address;
    private Date birthday;
    private String phone;
    private double salary;
    private float rate;

    public Employee()
    {
    }

    public Employee(int id, String fullName, String address, Date birthday, String phone, double salary, float rate)
    {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.birthday = birthday;
        this.phone = phone;
        this.salary = salary;
        this.rate = rate;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", rate=" + rate +
                '}';
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public float getRate()
    {
        return rate;
    }

    public void setRate(float rate)
    {
        this.rate = rate;
    }
}
