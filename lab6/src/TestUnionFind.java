import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;
import org.junit.Test;

public class TestUnionFind {
    @Test
    public void testBasics() {
        UnionFind test_arr = new UnionFind(8);
        // check if initials are connected : should be no
        assertEquals(false,test_arr.connected(0,1));

        // union first 2
        test_arr.union(0,1);
        int size_test = test_arr.sizeOf(0);
        System.out.println(size_test);
        assertEquals(2,test_arr.sizeOf(1));

        // test connected
        test_arr.union(2,3);
        test_arr.union(0,3);
        assertEquals(true,test_arr.connected(1,2));

    }

    @Test
    public void testPathContraction() {
        UnionFind test_arr = new UnionFind(8);

        // union first 5
        test_arr.union(0,1);
        test_arr.union(2,3);
        test_arr.union(0,3);
        test_arr.union(0,4);
        assertEquals(3, test_arr.parent(0));
        assertEquals(4, test_arr.sizeOf(0));

    }


    @Test
    public void testinvalid() {
        UnionFind test_arr = new UnionFind(8);

        // union first 5
        //test_arr.union(-1,1);

    }


}
