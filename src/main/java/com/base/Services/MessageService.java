package com.base.Services;

import com.base.Base;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.Http.NotFound;
import com.base.Exceptions.ThreadNotFound;
import com.base.Http.Request.Request;
import com.base.Http.Response.Response;
import com.base.Models.Message;

import java.util.HashMap;

public class MessageService {

    private Base base;

    public MessageService(Base base) {
        this.base = base;
    }


}
