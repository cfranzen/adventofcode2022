package de.cfranzen.adventofcode.day3;

record ItemType(char type) {

    ItemType(char type) {
        this.type = type;

        if (!isAsciiLetter(type)) {
            throw new IllegalArgumentException("Provided type is not valid ASCII letter");
        }
    }

    public int getPriority() {
        if (isLowercaseAscii(type)) {
            return type - 'a' + 1;
        } else {
            return type - 'A' + 27;
        }
    }

    public static boolean isAsciiLetter(char ch) {
        return isLowercaseAscii(ch) || isUppercaseAscii(ch);
    }

    private static boolean isUppercaseAscii(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    private static boolean isLowercaseAscii(char ch) {
        return ch >= 'a' && ch <= 'z';
    }
}
