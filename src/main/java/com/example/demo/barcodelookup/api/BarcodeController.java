package com.example.demo.barcodelookup.api;
import com.example.demo.barcodelookup.model.Email;
import com.example.demo.barcodelookup.model.Product;
import com.example.demo.barcodelookup.service.ItemLookupService;
import com.example.demo.barcodelookup.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/api/v1/itemLookup")
@RestController
public class BarcodeController {

    private final ItemLookupService itemLookupService;
    private EmailService emailService = new EmailService();
    @Autowired
    public BarcodeController(ItemLookupService itemLookupService) {
        this.itemLookupService = itemLookupService;
    }
    Logger logger = LoggerFactory.getLogger(BarcodeController.class);


    @PostMapping(path = "ifDoesntExistStoreForDataGathering/{id}")
    public Optional<Product> addNewBarCode(@Valid @NonNull @PathVariable("id")String id)
    {
        return itemLookupService.findBarCodeSaveIfNotFound(id);
    }

    @GetMapping(path = "ifDoesntExistUseVendorData/{id}")
    public Object ifDoesntExistUseVendorData(@Valid @NonNull @PathVariable("id")String id) {
        return itemLookupService.ifDoesntExistUseVendorData(id).orElseThrow(() -> new RuntimeException("Our database and 3rd party api has not found the barcode please check if api key is still valid"));
    }


    @PostMapping(path = "email")
    public void SendEmail( @RequestBody  @Valid @NonNull Email emailObject) {

        try {

        emailService.setMsg(emailObject.getMessage());
        emailService.setRecipientEmail(emailObject.getRecipient());
        emailService.setSubject(emailObject.getSubject());
        emailService.sendMessageWithAttachment();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
