package zw.co.econet.econetecommerceapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.HttpMethods;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import zw.co.econet.econetecommerceapp.model.Product;
import zw.co.econet.econetecommerceapp.model.ProductCategory;
@Configuration
public class RestDataConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        HttpMethod[] unsupportedmethods = {HttpMethod.DELETE, HttpMethod.POST, HttpMethod.PUT};

        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedmethods))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedmethods)));

        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedmethods))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedmethods)));

    }
}
