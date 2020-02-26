package com.ncrcorp.ncrhire.services;

import com.ncrcorp.ncrhire.pojo.SourceCode;
import com.ncrcorp.ncrhire.pojo.SubmissionDetails;
import com.ncrcorp.ncrhire.pojo.Token;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.security.PublicKey;

@Service
public class CompilerService {

    public Token generateTokeinId(SourceCode sourceCode) {
        LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap();

        map.add("source_code", sourceCode.getSource_code());
        map.add("language_id", sourceCode.getLanguage_id() + "");

        BodyInserters.FormInserter<String> inserter
                = BodyInserters.fromFormData(map);
        Token tokenId = WebClient
                .builder()
                //.baseUrl("https://api.judge0.com/submissions/?base64_encoded=false&wait=false")
                //  .defaultCookie("cookieKey", "cookieValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build().post().uri("https://api.judge0.com/submissions/?base64_encoded=false&wait=false")
                .body(inserter)
                .retrieve().bodyToMono(Token.class).block();

        return tokenId;
    }

    public SubmissionDetails getSubmissionDetails(Token tokenId) {
        String reqFields = "?base64_encoded=false&fields=stdout,status_id,language_id,time,expected_output";
        String submissionUrl = "https://api.judge0.com/submissions/" + tokenId.getToken() + reqFields;
        int curStatusVal = 0;

        SubmissionDetails submissionDetails = WebClient
                .builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build().get().uri(submissionUrl)
                .retrieve().bodyToMono(SubmissionDetails.class).block();
        while (curStatusVal <= 2) {
            submissionDetails = WebClient
                    .builder()
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .build().get().uri(submissionUrl)
                    .retrieve().bodyToMono(SubmissionDetails.class).block();
            curStatusVal = submissionDetails.getStatus_id();
        }
        return submissionDetails;
    }
}
