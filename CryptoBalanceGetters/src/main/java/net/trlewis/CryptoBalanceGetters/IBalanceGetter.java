package net.trlewis.CryptoBalanceGetters;

import net.trlewis.CryptoInfo.AddressBalance;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.util.Map;

public interface IBalanceGetter
{
    /**
     * Gets the current balance of a particular address by making an API call to a website
     * (which website depends on the implementor). Returns a number in "standard"
     * units. (e.g.: bitcoins instead of satoshis).
     * @param address The address to get the balance of.
     * @return An object containing the address, balance, and symbol of the currency.
     */
    @SuppressWarnings("unused")
    @Nullable AddressBalance getBalance(final String address);

    /**
     * Gets the current balance of all addresses given. Returns the same values as
     * getBalance(String). May make a single call for every address in the list if the
     * website the implementor calls does not support multiple addresses per request.
     * @param addresses The addresses to get the balance of.
     * @return The current balances of the addresses. The key is the address, value is the balance.
     * Any addresses that encountered an error while fetching the balance have a null value in
     * the map.
     */
    @SuppressWarnings("unused")
    @Nullable Map<String, AddressBalance> getBalances(final Iterable<String> addresses);

}
