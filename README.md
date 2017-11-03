# CryptocurrencyLibraries

A handful of modules that provide different functionality for getting balances of cryptocurrency addresses.

## CryptoInfo

The root of the project. Has common info and classes used by all projects.

## CryptoBalanceGetters

A collection of of classes that get the balances of cryptocurrency adresses from API calls to websites. Note that these getters retrieve that balance of the address in its native units. Not the smallest/base units and not the fiat currency value.

## CryptoValueGetters

Classes that get the cryptocurrency <-> fiat currency rates of various currencies. Currently only planned for USD, that may change later. Intended to be paired with the CryptoBalanceGetters to get the fiat value of the contents of an address.

## CryptoSandbox

Just fiddling code, not useful for anything...
