package org.example;

import java.util.stream.Collectors;

public class NumString {

    private String str;

    public NumString(String str) {
        this.str = str;
    }

    public String getString() {
        return str;
    }

    public void setString(String str) {
        this.str = str;
    }

    public int getCountNumberInString() {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isNumberCharacter(str.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public String getSubstrOnlyNumber() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (isNumberCharacter(str.charAt(i))) {
                stringBuffer.append(str.charAt(i));
            }
        }
        return new String(stringBuffer);
    }

    private boolean isNumberCharacter(char ch) {
        return ('0' <= ch && ch <= '9');
    }

    @Override
    public String toString() {
        return "NumString{\n" +
                "\tstr='" + str + '\'' +
                "\n\tthe number of numbers: " + getCountNumberInString() +
                "\n\t==>" + getSubstrOnlyNumber() +
                "\n}";
    }
}
