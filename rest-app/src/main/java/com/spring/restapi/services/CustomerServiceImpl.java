package com.spring.restapi.services;

import com.spring.restapi.Domain.*;
import com.spring.restapi.api.v1.mapper.*;
import com.spring.restapi.controllers.v1.*;
import com.spring.restapi.exceptions.*;
import com.spring.restapi.model.*;
import com.spring.restapi.repositories.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.customerMapper = CustomerMapper.CUSTOMER_MAPPER_INSTANCE;
    }

    private String getCustomerUrl(Long id) {
        return CustomerController.BASE_URL + "/" + id;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(customer -> {
                    CustomerDTO customerDTO = customerMapper.customerToCustomerDto(customer);
                    customerDTO.setCustomerUrl(getCustomerUrl(customer.getId()));
                    return customerDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::customerToCustomerDto)
                .map(customerDTO -> {
                    //set API URL
                    customerDTO.setCustomerUrl(getCustomerUrl(id));
                    return customerDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    private CustomerDTO saveAndReturnDTO(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        CustomerDTO returnDto = customerMapper.customerToCustomerDto(savedCustomer);
        returnDto.setCustomerUrl(getCustomerUrl(savedCustomer.getId()));
        return returnDto;
    }

    public CustomerDTO saveCustomer(CustomerDTO CustomerDTO) {
        return saveAndReturnDTO(customerMapper.customerDtoToCustomer(CustomerDTO));
    }

    @Override
    public CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);
        customer.setId(id);
        return saveAndReturnDTO(customer);
    }

    @Override
    public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(customer -> {
            if (customerDTO.getFirstname() != null) {
                customer.setFirstname(customerDTO.getFirstname());
            }

            if (customerDTO.getLastname() != null) {
                customer.setLastname(customerDTO.getLastname());
            }
            CustomerDTO returnDto = customerMapper.customerToCustomerDto(customerRepository.save(customer));

            returnDto.setCustomerUrl(getCustomerUrl(id));
            return returnDto;
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}
