package net.trlewis.CryptoBalanceGetters;

import com.google.gson.JsonObject;
import net.trlewis.CryptoInfo.AddressBalance;
import net.trlewis.CryptoInfo.CryptoStats;
import net.trlewis.CryptoInfo.CryptoSymbol;
import net.trlewis.CryptoValueGetters.GetRequestHelper;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BlockCypherBitcoinBalanceGetter implements IBalanceGetter
{
    @Override
    @Nullable
    public AddressBalance getBalance(final String address)
    {
        String loc = String.format("https://api.blockcypher.com/v1/btc/main/addrs/%s/balance"
                , address);
        JsonObject json = GetRequestHelper.getJsonFromGetRequest(loc);

        if(null == json)
            return null;

        String balStr = json.get("final_balance").getAsString();
        BigDecimal balSats = new BigDecimal(balStr);
        BigDecimal bal = balSats.movePointLeft(CryptoStats.decimalPlaces(CryptoSymbol.BTC));
        return new AddressBalance(CryptoSymbol.BTC, address, bal);
    }

    @Override
    @Nullable
    public Map<String, AddressBalance> getBalances(final Iterable<String> addresses)
    {
        Map<String, AddressBalance> map = new HashMap<>();
        for(String a : addresses)
            map.put(a, getBalance(a));
        return map;
    }
}
