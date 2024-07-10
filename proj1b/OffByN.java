
/*
 *@title OffByN
 *@author NorBury
 *@version 1.0
 *@create 2024/7/9 16:57
 *@description
 */


public class OffByN implements CharacterComparator{
    private int sentance;

    public OffByN(int N) {
        sentance = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if ((x - y) == sentance || (x-y) == -sentance) {
            return true;
        }
        return false;
    }
}
