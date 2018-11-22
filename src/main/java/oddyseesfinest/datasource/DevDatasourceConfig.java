package oddyseesfinest.datasource;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Component
@Profile("dev")
public class DevDatasourceConfig implements DatasourceConfig {

	private static final Logger logger = LoggerFactory.getLogger(DevDatasourceConfig.class);

	@Value("${com.cloudinary.cloud_name}")
	String cloudName;

	@Value("${com.cloudinary.api_key}")
	String apiKey;

	@Value("${com.cloudinary.api_secret}")
	String apiSecret;

	@Override
	public Cloudinary provide() {

		@SuppressWarnings("unchecked")
		Map<String, String> config = ObjectUtils.asMap("cloud_name", cloudName, "api_key", apiKey, "api_secret",
				apiSecret);

		logger.info("Using development datasource configuration");

		return new Cloudinary(config);
	}

}
