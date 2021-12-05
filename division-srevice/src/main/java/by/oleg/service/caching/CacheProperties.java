package by.oleg.service.caching;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app.cache")
public class CacheProperties {

    private CacheConfig division;

    public static class CacheConfig {
        String name;
        Integer ttl;
        Integer size;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getTtl() {
            return ttl;
        }

        public void setTtl(Integer ttl) {
            this.ttl = ttl;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }
    }
}
