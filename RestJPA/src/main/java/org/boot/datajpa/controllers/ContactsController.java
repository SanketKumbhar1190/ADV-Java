package org.boot.datajpa.controllers;


import java.util.List;
import org.boot.datajpa.dto.ContactsDTO;
import org.boot.datajpa.services.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    ContactsService contactsService;

    @PostMapping("/newContact")
    public boolean createContact(@RequestBody ContactsDTO contactsDTO) {
        return contactsService.addContacts(contactsDTO);
    }

    @GetMapping("/getContact/{cid}") // Using PathVariable
    public ContactsDTO getContactById(@PathVariable("cid") int contactId) {
        return contactsService.getContactById(contactId);
    }

    @GetMapping("/allContacts/{pageNo}/{pageSize}")
    public List<ContactsDTO> getAllContacts(@PathVariable("pageNo") int pageNo,
                                             @PathVariable("pageSize") int pageSize) {
        return contactsService.getAllContacts(pageNo - 1, pageSize); // pageNo is 0-indexed in Spring Data JPA
    }

    @GetMapping("/getContactsByFirstName")
    public ContactsDTO getContactsByFirstName(@RequestParam("firstName") String firstName) {
        return contactsService.getContactsByFirstName(firstName);
    }

    @GetMapping("/getContactsLike")
    public List<ContactsDTO> getContactsLike(@RequestParam("like") String like) {
        return contactsService.getContactsLike(like);
    }
}