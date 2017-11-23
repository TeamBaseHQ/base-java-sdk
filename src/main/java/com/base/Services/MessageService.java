package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.Http.NotFound;
import com.base.Exceptions.MessageNotFound;
import com.base.Exceptions.ThreadNotFound;
import com.base.Helpers;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Models.Message;

import java.io.File;
import java.util.*;

public class MessageService {

    /**
     * {@link Base}
     */
    private Base base;

    /**
     * Construct Instance of Base Class
     *
     * @param base
     */
    public MessageService(Base base) {
        this.base = base;
    }

    /**
     * Create Message of Thread
     *
     * @param teamSlug    Message teamSlug
     * @param channelSlug Message channelSlug
     * @param threadSlug  Message threadSlug
     * @param content     Message content
     * @param type        Message type
     * @return Message
     * @throws ThreadNotFound
     * @throws BaseHttpException
     */
    public Message createMessage(String teamSlug, String channelSlug, String threadSlug, String content, String type) throws ThreadNotFound, BaseHttpException {
        File[] files = {};
        return this.createMessage(teamSlug, channelSlug, threadSlug, content, type, files);
    }

    /**
     * Create Message of Thread
     *
     * @param teamSlug    Message teamSlug
     * @param channelSlug Message channelSlug
     * @param threadSlug  Message threadSlug
     * @param content     Message content
     * @param type        Message type
     * @param files       Message files
     * @return Message
     * @throws ThreadNotFound
     * @throws BaseHttpException
     */
    public Message createMessage(String teamSlug, String channelSlug, String threadSlug, String content, String type, File[] files) throws ThreadNotFound, BaseHttpException {
        HashMap<String, String> parameters = new HashMap<>();

        Map<String, File> requestFiles = new HashMap<>();

        for (int i = 0; i < files.length; i++) {
            requestFiles.put("files*" + i, files[i]);
        }

        parameters.put("content", content);
        parameters.put("type", type);
        try {
            String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug).concat("/threads/").
                    concat(threadSlug).concat("/messages");
            Response response = this.base.sendRequest(URL, Request.METHOD_POST, parameters, new HashMap<>(), requestFiles);
            return (Message) Base.makeModel(Message.class, response.getBody());
        } catch (NotFound e) {
            throw new ThreadNotFound(teamSlug);
        }
    }

    /**
     * List of all thread messages
     *
     * @param teamSlug    Team Slug
     * @param channelSlug Channel Slug
     * @param threadSlug  Thread Slug
     * @param page        Page number
     * @param limit       Limit Value
     * @return List of Messages
     * @throws ThreadNotFound    Exception
     * @throws BaseHttpException Exception
     */
    public List<Message> getAllMessages(String teamSlug, String channelSlug, String threadSlug, int page, int limit) throws ThreadNotFound, BaseHttpException {

        ArrayList<String> parameters = new ArrayList<>();

        if (page != 0) {
            parameters.add("page=".concat(Integer.toString(page)));
        }
        if (limit != 0) {
            parameters.add("limit=".concat(Integer.toString(limit)));
        }
        String URL = Helpers.buildUrlWithQuery("/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug).concat("/threads/").concat(threadSlug)
                .concat("/messages/"), parameters);

        try {
            Response response = this.base.sendRequest(URL, Request.METHOD_GET);
            Message[] messagesArray = (Message[]) Base.makeModel(Message[].class, response.getBody());
            return new ArrayList<>(Arrays.asList(messagesArray));
        } catch (NotFound e) {
            throw new ThreadNotFound(threadSlug);
        }
    }

    /**
     * List of all thread messages
     *
     * @param teamSlug    Team Slug
     * @param channelSlug Channel Slug
     * @param threadSlug  Thread Slug
     * @param page        Page number
     * @return List of Messages
     * @throws ThreadNotFound    Exception
     * @throws BaseHttpException Exception
     */
    public List<Message> getAllMessages(String teamSlug, String channelSlug, String threadSlug, int page) throws ThreadNotFound, BaseHttpException {
        return getAllMessages(teamSlug, channelSlug, threadSlug, page, 0);
    }

    /**
     * List of all thread messages
     *
     * @param teamSlug    Team Slug
     * @param channelSlug Channel Slug
     * @param threadSlug  Thread Slug
     * @return List of Messages
     * @throws ThreadNotFound    Exception
     * @throws BaseHttpException Exception
     */
    public List<Message> getAllMessages(String teamSlug, String channelSlug, String threadSlug) throws ThreadNotFound, BaseHttpException {
        return getAllMessages(teamSlug, channelSlug, threadSlug, 0, 0);
    }

    /**
     * Show thread message
     *
     * @param teamSlug
     * @param channelSlug
     * @param threadSlug
     * @param messageSlug
     * @return Message
     * @throws MessageNotFound   Exception
     * @throws BaseHttpException Exception
     */
    public Message getMessage(String teamSlug, String channelSlug, String threadSlug, String messageSlug) throws MessageNotFound, BaseHttpException {
        try {
            String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug).concat("/threads/").concat(threadSlug)
                    .concat("/messages/").concat(messageSlug);
            Response response = this.base.sendRequest(URL, Request.METHOD_GET);
            return (Message) Base.makeModel(Message.class, response.getBody());
        } catch (NotFound e) {
            throw new MessageNotFound(messageSlug);
        }
    }

    /**
     * Update thread Message
     *
     * @param teamSlug
     * @param channelSlug
     * @param threadSlug
     * @param messageSlug
     * @param messageContent
     * @param type
     * @return Message
     * @throws BaseHttpException Exception
     * @throws MessageNotFound   Exception
     */
    public Message updateMessage(String teamSlug, String channelSlug, String threadSlug, String messageSlug, String messageContent, String type) throws BaseHttpException, MessageNotFound {
        Map<String, String> parameters = new HashMap<>();
        if (!messageContent.isEmpty()) {
            parameters.put("content", messageContent);
        }

        if (!type.isEmpty()) {
            parameters.put("type", type);
        }

        try {
            String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug).concat("/threads/").concat(threadSlug)
                    .concat("/messages/").concat(messageSlug);
            Response response = this.base.sendRequest(URL, Request.METHOD_PATCH, parameters);
            return (Message) Base.makeModel(Message.class, response.getBody());
        } catch (NotFound e) {
            throw new MessageNotFound(messageSlug);
        }

    }

    /**
     * Delete Message
     *
     * @param teamSlug
     * @param channelSlug
     * @param threadSlug
     * @param messageSlug
     * @return boolean value
     * @throws BaseHttpException Exception
     * @throws MessageNotFound   Exception
     */
    public boolean deleteMessage(String teamSlug, String channelSlug, String threadSlug, String messageSlug) throws BaseHttpException, MessageNotFound {

        try {
            String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug).concat("/threads/").concat(threadSlug).concat("/messages/").concat(messageSlug);
            Response response = this.base.sendRequest(URL, Request.METHOD_DELETE);
            return true;
        } catch (NotFound e) {
            throw new MessageNotFound(messageSlug);
        }
    }

    /**
     * Star Thread Message
     *
     * @param teamSlug
     * @param channelSlug
     * @param threadSlug
     * @param messageSlug
     * @return boolean Value
     * @throws BaseHttpException Exception
     * @throws MessageNotFound   Exception
     */
    public boolean starThreadMessage(String teamSlug, String channelSlug, String threadSlug, String messageSlug) throws BaseHttpException, MessageNotFound {

        try {
            String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug).concat("/threads/").concat(threadSlug).concat("/messages/").concat(messageSlug).concat("/star");
            Response response = this.base.sendRequest(URL, Request.METHOD_POST);
            return true;
        } catch (NotFound e) {
            throw new MessageNotFound(messageSlug);
        }
    }

    /**
     * UnStar Thread Message
     *
     * @param teamSlug
     * @param channelSlug
     * @param threadSlug
     * @param messageSlug
     * @return boolean Value
     * @throws BaseHttpException Exception
     * @throws MessageNotFound   Exception
     */
    public boolean unStarThreadMessage(String teamSlug, String channelSlug, String threadSlug, String messageSlug) throws BaseHttpException, MessageNotFound {

        try {
            String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug).concat("/threads/").concat(threadSlug).concat("/messages/").concat(messageSlug).concat("/star");
            Response response = this.base.sendRequest(URL, Request.METHOD_DELETE);
            return true;
        } catch (NotFound e) {
            throw new MessageNotFound(messageSlug);
        }
    }

}
