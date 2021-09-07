package com.mattel.service;

import com.mattel.model.Request;

import java.util.List;

public interface RequestService {

    public Request submitRequest(Request request);
    public Request adjustRequestStatus(int requestId, String status);
    public List<Request> getRequests(String status);
}
