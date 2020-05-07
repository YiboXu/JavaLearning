package tk.springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import tk.springmvc.service.WebUserService;

import javax.sql.DataSource;
import javax.swing.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
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
        //1. 授权首页,登录页和静态资源
        //hasRole("ADMIN") == hasAuthority("ROLE_ADMIN");
        http.authorizeRequests()
                .antMatchers("/index.jsp","/myLogin.jsp","/static/**","/accessDeny").permitAll()
                //通过角色来授权, 所以登录用户需要有ROLE_ADMIN的authority才能访问/special1/**
                .antMatchers("/special1/**").hasRole("ADMIN")
                //通过权限来授权, 所以登录用户需要有ROLE_USER的authority才能访问/special2/**
                .antMatchers("/special2/**").hasAnyAuthority("ROLE_USER")
                //通过角色来授权, 所以登录用户需要有ROLE_USER的authority才能访问/special1/**
                .antMatchers("/special3/**").hasRole("USER")
                //剩余的资源，只要登录成功就可以访问
                .anyRequest().authenticated();

        /*
             http
            .authorizeRequests()
            .antMatchers("/spitters/me").authenticated()
            .antMatchers(HttpMethod.POST, "/spittles").authenticated()   // /spittles只有POST方法需要授权
            .anyRequest().permitAll()           // 除了上面2个路径以外，其他的路径不需要授权
            .and()
            .requiresChannel()
            .antMatchers("/spitter/form").requiresSecure();        // 需要通过 https:// 来访问
        */


        //指定默认登录页
        //http.formLogin();

        //2. 指定自定义登录页
        //usernameParameter需要和myLogin.jsp里面用户名域的name相匹配
        //passwordParameter需要和myLogin.jsp里面密码域的name相匹配
        //loginProcessingUrl需要和myLogin.jsp里面表单域的action="/login"相匹配
        //注意，自己并不需要定义controller来处理/myLogin
        http.formLogin().loginPage("/myLogin.jsp").usernameParameter("name").passwordParameter("psw").loginProcessingUrl("/myLogin");

        //3. 表单中添加csrf
        /**
         * SpringSecurity添加了csrf功能【DefaultCsrfToken】，
         * 所有的表单提交为了防止跨站请求伪造，我们需要加上_csrf项; 或者，暂时禁用http.csrf().disable();
         * <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
         *      ${_csrf}  ===>>>  org.springframework.security.web.csrf.DefaultCsrfToken@19116cfd
         *      <input type="hidden" name="_csrf" value="310988c2-3f9d-4651-9e19-6ef4b2c4aa3a"/>
         */
        //http.csrf().disable();

        //4. 指定登出页
        http.logout().logoutUrl("/myLogout").logoutSuccessUrl("/myLogin.jsp");

        //5 指定异常处理
        http.exceptionHandling().accessDeniedPage("/accessDeny");

        //6 开启记住我功能
        //如果将登录状态token记录在数据库，需要先创建一个表:
        //create table persistent_logins (username varchar(64) not null, series varchar(64) primary key,token varchar(64) not null, last_used timestamp not null);
        JdbcTokenRepositoryImpl ptr = new JdbcTokenRepositoryImpl();
        ptr.setDataSource(dataSource);
        http.rememberMe().tokenRepository(ptr);
        //http.rememberMe();  //仅仅保存在内存中，服务器重启后登录状态失效，需要重新登录
    }

    //7. 配置用来做授权的user store

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
