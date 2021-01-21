package com.example.TwiiterTrendingHashTags.service;

import com.example.TwiiterTrendingHashTags.model.Tweets;

import java.util.List;

public interface TweetService {

    List<String> getTopTenHashTags(List<String> tweetsList);
}
