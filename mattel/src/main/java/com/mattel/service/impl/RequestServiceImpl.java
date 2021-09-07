package com.mattel.service.impl;

import com.mattel.exception.UserException;
import com.mattel.model.Request;
import com.mattel.repository.RequestRepository;
import com.mattel.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    private RequestRepository requestRepository;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Request submitRequest(Request request) {
        request.setStatus("pending");
        return requestRepository.save(request);
    }

    @Override
    public Request adjustRequestStatus(int requestId, String status) {
        Request request = new Request();
        request = requestRepository.getById(requestId);
        if(request == null){
            throw new UserException("Request is not found");
        }else{
            request.setStatus(status);
            requestRepository.save(request);
        }
        return request;
    }

    @Override
    public List<Request> getRequests(String status) {
        if(status.equals("pending")) {
            return requestRepository.findAllByStatus(status);
        }else{
            return requestRepository.findAllByStatus(status);
        }
    }

}
