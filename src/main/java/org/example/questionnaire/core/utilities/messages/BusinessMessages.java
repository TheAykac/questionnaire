package org.example.questionnaire.core.utilities.messages;

public class BusinessMessages {


    /**
     * A class that contains the messages used in the project.
     */
    public static class GlobalMessages {

        public static final String DATA_LISTED_SUCCESSFULLY = "Data Listed Successfully";

        public static final String DATA_ADDED_SUCCESSFULLY = "Data Added Successfully";
        public static final String DATA_UPDATED_SUCCESSFULLY = "Data updated Successfully, dataId: ";
        public static final String DATA_DELETED_SUCCESSFULLY = "Data deleted successfully, dataId: ";
    }

    public static class ErrorMessage {
        public static final String INVALID_USERNAME_OR_PASSWORD = "Kullanıcı adı veya şifre hatalı.";
        public static final String USER_NOT_FOUND = "Kullanıcı bulunamadı, kullanıcıId: ";

        public static final String USERNAME_ALREADY_EXISTS = "Bu Kullanıcı Adı Kullanılıyor";
        public static final String SYSTEM_ERROR = "Sistem Tarafından Fırlatılan Hatalar";


    }
}
