package org.boot.datajpa.services;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional; // Added for Optional

import org.boot.datajpa.dto.ContactsDTO;
import org.boot.datajpa.entity.Contacts;
import org.boot.datajpa.repository.ContactsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest; // Added for pagination
import org.springframework.data.domain.Pageable; // Added for pagination
import org.springframework.data.domain.Sort; // Added for sorting
import org.springframework.stereotype.Service;

@Service
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    ContactsRepository contactsRepo; // Renamed from contactRepo for consistency

    @Override
    public List<ContactsDTO> getAllContacts() {
        Iterator<Contacts> iter = contactsRepo.findAll().iterator();
        List<ContactsDTO> list = new ArrayList<>();
        while(iter.hasNext()) {
            Contacts objContact = iter.next();
            ContactsDTO dto = new ContactsDTO();
            BeanUtils.copyProperties(objContact, dto);
            list.add(dto);
        }
        return list;
    }

    @Override
    public ContactsDTO getContactById(int contactId) {
        Optional<Contacts> optContacts = contactsRepo.findById(contactId);
        if(optContacts.isPresent()) {
            Contacts objContact = optContacts.get();
            ContactsDTO dto = new ContactsDTO();
            BeanUtils.copyProperties(objContact, dto);
            return dto;
        }
        return null;
    }

    @Override
    public boolean addContacts(ContactsDTO dto) {
        Contacts objContact = new Contacts();
        BeanUtils.copyProperties(dto, objContact);
        contactsRepo.save(objContact);
        return true;
    }

    @Override
    public List<ContactsDTO> getAllContacts(int pageNo, int pageSize) {
        Sort sortLastName = Sort.by("lastName").ascending()
                              .and(Sort.by("firstName").ascending());
        Pageable page = PageRequest.of(pageNo, pageSize, sortLastName);
        List<Contacts> allContacts = contactsRepo.findAll(page).toList();
        List<ContactsDTO> listDTO = new ArrayList<>();
        for(Contacts objContacts : allContacts) {
            ContactsDTO dto = new ContactsDTO();
            BeanUtils.copyProperties(objContacts, dto);
            listDTO.add(dto);
        }
        return listDTO;
    }

    @Override
    public ContactsDTO getContactsByFirstName(String firstName) {
        Contacts objContact = contactsRepo.findByFirstName(firstName);
        ContactsDTO dto = new ContactsDTO();
        BeanUtils.copyProperties(objContact, dto);
        return dto;
    }

    @Override
    public List<ContactsDTO> getContactsLike(String like) {
        List<Contacts> list = contactsRepo.showAllContactsLike(like); // Using JPQL custom query
        // Or, to use native query: List<Contacts> list = contactsRepo.showAllLike(like);
        List<ContactsDTO> listDTO = new ArrayList<>();
        for(Contacts objContacts : list) {
            ContactsDTO dto = new ContactsDTO();
            BeanUtils.copyProperties(objContacts, dto);
            listDTO.add(dto);
        }
        return listDTO;
    }
}