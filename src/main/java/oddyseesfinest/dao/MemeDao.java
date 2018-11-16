package oddyseesfinest.dao;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import oddyseesfinest.model.Meme;

@Service
public class MemeDao {

	Cloudinary cloudinary = new Cloudinary(System.getenv("CLOUDINARY_URL"));

	public Meme getMeme() {

		return new Meme();

	}

	public Map<?, ?> save(MultipartFile file) throws Exception {

		Map<?, ?> uploadResult;

		try {
			uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());

		} catch (Exception e) {
			throw e;
		}

		return uploadResult;
	}

	public String test() {

		return cloudinary.url().imageTag("samples/animals/kitten-playing.gif");
	}

}
