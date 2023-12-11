package com.carobackendhere;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonalException extends Exception{

    public PersonalException(String msg){ super(msg);}
}
