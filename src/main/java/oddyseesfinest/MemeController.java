package oddyseesfinest;

import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import java.sql.*;

@RestController
public class MemeController {

	@RequestMapping("/")
	public String index() {

		return "Oddysee's Finest";
	}

}
