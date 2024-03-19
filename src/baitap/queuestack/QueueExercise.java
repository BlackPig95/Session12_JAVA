package baitap.queuestack;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueueExercise
{
    private static final Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args)
    {
//        bai1();
//        bai2AndBai6();
//        bai3();
//        bai5Palindrome();
//        bai7();
//        bai9();
//        bai11();
//        bai12();
//        bai13();
//        bai14();
        bai15();
    }

    //        bai 1
    private static void bai1()
    {
        final int MAX_SIZE = 10;
        Random random = new Random();
        ArrayList<Integer> inputList = new ArrayList<>();
        Queue<Integer> integerQueue = new PriorityQueue<>();
        for (int i = 0; i < MAX_SIZE; i++)
        {
            inputList.add(random.nextInt(1, 21));
            System.out.print(inputList.get(i) + " ");
        }
        integerQueue.addAll(inputList);
        System.out.println();
        System.out.println(integerQueue);//Thứ tự dựa trên natural order hoặc comparator khi khởi tạo
        while (!integerQueue.isEmpty())
        {
            System.out.println(integerQueue.poll());
        }
    }

    //bai 2 + bai 6
    private static void bai2AndBai6()
    {
        Stack<Character> bracketStack = new Stack<>();
        String bracketInput1 = "({[]})";
        String bracketInput2 = "({[]>)";
        String bracketInput3 = "({[]})}";
        String bracketInput4 = "(({[]})";
        String bracketInput5 = "({[asasfasifaisi]})";
        String expressionTest = "a*b+(a-b)-(a*c/b+(a-b*c))";
        String input = expressionTest;
        for (int i = 0; i < input.length(); i++)
        {
            char c = input.charAt(i);
            switch (c)
            {
                case '(', '{', '[':
                    bracketStack.push(c);
                    break;
                case ')':
                    if (bracketStack.peek() != '(')//Dùng pop ở đây sẽ có thể gây lỗi khi stack đã empty
                    {
                        System.out.println("Không đúng");
                        return;
                    }
                    bracketStack.pop();
                    break;
                case '}':
                    if (bracketStack.peek() != '{')
                    {
                        System.out.println("Không đúng");
                        return;
                    }
                    bracketStack.pop();
                    break;
                case ']':
                    if (bracketStack.peek() != '[')
                    {
                        System.out.println("Không đúng");
                        return;
                    }
                    bracketStack.pop();
                    break;
                default:
                    break;
            }
        }
        if (bracketStack.isEmpty())
            System.out.println("Chuỗi đúng");
        else System.out.println("Chuỗi sai");
    }

    //bai 3 đảo ngược chuỗi (số 4)
    private static void bai3()
    {
        System.out.println("Nhập số lượng các từ muốn thêm");
        Stack<String> reverseString = new Stack<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++)
        {
            System.out.println("Mời nhập từ thứ " + (i + 1));
            reverseString.push(scanner.nextLine());
        }
        System.out.println("Văn bản đảo ngược là:");
        while (!reverseString.isEmpty())
            System.out.print(reverseString.pop() + " ");
    }

    //bai 5 Palindrome
    private static void bai5Palindrome()
    {
        System.out.println("Nhập vào một chuỗi để kiểm tra");
        String input = scanner.nextLine();
        Queue<Character> fifoInput = new ArrayDeque<>();
        Stack<Character> lifoInput = new Stack<>();
        for (int i = 0; i < input.length(); i++)
        {
            fifoInput.offer(input.charAt(i));
            lifoInput.push(input.charAt(i));
        }
        while (!fifoInput.isEmpty())
        {
            if (fifoInput.poll() != lifoInput.pop())
            {
                System.out.println("Không phải palindrome");
                return;
            }
        }
        System.out.println("Là palindrome");
    }

    //bai 7 demerging
    private static void bai7()
    {
        Bai7NamNu[] initialList = new Bai7NamNu[10];//Giả định đây là file ban đầu
        for (int i = 0; i < 10; i++)
        {
            initialList[i] = new Bai7NamNu();//Set giá trị giả định cho các phần tử
        }
        Queue<Bai7NamNu> queueFemale = new ArrayDeque<>();
        Queue<Bai7NamNu> queueMale = new ArrayDeque<>();
        for (int i = 0; i < 10; i++)
        {
            if (initialList[i].isSex())
                queueMale.offer(initialList[i]);//Offer từng phần tử nam và
            else if (!initialList[i].isSex())//nữ vào các queue tương ứng
                queueFemale.offer(initialList[i]);
        }
        ArrayList<Bai7NamNu> fileToPush = new ArrayList<>();

        while (!queueFemale.isEmpty())
            fileToPush.add(queueFemale.poll());//add từng phần tử của queue nữ vào file giả định
        while (!queueMale.isEmpty())//rồi đến queue nam
            fileToPush.add(queueMale.poll());
        System.out.println(fileToPush);
    }

    //bai 9 Đảo ngược mảng
    private static void bai9()
    {
        ArrayList<Integer> intArray = new ArrayList<>();
        ArrayList<String> stringArray = new ArrayList<>();
        System.out.println("Nhập số 1 để nhập mảng số nguyên, số 2 để nhập chuỗi");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice)
        {
            case 1:
                System.out.println("Nhập số lượng chữ số muốn nhập");
                int number = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < number; i++)
                {
                    System.out.println("Nhập số thứ " + (i + 1));
                    intArray.add(Integer.valueOf(scanner.nextLine()));
                }
                break;
            case 2:
                System.out.println("Nhập chuỗi");
                String input = scanner.nextLine();
                String[] s = input.split(" ");//Phân tách chuỗi bằng dấu cách
                stringArray.addAll(Arrays.asList(s));
                break;
            default:
                break;
        }
        System.out.println("Mảng ban đầu");
        System.out.println(intArray);
        System.out.println(stringArray);
        System.out.println("-------------------------");
        Stack<Integer> reverseIntStack = new Stack<>();
        Stack<String> reverseStringStack = new Stack<>();
        if (!intArray.isEmpty())
        {
            for (Integer i : intArray)
            {
                reverseIntStack.push(i);//Thêm từng phần tử vào stack
            }
            intArray.clear();//Xóa sạch mảng ban đầu
            while (!reverseIntStack.isEmpty())
                intArray.add(reverseIntStack.pop());//Lấy ra từ stack và thêm lại vào mảng
            System.out.println(intArray);
        }
        if (!stringArray.isEmpty())
        {
            for (String s : stringArray)
            {
                reverseStringStack.push(s);//Thêm từng phần tử vào stack
            }
            stringArray.clear();//Xóa sạch mảng ban đầu
            while (!reverseStringStack.isEmpty())
                stringArray.add(reverseStringStack.pop());//Lấy ra từ stack và thêm lại vào mảng
            System.out.println(stringArray);
        }
    }

    //bai 10 operator
//    private static void bai10()
//    {
//        System.out.println("Nhập một biểu thức gồm các toán tử + - * / và các số");
//        String input = scanner.nextLine();
//        Stack<Character> calculate = new Stack<>();
//        Pattern pattern = Pattern.compile("\\d");
//        char[] chars = input.toCharArray();
//        StringBuilder number = new StringBuilder();
//        for (char c : chars)
//        {
//            Matcher matcher = pattern.matcher(Character.toString(c));//Không dùng regex với char được
//            if (matcher.find())
//                calculate.push(c);
//            else
//            {
//                while (!calculate.isEmpty())
//                {
//                    number.append(calculate.pop());
//                }
//                int firstNum = Integer.parseInt(number.toString());
//            }
//        }
//    }

    //bai 11 max
    private static void bai11()
    {
        int[] arrayInt = new int[random.nextInt(5, 11)];
        for (int i = 0; i < arrayInt.length; i++)
        {
            arrayInt[i] = random.nextInt(10, 30);//Tạo mảng ban đầu
            System.out.print(arrayInt[i] + " ");
        }
        Stack<Integer> stackInt = new Stack<>();
        for (int i = 0; i < arrayInt.length; i++)
        {
            if (stackInt.isEmpty() || stackInt.peek() < arrayInt[i])
            {
                stackInt.push(arrayInt[i]);
            }
        }
        System.out.println("Phần tử lớn nhất: " + stackInt.peek());
    }

    //bai 12 min
    private static void bai12()
    {
        int[] arrayInt = new int[random.nextInt(5, 11)];
        for (int i = 0; i < arrayInt.length; i++)
        {
            arrayInt[i] = random.nextInt(10, 30);//Tạo mảng ban đầu
            System.out.print(arrayInt[i] + " ");
        }
        Stack<Integer> stackInt = new Stack<>();
        for (int i = 0; i < arrayInt.length; i++)
        {
            if (stackInt.isEmpty() || stackInt.peek() > arrayInt[i])
            {
                stackInt.push(arrayInt[i]);
            }
        }
        System.out.println("Phần tử lớn nhất: " + stackInt.peek());
    }

    //bai 13 check descending
    private static void bai13()
    {
        System.out.println("Nhập chuỗi đầu vào");
        String input = scanner.nextLine();
        Stack<Character> stackDescending = new Stack<>();
        for (int i = 0; i < input.length(); i++)
        {
            if (stackDescending.isEmpty())
                stackDescending.push(input.charAt(i));
            else if (stackDescending.peek().compareTo(input.charAt(i)) < 0)
            {
                System.out.println("Không giảm dần");
                return;
            }
            stackDescending.push(input.charAt(i));
        }
        System.out.println("Chuỗi giảm dần");
    }

    //bai 14 prime number
    private static void bai14()
    {
        System.out.println("Nhập chuỗi các số");
        String input = scanner.nextLine();
        Stack<Character> stackChar = new Stack<>();
        for (int i = 0; i < input.length(); i++)
        {
            stackChar.push(input.charAt(i));//Đẩy các ký tự vào stack
        }
        StringBuilder charToNum = new StringBuilder();
        while (!stackChar.isEmpty())
        {           //Nếu gặp ký tự không phải số thì ngừng nối chuỗi
            while (!stackChar.isEmpty() && Character.isDigit(stackChar.peek()))
            {//Đặt stackChar.isEmpty ở đầu để tránh emptystackexception
                charToNum.insert(0, stackChar.pop());//Nối chữ số vào bên trái string
            }
            if (charToNum.length() != 0)//Nếu chuỗi có độ dài lớn hơn 0 => Có số để kiểm tra
            {
                int numberToCheck = Integer.parseInt(charToNum.toString());//Ép kiểu về int
                if (!checkPrime(numberToCheck))
                {
                    System.out.println("Chuỗi này có số không phải số nguyên tố");
                    return;
                }
                charToNum.setLength(0);//Reset lại string về rỗng
            }
            if (!stackChar.isEmpty()) stackChar.pop();//Đặt if để tránh việc pop 2 element liên tiếp
        }                                              //=> empty exception khi có số nguyên tố ở đầu chuỗi
        System.out.println("Toàn bộ chuỗi là các số nguyên tố");
    }

    public static boolean checkPrime(int number)
    {
        if (number < 2)
            return false;
        if (number == 2)
            return true;
        for (int i = 2; i <= number / i; i++)
        {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    //bai 15 decimal to binary
    private static void bai15()
    {
        System.out.println("Nhập số theo hệ thập phân");
        int input = Integer.parseInt(scanner.nextLine());
        Stack<String> binaryStack = new Stack<>();
        while (input > 0)
        {
            binaryStack.push(String.valueOf(input % 2));
            input /= 2;
        }
        while (!binaryStack.isEmpty())
            System.out.print(binaryStack.pop());
    }
}
