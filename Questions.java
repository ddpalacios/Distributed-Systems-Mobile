package com.example.myapplication;
import java.lang.reflect.Array;
import java.util.UUID;


public class Questions {

    private int object_id;
    private String[] response;
    private String type;
    private Object json_as_dictionary;

    public Questions(int object_id, String[] response, String type) {
        this.object_id = object_id;
        this.response = response;
        this.type = type;


    }

    public Object create_a_question(Object question_representation) {

        if (question_representation instanceof Questions) {

            return question_representation;
        }

        if (question_representation instanceof Array) {
            json_as_dictionary = question_representation;

        } else if (question_representation instanceof String) {
            // Object json_as_dictionary = json.loads(question_representation)
            // Find best way for serialization
        } else {
            throw new IllegalArgumentException("Json representation must be a dictionary");

        }
        Object question_type = json_as_dictionary; //Get question type

        if (question_type == 'multiple choice') {
            return MultipleChoiceQuestion(json_as_dictionary);


        } else if (question_type == 'short_answer') {
            return shortAnswerQuestion(json_as_dictionary);


        } else if (question_type == 'fill_in_the_blank') {
            return FillinTheBlankQuestion(json_as_dictionary);


        } else:
        throw new IllegalArgumentException("This question type is not supported");

        return 0;
    }


    public void add_response(Object response) {


    }

    public Boolean validate_response(Object response) {
        return false;
    }

        public Object get_responses () {
            return response;
        }

        public Boolean __eq__ (Object other) {
            if (other instanceof Questions){
        return false;
        }
    return true;
    }
}

