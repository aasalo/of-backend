package oddyseesfinest;

public class Meme {

	String name;
	String[] tags;
	// bytearray bytea;

	public Meme(String name, String[] tags) {
		this.name = name;
		this.tags = tags;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

}
