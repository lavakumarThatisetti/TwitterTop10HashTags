package com.example.TwiiterTrendingHashTags.repository;

import com.example.TwiiterTrendingHashTags.model.Tweets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweets,Long> {

//    @Query("SELECT t.tweet FROM tweets t")
//    String[] getAllTweets();
}
