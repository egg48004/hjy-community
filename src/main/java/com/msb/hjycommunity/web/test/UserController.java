package com.msb.hjycommunity.web.test;


import com.msb.hjycommunity.common.core.domain.BaseResponse;
import com.msb.hjycommunity.common.core.exception.BaseException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("user")
public class UserController {
    @RequestMapping("queryUserId")
    public BaseResponse<User> queryUserByid(String userID){
        if (Objects.equals(userID, "1")){
            return BaseResponse.success(new User("1", "user1"));
        }else {
            return BaseResponse.fail("query failed");
        }
    }

    @RequestMapping("addUser")
    public BaseResponse addUser(@Validated User user, BindingResult bindingResult){
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if (fieldErrors.isEmpty()){
            return BaseResponse.success(user);
        }else {
            return BaseResponse.fail(fieldErrors.get(0).getDefaultMessage());
        }

    }

    @RequestMapping("queryUser")
    public BaseResponse queryUser(){
        //抛出自己定义的异常
        throw new BaseException("500", "throw new exceptions 11111");

    }


}
