package huglife;
import huglife.Plip;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.Impassible;
import huglife.Empty;
import org.junit.Test;

import java.awt.*;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TestClorus {


    @Test
    public void testBasics() {
        Clorus p = new Clorus(2);
        assertEquals(2, p.energy(), 0.01);
        assertEquals(new Color(34, 0, 231), p.color());
        p.move();
        assertEquals(1.97, p.energy(), 0.01);
        p.move();
        assertEquals(1.94, p.energy(), 0.01);
        p.stay();
        assertEquals(1.93, p.energy(), 0.01);
        p.stay();
        assertEquals(1.92, p.energy(), 0.01);
    }

    @Test
    public void testReplicate() {
        Clorus p = new Clorus(2);
        Clorus baby = p.replicate();
        assertEquals(1, p.energy(), 0.01);
    }

    @Test
    public void testChoose() {

        // No empty adjacent spaces; stay.
        Clorus c = new Clorus(2);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());

        Action actual = c.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.STAY);

        assertEquals(expected, actual);


        // Energy >= 1; replicate towards an empty space.
        c = new Clorus(2);
        HashMap<Direction, Occupant> topEmpty = new HashMap<Direction, Occupant>();
        topEmpty.put(Direction.TOP, new Empty());
        topEmpty.put(Direction.BOTTOM, new Impassible());
        topEmpty.put(Direction.LEFT, new Impassible());
        topEmpty.put(Direction.RIGHT, new Impassible());

        actual = c.chooseAction(topEmpty);
        expected = new Action(Action.ActionType.REPLICATE, Direction.TOP);

        assertEquals(expected, actual);


        // Energy >= 1; replicate towards an empty space.
        c = new Clorus(2);
        HashMap<Direction, Occupant> allEmpty = new HashMap<Direction, Occupant>();
        allEmpty.put(Direction.TOP, new Empty());
        allEmpty.put(Direction.BOTTOM, new Empty());
        allEmpty.put(Direction.LEFT, new Empty());
        allEmpty.put(Direction.RIGHT, new Empty());

        actual = c.chooseAction(allEmpty);
        Action unexpected = new Action(Action.ActionType.STAY);

        assertNotEquals(unexpected, actual);

        // Energy >= 1; replicate towards an empty space.
        c = new Clorus(2);
        Plip p = new Plip(.99);
        HashMap<Direction, Occupant> OnePlip = new HashMap<Direction, Occupant>();
        OnePlip.put(Direction.TOP, p);
        OnePlip.put(Direction.BOTTOM, new Empty());
        OnePlip.put(Direction.LEFT, new Empty());
        OnePlip.put(Direction.RIGHT, new Empty());

        actual = c.chooseAction(OnePlip);
        expected = new Action(Action.ActionType.ATTACK, Direction.TOP);
        assertEquals(expected, actual);

        // All Plip
        c = new Clorus(2);
        HashMap<Direction, Occupant> AllPlip = new HashMap<Direction, Occupant>();
        AllPlip.put(Direction.TOP, new Plip(1.99));
        AllPlip.put(Direction.BOTTOM, new Plip(1.99));
        AllPlip.put(Direction.LEFT, new Plip(1.99));
        AllPlip.put(Direction.RIGHT, new Plip(1.99));

        actual = c.chooseAction(AllPlip);
        expected = new Action(Action.ActionType.STAY);
        assertEquals(expected, actual);
    }



}
