public class OffByOne implements CharacterComparator{


    @Override
    public boolean equalChars(char char1, char char2){
        int diff = char1 - char2;
        if (diff == 1 || diff == -1){
            return true;
        }
        else{
            return false;
        }
    }

}
