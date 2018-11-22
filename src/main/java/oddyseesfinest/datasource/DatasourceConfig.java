package oddyseesfinest.datasource;

import org.springframework.stereotype.Component;

import com.cloudinary.Cloudinary;

@Component
public interface DatasourceConfig {

	Cloudinary provide();

}
