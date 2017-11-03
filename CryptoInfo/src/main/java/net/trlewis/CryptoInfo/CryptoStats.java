package net.trlewis.CryptoInfo;

public class CryptoStats
{
    public static String baseUnitName(CryptoSymbol symbol)
    {
        String name = null;

        switch(symbol)
        {
            case BTC:
            case BCC:
            case BCH:
                name = "Satoshi";
                break;
            case ETH:
                name = "Wei";
                break;
            case LTC:
                name = "Litoshi";
                break;
            case DOGE:
                name = "Kabosu"; // "Shibe?"
                break;
        }

        return name;
    }

    /**
     * How many decimal places the main unit of the currency has.
     */
    public static int decimalPlaces(CryptoSymbol symbol)
    {
        int decimalPlaces = 0;

        switch(symbol)
        {
            case BTC:
            case BCC:
            case BCH:
            case DOGE:
                decimalPlaces = 8;
                break;
            case ETH:
                decimalPlaces = 14;
                break;
            //TODO: the rest of this
        }

        return decimalPlaces;
    }

    /**
     * Whether or not there is a finite supply of the currency that will ever exist (deflationary).
     */
    public static boolean isSupplyFinite(CryptoSymbol symbol)
    {
        boolean isFinite = false;

        // only add in ones that are finite
        switch(symbol)
        {
            case BTC:
            case BCC:
            case BCH:
            case LTC:
            case DASH:
                isFinite = true;
            //TODO: the other finite coins
        }

        return isFinite;
    }

    /**
     * The name of the main, most common, unit of the currency. Not to be confused with the smallest unit.
     */
    public static String mainUnitName(CryptoSymbol symbol)
    {
        String name = null;

        switch(symbol)
        {
            case BTC:
                name = "Bitcoin";
                break;
            case BCC:
            case BCH:
                name = "Bitcoin"; // "Bitcoin Cash?"
                break;
            case ETH:
                name = "Ether";
                break;
            case LTC:
                name = "Litecoin";
                break;
            case DASH:
                name = "Dash"; // is that true?
                break;
            case ZEC:
                name = "Zcash"; // is that true?
                break;
        }

        return name;
    }


    /**
     * The total amount of main units of the cryptocurrency that will ever exist. Returns a negative value if
     * the currency does not have a finite supply.
     */
    public static long maximumSupply(CryptoSymbol symbol)
    {
        long maxSupply = -1;

        switch(symbol)
        {
            case BTC:
            case BCC:
            case BCH:
            case ZEC:
                maxSupply = 21000000;
                break;
            // case ETH: // not finite
            case LTC:
                maxSupply = 84000000;
                break;
            // case DOGE: // not finite
            case DASH:
                maxSupply = 22000000;
                break;
        }

        return maxSupply;
    }


}
