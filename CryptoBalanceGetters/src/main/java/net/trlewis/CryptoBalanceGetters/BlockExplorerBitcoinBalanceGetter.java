//currently returning 403 for every request
//package net.trlewis.CryptoBalanceGetters;
//
//import net.trlewis.CryptoInfo.AddressBalance;
//import net.trlewis.CryptoInfo.CryptoStats;
//import net.trlewis.CryptoInfo.CryptoSymbol;
//import org.jetbrains.annotations.Nullable;
//
//import java.math.BigDecimal;
//import java.util.HashMap;
//import java.util.Map;
//
//public class BlockExplorerBitcoinBalanceGetter implements IBalanceGetter
//{
//    @Override
//    public @Nullable AddressBalance getBalance(final String address)
//    {
//        String loc = String.format("https://blockexplorer.com/api/addr/%s/balance", address);
//        String raw = GetRequestHelper.getRawGetRequest(loc);
//        if(null == raw || 0 == raw.length())
//            return null;
//        BigDecimal balSats = new BigDecimal(raw);
//        BigDecimal bal = balSats.movePointLeft(CryptoStats.decimalPlaces(CryptoSymbol.BTC));
//        return new AddressBalance(CryptoSymbol.BTC, address, bal);
////        return dec.movePointLeft(SATOSHI_DECIMAL_PLACES);
//    }
//
//    @Override
//    public @Nullable Map<String, AddressBalance> getBalances(final Iterable<String> addresses)
//    {
//        //TODO: actual fetching
//        Map<String, AddressBalance> map = new HashMap<>();
//        for(String addr : addresses)
//            map.put(addr, null);
//        return map;
//    }
//}
