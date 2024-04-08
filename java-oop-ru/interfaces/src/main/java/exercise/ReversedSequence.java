package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String str;

    ReversedSequence(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result = result + str.charAt(i);
        }
        this.str = result;
    }
    @Override
    public int length() {
        return str.length();
    }

    @Override
    public char charAt(int index) {
        return this.str.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.str.substring(start, end);
    }

    @Override
    public String toString() {
        return this.str;
    }
}
// END
