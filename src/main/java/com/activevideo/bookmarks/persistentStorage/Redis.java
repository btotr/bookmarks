package com.activevideo.bookmarks.persistentStorage;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.PipelineBlock;

public class Redis {
   private static Redis instance = null;
   private Jedis jedis = null;
   
   protected Redis() {
       //jedis = new Jedis("127.0.0.1");
       //jedis.connect();
       System.out.println("Redis Connected");
   }
   public static Redis getInstance() {
      if(instance == null) {
         instance = new Redis();
      }
      return instance;
   }
   
   public String get(String clientId){
       System.out.println("get all: from clientid" + clientId);
       /*Set<String> all = jedis.smembers("client:"+clientId);
       String response = "{\"response\": [";
       for(String bookmarkId : all) {
           response += "{\"bookmarkId\":\""+bookmarkId+"\",\"value\":"+jedis.get("bookmark:" + bookmarkId)+"},";
       }
       response = response.substring(0, response.length() - 1) + "]}";
       return  response;*/
       return "{\"a\":\"a\"}";
   }
   
   public String get(String clientId, String bookmarkId){
       System.out.println("get: "+ bookmarkId);
       // todo filter clientId?
       //String bookmark = jedis.get("bookmark:" + bookmarkId);
       String bookmark = "test";
       return "{\"response\":" + bookmark + "}";
   }
   
   public void set(String clientId, String bookmarkId, String value) {
       System.out.println("set: "+ bookmarkId + " with value " + value); 
       //jedis.sadd("client:"+clientId, bookmarkId);
       //jedis.set("bookmark:"+ bookmarkId, value);
   }
   
   public void delete(String clientId, String bookmarkId) {
       System.out.println("delete: "+ bookmarkId + " from client id "+ clientId);
       //jedis.srem("client:"+clientId, bookmarkId);
   }
   
   public void disconnect(){
       //jedis.disconnect();
   }
}