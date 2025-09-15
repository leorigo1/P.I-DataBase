package leonardo.rigo.backend.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class CORSConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // todos os endpoints
                        .allowedOrigins("http://localhost:3000") // origem do front Angular
                        .allowedOrigins("http://localhost:5173") // // origem do front React
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // métodos permitidos
                        .allowedHeaders("*")
                        .allowCredentials(true); // permite cookies/autenticação
            }
        };
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions(frame -> frame.disable())) // necessário pro H2
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers(
                                        "/h2-console/**", // 👈 libera o h2
                                        "/users/login-google" // libera login com o google
                                ).permitAll()
                                .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());

        return http.build();
    }
}

