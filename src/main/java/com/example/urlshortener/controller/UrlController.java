package com.example.urlshortener.controller;

import com.example.urlshortener.dto.ShortenUrlRequest;
import com.example.urlshortener.dto.ShortenUrlResponse;
import com.example.urlshortener.service.UrlService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlController {

    private final UrlService urlService;

    // Constructor Injection
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }
    @PostMapping("/shorten") //“This method handles POST /shorten”
//    public String shortenUrl(@RequestBody ShortenUrlRequest request)
//    {
//
////        String shortCode = urlService.generateShortUrl(longUrl);
//////        → Controller sends data to service
//////        → Service does logic
//////        → Service returns result
//        String shortCode =
//                urlService.generateShortUrl(request.getLongUrl());
//
//        return "Short URL is: " + shortCode;
//    }
    public ShortenUrlResponse shortenUrl(
            @RequestBody ShortenUrlRequest request) {

        String shortCode =
                urlService.generateShortUrl(request.getLongUrl());

        return new ShortenUrlResponse(shortCode);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(
            @PathVariable String shortCode) {

        String originalUrl =
                urlService.getOriginalUrl(shortCode);

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .header(HttpHeaders.LOCATION, originalUrl)
                .build();
    }


}
