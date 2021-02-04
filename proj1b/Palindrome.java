public class Palindrome {
    public Deque<Character> wordToDeque(String word){

        ArrayDeque <Character> return_deque = new ArrayDeque(word.length());

        for (int i = 0; i < word.length(); i++) {
            return_deque.addLast(word.charAt(i));
        }
        return return_deque;
    }



    /**
     * Test whether a given word is a palindrome or not. Without Recursion.
     * @param word
     * @return true if the word is palindrome, false otherwise
     */
    public boolean isPalindrome(String word){
        Deque <Character> original = wordToDeque(word);
        for (int i = 0; i< word.length()/2; i++) {
            char front = original.removeFirst();
            char end = original.removeLast();
            if(front != end) {
                return false;
            }
        }
        return true;
    }


    public boolean isPalindrome(String word, CharacterComparator cc) {

        Deque <Character> original = wordToDeque(word);
        for (int i = 0; i< word.length()/2; i++) {
            char front = original.removeFirst();
            char end = original.removeLast();
            if(!cc.equalChars(front,end)) {
                return false;
            }
        }
        return true;
    }

}
