package oddyseesfinest.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import oddyseesfinest.dao.MemeDao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/images")
public class MemeController {

	@Autowired
	private MemeDao memeDao;

	@GetMapping("/all")
	public Map<String, Object> getMemes() {
		return memeDao.getMemes();
	}

	@PostMapping("/upload")
	public ResponseEntity<Map<?, ?>> handleFileUpload(@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam(value = "tags", required = false) String[] tags,
			@RequestParam(value = "name", required = false) String filename) throws Exception {

		Map<String, Object> response = memeDao.save(file, tags, filename);

		return new ResponseEntity<Map<?, ?>>(response, HttpStatus.CREATED);
	}

	@GetMapping("/search/tag")
	public ResponseEntity<Map<String, Object>> getByTag(@RequestParam(value = "tag") String tag) {

		Map<String, Object> response = memeDao.getByTag(tag);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
