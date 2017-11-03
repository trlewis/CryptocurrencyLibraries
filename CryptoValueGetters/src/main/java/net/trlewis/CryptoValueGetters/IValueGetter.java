package net.trlewis.CryptoValueGetters;

import net.trlewis.CryptoInfo.CryptoSymbol;

import java.util.Map;

public interface IValueGetter
{
    /**
     * Get the USD value of the supplied type. A negative value means an error occurred.
     */
    Double getValue(final CryptoSymbol symbol);

    Map<CryptoSymbol, Double> getValues(Iterable<CryptoSymbol> symbols);
}
