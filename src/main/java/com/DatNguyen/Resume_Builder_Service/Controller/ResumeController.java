package com.DatNguyen.Resume_Builder_Service.Controller;

import com.DatNguyen.Resume_Builder_Service.Entity.ResumeRequest;
import com.DatNguyen.Resume_Builder_Service.Service.ResumeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @PostMapping("/generate")
    public ResponseEntity<Mono<Map<String, Object>>> getResumeData(
            @RequestBody ResumeRequest resumeRequest
    ) throws IOException {

        Mono<Map<String, Object>> stringObjectMap = resumeService.generateResumeResponse(resumeRequest.userDescription());
        return new ResponseEntity<>(stringObjectMap, HttpStatus.OK);

    }
}