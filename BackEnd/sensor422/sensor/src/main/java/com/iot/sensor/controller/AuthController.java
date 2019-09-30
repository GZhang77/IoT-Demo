package com.iot.sensor.controller;


import com.iot.sensor.model.User;
import com.iot.sensor.payload.LoginTO;
import com.iot.sensor.payload.Result;
import com.iot.sensor.service.TokenService;
import com.iot.sensor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginTO loginTO) {

        User user = userService.getByNumberAndName(loginTO.getUserIdentification(), loginTO.getName());

        if(user == null) {
            return new Result(false, null);
        }

        return new Result(true, tokenService.generateToken(user));
    }

}
