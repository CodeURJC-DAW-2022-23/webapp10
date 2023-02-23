package com.nutri.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;


public class CustomErrorControler {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "404";
            }
            else if(statusCode == HttpStatus.FORBIDDEN.value() ) {
                return "403";

            } else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value() ) {
                return "500";
            }
        }
        return "error";
    }
}
