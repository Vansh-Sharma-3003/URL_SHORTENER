package com.example.URL.Shortner.Services;

import com.example.URL.Shortner.Model.UrlModel;
import com.example.URL.Shortner.Repo.UrlRepo;
import org.springframework.stereotype.Service;

@Service
public class UrlShortService {

    private final UrlRepo urlRepo;
    private final Base62Encoder base62Encoder;

    public UrlShortService(Base62Encoder base62Encoder, UrlRepo urlRepo) {
        this.base62Encoder = base62Encoder;
        this.urlRepo = urlRepo;
    }

    // This method created the URLs into short Form...
    public String urlShorten(String longUrl){
        UrlModel urlModel =new UrlModel();
        urlModel.setLongURL(longUrl);
        UrlModel saveUrl=urlRepo.save(urlModel);

        String shortCode = base62Encoder.encode(saveUrl.getId());

        saveUrl.setShortCode(shortCode);
        urlRepo.save(saveUrl);

        return shortCode;
    }

    // this method send longURL...
    public String longURL(String shortcode){

        return urlRepo.findByShortCode(shortcode) .map(UrlModel::getLongURL)
                .orElseThrow(() -> new RuntimeException("URL not found for short code: " + shortcode));
    }
}
