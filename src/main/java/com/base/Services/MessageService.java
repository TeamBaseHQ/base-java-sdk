package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.Http.NotFound;
import com.base.Exceptions.MessageNotFound;
import com.base.Exceptions.ThreadNotFound;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Models.Message;

import java.util.*;

public class MessageService {

    private Base base;

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
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("content", content);
        parameters.put("type", type);
        try {
            String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug).concat("/threads/").
                    concat(threadSlug).concat("/messages");
            Response response = this.base.sendRequest(URL, Request.METHOD_POST, parameters);
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
     * @return List of Messages
     * @throws ThreadNotFound    Exception
     * @throws BaseHttpException Exception
     */
    public List<Message> getAllMessages(String teamSlug, String channelSlug, String threadSlug) throws ThreadNotFound, BaseHttpException {
        try {
            String URL = "/teams/".concat(teamSlug).concat("/channels/").concat(channelSlug).concat("/threads/").concat(threadSlug)
                    .concat("/messages/");
            Response response = this.base.sendRequest(URL, Request.METHOD_GET);
            Message[] messagesArray = (Message[]) Base.makeModel(Message[].class, response.getBody());
            return new ArrayList<>(Arrays.asList(messagesArray));
        } catch (NotFound e) {
            throw new ThreadNotFound(threadSlug);
        }
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


}
