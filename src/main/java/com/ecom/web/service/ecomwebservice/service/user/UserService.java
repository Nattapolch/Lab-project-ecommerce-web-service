package com.ecom.web.service.ecomwebservice.service.user;

import com.ecom.web.service.ecomwebservice.dto.ResponseBase;
import com.ecom.web.service.ecomwebservice.dto.user.UserDetailDto;
import com.ecom.web.service.ecomwebservice.dto.user.UserDetailRequest;

public interface UserService {
    ResponseBase<UserDetailDto> GetUserDetail (UserDetailRequest request);
}
