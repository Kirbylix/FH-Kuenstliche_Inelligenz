package environment;

/**
 * Richtungen werden als Zahlen verwendet, und diese Klasse verwaltet die Zuordnung von Himmelsrichtung und Zahl.
 * Nord = 0
 * Ost  = 1
 * SÃ¼d  = 2
 * West = 3
 */
public final class Direction {

    static final int NORTH = 0;
    static final int EAST = 1;
    static final int SOUTH = 2;
    static final int WEST = 3;

    public Direction(){
    }

    public static int turnLeft(int _direction){
        if(_direction == NORTH){
            return WEST;
        }
        return _direction-1;
    }

    public static int turnRight(int _direction){
        if(_direction == WEST){
            return NORTH;
        }
        return _direction+1;
    }

    public static int turnAround(int _direction){
        switch(_direction){
            case 0: return SOUTH;
            case 1: return WEST;
            case 2: return NORTH;
            case 3: return EAST;
            default: System.err.println("Direction.turnAround: falscher Übergabeparameter: " + _direction);
                break;
        }
        return -1;
    }

    public static int getX(int _direction){
        switch(_direction){
            case 0: return 0;
            case 1: return 1;
            case 2: return 0;
            case 3: return -1;
            default: System.err.println("Direction.getX: falscher Übergabeparameter: " + _direction);
                break;
        }
        return 0;
    }

    public static int getY(int _direction){
        switch(_direction){
            case 0: return -1;
            case 1: return 0;
            case 2: return 1;
            case 3: return 0;
            default: System.err.println("Direction.getY: falscher Übergabeparameter: " + _direction);
                break;
        }
        return 0;
    }

    public static boolean isHorizontal(int _direction){
        if(_direction == EAST || _direction == WEST){
            return true;
        }
        return false;
    }

    public static boolean isVertical(int _direction){
        if(_direction == NORTH || _direction == SOUTH){
            return true;
        }
        return false;
    }

    public static String toString(int _direction){
        return "Direction: " + _direction;
    }



}
