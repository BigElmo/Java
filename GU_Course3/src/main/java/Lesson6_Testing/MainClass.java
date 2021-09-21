package Lesson6_Testing;

public class MainClass {

    public int[] getAfter4Array(int[] sourceArray) {
        int last4index = -1;
        int[] result;
        for (int i = 0; i < sourceArray.length; i++) {
            if (sourceArray[i] == 4) {
                last4index = i;
            }
        }
        if (last4index == -1) {
            result = new int[1];
            try {
                result[0] = sourceArray[last4index];
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        } else {
            result = new int[sourceArray.length - last4index - 1];
            try {
                for (int i = 0; i < result.length; i++) {
                    result[i] = sourceArray[last4index + 1 + i];
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean has1and4Array(int[] sourceArray) {
        boolean has1 = false;
        boolean has4 = false;
        for (int e : sourceArray) {
            if (e == 1) {
                has1 = true;
            } else if (e == 4) {
                has4 = true;
            } else
                return false;
            }
        return (has1 && has4);
    }
}
