import java.util.*;

public class Problem_6_7 {

    // COMPUTE ALL MNEMONICS FOR A PHONE NUMBER

    // Write a program which takes as input a phone number, specified as a string of digits,
    //and returns all possible character sequences that correspond to the phone number.
    //The cell phone keypad is specified by a mapping that takes a digit and returns the
    //corresponding set of characters. The character sequences do not have to be legal
    //words or phrases.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your 7 or 10 digit number : ");
        String number = sc.next();

        List<String> ans = getAllMnemonics(number);

        System.out.println(ans.toString());

        System.out.println(ans.size());

    }

    static String[] keypad = {"0","1","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};


    private static List<String> getAllMnemonics(String number) {

        // To store completed length mnemonics
        char[] mnemonic = new char[number.length()];

        // To store ans
        List<String> mnemonics = new ArrayList<>();

        // call recursive function which will generate all possible mnemonics
//        helperRecursionMnemonics(number,0,mnemonic,mnemonics);

        // Without Recursion
        helperMnemonics(number,0,mnemonics);

        return mnemonics;

    }

    static class MnemonicObj {
//        char[] mnemonic;
        int currentIndex;
        StringBuilder mnemonic;

        public MnemonicObj(int currentIndex,StringBuilder mnemonic)
        {
            this.currentIndex = currentIndex;
            this.mnemonic = new StringBuilder(mnemonic.toString());
        }
    }

    private static void helperMnemonics(String number,int currentIndex,List<String> mnemonics)
    {
        // To convert recursive to iterative we used stack to store each recursive call in stack
        Stack<MnemonicObj> stack = new Stack<>();

        // To store mnemonic
        StringBuilder mnemonic;

        // Add first digits chars all possibility into stack before entering into while loop
        int currentDigit = number.charAt(currentIndex) - '0';
        String possibleChars = keypad[currentDigit];
        for (int i = 0; i < possibleChars.length(); i++) {
//            mnemonic[currentIndex] = possibleChars.charAt(i);
            mnemonic = new StringBuilder();
            mnemonic.append(possibleChars.charAt(i));
            stack.push(new MnemonicObj(currentIndex+1,mnemonic));
        }


        while(!stack.isEmpty())
        {
            MnemonicObj currentMnemonic =  stack.pop();;

            // if it completes one mnemonic add it into mnemonics
            if(currentMnemonic.currentIndex==number.length())
            {
//                System.out.println(Arrays.toString(currentMnemonic.mnemonic));
                mnemonics.add(currentMnemonic.mnemonic.toString());
//                mnemonics.add(new String(currentMnemonic.mnemonic));
            }
            else
            {
                // Add each character into mnemonic index and push it into stack

                currentDigit = number.charAt(currentMnemonic.currentIndex) - '0';
                possibleChars = keypad[currentDigit];
                for (int i = 0; i < possibleChars.length(); i++) {
//                    currentMnemonic.mnemonic[currentMnemonic.currentIndex] = possibleChars.charAt(i);
                    mnemonic = new StringBuilder(currentMnemonic.mnemonic);
                    mnemonic.append(possibleChars.charAt(i));
                    stack.push(new MnemonicObj(currentMnemonic.currentIndex+1,mnemonic));
                }

            }



        }



    }



    // Using Recursion
    // Time : 0(4^n * n)
    private static void helperRecursionMnemonics(String number,int currentIndex,char[] mnemonic,List<String> mnemonics)
    {
        if(currentIndex==number.length())
        {
            // it means mnemonic is completed and ready to add in ans
            mnemonics.add(new String(mnemonic));
        }
        else
        {
            int currentDigit = number.charAt(currentIndex) - '0';
            if(currentDigit==0 || currentDigit==1)
            {
                // no possibility available for these two digits
                // so add directly and go to next index
                mnemonic[currentIndex]=number.charAt(currentIndex);
                helperRecursionMnemonics(number,currentIndex+1,mnemonic,mnemonics);
            }
            else
            {
                String possibleChars = keypad[currentDigit];

                // loop for all possible Chars for currentDigit
                for (int i = 0; i < possibleChars.length(); i++) {

                    // store on char and go to next digit
                    mnemonic[currentIndex] = possibleChars.charAt(i);

                    helperRecursionMnemonics(number,currentIndex+1,mnemonic,mnemonics);


                }

            }

        }

    }
}
