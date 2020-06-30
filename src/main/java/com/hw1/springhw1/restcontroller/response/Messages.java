package com.hw1.springhw1.restcontroller.response;

public class Messages {

    public enum Success {
        INSERT_SUCCESS("Record is saved successfully!");

        private String message;

        Success(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public enum Error {
        INSERT_FAILURE("Record cannot save");

        private String message;

        Error(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

}
