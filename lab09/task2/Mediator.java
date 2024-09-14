public class Mediator extends AbstractMediator {
    public boolean placeBid(float bid, String unitOfCurrency) {
        float america_dollar = this.dollarConverter.convertCurrencyToDollars(bid, unitOfCurrency);
        return this.americanSeller.isBidAccepted(america_dollar);
    };
}
