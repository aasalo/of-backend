package oddyseesfinest.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import oddyseesfinest.dao.MemeDao;
import oddyseesfinest.model.Meme;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class MemeController {

	@Autowired
	private MemeDao memeDao;

	@RequestMapping("/")
	public String index() {

		return "Oddysee's Finest";
	}

	@GetMapping("/")
	public Meme getMeme() {
		return memeDao.getMeme();
	}

	@GetMapping("/test")
	public String test() {
		return memeDao.test();
	}

	@PostMapping("/")
	public ResponseEntity<Map<?, ?>> handleFileUpload(@RequestParam("file") MultipartFile file) throws Exception {

		Map response;

		response = memeDao.save(file);

		return new ResponseEntity<Map<?, ?>>(response, null, HttpStatus.CREATED);
	}

}
