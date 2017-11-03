package main.java.net.trlewis.CryptoInfo;

import java.util.Objects;

public class SymbolConverter
{
    /**
     * Gets the full name of the cryptocurrency symbol passed into it
     */
    public static String symbolToFullName(CryptoSymbol symbol)
    {
        String name = null;
        switch(symbol)
        {
            case BTC:
                name = CryptoSymbolNames.Bitcoin;
                break;
            case BCC:
            case BCH:
                name = CryptoSymbolNames.BitcoinCash;
                break;
            case ETH:
                name = CryptoSymbolNames.Ethereum;
                break;
            case LTC:
                name = CryptoSymbolNames.Litecoin;
                break;
            case DASH:
                name = CryptoSymbolNames.Dash;
                break;
            case ZEC:
                name = CryptoSymbolNames.Zcash;
                break;
        }

        return name;
    }

    /**
     * @param symbolName The name of the symbol to attempt to convert
     * @return null if the symbolName was not understood, the corresponding CryptoSymbol if it was.
     */
    public static CryptoSymbol tryConvertNameToSymbol(String symbolName)
    {
        //replace all whitespace with nothing and convert to lower case
        String name = symbolName.replaceAll("\\s+", "").toLowerCase();

        if(Objects.equals(name, CryptoSymbolNames.Bitcoin.toLowerCase()))
            return CryptoSymbol.BTC;
        if(Objects.equals(name, CryptoSymbolNames.BitcoinCash.toLowerCase()))
            return CryptoSymbol.BCH; // so as to not confuse with Bitcoin Core
        if(Objects.equals(name, CryptoSymbolNames.Ethereum.toLowerCase()))
            return CryptoSymbol.ETH;
        if(Objects.equals(name, CryptoSymbolNames.Litecoin.toLowerCase()))
            return CryptoSymbol.LTC;
        if(Objects.equals(name, CryptoSymbolNames.Dash.toLowerCase()))
            return CryptoSymbol.DASH;
        if(Objects.equals(name, CryptoSymbolNames.Zcash.toLowerCase()))
            return CryptoSymbol.ZEC;

        return null;
    }
}
