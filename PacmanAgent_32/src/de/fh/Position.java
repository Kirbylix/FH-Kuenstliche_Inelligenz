package de.fh;

/**
 * Created by Kai on 25.10.2015.
 */
public class Position {
    private int x;
    private int y;

    /**
     * Konstruktor
     * @param x
     * @param y
     */
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Vergleichs Methoden gegen�bre einer anderen Position
     * @param
     * @return
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

    @Override
    public String toString(){
        return this.x + "|" + this.y;
    }

    /**
     * X Getter
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Y Getter
     * @return
     */
    public int getY() {
        return y;
    }

    public void decX(){this.x--;}
    public void decY(){this.y--;}
    public void incX(){this.x++;}
    public void incY(){this.y++;}

}
