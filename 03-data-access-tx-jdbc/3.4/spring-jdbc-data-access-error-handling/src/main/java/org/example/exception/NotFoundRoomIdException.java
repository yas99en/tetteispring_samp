package org.example.exception;

import org.springframework.dao.DataRetrievalFailureException;

@SuppressWarnings("serial")
public class NotFoundRoomIdException extends RuntimeException {

    public NotFoundRoomIdException(String s, DataRetrievalFailureException e) {
        super(s, e);
    }
}
