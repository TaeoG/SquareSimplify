package base;
import static base.Symbols.*;
/**
 * Created by JasonG on 8/4/2017.
 */
public class CharImage {

    private final int width;
    private final int height;
    private char[] contents;
    //private final int zoom;


    public CharImage(int width, int height)
    {
        //zoom = 3;
        this.width = width*2;
        this.height = height*2;
        contents = new char[this.width*this.height];
    }
    /*public CharImage(int width, int height, char[] in)
    {
        this.width = width;
        this.height = height;
        this.contents = in;
    }*/

    private char getCharAt(int x, int y)
    {
        return contents[y* width + x];
    }


    private void setCharAt(char c, int x, int y)
    {
        try{
            char former = contents[y* width + x];
            char output = Symbols.EnumSymbol.add(c,former);

            contents[y * width + x] = output;
        }
        catch(Exception e)
        {
            //do nothing
        }


    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        for(int y = 0; y< width; y++)
        {
            for(int x = 0; x < width; x++)
            {
                builder.append(getCharAt(x,y));
            }
            builder.append('\n');
        }
        return builder.toString();
    }

    public void drawBox(int xIn, int yIn, int w, int h)
    {
        xIn = 2* xIn;
        yIn = 2* yIn;
        w = 2*w;
        h = 2*h;
        setCharAt(NWCorner, xIn, yIn);
        setCharAt(NECorner, xIn + w -1, yIn);
        setCharAt(SWCorner, xIn, yIn + h - 1);
        setCharAt(SECorner, xIn + w -1, yIn + h - 1);

        drawVLine(xIn, yIn + 1, h - 2);
        drawVLine(xIn + w - 1, yIn+ 1, h- 2);
        drawHLine(xIn + 1, yIn, w - 2);
        drawHLine(xIn + 1, yIn + h -1, w-2);
    }
    public void drawHLine(int x, int y, int length)
    {
        for(int i = x; i< x + length; i++)
        {
            setCharAt(HLine,i,y);
        }

    }
    public void drawVLine(int x, int y, int length)
    {
        for(int i = y; i< y+length; i++)
        {
            setCharAt(VLine,x,i);
        }
    }
}
