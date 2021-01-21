package com.example.TwiiterTrendingHashTags.service.impl;

import com.example.TwiiterTrendingHashTags.model.Tweets;
import org.springframework.stereotype.Service;
import com.example.TwiiterTrendingHashTags.service.TweetService;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TweetServiceImpl implements TweetService {

    private static final Pattern HASH_TAG = Pattern.compile("#(\\w+)");
    private HashMap<String, Integer> freqMap=new HashMap<>();

    @Override
    public List<String> getTopTenHashTags(List<Tweets> tweetsList) {
        List<String> result=new ArrayList<>();
        for(Tweets tweet:tweetsList) {
            Matcher m = HASH_TAG.matcher(tweet.getTweet());
            while (m.find()) {
                String tag = m.group(); //m.group(1) to exclude #
                freqMap.put(tag, freqMap.getOrDefault(tag,0)+1);
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> topPriority = new PriorityQueue<>(
                (a,b) -> a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );
        for(Map.Entry<String,Integer> entry:freqMap.entrySet()){
            topPriority.offer(entry);
            if(topPriority.size()>10){
                topPriority.poll();
            }

        }
        while(!topPriority.isEmpty()){
            result.add(0,topPriority.poll().getKey());
        }
        return result;
    }
}
