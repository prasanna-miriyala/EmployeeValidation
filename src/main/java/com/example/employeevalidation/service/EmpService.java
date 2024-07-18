package com.example.employeevalidation.service;



import com.example.employeevalidation.dto.EmpDTO;
import com.example.employeevalidation.entity.Employee;
import com.example.employeevalidation.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class EmpService {
    @Autowired
    private EmpRepository employeeRepo;
    public Employee saveEmployee(EmpDTO empDTO){
        String phnums = empDTO.getPhoneNums();

        if(phnums.length()==0 || (phnums.length()>0 && phnums.length()<10)){
            System.out.println("Give valid phone number");
            return null;
        }
        if(phnums.contains(",")){
            StringTokenizer st = new StringTokenizer(",");
            while(st.hasMoreElements()){
                String num = st.nextToken();
                if(num.length()!=10){
                    System.out.println("Give valid phone numbers");
                    //need to implement wrapper empoyee response which contians status codes
                    //for the intereset of time I ma validating here in service class but not propagate response in wrapper class
                    return null;
                }
            }
        }
        Employee employee= Employee.builder().
                firstName (empDTO.getFirstName())
                .lastName (empDTO.getLastName ()  )
                .email ( empDTO.getEmail ( ) )
                .phoneNums ( empDTO.getPhoneNums ( ) )
                .doj ( empDTO.getDoj ( ) )
                .salary ( empDTO.getSalary ( ) )
                .build();

        System.out.println("employee" +employee);
        return  employeeRepo.save(employee);
    }
    public List<Employee> display() {
        List<Employee> employeeList = employeeRepo.findAll();
        System.out.println("employeeList: "+employeeList);
        employeeList.forEach(System.out::println);

        return employeeList;
    }


}

