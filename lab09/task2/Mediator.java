public class Mediator implements AbstractMediator {
    private AmericanSeller americanSeller;
    private FrenchBuyer frenchBuyer;
    private SwedishBuyer swedishBuyer;
    private DollarConverter dollarConverter;

    public void registerAmericanSeller(AmericanSeller americanSeller) {
        this.americanSeller = americanSeller;
    };
    public void registerFrenchBuyer(FrenchBuyer frenchBuyer) {
        this.frenchBuyer = frenchBuyer;
    };
    public void registerSwedishBuyer(SwedishBuyer swedishBuyer) {
        this.swedishBuyer = swedishBuyer;
    };
    public void registerDollarConverter(DollarConverter dollarConverter) {
        this.dollarConverter = dollarConverter;
    };

    public boolean placeBid(float bid, String unitOfCurrency) {
        float america_dollar = this.dollarConverter.convertCurrencyToDollars(bid, unitOfCurrency);
        return this.americanSeller.isBidAccepted(america_dollar);
    };
}
