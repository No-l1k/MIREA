package Practic15;
public class Number
{
    private String number,  kod="<";
    public Number(String number)
    {
        this.number=number;
        NewNumber(number);
    }
    public void NewNumber(String number)
    {
        String first,second;
        char ch = number.charAt(0);
        if(ch=='+')
        {
            number=number.substring(1);
            number=NewNumberHelper(number);
            System.out.println(ch+kod+"><"+number+">");
        }
        else {
            kod=number.substring(0,1);
            System.out.println("+<"+kod+"><"+number.substring(1,4)+"><"+number.substring(4,7)+"><"+number.substring(7,11)+">");

        }
    }
    public String NewNumberHelper(String number)
    {
        if(number.length()>10)
        {
            kod =kod+ number.charAt(0);
            number=number.substring(1);
            NewNumberHelper(number);
        }
        return (number.substring(1));
    }
    public static void main(String []args)
    {
        Number num = new Number("+79654564545");
        Number num1 = new Number("546195235456");
        Number num2 = new Number("89456455454");

    }
}