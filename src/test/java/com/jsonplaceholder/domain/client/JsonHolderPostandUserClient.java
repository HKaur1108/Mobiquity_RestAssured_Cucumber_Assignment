package com.jsonplaceholder.domain.client;

import com.jsonplaceholder.core.client.JsonHolderClient;
import com.jsonplaceholder.core.configuration.ConfigParser;
import com.jsonplaceholder.domain.response.CommentResponse;
import com.jsonplaceholder.domain.response.PostResponse;
import com.jsonplaceholder.domain.response.UserResponse;

import java.util.ArrayList;

public class JsonHolderPostandUserClient extends JsonHolderClient {
    private String GET_USERS="/users/";
    private  String GET_POSTS="/posts";
    private String GET_COMMENTS="/comments";
    private String url;
    private PostResponse[] postsArrResponse;
    private CommentResponse[] commentsArrResponse;
    private ArrayList<CommentResponse> commentResponseArrayList;
    private ArrayList<String> emailsForAPost;
    private ArrayList<String> emailsForAllCommentsForAUser;
    private ArrayList<String> postIdsArr;
    private ArrayList<String> postArr;


    public  JsonHolderPostandUserClient(){
        this.url= ConfigParser.getValue("BaseUrl");

    }
    public UserResponse getUserById(int id){
        return get(url + GET_USERS + Integer.toString(id));

    }
    public ArrayList<String> getPostsIdsForAUser(String userId){
        postIdsArr=new ArrayList<String>();
        postsArrResponse =getPosts(url + GET_POSTS, userId);
        for(PostResponse postResponse : postsArrResponse){
            postIdsArr.add(postResponse.getId());
        }
        return postIdsArr;
    }

    public ArrayList<String> getEmailsForAPost(String postId){
        emailsForAPost=new ArrayList<String>();
        commentsArrResponse =getComments(url+GET_COMMENTS, postId);

        for(CommentResponse commentResponse : commentsArrResponse){
            emailsForAPost.add(commentResponse.getEmail());
        }
        return emailsForAPost;
    }

    public int numberOfUsers(){
        return getAllUsers(url+ GET_USERS).length;
    }
    public ArrayList<String> getEmailsForAllCommentsForAUser(String userId){
        postIdsArr=getPostsIdsForAUser(userId);
        emailsForAllCommentsForAUser=new ArrayList<String>();
        for(String postId : postIdsArr){
            emailsForAllCommentsForAUser.addAll(getEmailsForAPost(postId));
        }
        return emailsForAllCommentsForAUser;

    }



}

