import base.CharImage;

import java.util.ArrayList;
import java.util.Iterator;

import static base.Symbols.NorthT;

/**
 * Created by JasonG on 8/3/2017.
 */
public class ChunkSlice {

    ArrayList<Box> contents = new ArrayList<Box>();
    boolean[] raw;
    int nextBoxName = 0;
    String output;


    public ChunkSlice(String in)
    {
        raw = new boolean[in.length() - 16];
        process(in);
        simplify();
    }
    CharImage simplify()
    {
        for(int x = 0; x< 16; x++)
        {
            for(int y = 0; y < 16; y++)
            {
                Box adj = getBoxAt(x, y-1);
                if(adj != null && adj.getW() == 1)
                {
                    adj.heighten(1);
                }
            }
        }
        return null; //placeholder
    }
    void mergeBoxes(Box box)
    {
        boolean north = false;
        int northsplit = 0;
        boolean west = false;
        int westsplit = 0;
        Box northbox = getBoxAt(box.getX(), box.getY() - 1);
        Box westbox = getBoxAt(box.getX() -1, box.getY());

        if(northbox != null && northbox.coversWRange(box.getX(), box.getMaxX()))
        {

        }
    }
    int splitbox(Box box, int xPlane, int yPlane)
    {
        return 0;
    }
    Box getBoxAt(int x, int y)
    {
        for(Box b: contents)
        {
            if(b.containsCoord(x,y)) return b;
        }
        return null;
    }
    boolean isTouchingUp(int x, int y)
    {
        return y == 0? false : getRawVoxel(x, y-1);
    }
    boolean isTouchingLeft(int x, int y)
    {
        return x == 0? false : getRawVoxel(x-1, y);
    }
    boolean getRawVoxel(int x, int y)
    {
        return raw[y*16 + x];
    }

    private void process(String input)
    {
        int booloffset = 0;
        for(char c : input.toCharArray())
        {
            switch (c)
            {
                case '■': raw[booloffset] = true; booloffset ++; break;
                case '\n': break;
                default: raw[booloffset] = false; booloffset ++; break;
            }
        }

    }


}
