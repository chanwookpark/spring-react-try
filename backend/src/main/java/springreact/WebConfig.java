package springreact;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.script.ScriptTemplateConfigurer;

/**
 * @author chanwook
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //FIXME 프론트엔드와 함께 사용할 수 있도록 바꾸자..
        registry.scriptTemplate().prefix("public/").suffix(".html");
    }

    @Bean
    public ScriptTemplateConfigurer mustacheTemplate() {
        final ScriptTemplateConfigurer configurer = new ScriptTemplateConfigurer();
        configurer.setEngineName("nashorn");
        configurer.setScripts("public/mustache-render.js", "public/polyfill.js", "/META-INF/resources/webjars/mustache/2.2.1/mustache.min.js");
        configurer.setRenderObject("Mustache");
        configurer.setRenderFunction("render");
        return configurer;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}
