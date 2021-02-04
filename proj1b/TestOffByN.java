import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    //static CharacterComparator offByOne = new OffByOne();
    static CharacterComparator OBN = new OffByN(5);
    // Your tests go here.
    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/

    @Test
    public void testequalCharsN() {
        //boolean test1 = palindrome.isPalindrome("flake",OBN);
        assertTrue(OBN.equalChars('a','f'));
        //assertTrue(test1);
    }

}