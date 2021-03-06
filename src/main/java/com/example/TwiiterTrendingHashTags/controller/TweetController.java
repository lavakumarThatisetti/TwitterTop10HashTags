package com.example.TwiiterTrendingHashTags.controller;

import com.example.TwiiterTrendingHashTags.model.Tweets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.TwiiterTrendingHashTags.repository.TweetRepository;
import com.example.TwiiterTrendingHashTags.service.TweetService;

import java.util.List;

@RestController
@RequestMapping("/twitter")
public class TweetController {
    private TweetRepository tweetRepository;
    private TweetService tweetService;

    @Autowired
    public TweetController(TweetRepository tweetRepository,TweetService tweetService){
        this.tweetRepository= tweetRepository;
        this.tweetService=tweetService;
    }

    @PostMapping(produces = "application/json",value = "/addTweet")
    public ResponseEntity<Tweets> addTweet(@RequestBody Tweets twitter){
        return  ResponseEntity.ok(tweetRepository.save(twitter));
    }

    @GetMapping(value="/getTopTenHashTags")
    public ResponseEntity<List<String>> getTopTenHashTags(){
        List<String> tweetsList = tweetRepository.getAllTweets();
        List<String> hasTags = tweetService.getTopTenHashTags(tweetsList);
        return ResponseEntity.ok(hasTags);
    }

}
