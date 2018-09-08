package edu.gatech.seclass;
public class MyCustomString implements MyCustomStringInterface {
    public String inputstring;

    @Override
    public String getString() {
        if (inputstring == null || inputstring.isEmpty()) {
            return null;
        } else {
            return inputstring;
        }
    }

    @Override
    public void setString(String string) {
        inputstring = string;
    }

    @Override
    public int countDuplicates() {
        int count;
        if (inputstring == null || inputstring.isEmpty()) {
            return 0;
        } else {
            count = 0;
            for (int i = 0; i < inputstring.length() - 1; i++) {
                if (inputstring.charAt(i) == inputstring.charAt(i + 1)) {
                    count++;
                }
            }
            return count;
        }
    }

    @Override
    public String addDigits(int n, boolean positive) {
        int currentdigit = 0;
        String outputstring = "";
        if (inputstring == null) {
            throw new NullPointerException("Null pointer exception error: inputstring is null.");
        } else {
            if (n > 9 || n <= 0) {
                throw new IllegalArgumentException("Illegal argument exception error: n>9 or n<=0");
            } else {
                for (int i = 0; i < inputstring.length(); ++i) {
                    if (Character.isDigit(inputstring.charAt(i))) {
                        if (positive == true) {
                            currentdigit = Integer.parseInt(inputstring.substring(i, i + 1)) + n;
                        }
                        if (positive == false) {
                            currentdigit = Integer.parseInt(inputstring.substring(i, i + 1)) - n;
                        }
                        currentdigit += 10;
                        currentdigit %= 10;
                        outputstring += Integer.toString(currentdigit);
                    } else {
                        outputstring += inputstring.substring(i, i + 1);
                    }
                }
                return outputstring;
            }
        }
    }


    @Override
    public void flipLetttersInSubstring(int startPosition, int endPosition) {
        String outputstring = "";
        String letterstring = "";
        String newletterstring = "";
        int lettercount = 0;
        if (inputstring == null) {
            throw new NullPointerException("error: current string is null");
        }
            else{
                if (endPosition > inputstring.length()||startPosition<=0) {
                    throw new MyIndexOutOfBoundsException("error: endPosition > string length and startPosition <=0,  out of bounds");
                }
                else{
                    if (startPosition > endPosition) {
                        throw new IllegalArgumentException("error: startPosition > endPosition");
                    }
                    else{
                        for (int i = 0; i < startPosition - 1; ++i) {
                            outputstring += inputstring.substring(i, i + 1);
                        }
                        for (int i = startPosition - 1; i < endPosition; ++i) {
                            if (Character.isLetter(inputstring.charAt(i))) {
                                letterstring += inputstring.substring(i, i + 1);
                            }
                        }
                        for (int i = 0; i < letterstring.length(); ++i) {
                            newletterstring += letterstring.substring(letterstring.length() - i - 1, letterstring.length() - i);
                        }
                        for (int i = startPosition - 1; i < endPosition; ++i) {
                            if (Character.isLetter(inputstring.charAt(i))) {
                                outputstring += newletterstring.substring(lettercount, lettercount + 1);
                                ++lettercount;
                            } else {
                                outputstring += inputstring.substring(i, i + 1);
                            }
                        }
                        if (endPosition < inputstring.length()) {
                            for (int i = endPosition; i < inputstring.length(); ++i) {
                                outputstring += inputstring.substring(i, i + 1);
                            }
                        }
                        inputstring = outputstring;
                    }
                }
            }
    }
}