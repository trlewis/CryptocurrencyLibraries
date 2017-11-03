package net.trlewis.CryptoInfo;

import java.math.BigDecimal;

/**
 * Simple holder for basic information about a cryptocurrency.
 */
public class AddressBalance
{
    private String address;
    private BigDecimal balance;
    private CryptoSymbol symbol;

    public AddressBalance(CryptoSymbol symbol, String address, BigDecimal balance)
    {
        this.address = address;
        this.balance = balance;
        this.symbol = symbol;
    }

    public CryptoSymbol getSymbol() { return symbol; }

    public BigDecimal getBalance() { return balance; }

    public String getAddress() { return address; }
}
