package net.trlewis.CryptoSandbox;

import net.trlewis.CryptoBalanceGetters.BlockChainInfoBitcoinBalanceGetter;
import net.trlewis.CryptoBalanceGetters.BlockCypherBitcoinBalanceGetter;
//import net.trlewis.CryptoBalanceGetters.BlockExplorerBitcoinBalanceGetter;
import net.trlewis.CryptoBalanceGetters.IBalanceGetter;
import net.trlewis.CryptoInfo.AddressBalance;
import net.trlewis.CryptoInfo.CryptoSymbol;
import net.trlewis.CryptoInfo.SymbolConverter;
import net.trlewis.CryptoValueGetters.CryptoCompareValueGetter;
import net.trlewis.CryptoValueGetters.IValueGetter;

import java.math.BigDecimal;

public class MainClass
{
    public static void main(String[] args)
    {
        checkBitcoinBalanceGetters();
//        BigDecimal testDec = new BigDecimal(100.234234).setScale(2, BigDecimal.ROUND_DOWN);
//        String testStr = String.format("$%1$s", testDec);
//        System.out.println(testStr);
    }

    private static void checkBitcoinBalanceGetters()
    {
        final String testAddr = "19cSneAZrewkySQ8yV3DrnxMWX1okxZiMe";

//        IBalanceGetter getter = new BlockChainInfoBitcoinBalanceGetter();
        IBalanceGetter getter = new BlockCypherBitcoinBalanceGetter();
//        IBalanceGetter getter = new BlockExplorerBitcoinBalanceGetter();
        AddressBalance bal = getter.getBalance(testAddr);

        if(bal == null)
        {
            System.out.println("error occurred while fetching");
            return;
        }

        System.out.println(bal.getAddress());
        System.out.println(bal.getBalance());
        System.out.println(bal.getSymbol());
        System.out.println(SymbolConverter.symbolToFullName(bal.getSymbol()));

        IValueGetter valueGetter = new CryptoCompareValueGetter();

        Double value = valueGetter.getValue(CryptoSymbol.BTC);
        if(value < 0)
        {
            System.out.println("error fetching value");
        }
        else
        {
            BigDecimal valBd = new BigDecimal(value);
            BigDecimal addrVal = bal.getBalance().multiply(valBd);
            addrVal = addrVal.setScale(2, BigDecimal.ROUND_DOWN);
            String output = String.format("$%1$s", addrVal);
            System.out.println(output);
        }
    }
}
