package org.boot.datajpa.services;


import java.util.List;
import org.boot.datajpa.dto.ContactsDTO;

public interface ContactsService {
    public List<ContactsDTO> getAllContacts();
    
    public ContactsDTO getContactById(int contactId);
    
    public boolean addContacts(ContactsDTO dto);
    
    public List<ContactsDTO> getAllContacts(int pageNo, int pageSize); // Added for pagination
    
    public ContactsDTO getContactsByFirstName(String firstName); // Added for findByFirstName
    
    public List<ContactsDTO> getContactsLike(String like); // Added for search like
}