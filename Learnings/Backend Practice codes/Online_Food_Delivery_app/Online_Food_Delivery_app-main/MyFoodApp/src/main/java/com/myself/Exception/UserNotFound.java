package com.myself.Exception;

import lombok.NoArgsConstructor;

/**
 * The type User not found.
 */
@NoArgsConstructor
public class UserNotFound extends  RuntimeException{
    /**
     * Instantiates a new User not found.
     *
     * @param message the message
     */
    public UserNotFound(String message) {
 	   super(message);
    }
}
