
public class OffByN implements CharacterComparator {

    private int off_num;
    public OffByN(int num){
        off_num = num;
    }

    @Override
    public boolean equalChars(char char1, char char2){
        int diff = char1 - char2;
        if (diff == off_num || diff == -1 * off_num){
            return true;
        }
        else{
            return false;
        }
    }

}
