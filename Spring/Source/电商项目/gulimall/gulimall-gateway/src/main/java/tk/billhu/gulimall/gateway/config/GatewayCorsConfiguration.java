package tk.billhu.gulimall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class GatewayCorsConfiguration {
    @Bean
    public CorsWebFilter corsWebFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        //配置跨域
        corsConfiguration.addAllowedHeader("*");   //允许哪个header的请求跨域
        corsConfiguration.addAllowedMethod("*");   //允许哪些请求方式(get,put,post...)跨域
        corsConfiguration.addAllowedOrigin("*");   //允许哪些请求来源进行跨域
        corsConfiguration.setAllowCredentials(true); //允许携带cookie进行跨域

        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsWebFilter(source);
    }
}
