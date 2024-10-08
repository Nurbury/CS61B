import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        Assert.assertFalse(offByOne.equalChars('a','v'));
        Assert.assertTrue(offByOne.equalChars('a','b'));
        Assert.assertTrue(offByOne.equalChars('d','c'));
        Assert.assertTrue(offByOne.equalChars('&','%'));
        Assert.assertFalse(offByOne.equalChars('a','a'));
    }
    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/

}
