package tia.model;

public class Position {
    
    private int px, py;

    public Position(int x, int y) {
        setPosition(x, y);
    }

    public Position(Position pos) {
        this(pos.getX(), pos.getY());
    }

    public int getX(){
        return px;
    }

    public int getY() {
        return py;
    }

    private void setX(int x) {
        px = x;
    }

    private void setY(int y) {
        py = y;
    }

    public void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }

/**Check if the piece is in its place */
    public boolean equals(Position pos) {
        if (pos == null)
            return false;
        return (pos.px == px && pos.py == py);

    }

/**<print the position of the current piece */
    public String PrintPosition() {
        StringBuilder builder = new StringBuilder("[");
        builder.append(px)
                .append(",")
                .append(py)
                .append("]");
        
        return builder.toString();
    }

/** Get the four neighbors (top, bottom, left, right) of the piece  */
    public Position[] getAdjacency() {
        return new Position[] {
                new Position(px - 1, py),
                new Position(px, py + 1),
                new Position(px + 1, py),
                new Position(px, py - 1)
        };
    }

}
