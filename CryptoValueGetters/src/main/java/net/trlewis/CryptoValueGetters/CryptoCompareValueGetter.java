package net.trlewis.CryptoValueGetters;

import com.google.gson.JsonObject;
import net.trlewis.CryptoInfo.CryptoSymbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CryptoCompareValueGetter implements IValueGetter
{
    @Override
    public Double getValue(final CryptoSymbol type)
    {
        // https://min-api.cryptocompare.com/data/price?fsym=USD&tsyms=BTC,ETH,LTC,DASH
        String typeStr = type.name();
        String loc = String.format(
                "https://min-api.cryptocompare.com/data/price?fsym=%s&tsyms=USD"
                , typeStr);
        JsonObject json = GetRequestHelper.getJsonFromGetRequest(loc);

        if(null == json)
            return -1.0;

        String valStr = json.get("USD").getAsString();
        try {
            @SuppressWarnings("UnnecessaryLocalVariable")
            double val = Double.parseDouble(valStr);
            return val;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return -1.0;
    }

    @Override
    public Map<CryptoSymbol, Double> getValues(final Iterable<CryptoSymbol> types)
    {
        // https://min-api.cryptocompare.com/data/price?fsym=USD&tsyms=BTC,ETH,LTC,DASH
        List<String> typeSymbols = new ArrayList<>();
        for(CryptoSymbol t : types)
            typeSymbols.add(t.name());
        String tsyms = String.join(",", typeSymbols);
        String loc = String.format(
                "https://min-api.cryptocompare.com/data/price?fsym=USD&tsyms=%s", tsyms);
        JsonObject json = GetRequestHelper.getJsonFromGetRequest(loc);

        if(null == json)
            return null;

        try {
            Map<CryptoSymbol, Double> map = new HashMap<>();
            for(String tsym : typeSymbols)
            {
                //request is FROM USD, TO other types, so we need to 1/val to get the type => USD
                String valStr = json.get(tsym).getAsString();
                Double val = Double.parseDouble(valStr);
                map.put(CryptoSymbol.valueOf(tsym), 1.0/val);
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}