package com.base;

import com.base.Auth.AccessToken;
import com.base.Exceptions.BaseException;
import com.base.Exceptions.BaseHttpException;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Models.ResponseModel;
import com.base.Services.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public final class Base {

    /**
     * {@link BaseClient} client
     */
    private BaseClient client;

    /**
     * Create UserService Reference
     */
    private UserService userService;

    /**
     * Create TeamService Reference
     */
    private TeamService teamService;

    /**
     * Create TeamMemberService Reference
     */
    private TeamMemberService teamMemberService;

    /**
     * Create ChannelService Reference
     */
    private ChannelService channelService;

    /**
     * Create ChannelMemberService Reference
     */
    private ChannelMemberService channelMemberService;

    /**
     * Create ThreadService Reference
     */
    private ThreadService threadService;

    /**
     * Create MessageService Reference
     */
    private MessageService messageService;

    /**
     * Create PreferencesService Reference
     */
    private PreferenceService preferenceService;

    /**
     * Create InvitationService  Reference
     */
    private InvitationService invitationService;

    /**
     * Construct {@link Base} with all bootstrapServices
     */
    public Base() {
        this.client = new BaseClient();
        this.bootstrapServices();
    }

    /**
     * Construct {@link Base} and set accessToken.
     *
     * @param accessToken Client access Token
     */
    public Base(String accessToken) {
        this();
        this.getClient()
                .setAccessToken(new AccessToken(accessToken));
    }

    /**
     * Construct {@link Base} wtih specified clientId and clientSecret
     *
     * @param clientId     Client ID
     * @param clientSecret Client Secret
     */
    public Base(String clientId, String clientSecret) {
        this();
        this.getClient()
                .setClientId(clientId)
                .setClientSecret(clientSecret);
    }

    /**
     * Construct {@link BaseClient}
     *
     * @param client baseClient
     */
    public Base(BaseClient client) {
        this();
        this.client = client;
    }

    /**
     * Make Model.
     *
     * @param model    Model Type.
     * @param jsonData JSON Data.
     * @return Model Object.
     */
    public static Object makeModel(Type model, String jsonData) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        ResponseModel response = gson.fromJson(jsonData, ResponseModel.class);
        Object data = response.getData();
        String jData = gson.toJson(data);
        return gson.fromJson(jData, model);
    }

    /**
     * @return Base Client
     */
    public BaseClient getClient() {
        return client;
    }

    /**
     * Set Base Client
     *
     * @param client
     * @return
     */
    public Base setClient(BaseClient client) {
        this.client = client;
        return this;
    }

    /**
     * Send {@link Request} with endpoint and method
     *
     * @param endpoint API EndPoint
     * @param method   Method Type
     * @return Response
     * @throws BaseHttpException Exception
     */
    public Response sendRequest(String endpoint, String method)
            throws BaseHttpException {
        return this.sendRequest(endpoint, method, new HashMap<>());
    }

    /**
     * Send {@link Request} with endpoint, method and Parameters
     *
     * @param endpoint   API EndPoint
     * @param method     Method Type
     * @param parameters Parameters
     * @return Response
     * @throws BaseHttpException Exception
     */
    public Response sendRequest(String endpoint, String method, Map<String, String> parameters)
            throws BaseHttpException {
        return this.sendRequest(endpoint, method, parameters, new HashMap<>());
    }

    /**
     * Send {@link Request} with endpoint, method, Parameters and Headers
     *
     * @param endpoint   API EndPoint
     * @param method     Method Type
     * @param parameters Parameters
     * @param headers    Additional Headers
     * @return Response
     * @throws BaseHttpException Exception
     */
    public Response sendRequest(String endpoint, String method, Map<String, String> parameters, Map<String, String>
            headers)
            throws BaseHttpException {
        return this.sendRequest(endpoint, method, parameters, headers, new HashMap<>());
    }

    /**
     * Send {@link Request} with endpoint, method, Parameters, Headers and Files
     *
     * @param endpoint   API EndPoint
     * @param method     Method Type
     * @param parameters Parameters
     * @param files      Files that you want to upload
     * @return Response
     * @throws BaseHttpException Exception
     */
    public Response sendRequest(String endpoint, String method, Map<String, String> parameters, Map<String, String>
            headers, Map<String, File> files)
            throws BaseHttpException {
        return this.sendRequest(endpoint, method, parameters, headers, files, null, null);
    }

    /**
     * Send {@link Request} with endpoint, method, Parameters, Headers, Files and AccessToken
     *
     * @param endpoint    API EndPoint
     * @param method      Method Type
     * @param parameters  Parameters
     * @param files       Files that you want to upload
     * @param accessToken AccessToken of User
     * @return Response
     * @throws BaseHttpException Exception
     */
    public Response sendRequest(String endpoint, String method, Map<String, String> parameters, Map<String, String>
            headers, Map<String, File> files, AccessToken accessToken)
            throws BaseHttpException {
        return this.sendRequest(endpoint, method, parameters, headers, files, accessToken, null);
    }

    /**
     * Send {@link Request} with endpoint, method, Parameters, Headers, Files, AccessToken and Response
     *
     * @param endpoint    API EndPoint
     * @param method      Method Type
     * @param parameters  Parameters
     * @param files       Files that you want to upload
     * @param accessToken AccessToken of User
     * @param response    Response
     * @return Response
     * @throws BaseHttpException Exception
     */
    public Response sendRequest(String endpoint, String method, Map<String, String> parameters, Map<String, String>
            headers, Map<String, File> files, AccessToken accessToken, Response response) throws BaseHttpException {
        Request request = new Request(endpoint, method);

        request.setHeaders(headers)
                .setFiles(files)
                .setParameters(parameters)
                .setAccessToken(accessToken);

        return this.getClient().sendRequest(request, response);
    }

    /**
     * Get User Access Token (Login).
     *
     * @param email    User Email
     * @param password User Password
     * @return AccessToken
     * @throws BaseException Exception
     */
    public AccessToken getUserAccessToken(String email, String password) throws BaseException {
        try {
            Map<String, String> parameters = new HashMap<>();
            parameters.put("email", email);
            parameters.put("password", password);

            Response response = this.sendRequest("/users/login", Request.METHOD_POST, parameters);
            return (AccessToken) makeModel(AccessToken.class, response.getBody());
        } catch (BaseHttpException e) {
            throw new BaseException(500, e.getMessage());
        }
    }

    /**
     * Base UserService
     *
     * @return UserService
     */
    public UserService userService() {
        return this.userService;
    }

    /**
     * Base TeamService
     *
     * @return TeamService
     */
    public TeamService teamService() {
        return this.teamService;
    }

    /**
     * Base TeamMemberService
     *
     * @return TeamMemberService
     */
    public TeamMemberService teamMemberService() {
        return this.teamMemberService;
    }

    /**
     * Base ChannelService
     *
     * @return ChannelService
     */
    public ChannelService channelService() {
        return this.channelService;
    }

    /**
     * Base ChannelMemberService
     *
     * @return ChannelMemberService
     */
    public ChannelMemberService channelMemberService() {
        return this.channelMemberService;
    }

    /**
     * Base ThreadService
     *
     * @return ThreadService
     */
    public ThreadService threadService() {
        return this.threadService;
    }

    /**
     * Base MessageService
     *
     * @return MessageService
     */
    public MessageService messageService() {
        return this.messageService;
    }

    /**
     * Base PreferencesService
     *
     * @return PreferencesService
     */
    public PreferenceService preferenceService() {
        return this.preferenceService;
    }

    /**
     * Base PreferencesService
     *
     * @return PreferencesService
     */
    public InvitationService invitationService() {
        return this.invitationService;
    }


    /**
     * Generate All bootstrapServices
     */
    private void bootstrapServices() {
        this.userService = new UserService(this);
        this.teamService = new TeamService(this);
        this.teamMemberService = new TeamMemberService(this);
        this.channelService = new ChannelService(this);
        this.channelMemberService = new ChannelMemberService(this);
        this.threadService = new ThreadService(this);
        this.messageService = new MessageService(this);
        this.preferenceService = new PreferenceService(this);
        this.invitationService = new InvitationService(this);
    }
}
