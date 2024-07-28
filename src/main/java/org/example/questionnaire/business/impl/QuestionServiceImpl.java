package org.example.questionnaire.business.impl;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.questionnaire.business.service.QuestionService;
import org.example.questionnaire.core.utilities.exceptions.BusinessException;
import org.example.questionnaire.core.utilities.mapping.QuestionMapper;
import org.example.questionnaire.core.utilities.messages.BusinessMessages;
import org.example.questionnaire.core.utilities.result.DataResult;
import org.example.questionnaire.core.utilities.result.SuccessDataResult;
import org.example.questionnaire.dataAccess.*;
import org.example.questionnaire.dtos.request.QuestionRequest;
import org.example.questionnaire.model.UserLogin;
import org.example.questionnaire.model.abstracts.BaseQuestion;
import org.example.questionnaire.model.concretes.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final HttpSession session;

    private final ParagraphQuestionRepository paragraphQuestionRepository;

    private final MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;

    private final CheckboxQuestionRepository checkboxQuestionRepository;

    private final DropdownQuestionRepository dropdownQuestionRepository;

    private final LinearScaleQuestionRepository linearScaleQuestionRepository;

    private final DateQuestionRepository dateQuestionRepository;

    private final QuestionMapper questionMapper = QuestionMapper.INSTANCE;


    @Override
    public DataResult<BaseQuestion> createQuestion(QuestionRequest questionRequest) throws BusinessException {
        switch (questionRequest.getQuestionType()) {
            case PARAGRAPH:
                ParagraphQuestion paragraphQuestion = questionMapper.toParagraphQuestion(questionRequest);
                paragraphQuestion.setCreateUserCode(getUserCode());
                ParagraphQuestion saveParagraph = paragraphQuestionRepository.save(paragraphQuestion);
                return new SuccessDataResult<>(saveParagraph, BusinessMessages.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
            case MULTIPLE_CHOICE:
                MultipleChoiceQuestion multipleChoiceQuestion = questionMapper.toMultipleChoiceQuestion(questionRequest);
                multipleChoiceQuestion.setCreateUserCode(getUserCode());
                MultipleChoiceQuestion saveMultipleChoice = multipleChoiceQuestionRepository.save(multipleChoiceQuestion);
                return new SuccessDataResult<>(saveMultipleChoice, BusinessMessages.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
            case CHECKBOX:
                CheckboxQuestion checkboxQuestion = questionMapper.toCheckboxQuestion(questionRequest);
                checkboxQuestion.setCreateUserCode(getUserCode());
                CheckboxQuestion saveCheckBox = checkboxQuestionRepository.save(checkboxQuestion);
                return new SuccessDataResult<>(saveCheckBox, BusinessMessages.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
            case DROPDOWN:
                DropdownQuestion dropdownQuestion = questionMapper.toDropdownQuestion(questionRequest);
                dropdownQuestion.setCreateUserCode(getUserCode());
                DropdownQuestion saveDropDown = dropdownQuestionRepository.save(dropdownQuestion);
                return new SuccessDataResult<>(saveDropDown, BusinessMessages.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
            case LINEAR_SCALE:
                LinearScaleQuestion linearScaleQuestion = questionMapper.toLinearScaleQuestion(questionRequest);
                linearScaleQuestion.setCreateUserCode(getUserCode());
                LinearScaleQuestion saveLinearScale = linearScaleQuestionRepository.save(linearScaleQuestion);
                return new SuccessDataResult<>(saveLinearScale, BusinessMessages.GlobalMessages.DATA_ADDED_SUCCESSFULLY);
            case DATE:
                DateQuestion dateQuestion = questionMapper.toDateQuestion(questionRequest);
                dateQuestion.setCreateUserCode(getUserCode());
                DateQuestion saveDate = dateQuestionRepository.save(dateQuestion);
                return new SuccessDataResult<>(saveDate, BusinessMessages.GlobalMessages.DATA_ADDED_SUCCESSFULLY);

            default:
                throw new IllegalArgumentException("Unknown question type: " + questionRequest.getQuestionType());
        }
    }

    private String getUserCode() throws BusinessException {
        UserLogin userLogin = (UserLogin) session.getAttribute("userLogin");
        if (userLogin == null) {
            throw new BusinessException(BusinessMessages.ErrorMessage.USER_NOT_FOUND);
        }
        return userLogin.getUserCode();
    }
}
