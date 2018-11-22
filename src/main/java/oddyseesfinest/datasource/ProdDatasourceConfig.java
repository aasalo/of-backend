package oddyseesfinest.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.cloudinary.Cloudinary;

@Component
@Profile("!dev")
public class ProdDatasourceConfig implements DatasourceConfig {

	private static final Logger logger = LoggerFactory.getLogger(ProdDatasourceConfig.class);

	@Override
	public Cloudinary provide() {

		logger.info("Using production datasource configuration");

		return new Cloudinary(System.getenv("CLOUDINARY_URL"));
	}

}
