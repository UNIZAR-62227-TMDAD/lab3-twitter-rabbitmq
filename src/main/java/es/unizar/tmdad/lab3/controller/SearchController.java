package es.unizar.tmdad.lab3.controller;

import es.unizar.tmdad.lab3.service.TwitterLookupService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController {

    final TwitterLookupService twitter;

    public SearchController(TwitterLookupService twitter) {
        this.twitter = twitter;
    }

    @RequestMapping("/")
    public String greeting() {
        return "index";
    }

    @MessageMapping("/search")
    public void search(String query) {
        twitter.search(query);
    }
}