public abstract class AbstractMediator {
    AmericanSeller americanSeller;
    FrenchBuyer frenchBuyer;
    SwedishBuyer swedishBuyer;
    DollarConverter dollarConverter;

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
    
    public abstract boolean placeBid(float bid, String unitOfCurrency);
}
