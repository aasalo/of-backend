package oddyseesfinest.controller;

import org.springframework.web.bind.annotation.RestController;

import oddyseesfinest.dao.MemeDao;
import oddyseesfinest.model.Meme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
