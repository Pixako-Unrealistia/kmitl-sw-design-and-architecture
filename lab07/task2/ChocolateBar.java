public class ChocolateBar {
	private String type;
	private int id;

	public ChocolateBar(String type, int id) {
		this.type = type;
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "ChocolateBar{" +
				"type='" + type + '\'' +
				", id=" + id +
				'}';
	}
}