package by.oleg.service.caching;

import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfiguration {

    private final CacheProperties cacheProperties;

    @Autowired
    public CacheConfiguration(CacheProperties cacheProperties) {
        this.cacheProperties = cacheProperties;
    }

    @Bean("cacheManager")
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager() {

            protected Cache createConcurrentMapCache(String cacheName) {
                int maxSize = 100;
                int ttl = 10000;

                maxSize = cacheProperties.getDivision().size;
                ttl = cacheProperties.getDivision().ttl;

                return new ConcurrentMapCache(cacheName, CacheBuilder.newBuilder()
                        .maximumSize(maxSize)
                        .expireAfterWrite(ttl, TimeUnit.SECONDS)
                        .build().asMap(), false);
            }
        };
    }
}
