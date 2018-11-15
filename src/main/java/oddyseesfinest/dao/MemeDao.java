package oddyseesfinest.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cloudinary.*;

import oddyseesfinest.model.Meme;

@Service
public class MemeDao {

	Cloudinary cloudinary = new Cloudinary(System.getenv("CLOUDINARY_URL"));

	public Meme getMeme() {

		return new Meme();

	}

	public String test() {

		return cloudinary.url().imageTag("samples/animals/kitten-playing.gif");
	}

}
