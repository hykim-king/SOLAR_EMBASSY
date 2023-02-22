package community.solar_embassy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                //비밀번호 입력 시 자동 암호화
                .usersByUsernameQuery("select buId,buPasswords,enabled "
                        + "from business "
                        + "where buNo = ?")
                .authoritiesByUsernameQuery("select name,authority "
                        + "from authorities "
                        + "where id = ?");
    }
//    Authentication 로그인
//    Autheroization 권한

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/**").permitAll() // 로그인 없이 누구나 접근 가능한 url("/**" 모든 폴더에 접근 가능)
                        .anyRequest().authenticated() //반드시 로그인해야 확인할 수 있는 페이지
                        .and()
                )
                .formLogin((form) -> form
                        .loginPage("/login") // 로그인할 페이지
                        .permitAll() // 로그인하지 않는 사용자도 로그인 페이지에 접근할 수 있도록 설정
                )
                .logout(LogoutConfigurer::permitAll); // 로그아웃
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


//    @Bean  // 임시 테스트용
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user") // 유저 아이디
//                        .password("password")  // 비밀번호
//                        .roles("USER") //권한
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}