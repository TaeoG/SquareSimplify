import base.CharImage;
import com.sun.deploy.util.OrderedHashSet;

import java.util.TreeMap;

/**
 * Created by JasonG on 8/3/2017.
 */
public class Simplify {
// alt 254
    static String input =
                    "■■■■■■■■■■■■■■■■" +
                    "■■■■■■■■■■■■■■■■" +
                    "■■■■■■■■■■■■■■■■" +
                    "■■■■■ ■■■■ ■■■■■" +
                    "■■■■■ ■■■■ ■■■■■" +
                    "■■■■■ ■■■■ ■■■■■" +
                    "■■■■■ ■■■■ ■■■■■" +
                    "■■■■■ ■■■■ ■■■■■" +
                    "■■■■■■■■■■■■■■■■" +
                    "■■■ ■■■■■■■■ ■■■" +
                    "■■■■ ■■■■■■ ■■■■" +
                    "■■■■■      ■■■■■" +
                    "■■■■■■■■■■■■■■■■" +
                    "■■■■■■■■■■■■■■■■" +
                    "■■■■■■■■■■■■■■■■" +
                    "■■■■■■■■■■■■■■■■";
    static OrderedHashSet output = new OrderedHashSet();


    public static void main(String[] args)
    {
        System.out.println("Input :");
        //CharImage image = new CharImage(16,16, input.toCharArray());
        CharImage image = new CharImage(16,16);
        char[] inputarray = input.toCharArray();
        for(int y = 0; y < 16; y++)
        {
            for(int x = 0; x< 16; x++)
            {
                if(inputarray[y*16 + x] == '■')
                {
                    image.drawBox(x,y,1,1);
                }
            }
        }
        System.out.print(image.toString());

    }
}
