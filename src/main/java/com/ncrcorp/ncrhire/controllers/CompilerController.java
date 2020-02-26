package com.ncrcorp.ncrhire.controllers;

import com.ncrcorp.ncrhire.pojo.SourceCode;
import com.ncrcorp.ncrhire.pojo.SubmissionDetails;
import com.ncrcorp.ncrhire.pojo.Token;
import com.ncrcorp.ncrhire.services.CompilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class CompilerController {
    @Autowired
    private CompilerService compilerService;

    @PostMapping(value = "/run", consumes = "application/json")
    public SubmissionDetails run_compileCode(@RequestBody SourceCode srcCode) {
        Token tokenId = compilerService.generateTokeinId(srcCode);
        SubmissionDetails submissionDetails = compilerService.getSubmissionDetails(tokenId);
        return submissionDetails;
    }

}
