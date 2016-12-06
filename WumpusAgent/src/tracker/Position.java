package tracker;

/**
 * Position mit x/y - Koordinate
 */
public final class Position {
    private final int x;
    private final int y;

    /**
     * Konstruktor
     * @param x x-Koordinate
     * @param y y-Koordinate
     */
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Vergleichs Methoden gegen�bre einer anderen Position
     * @param object Position
     * @return true/false
     */
    @Override
    public boolean equals(Object object){
        assert (object != null);
        Position position2 = null;
        if(object instanceof Position)
            position2 = (Position) object;

        if(x == position2.getX() && y == position2.getY()){
            return true;
        }
        return false;
    }

    /**
     * Position Ausgabe
     * @return x / y
     */
    @Override
    public String toString(){
        return this.x + "|" + this.y;
    }

    /**
     * Manhatten-Distanz der Position zur Uebergebenen Position
     * @param _position Position
     * @return Manhatten-Distanz
     */
    public int distance(Position _position){
        int x = Math.abs(this.x - _position.getX());
        int y = Math.abs(this.y - _position.getY());
        return x + y;
    }
    /**
     * X Getter
     * @return x-Koordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Y Getter
     * @return y-Koordinate
     */
    public int getY() {
        return y;
    }

}
