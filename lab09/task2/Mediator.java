public class Mediator extends AbstractMediator {
    public boolean placeBid(float bid, String unitOfCurrency) {
        this.dollarConverter.convertCurrencyToDollars(bid, unitOfCurrency);
        return this.americanSeller.isBidAccepted(bid);
    };
}
