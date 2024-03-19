package baitap.queuestack;

public class Bai7NamNu
{
    private int dob; //Giả định date of birth là số int cho dễ làm việc
    private static int increaseDob = 1;
    private boolean sex;

    public Bai7NamNu()
    {
        this.dob = increaseDob++;
        if (dob % 2 == 0)
            this.sex = false;
        else this.sex = true;
    }

    public int getDob()
    {
        return dob;
    }

    @Override
    public String toString()
    {
        return "Bai7NamNu{" +
                "dob=" + dob +
                ", sex=" + sex +
                '}';
    }

    public boolean isSex()
    {
        return sex;
    }
}
