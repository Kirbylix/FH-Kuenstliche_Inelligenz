package goals;

import tracker.Position;

public final class RatedPosition {
    public final int direction;
    private int fRating;
    private int gRating;
    private int hRating;
    public final RatedPosition parent;
    public final Position position;

    /**
     * Konstruktor
     * @param _parent
     * @param _position
     * @param _direction
     */
    public RatedPosition(RatedPosition _parent, Position _position, int _direction){
        this.direction = _direction;
        this.parent = _parent;
        this.position = _position;
    }

    public int distance(int x, int y){
        //TODO
        return 0;
    }

    public void calcFRating(){
        //TODO
    }

    public int getfRating(){
        return this.fRating;
    }

    public void setgRating(int _rating){
        this.gRating = _rating;
    }

    public int getGRating(){
        return this.gRating;
    }

    public void setHRating(int _rating){
        this.hRating = _rating;
    }

    public int getHrating(){
        return this.hRating;
    }
}