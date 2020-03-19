package tk.springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import tk.springmvc.service.WebUserService;

import javax.sql.DataSource;
import javax.swing.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private WebUserService webUserService;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setWebUserService(WebUserService webUserService) {
        this.webUserService = webUserService;
    }

    //配置哪些URL需要做授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin();


            /*设置那些路径需要授权
            http
            .authorizeRequests()
            .antMatchers("/spitters/me").authenticated()
            .antMatchers(HttpMethod.POST, "/spittles").authenticated()   // /spittles只有POST方法需要授权
            .anyRequest().permitAll()           // 除了上面2个路径以外，其他的路径不需要授权
            .and()
            .requiresChannel()
            .antMatchers("/spitter/form").requiresSecure();        // 需要通过 https:// 来访问
             */
    }

    //配置用来做授权的user store

    /*
    Spring Security中密码的存储格式是“{id}…………”。
    {bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG
    {noop}password
    {pbkdf2}5d923b44a6d129f3ddf3e3c8d29412723dcbde72445e8ef6bf3b508fbf17fa4ed4d6b99ca763d8dc
    {scrypt}$e0801$8bWJaSu2IKSn9Z9kM+TPXfOc/9bdYSrN1oD9qfVThWEwdRTnO7re7Ei+fUZRJ68k9lTyuTeUp4of4g24hHnazw==$OAOec05+bXxvuu/1qZ6NUR+xQYvYv7BeL1QxwRpY5Pc=
    {sha256}97cde38028ad898ebc02e690819fa220e88c62e0699403e94fff291cfffaf8410849f27605abcbc0
    所有这些都是明文密码'password‘
    所以我们设置密码的时候需要用加密后的密码
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*in-memory user store
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("billhu").password(new BCryptPasswordEncoder().encode("123456")).roles("USER","ADMIN").and()
                .withUser("sofica").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");
        */

        /*JDBC user store
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, true from users where username=?")
                .authoritiesByUsernameQuery("select username, usergroup from users where username=?");

         */

        //自定义user store (通过WebUserServiceImpl从DataSource(MyBatis)里面获取用户
        auth.userDetailsService(webUserService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
