package tia.model;

import tia.model.PathFinding.Graph;

public class Agent extends Thread {
    private Position position;
    private Position position_final;
    private int id, priority;
    private Startegy strategy;
//TODO: define the Strategy class

/** Agent constructor */
    public Agent(Position init, Position fin) {
        position = null;
        id = -1;
        priority = -1;
        setPosition(init);
        setFinalPosition(fin);

    }

    public synchronized void setAgentId(int agent_id) {
        id = agent_id;
    }

    public synchronized void setAgentPriority(int agent_prio) {
        priority = agent_prio;
    }

    public int getAgentPriority() {
        return priority;
    }

    public int getAgentId() {
        return id;
    }

    public Position getInitPosition() {
        return position;
    }

    public Position getFinalPosition() {
        return position_final;
    }

    public synchronized void setPosition(Position pos) {
        position = new Position(pos);
        //TODO : Create the graph class with the A* algorithm
        Graph.setFree(position, false);
        if (ReachedPosition()) {
            Graph.block(position);
        }
    }

    public synchronized void setFinalPosition(Position pos) {
        position_final = new Position(pos);
    }

/** Check if the piece is in the right final position */
    boolean ReachedPosition() {
        return position.equals(position_final);
    }

}
