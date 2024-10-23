package com.example.LinkShortner.controller;

import com.example.LinkShortner.entity.Url;
import com.example.LinkShortner.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/v1/url")
public class UrlController {

    @Autowired
    private Service SS;


    @PostMapping("shortUrl")
    public ResponseEntity<Url> ShortenUrl(@RequestParam String OrignalUrl){
        return ResponseEntity.ok(SS.ShortenUrl(OrignalUrl));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getUrl (@RequestParam String urlcode){
        Optional<Url> optionalUrl = SS.GetCode(urlcode);

        if(optionalUrl.isPresent()){
            Url UU = optionalUrl.get();
            return ResponseEntity
                    .status(302)
                    .location(URI.create(UU.getOrignalUrl()))
                    .build();

        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}

