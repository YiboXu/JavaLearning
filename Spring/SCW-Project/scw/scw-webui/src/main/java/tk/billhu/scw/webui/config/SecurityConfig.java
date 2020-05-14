package tk.billhu.scw.webui.config;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import tk.billhu.scw.webui.entities.TUser;
import tk.billhu.scw.webui.service.WebUserService;
import tk.billhu.scw.webui.vo.response.UserResponseVo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private WebUserService webUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //自定义user store (通过WebUserServiceImpl从DataSource(MyBatis)里面获取用户
        auth.userDetailsService(webUserService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //1. 资源认证设置
        http.authorizeRequests()
                .antMatchers("/bootstrap/**","/css/**","/fonts/**","/img/**","/jquery/**","/script/**","/ztree/**").permitAll()
                .antMatchers("/","/index","/login.html","/login","/member/register","/member/doRegister","/member/sendsms","/ajax").permitAll()
                .antMatchers("/admin/index").hasRole("ADMIN")
                //每个登录账号有一个基本role  "ADMIN",同时还具有其他的ROLE, (t_admin_role表中设定, 对应具体的ROLE在t_role里面)
                //每个ROLE又具有各种不同的permission, 在t_role_permission中设置(对应具体permission在t_permission中)
                //在各个controller路径下面通过@PreAuthorize("hasAuthority('xxx')")来指定访问该路径所需要的权限
                //目前只在TAdminUserController指定了访问权限, 其他controller可以同理配置
                //.antMatchers("/admin/**").hasRole("PM - 项目经理")
                .anyRequest().authenticated();

        //2. 设置登录页面
        http.formLogin()
                .loginPage("/login")
                .usernameParameter("loginacct")
                .passwordParameter("userpswd")
                .loginProcessingUrl("/doLogin")
                .successForwardUrl("/loginSuccess");

        //3. 关闭crsf(待表单添加了crsf隐藏域后开启)
        http.csrf().disable();

        //4. 设置注销页面
        http.logout().logoutUrl("/doLogout").logoutSuccessUrl("/");

        //5 指定异常处理
        http.exceptionHandling().accessDeniedHandler(new AccessDeniedHandler() {
            @Override
            public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
                String type = httpServletRequest.getHeader("X-Requested-With");
                if("XMLHttpRequest".equals(type)){           //异步访问,比如页面通过ajax访问controller
                    httpServletResponse.getWriter().print("403");
                }else{          //同步访问，正常的form submit
                    httpServletRequest.getRequestDispatcher("/accessDeny").forward(httpServletRequest,httpServletResponse);
                }
            }
        });

        //6 开启记住我功能
        //http.rememberMe();  //仅仅保存在内存中，服务器重启后登录状态失效，需要重新登录
    }
}
