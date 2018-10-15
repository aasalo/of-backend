package oddyseesfinest;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class DBConfig {

	final static Logger logger = LoggerFactory.getLogger(DBConfig.class);

	@Bean
	public BasicDataSource dataSource() throws URISyntaxException {

		logger.info("trying to fetch dburi");

		URI dbUri = new URI(System.getenv("DATABASE_URL"));

		logger.info(dbUri.toString());

		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl(dbUrl);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);

		return basicDataSource;
	}
}