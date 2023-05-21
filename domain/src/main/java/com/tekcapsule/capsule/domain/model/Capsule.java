package com.tekcapsule.capsule.domain.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tekcapsule.core.domain.AggregateRoot;
import com.tekcapsule.core.domain.BaseDomainEntity;
import lombok.*;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
@DynamoDBTable(tableName = "Capsule")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Capsule extends BaseDomainEntity implements AggregateRoot {

    @DynamoDBHashKey(attributeName="capsuleId")
    @DynamoDBAutoGeneratedKey
    private String capsuleId;
    @DynamoDBAttribute(attributeName = "title")
    private String title;
    @DynamoDBAttribute(attributeName="topicCode")
    private String topicCode;
    @DynamoDBAttribute(attributeName="categoryCode")
    private String categoryCode;
    @DynamoDBAttribute(attributeName="category")
    private String category;
    @DynamoDBAttribute(attributeName="subCategory")
    private String subCategory;
    @DynamoDBAttribute(attributeName = "author")
    private String author;
    @DynamoDBAttribute(attributeName = "description")
    private String description;
    @DynamoDBAttribute(attributeName = "publisher")
    private String publisher;
    @DynamoDBAttribute(attributeName="publishedDate")
    private String publishedDate;
    @DynamoDBAttribute(attributeName = "resourceUrl")
    private String resourceUrl;
    @DynamoDBAttribute(attributeName = "type")
    @DynamoDBTypeConvertedEnum
    private CapsuleType type;
    @DynamoDBAttribute(attributeName = "audience")
    @DynamoDBTypeConvertedEnum
    private TargetAudience audience;
    @DynamoDBAttribute(attributeName = "level")
    @DynamoDBTypeConvertedEnum
    private TopicLevel level;
    @DynamoDBAttribute(attributeName = "expiryDate")
    private String expiryDate;
    @DynamoDBAttribute(attributeName = "duration")
    private Integer duration;
    @DynamoDBAttribute(attributeName="tags")
    private List<String> tags;
    @DynamoDBAttribute(attributeName = "imageUrl")
    private String imageUrl;
    @DynamoDBAttribute(attributeName = "editorsPick")
    private Integer editorsPick;
    @DynamoDBAttribute(attributeName = "views")
    private Integer views;
    @DynamoDBAttribute(attributeName = "bookmarks")
    private Integer bookmarks;
    @DynamoDBAttribute(attributeName = "recommendations")
    private Integer recommendations;
    @DynamoDBAttribute(attributeName = "quizzes")
    private List<Quiz> quizzes;
    @DynamoDBAttribute(attributeName = "keyPoints")
    private List<String> keyPoints;
    @DynamoDBAttribute(attributeName = "badges")
    @DynamoDBTypeConvertedEnum
    private Badge badge;
    @DynamoDBAttribute(attributeName = "status")
    @DynamoDBTypeConvertedEnum
    private Status status;
}