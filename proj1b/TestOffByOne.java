import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    static Palindrome palindrome = new Palindrome();
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    // Your tests go here.
    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/


    @Test
    public void testequalChars() {
        boolean test1 = palindrome.isPalindrome("flake",offByOne);
        assertTrue(test1);
    }


}
