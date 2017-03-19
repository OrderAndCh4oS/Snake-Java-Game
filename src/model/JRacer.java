package model;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarcoma on 05/03/17.
 */
public class JRacer {
    private int x;
    private int y;
    private Color colour;
    private ArrayList<Point> trail;

    public JRacer(final Color colour) {
        x = 40;
        y = 30;
        this.colour = colour;
        trail = new ArrayList<Point>();
        trail.add(new Point(x, y));
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public Color getColour() {
        return colour;
    }

    public void addPointToTrail(Point point) {
        this.trail.add(point);
    }

    public List<Point> getTrail() {
        return trail;
    }

    @Override
    public String toString() {
        String str = "X: " + x;
        str = str + ", ";
        str = str + "Y: " + y;
        return str;
    }
}
