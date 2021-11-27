package ui;

public class Password {
    public static char[] verschluesseln(int offset, char[] charArray) {

        char[] cryptArray = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            int verschiebung = (charArray[i] + offset)%128;
            cryptArray[i] = (char) (verschiebung);
        }
        return cryptArray;

    }

    // hier die Methode zum entschlüsseln

    public static char[] entschluesseln(int offset, char[] charArray) {
        char[] cryptArray = new char[charArray.length];
        int verschiebung;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] - offset < 0)  verschiebung =
                    charArray[i] - offset + 128;
            else verschiebung = (charArray[i] - offset)%128;
            cryptArray[i] = (char) (verschiebung);
        }
        return cryptArray;

    }
}
