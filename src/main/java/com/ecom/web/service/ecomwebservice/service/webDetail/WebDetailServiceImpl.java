package com.ecom.web.service.ecomwebservice.service.webDetail;

import org.springframework.stereotype.Service;

import com.ecom.web.service.ecomwebservice.dto.ResponseBase;

@Service
public class WebDetailServiceImpl implements WebDetailService {

    public ResponseBase<String> GetVersion() {

        var response = new ResponseBase<String>();
        try {

            response.setData("version : 1.0.0");
            response.setErrorCode("0000");
            response.setErrorMessage("Success");

            return response;

        } catch (Exception ex) {
            response.setErrorCode("9999");
            response.setErrorMessage("Exception was occured : " + ex.getMessage());

            return response;
        }
    }
}
