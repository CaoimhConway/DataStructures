/**
 * The OffByN constructor creates objects whose equalChars method return true for characters that are off by N.
 */

public class OffByN implements CharacterComparator {
    private int n;

    public OffByN(int difference) {
        n = difference;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = Math.abs(x - y);
        if (diff == n) {
            return true;
        }
        return false;
    }
}

