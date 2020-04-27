package ua.lviv.iot.spring.lab7.TourFirm.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.lab7.TourFirm.dataaccess.CustomersRepository;
import ua.lviv.iot.spring.lab7.TourFirm.spring.model.Customer;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomersService {

        @Autowired
        private CustomersRepository customersRepository;

        public List<Customer> getAllCustomers() {
            return customersRepository.findAll();
        }

        public Customer getCustomerById(Integer customerId) {
            try {
                return customersRepository.findById(customerId).get();
            } catch (NoSuchElementException e) {
                return null;
            }
        }

        public Customer createCustomer(Customer customer) {
            return customersRepository.save(customer);
        }

        public Customer updateCustomer(Integer customerId, Customer customer) {
            customer.setId(customerId);
            return customersRepository.save(customer);
        }

        public void deleteCustomer(Integer customerId) {
            customersRepository.deleteById(customerId);
        }

        public boolean customerExists(Integer customerId) {
            return customersRepository.existsById(customerId);
        }
}
