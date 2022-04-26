package com.qa.playerbase.exception;

import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Player does not exist")
public class PlayerNotFoundException extends EntityNotFoundException {

}
