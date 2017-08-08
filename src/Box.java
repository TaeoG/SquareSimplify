/**
 * Created by JasonG on 8/3/2017.
 */
public class Box {
    int x;
    int y;
    int w;
    int h;
    char name;

    public Box(char name, int x, int y)
    {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    public boolean containsCoord(int xIn, int yIn)
    {
        return xIn < x + w && xIn >= x && yIn < y + h && yIn >= y;
    }
    public int getMaxX()
    {
        return x + w;
    }
    public int getMaxY()
    {
        return y + h;
    }
    public int getArea()
    {
        return w*h;
    }
    public boolean coversWRange(int x1, int x2)
    {
        return x1 >= x && x2 < x+w;
    }
    public boolean coversHRange(int y1, int y2)
    {
        return y1 >= y && y2 < y+h;
    }


    public void widen(int amount)
    {
        w += amount;
    }

    public void heighten(int amount)
    {
        h += amount;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

}
