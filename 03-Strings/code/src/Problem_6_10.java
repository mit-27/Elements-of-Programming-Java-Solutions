import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem_6_10 {

    // COMPUTE ALL VALID IP ADDRESSES

    // Write a program that determines where to add periods to a decimal string so that the
    //resulting string is a valid IP address. There may be more than one valid IP address
    //corresponding to a string, in which case you should print all possibilities.

    // For example, if the mangled string is "19216811" then two corresponding IP ad¬
    //dresses are 192.168.1.1 and 19.216.81.1. (There are seven other possible IP addresses
    //for this string.)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String IP = sc.next();
        System.out.println(getAllIP(IP));
    }


    private static List<String> getAllIP(String input)
    {
        List<String> answer = new ArrayList<>();

        // With Recursion
//        getAllIPHelper(input.toCharArray(),0,0,answer,new StringBuilder());

        // Without Recursion
        getAllIPWithoutRecursion(answer,input);

        return answer;
    }

    private static void getAllIPWithoutRecursion(List<String> answer,String s)
    {
        for (int i=1;i<4 && i<s.length();i++)
        {
            final String first = s.substring(0,i);
            if(isValidPart(first))
            {
                for (int j=1;i+j<s.length() && j<4;j++)
                {
                    final String second = s.substring(i,i+j);
                    if(isValidPart(second))
                    {
                        for (int k=1;i+j+k<s.length() && k<4;k++)
                        {
                            final String third = s.substring(i+j,i+j+k);
                            final String fourth = s.substring(i+j+k);
                            if(isValidPart(third) && isValidPart(fourth))
                            {
                                answer.add(first+"."+second+"."+third+"."+fourth);
                            }
                        }
                    }
                }
            }
        }


    }

    private static  boolean isValidPart(String numberPart)
    {
        if(numberPart.length()>3){
            return false;
        }

        if(numberPart.startsWith("0") && numberPart.length()>1)
        {
            return false;
        }

        int number = Integer.parseInt(numberPart);

        return number>=0 && number<=255;
    }


    private static void getAllIPHelper(char[] input,int currentDotCount,int currentIndex,List<String> answer,StringBuilder currentIP)
    {
        int digit = 0;
        // flag to differentiate digit 0 and after adding index 0
        boolean flag0 = false;
        if(currentDotCount>0 && currentDotCount<=3)
        {
            currentIP.append('.');
//            currentDotCount++;
        }

        // For base case
        // If three dots added then we only have to directly add it into answer no need to call another recursive
        if(currentDotCount==3)
        {
            for (int i = currentIndex; i < input.length; i++) {
                int currentDigit = input[i] - '0';
                flag0=true;
                digit = (digit * 10) + currentDigit;
            }

            if(digit<=255 && flag0)
            {
                StringBuilder temp = new StringBuilder(currentIP);
                temp.append(digit);
                answer.add(temp.toString());
            }

            return;
        }


        for (int i = currentIndex; i < input.length; i++) {

            int currentDigit = input[i] - '0';
            digit = (digit * 10) + currentDigit;

            // Base case
            if(digit>255)
            {
                return;
            }
            // we need to recursive after adding digit and .
            if(digit<=255)
            {
                StringBuilder temp = new StringBuilder(currentIP);
                temp.append(digit);
//                    currentIP.append(digit);
//                    currentIP.append('.');
                getAllIPHelper(input,currentDotCount+1,i+1,answer,new StringBuilder(temp));
            }
            else
            {
                return;
            }






        }

    }
}
