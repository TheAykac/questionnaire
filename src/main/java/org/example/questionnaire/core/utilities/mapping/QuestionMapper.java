package org.example.questionnaire.core.utilities.mapping;

import lombok.RequiredArgsConstructor;
import org.example.questionnaire.dtos.request.QuestionRequest;
import org.example.questionnaire.model.concretes.questions.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
@RequiredArgsConstructor
public abstract class QuestionMapper {

    public static QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    @Mapping(target = "questionType", constant = "PARAGRAPH")
    @Mapping(target = "questionText", source = "questionText")
    @Mapping(target = "createUserCode", source = "createUserCode")
    public abstract ParagraphQuestion toParagraphQuestion(QuestionRequest questionRequest);

    @Mapping(target = "choices", source = "options")
    @Mapping(target = "questionType", constant = "MULTIPLE_CHOICE")
    @Mapping(target = "questionText", source = "questionText")
    public abstract MultipleChoiceQuestion toMultipleChoiceQuestion(QuestionRequest questionRequest);

    @Mapping(target = "checkboxes", source = "options")
    @Mapping(target = "questionType", constant = "CHECKBOX")
    @Mapping(target = "questionText", source = "questionText")
    public abstract CheckboxQuestion toCheckboxQuestion(QuestionRequest questionRequest);

    @Mapping(target = "options", source = "options")
    @Mapping(target = "questionType", constant = "DROPDOWN")
    @Mapping(target = "questionText", source = "questionText")
    public abstract DropdownQuestion toDropdownQuestion(QuestionRequest questionRequest);

    @Mapping(target = "minScale", source = "minScale")
    @Mapping(target = "maxScale", source = "maxScale")
    @Mapping(target = "questionType", constant = "LINEAR_SCALE")
    @Mapping(target = "questionText", source = "questionText")
    public abstract LinearScaleQuestion toLinearScaleQuestion(QuestionRequest questionRequest);

    @Mapping(target = "questionType", constant = "DATE")
    @Mapping(target = "questionText", source = "questionText")
    public abstract DateQuestion toDateQuestion(QuestionRequest questionRequest);
}
