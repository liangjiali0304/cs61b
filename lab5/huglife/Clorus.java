package huglife;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Clorus extends Creature {
    /**
     * red color.
     */
    private int r;
    /**
     * green color.
     */
    private int g;
    /**
     * blue color.
     */
    private int b;

    /**
     * probability of taking a move when ample space available.
     */
    private double moveProbability = 0.5;
    /**
     * move action loss.
     */
    private double moveLoss = -0.03;
    /**
     * stay action gain.
     */
    private double stayGain = -0.01;

    /**
     * fraction of energy to retain when replicating.
     */
    private double repEnergyRetained = 0.5;
    /**
     * fraction of energy to bestow upon offspring.
     */
    private double repEnergyGiven = 0.5;

    /**
     * creates clorus with energy equal to E.
     */
    public Clorus(double e) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    /**
     * creates a clorus with energy equal to 1.
     */
    public Clorus() {
        this(1);
    }

    /**
    r = 34, b = 231, g =0
     */
    @Override
    public Color color() {
        r = 34;
        b = 231;
        g = 0;
        return color(r, g, b);
    }

    /**
     * Eat Plip
     */
    public void attack(Creature c) {
        this.energy += c.energy();
    }

    /**
     * cloruss should lose 0.03 units of energy when moving.
     */
    public void move() {
        this.energy -= 0.03;
    }


    /**
     * clorus lose 0.01 energy when staying due to photosynthesis.
     */
    public void stay() {
        this.energy -= 0.01;
    }


    /**
     * clorus and their offspring each get 50% of the energy, with none
     * lost to the process. Now that's efficiency! Returns a baby
     * clorus.
     */
    public Clorus replicate() {
        energy *= repEnergyRetained;
        return new Clorus(energy * repEnergyGiven);
    }

    /**
     * cloruss take exactly the following actions based on NEIGHBORS:
     1. If there are no empty squares, the Clorus will STAY (even if there are Plips nearby
     they could attack since plip squares do not count as empty squares).
     2. Otherwise, if any Plips are seen, the Clorus will ATTACK one of them randomly.
     3. Otherwise, if the Clorus has energy greater than or equal to one, it will REPLICATE
     to a random empty square.
     4. Otherwise, the Clorus will MOVE to a random empty square.
     */
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        // Rule 1
        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        Deque<Direction> PlipNeighbors = new ArrayDeque<>();
        boolean anyPlip = false;

        for (Direction dir: neighbors.keySet()) {
            if (neighbors.get(dir).name().equals("empty")) {
                emptyNeighbors.addLast(dir);
            }

            // Rule 3
            else if (neighbors.get(dir).name().equals("plip")){
                PlipNeighbors.addLast(dir);
                anyPlip = true;
            }
        }

        if (emptyNeighbors.isEmpty()) {
            return new Action(Action.ActionType.STAY);
        }


        // Rule 2
        if (anyPlip) {
            return new Action(Action.ActionType.ATTACK, HugLifeUtils.randomEntry(PlipNeighbors));
        }


        // Rule 3
        // HINT: randomEntry(emptyNeighbors)

        if(energy >= 1.0 ){
            return new Action(Action.ActionType.REPLICATE,HugLifeUtils.randomEntry(emptyNeighbors));
        }


        // Rule 4
        return new Action(Action.ActionType.MOVE,HugLifeUtils.randomEntry(emptyNeighbors));
    }

}
