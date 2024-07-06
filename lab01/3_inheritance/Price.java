abstract class Price {
    static Price regular() {
        return _regular;
    }
    
    static Price childrens() {
        return _childrens;
    }
    static Price newRelease() {
        return _newRelease;
    }
        
    private static Price _childrens = new ChildrensPrice();
    private static Price _newRelease = new NewReleasePrice();
    private static Price _regular = new RegularPrice();
}