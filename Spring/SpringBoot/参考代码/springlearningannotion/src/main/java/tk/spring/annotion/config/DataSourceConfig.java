package tk.spring.annotion.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/application.properties")
public class DataSourceConfig implements EmbeddedValueResolverAware {

    @Value("${datasource.username}")
    private String username;

    private String devUrl;
    private String tstUrl;
    private String prdUrl;
    private String driver;

    private StringValueResolver stringValueResolver;

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource devDataSource(@Value("${datasource.password}") String password){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(devUrl);
        dataSource.setDriverClassName(driver);

        return dataSource;
    }

    @Profile("tst")
    @Bean("tstDataSource")
    public DataSource tstDataSource(@Value("${datasource.password}") String password){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(tstUrl);
        dataSource.setDriverClassName(driver);

        return dataSource;
    }

    @Profile("prd")
    @Bean("prdDataSource")
    public DataSource prdDataSource(@Value("${datasource.password}") String password){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(prdUrl);
        dataSource.setDriverClassName(driver);

        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.stringValueResolver = resolver;
        this.devUrl = stringValueResolver.resolveStringValue("${datasource.devUrl}");
        this.tstUrl = stringValueResolver.resolveStringValue("${datasource.tstUrl}");
        this.prdUrl = stringValueResolver.resolveStringValue("${datasource.prdUrl}");
        this.driver = stringValueResolver.resolveStringValue("${datasource.driver}");
    }
}
