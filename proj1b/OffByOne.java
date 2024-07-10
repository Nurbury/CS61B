
/*
 *@title OffByOne
 *@author NorBury
 *@version 1.0
 *@create 2024/7/9 16:56
 *@description
 */


public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
        if ((x - y) == 1 || (x - y) == -1) {
            return true;
        }
        return false;
    }


}
