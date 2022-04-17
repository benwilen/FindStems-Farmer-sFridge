import java.util.*;

public class getStemsTest {

    public static Set<String> getStems(String original) {

        Set<String> allStems = new HashSet<String>();

        allStems.add(original);

        if (original.length() > 1) {
            char lastChar = original.charAt(original.length() - 1);

            if (lastChar == 'L') {
                allStems.addAll(getStems(original.substring(0, original.length() - 1)));
            }

            if (original.length() > 2) {
                String lastTwoChar = original.substring(original.length() - 2, original.length());

                if (lastTwoChar.equals("LZ") || lastTwoChar.equals("ZQ")) {
                    allStems.addAll(getStems(original.substring(0, original.length() - 2)));
                    return allStems;
                }

                if (original.length() > 3) {
                    String lastThreeChar = original.substring(original.length() - 3, original.length());

                    if (lastThreeChar.equals("EVM")) {
                        allStems.addAll(getStems(original.substring(0, original.length() - 3)));
                        return allStems;
                    }

                    if (lastThreeChar.equals("EZL")) {
                        allStems.addAll(getStems(original.substring(0, original.length() - 3) + "R"));
                    }

                    if (lastThreeChar.equals("PZL")) {
                        allStems.addAll(getStems(original.substring(0, original.length() - 3) + "A"));
                        allStems.addAll(getStems(original.substring(0, original.length() - 3) + "AZ"));
                    }
                }
            }
        }

        return allStems;
    }

    public static void main(String args[]) {
        System.out.println(getStems(args[0]));
    }

}
