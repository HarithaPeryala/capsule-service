package com.tekcapsule.capsule.application.function;

import com.tekcapsule.capsule.application.config.AppConfig;
import com.tekcapsule.capsule.application.function.input.SearchBySubCategoryInput;
import com.tekcapsule.capsule.domain.model.Capsule;
import com.tekcapsule.capsule.domain.service.CapsuleService;
import com.tekcapsule.core.utils.HeaderUtil;
import com.tekcapsule.core.utils.Outcome;
import com.tekcapsule.core.utils.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
@Slf4j
public class SearchBySubCategoryFunction implements Function<Message<SearchBySubCategoryInput>, Message<List<Capsule>>> {

    private final CapsuleService capsuleService;

    private final AppConfig appConfig;

    public SearchBySubCategoryFunction(final CapsuleService capsuleService, final AppConfig appConfig) {
        this.capsuleService = capsuleService;
        this.appConfig = appConfig;
    }

    @Override
    public Message<List<Capsule>> apply(Message<SearchBySubCategoryInput> findBySubCategoryInputMessage) {
        Map<String, Object> responseHeaders = new HashMap<>();
        List<Capsule> capsules =new ArrayList<>();
        String stage = appConfig.getStage().toUpperCase();
        try {
            SearchBySubCategoryInput searchBySubCategoryInput = findBySubCategoryInputMessage.getPayload();
            log.info(String.format("Entering search by sub category function subcategory %s", searchBySubCategoryInput.getSubCategory()));
            capsules = capsuleService.findBySubCategory(searchBySubCategoryInput.getTopicCode(), searchBySubCategoryInput.getCategory(), searchBySubCategoryInput.getSubCategory());
            responseHeaders = HeaderUtil.populateResponseHeaders(responseHeaders, Stage.valueOf(stage), Outcome.SUCCESS);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            responseHeaders = HeaderUtil.populateResponseHeaders(responseHeaders, Stage.valueOf(stage), Outcome.ERROR);
        }
        return new GenericMessage(capsules, responseHeaders);
    }
}