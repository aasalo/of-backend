package oddyseesfinest;

import java.lang.reflect.Array;

import org.springframework.beans.factory.annotation.Autowired;

public class MemeDao {

	public Meme getMeme() {

		String[] tags = new String[2];

		tags[1] = "BAR";
		tags[2] = "XYZ";

		return new Meme("FOO", tags);

	}

}
