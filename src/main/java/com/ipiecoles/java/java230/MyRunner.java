package com.ipiecoles.java.java230;

import com.ipiecoles.java.java230.model.Employe;
import com.ipiecoles.java.java230.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(employeRepository.count());
        Optional<Employe> e = employeRepository.findById(5L);
        if (e.isPresent()) {
            Employe emp = e.get();
            System.out.println(emp);
            emp.setSalaire(2500d);
            System.out.println(emp);
        } else {
            System.out.println("Employé non trouvé");
        }
        System.out.println(employeRepository.findByMatricule("M00001"));
        /*Page<Employe> emps = employeRepository.;
        for (Employe employe : emps) {
            //System.out.println(employe);
        }*/
    }

    public static void print(Object t) {
        System.out.println(t);
    }
}
