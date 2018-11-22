package oddyseesfinest.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import oddyseesfinest.datasource.DatasourceConfig;

@Service
public class MemeDao {

	private static final Logger logger = LoggerFactory.getLogger(MemeDao.class);

	@Autowired
	DatasourceConfig dsConfig;

	@SuppressWarnings("unchecked")
	public Map<String, Object> getMemes() {

		Cloudinary cloudinary = dsConfig.provide();
		Map<String, Object> result = null;

		try {
			result = cloudinary.api().resources(ObjectUtils.emptyMap());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getByTag(String tag) {

		Map<String, Object> searchResult = null;

		Cloudinary cloudinary = dsConfig.provide();

		try {
			searchResult = cloudinary.api().resourcesByTag(tag, ObjectUtils.emptyMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return searchResult;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> save(MultipartFile image, String[] tags, String filename) throws Exception {

		Cloudinary cloudinary = dsConfig.provide();

		Map<String, Object> uploadResult;
		Map<String, Object> options = ObjectUtils.asMap("folder", "memes");

		logger.info("Received file " + image.getOriginalFilename() + ", trying to convert..");

		// Convert multipart file type image to File because Cloudinary doesn't
		// accept multipart as an upload type.
		File convertedFile = multipartToFile(image);

		if (tags != null) {
			options.put("tags", tags);
		}

		if (filename != null) {
			options.put("unique_id", filename);
		}

		try {
			uploadResult = cloudinary.uploader().upload(convertedFile, options);

			logger.info("File successfully uploaded.");

		} catch (Exception e) {
			logger.error("An error occurred when uploading image. " + e.getMessage());
			throw e;
		}

		return uploadResult;
	}

	private static File multipartToFile(MultipartFile image) throws IllegalStateException, IOException {

		File convertedFile = Files.createTempFile("temp", image.getOriginalFilename()).toFile();
		image.transferTo(convertedFile);
		return convertedFile;
	}

}
