package com.example.TwiiterTrendingHashTags.repository;
import com.example.TwiiterTrendingHashTags.model.Tweets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweets,Long> {

}
