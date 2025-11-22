package com.example.URL.Shortner.Controller;

import com.example.URL.Shortner.Services.UrlShortService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
public class UrlShortController {

    private final UrlShortService urlShortService;

    public UrlShortController(UrlShortService urlShortService) {
        this.urlShortService = urlShortService;
    }

    @PostMapping("/api/v1/shorten")
    public String urlShorten(@RequestBody Map<String, String> request) {
        String longUrl = request.get("longUrl");
        String shortCode = urlShortService.urlShorten(longUrl);
        return "Short URL created: " + shortCode;
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirectToLongUrl(@PathVariable String shortCode) {
        String longUrl = urlShortService.longURL(shortCode);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(longUrl))
                .build();
    }


}
