package com.iot.sensor.controller;

import com.iot.sensor.model.User;
import com.iot.sensor.payload.Result;
import com.iot.sensor.payload.UserTO;
import com.iot.sensor.security.CurrentUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @GetMapping("/me")
    public Result getUserDetail(@CurrentUser User currUser) {
        UserTO userTO = new UserTO();
        userTO.setName(currUser.getName());
        userTO.setParentPhone(currUser.getParentPhone());
        userTO.setClassName(currUser.getClassNumber());
        userTO.setUserIdentification(currUser.getNumber());
        userTO.setGender(currUser.getGender());

        return new Result(true, userTO);
    }


}
