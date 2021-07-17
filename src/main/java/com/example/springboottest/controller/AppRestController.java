package com.example.springboottest.controller;

import com.example.springboottest.entity.Customer;
import com.example.springboottest.entity.Wallet;
import com.example.springboottest.response.*;
import com.example.springboottest.service.CustomerService;
import com.example.springboottest.service.WalletService;
import com.example.springboottest.util.ErrorStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AppRestController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private WalletService walletService;

    @RequestMapping(value = "/api/customer/add", method = RequestMethod.POST)
    public Response customer(@RequestParam("body") String body,
                             @RequestParam(value = "image", required = false) MultipartFile image) {

        try {
            if (!StringUtils.hasLength(body)) {
                return ErrorResponse.getErrorResponse(ErrorStatus.UNKNOWN_ERROR, HttpStatus.NO_CONTENT);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            CustomRequestBody reqBody = objectMapper.readValue(body, CustomRequestBody.class);

            if (reqBody == null && reqBody.getUser() == null) {
                return ErrorResponse.getErrorResponse(ErrorStatus.UNKNOWN_ERROR, HttpStatus.BAD_REQUEST);
            }

            Customer customer = reqBody.getUser();

            if (!StringUtils.hasLength(customer.getShortName())) {
                return ErrorResponse.getErrorResponse(ErrorStatus.USER_NAME_REQUIRED, HttpStatus.BAD_REQUEST);
            } else if (!StringUtils.hasLength(customer.getEmail())) {
                return ErrorResponse.getErrorResponse(ErrorStatus.USER_EMIL_REQUIRED, HttpStatus.BAD_REQUEST);
            } else if (!StringUtils.hasLength(customer.getPhone())) {
                return ErrorResponse.getErrorResponse(ErrorStatus.USER_PHONE_REQUIRED, HttpStatus.BAD_REQUEST);
            }

            Customer responseUser = customerService.insert(customer);


            return new UserResponseBody().setUser(responseUser).setStatus(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ErrorResponse.getErrorResponse(ErrorStatus.UNKNOWN_ERROR, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/api/customer/update", method = RequestMethod.PUT)
    public Response updateCustomer(@RequestParam("body") String body) {

        try {
            if (!StringUtils.hasLength(body)) {
                return ErrorResponse.getErrorResponse(ErrorStatus.UNKNOWN_ERROR, HttpStatus.NO_CONTENT);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            CustomRequestBody reqBody = objectMapper.readValue(body, CustomRequestBody.class);

            if (reqBody == null && reqBody.getUser() == null) {
                return ErrorResponse.getErrorResponse(ErrorStatus.UPDATE_FAILED, HttpStatus.BAD_REQUEST);
            }

            Customer customer = reqBody.getUser();

            if (!StringUtils.hasLength(customer.getShortName())) {
                return ErrorResponse.getErrorResponse(ErrorStatus.USER_NAME_REQUIRED, HttpStatus.BAD_REQUEST);
            } else if (!StringUtils.hasLength(customer.getEmail())) {
                return ErrorResponse.getErrorResponse(ErrorStatus.USER_EMIL_REQUIRED, HttpStatus.BAD_REQUEST);
            } else if (!StringUtils.hasLength(customer.getPhone())) {
                return ErrorResponse.getErrorResponse(ErrorStatus.USER_PHONE_REQUIRED, HttpStatus.BAD_REQUEST);
            }

            Customer responseUser = customerService.update(customer);


            return new UserResponseBody().setUser(responseUser).setStatus(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ErrorResponse.getErrorResponse(ErrorStatus.UNKNOWN_ERROR, HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/api/customers", method = RequestMethod.GET)
    public Response getCustomerList() {

        List<CustomerModel> models = null;
        try {
            models = new ArrayList<>();

            List<Customer> customers = customerService.findAll();
            for (Customer customer : customers) {
                Wallet wallet = walletService.findById(customer.getWalletId());
                CustomerModel customerModel = CustomerModel.getCustomerModel(customer);
                customerModel.setBalance(wallet.getWalletBalance());
                models.add(customerModel);
            }
            return new CustomerResponseBody().setCustomer(models).setStatus(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ErrorResponse.getErrorResponse(ErrorStatus.CUSTOMER_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/api/customer/{userId}", method = RequestMethod.GET)
    public Response getCustomerById(@PathVariable("userId") BigInteger userId) {

        try {
            if (userId == null || userId.compareTo(BigInteger.ZERO) != 1) {
                return ErrorResponse.getErrorResponse(ErrorStatus.CUSTOMER_NOT_FOUND, HttpStatus.BAD_REQUEST);
            }
            Customer customer = customerService.findById(userId);
            if (customer != null) {
                Wallet wallet = walletService.findById(customer.getWalletId());
                CustomerModel customerModel = CustomerModel.getCustomerModel(customer);
                customerModel.setBalance(wallet.getWalletBalance());
                return new CustomerResponseBody()
                        .add(customerModel).setStatus(HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ErrorResponse.getErrorResponse(ErrorStatus.CUSTOMER_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }

//    @RequestMapping(value = "/api/customers", method = RequestMethod.GET)
//    public Response getCustomerById() {
//
//    }

    @RequestMapping(value = "/api/wallet/update-limit", method = RequestMethod.PUT)
    public Response updateLimit(@RequestParam("body") String body) {
        try {
            if (!StringUtils.hasLength(body)) {
                return ErrorResponse.getErrorResponse(ErrorStatus.UNKNOWN_ERROR, HttpStatus.NO_CONTENT);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            WalletUpdateRequestBody reqBody = objectMapper.readValue(body, WalletUpdateRequestBody.class);


            if (reqBody.getUserId() == null || reqBody.getLimit() == null) {
                return ErrorResponse.getErrorResponse(ErrorStatus.UPDATE_FAILED, HttpStatus.BAD_REQUEST);
            }

            Customer responseUser = customerService.findById(reqBody.getUserId());
            if (responseUser != null) {
                walletService.updateLimit(responseUser.getWalletId(), reqBody.getLimit());
                return new SuccessResponse<Response>().setStatus(HttpStatus.OK);
            }
            return ErrorResponse.getErrorResponse(ErrorStatus.UPDATE_FAILED, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ErrorResponse.getErrorResponse(ErrorStatus.UNKNOWN_ERROR, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/api/customer/update-balance", method = RequestMethod.PUT)
    public Response updateBalance(@RequestParam("body") String body) {
        try {
            if (!StringUtils.hasLength(body)) {
                return ErrorResponse.getErrorResponse(ErrorStatus.UNKNOWN_ERROR, HttpStatus.NO_CONTENT);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            WalletUpdateRequestBody reqBody = objectMapper.readValue(body, WalletUpdateRequestBody.class);


            if (reqBody.getUserId() == null
                    || reqBody.getBalance() == null
                    || reqBody.getPointer() == null) {
                return ErrorResponse.getErrorResponse(ErrorStatus.UPDATE_FAILED, HttpStatus.BAD_REQUEST);
            }

            Customer responseUser = customerService.findById(reqBody.getUserId());
            if (responseUser != null) {
                walletService.updateBalance(
                        responseUser.getWalletId(),
                        reqBody.getBalance(),
                        reqBody.getPointer());
                return new SuccessResponse<Response>().setStatus(HttpStatus.OK);
            }
            return ErrorResponse.getErrorResponse(ErrorStatus.UPDATE_FAILED, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ErrorResponse.getErrorResponse(ErrorStatus.UNKNOWN_ERROR, HttpStatus.BAD_REQUEST);
    }

}
