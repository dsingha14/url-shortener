package com.example.urlshortener.service;

import com.example.urlshortener.model.UrlMapping;
import com.example.urlshortener.repository.UrlMappingRepository;
import com.example.urlshortener.util.Base62Encoder;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    private final UrlMappingRepository repository;

    public UrlService(UrlMappingRepository repository) {
        this.repository = repository;
    }

    public String generateShortUrl(String longUrl) {
        long uniqueNumber = System.currentTimeMillis();
        String shortCode = Base62Encoder.encode(uniqueNumber);

        UrlMapping mapping = new UrlMapping();
        mapping.setLongUrl(longUrl);
        mapping.setShortCode(shortCode);

        repository.save(mapping);

        return shortCode;
    }

    //redirect logic
    public String getOriginalUrl(String shortCode) {
        UrlMapping mapping = repository
                .findByShortCode(shortCode)
                .orElseThrow(() ->
                        new RuntimeException("Short URL not found"));

        return mapping.getLongUrl();
    }
}
