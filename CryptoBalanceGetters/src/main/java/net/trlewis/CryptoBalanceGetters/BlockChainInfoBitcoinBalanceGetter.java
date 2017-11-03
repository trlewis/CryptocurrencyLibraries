package net.trlewis.CryptoBalanceGetters;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.trlewis.CryptoInfo.AddressBalance;
import net.trlewis.CryptoInfo.CryptoStats;
import net.trlewis.CryptoInfo.CryptoSymbol;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BlockChainInfoBitcoinBalanceGetter implements IBalanceGetter
{
    @Override
    public @Nullable AddressBalance getBalance(String address)
    {
        String loc = String.format("https://blockchain.info/rawaddr/%s?limit=0", address);
        JsonObject json = GetRequestHelper.getJsonFromGetRequest(loc);

        if(json != null)
        {
            String balanceStr = json.get("final_balance").getAsString();
            BigDecimal bal = getValueFromString(balanceStr);
            return new AddressBalance(CryptoSymbol.BTC, address, bal);
//            return getValueFromString(balanceStr);
        }

        return null;
    }

    @Override
    public @Nullable Map<String, AddressBalance> getBalances(Iterable<String> addresses)
    {
        String addrParam = String.join("|", addresses);
        String url = String.format("https://blockchain.info/multiaddr?active=%s", addrParam);
        JsonObject json = GetRequestHelper.getJsonFromGetRequest(url);

        if(json == null)
            return null;

        JsonArray addrs = json.get("addresses").getAsJsonArray();
        Map<String, AddressBalance> balances = new HashMap<>();
        for(JsonElement elem : addrs)
        {
            JsonObject obj = elem.getAsJsonObject();
            String thisAddr = obj.get("_address").getAsString();
            String balStr = obj.get("final_balance").getAsString();
            BigDecimal bal = getValueFromString(balStr);
            AddressBalance ab = new AddressBalance(CryptoSymbol.BTC, thisAddr, bal);
            balances.put(thisAddr, ab);
        }

        return balances;
    }

    private static BigDecimal getValueFromString(final String strSatoshis)
    {
        BigDecimal satoshis = new BigDecimal(strSatoshis);
        return satoshis.movePointLeft(CryptoStats.decimalPlaces(CryptoSymbol.BTC));
    }
}
