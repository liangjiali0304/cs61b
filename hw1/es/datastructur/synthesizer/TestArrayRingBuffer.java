package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;
import org.junit.Test;

import java.awt.*;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(6);
        arb.enqueue(33.1); // 33.1 null null  null
        arb.enqueue(44.8); // 33.1 44.8 null  null
        arb.enqueue(62.3); // 33.1 44.8 62.3  null
        arb.enqueue(-3.4); // 33.1 44.8 62.3 -3.4
        double removed = (double) arb.dequeue();     // 44.8 62.3 -3.4  null (returns 33.1)
        assertEquals(removed,33.1,0.01);
    }

    @Test
    public void Test_circle() {
        ArrayRingBuffer arb = new ArrayRingBuffer(6);
        arb.enqueue(33.1); // 33.1 null null  null
        arb.enqueue(44.8); // 33.1 44.8 null  null
        arb.enqueue(62.3); // 33.1 44.8 62.3  null
        arb.enqueue(-3.4); // 33.1 44.8 62.3 -3.4
        assertEquals(44.8,(double) arb.peek(),0.01);
    }
}
