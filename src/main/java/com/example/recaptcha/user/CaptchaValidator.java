package com.example.recaptcha.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class CaptchaValidator {

    @Autowired
    private RestTemplate restTemplate;

    public boolean isValidCaptcha(String captcha) {

        String url= "https://www.google.com/recaptcha/api/siteverify";
        String params="?secret=6LcQi5gmAAAAAHk_qTL7Xpqjd2HIPR-oDEK8M0O3&response="+captcha;
        String completeUrl=url+params;
        System.out.println(completeUrl);
        CaptchaResponse resp= restTemplate.postForObject(completeUrl, null, CaptchaResponse.class);
        return resp.isSuccess();
    }
}