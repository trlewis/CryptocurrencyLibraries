package net.trlewis.CryptoSandbox;

import net.trlewis.CryptoBalanceGetters.BlockChainInfoBitcoinBalanceGetter;
import net.trlewis.CryptoBalanceGetters.BlockCypherBitcoinBalanceGetter;
//import net.trlewis.CryptoBalanceGetters.BlockExplorerBitcoinBalanceGetter;
import net.trlewis.CryptoBalanceGetters.IBalanceGetter;
import net.trlewis.CryptoInfo.AddressBalance;
import net.trlewis.CryptoInfo.SymbolConverter;

public class MainClass
{
    public static void main(String[] args)
    {
        checkBitcoinBalanceGetters();
    }

    private static void checkBitcoinBalanceGetters()
    {
        final String testAddr = "19cSneAZrewkySQ8yV3DrnxMWX1okxZiMe";

//        IBalanceGetter getter = new BlockChainInfoBitcoinBalanceGetter();
        IBalanceGetter getter = new BlockCypherBitcoinBalanceGetter();
//        IBalanceGetter getter = new BlockExplorerBitcoinBalanceGetter();
        AddressBalance bal = getter.getBalance(testAddr);

        if(bal != null)
        {
            System.out.println(bal.getAddress());
            System.out.println(bal.getBalance());
            System.out.println(bal.getSymbol());
            System.out.println(SymbolConverter.symbolToFullName(bal.getSymbol()));
        }
        else
        {
            System.out.println("error occurred while fetching");
        }
    }
}
