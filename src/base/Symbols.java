package base;

import java.util.HashMap;
import java.util.Map;

import static base.Symbols.EnumSymbol.*;

/**
 * Created by JasonG on 8/4/2017.
 */
public class Symbols {

    public static final char NorthT = NORTHT.character;
    public static final char SouthT = SOUTHT.character;
    public static final char EastT = EASTT.character;
    public static final char WestT = WESTT.character;
    public static final char Cross =   CROSS.character;
    public static final char HLine =    HLINE.character;
    public static final char VLine =    VLINE.character;
    public static final char NWCorner = NWCORNER.character;
    public static final char NECorner = NECORNER.character;
    public static final char SWCorner = SWCORNER.character;
    public static final char SECorner = SECORNER.character;

    public char combine(char a, char b)
    {
        return EnumSymbol.add(a,b);
    }

    enum EnumSymbol
    {//0bNESW
        NORTHT('╦', 0b0111),
        SOUTHT('╩', 0b1101),
        EASTT('╣', 0b1011),
        WESTT('╠', 0b1110),
        CROSS('╬', 0b1111),
        HLINE('═', 0b0101),
        VLINE('║', 0b1010),
        NWCORNER('╔', 0b0110),
        NECORNER('╗', 0b0011),
        SWCORNER('╚', 0b1100),
        SECORNER('╝', 0b1001);

        char character;
        int bitmask;

        static final Map<Character, EnumSymbol> charmap = new HashMap<Character, EnumSymbol>(values().length,1);
        static final Map<Integer, EnumSymbol> intmap = new HashMap<>(values().length,1);
        static{
            for(EnumSymbol sym : values())
            {
                charmap.put(sym.character, sym);
                intmap.put(sym.bitmask, sym);
            }
        }
        EnumSymbol(char charIn, int bits)
        {
            character = charIn;
            bitmask = bits;
        }
        public static char add(char a, char b)
        {
            if(b == '\u0000')
            {
                return a;
            }
            if(a == '\u0000')
            {
                return b;
            }
            try{
                EnumSymbol aES = charmap.get(a);
                EnumSymbol bES = charmap.get(b);

                EnumSymbol cES = intmap.get(aES.bitmask | bES.bitmask);
                return cES.character;
            }
            catch (Exception e)
            {
                return '■';
            }


        }

    }

}
