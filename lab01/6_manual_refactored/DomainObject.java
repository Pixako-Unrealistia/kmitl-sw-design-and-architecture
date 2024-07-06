public class DomainObject {
    protected String _name = "no name";

    public DomainObject(String name) {
        _name = name;
    }

    public DomainObject() {
    }

    public String name() {
        return _name;
    }

    @Override
    public String toString() {
        return _name;
    }
}