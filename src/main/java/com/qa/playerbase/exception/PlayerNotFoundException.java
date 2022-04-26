package com.qa.playerbase.exception;

import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class PlayerNotFoundException extends EntityNotFoundException {

}
