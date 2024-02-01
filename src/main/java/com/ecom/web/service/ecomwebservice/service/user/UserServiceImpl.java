package com.ecom.web.service.ecomwebservice.service.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.web.service.ecomwebservice.dto.ResponseBase;
import com.ecom.web.service.ecomwebservice.dto.user.UserDetailDto;
import com.ecom.web.service.ecomwebservice.dto.user.UserDetailRequest;
import com.ecom.web.service.ecomwebservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();
    
    public ResponseBase<UserDetailDto> GetUserDetail (UserDetailRequest request){

        var response = new ResponseBase<UserDetailDto>();

        try{

            var hashPassword = this.hashString(request.getPassword(), "MD5");
            var result = userRepository.findByUsernameAndPassword(request.getUsername(), hashPassword);

            if(result == null){
                response.setErrorCode("US0001");
                response.setErrorMessage("Username or password is incorrect.");

                return response;
            }

            UserDetailDto user = modelMapper.map(result, UserDetailDto.class);

            response.setData(user);
            response.setErrorCode("0000");
            response.setErrorMessage("success");

            return response;
        }
        catch(Exception ex){
            response.setErrorCode("9999");
            response.setErrorMessage("Exception was occured : " + ex.getMessage());

            return response;
        }
    }

    private String hashString(String input, String algorithm) throws NoSuchAlgorithmException {
        
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        byte[] hashedBytes = digest.digest(input.getBytes());

        StringBuilder stringBuilder = new StringBuilder();
        for (byte hashedByte : hashedBytes) {
            stringBuilder.append(String.format("%02x", hashedByte));
        }

        return stringBuilder.toString();
    }
}
