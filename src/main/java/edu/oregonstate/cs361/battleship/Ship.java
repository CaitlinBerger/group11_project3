package edu.oregonstate.cs361.battleship;

/**
 * Created by michaelhilton on 1/5/17.
 */
public class Ship {
    private String name;
    private int length;
    private Coordinate start;
    private Coordinate end;
    private boolean stealth;

    public Ship(String n, int l,Coordinate s, Coordinate e, boolean hideme) {
        name = n;
        length = l;
        start = s;
        end = e;
        stealth = hideme;
    }

    public void setLocation(Coordinate s, Coordinate e) {
        start = s;
        end = e;

    }

    public boolean covers(Coordinate test) {
        //horizontal
        if(start.getAcross() == end.getAcross()){
            if(test.getAcross() == start.getAcross()){
                if((test.getDown() >= start.getDown()) &&
                (test.getDown() <= end.getDown()))
                return true;
            } else {
                return false;
            }
        }
        //vertical
        else{
            if(test.getDown() == start.getDown()){
                if((test.getAcross() >= start.getAcross()) &&
                        (test.getAcross() <= end.getAcross()))
                    return true;
            } else {
                return false;
            }

        }
        return false;
    }

    public String getName() {
        return name;
    }

    public boolean getStealth() {
        return stealth;
    }


    public boolean scan(Coordinate coor) {
        boolean scanResult = false;
        if(covers(coor)){
            scanResult = true;
        }
        if(covers(new Coordinate(coor.getAcross()-1,coor.getDown()))){
            scanResult = true;
        }
        if(covers(new Coordinate(coor.getAcross()+1,coor.getDown()))){
            scanResult = true;
        }
        if(covers(new Coordinate(coor.getAcross(),coor.getDown()-1))){
            scanResult = true;
        }
        if(covers(new Coordinate(coor.getAcross(),coor.getDown()+1))){
            scanResult = true;
        }
        if(this.stealth){
            scanResult = false;
        }

        return scanResult;
    }
}

