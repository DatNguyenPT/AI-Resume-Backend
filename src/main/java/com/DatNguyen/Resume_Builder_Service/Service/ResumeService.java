package com.DatNguyen.Resume_Builder_Service.Service;

import org.json.JSONObject;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Map;

public interface ResumeService {

    Mono<Map<String, Object>> generateResumeResponse(String userResumeDescription) throws IOException;
}