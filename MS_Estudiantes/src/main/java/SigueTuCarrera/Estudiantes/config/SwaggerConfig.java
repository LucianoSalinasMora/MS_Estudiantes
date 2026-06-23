package SigueTuCarrera.Estudiantes.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.media.Schema;
import jakarta.persistence.GeneratedValue;
import java.lang.reflect.Field;
import org.springdoc.core.customizers.PropertyCustomizer;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI EstudiantesOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Estudiantes (MS_Estudiantes)")
                        .description("Microservicio para la gestión de estudiantes del sistema académico")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Duoc UC")
                                .email("contacto@duocuc.cl")));
    }
    @Bean
    public PropertyCustomizer generatedValueReadOnlyCustomizer() {
        return (Schema schema, io.swagger.v3.core.converter.AnnotatedType type) -> {
            // Buscamos si el tipo de origen es una clase válida
            if (type.getType() instanceof Class<?>) {
                Class<?> clazz = (Class<?>) type.getType();
                
                
                for (Field field : clazz.getDeclaredFields()) {
                    if (field.getName().equals(schema.getName()) || 
                       (schema.getExtensions() != null && field.getName().equals(schema.getExtensions().get("x-properties")))) {
                        
                        
                        if (field.isAnnotationPresent(GeneratedValue.class)) {
                            schema.setReadOnly(true);
                        }
                    }
                }
            }
            return schema;
        };
    }
}
