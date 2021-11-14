package sx_vote.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //访问login.html后，提交表单给/dologin接口，由springSecurity框架拦截/dologin接口，验证成功后跳转
            http.formLogin() //定义当需要用户登录时候，转到的登录页面
                .loginPage("/login")
                .loginProcessingUrl("/dologin")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll() //注册页面html
                .antMatchers("/dologin").permitAll() //登录表单提交地址
                .antMatchers("/logout").permitAll()  //登出地址
                .antMatchers("/register").permitAll() //注册页面
                .antMatchers("/adduser").permitAll() //注册表单提交地址
                .antMatchers("/chuangjian").authenticated() //创建项目页面 设置需要先登录
                .antMatchers("/vote").authenticated()
                .antMatchers("/").permitAll()
                .anyRequest() // 其他任何请求,都可以访问
                .permitAll().and().csrf().disable();
    }
}