package exception;

import java.util.Arrays;

public class ToxicDemo {
    private final static String prefix = "You ";
    private final static String postfix = " use OOP";

    public static void main(String[] args) {
        try {
            printOOPString("can");
        } catch (ToxicException e) {
            System.out.println("Конечно могу, исключения не будет");
        }

        try {
            printOOPString("have to");
        } catch (ToxicException e) {
            System.out.println("Не видать автору прекрасного стейтлес кода...");
        }
    }

    public static void printOOPString(String str) throws ToxicException{
        String[] illegalStrings = {
                "have to",
                "should",
        };

        if (Arrays.asList(illegalStrings).contains(str)) {
            throw new ToxicException(
                    "Не надо навязывать мне ООП, это один из инструментов, а не серебрянная пуля"
            );
        }

        System.out.println(prefix + str + postfix);
    }
}
