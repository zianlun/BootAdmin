package zian.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/basic").setViewName("table/basic_table");
        registry.addViewController("/dynamic").setViewName("table/dynamic_table");
        registry.addViewController("/editable").setViewName("table/editable_table");
        registry.addViewController("/pricing").setViewName("table/pricing_table");
        registry.addViewController("/responsive").setViewName("table/responsive_table");
    }
}
