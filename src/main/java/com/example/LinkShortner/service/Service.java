package com.example.LinkShortner.service;

import com.example.LinkShortner.entity.Url;
import com.example.LinkShortner.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Random;

@org.springframework.stereotype.Service
public class Service {

    //conversion of link into url code

    @Autowired
            private Repository RR;

    String urlcode;

    private static final int URL_CODE_LENGTH = 6;
    private static final String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";


    public String genrateUrlCode(){
        StringBuilder urlCode =  new StringBuilder();
        Random random = new Random();

        for(int i = 0;i<URL_CODE_LENGTH;i++){
            int idx = random.nextInt(ALPHANUMERIC_STRING.length());
            urlCode.append(ALPHANUMERIC_STRING.charAt(idx));

        }

        return urlCode.toString();
    }

    public Url ShortenUrl(String orignalUrl){
        String code = genrateUrlCode();

        return RR.save(Url.builder()
                .orignalUrl(orignalUrl)
                .urlCode(code)
                .build());
    }

    public Optional<Url> GetCode(String urlcode){
        return RR.findByurlCode(urlcode);
    }


}
