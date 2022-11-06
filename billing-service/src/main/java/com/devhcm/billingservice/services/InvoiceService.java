package com.devhcm.billingservice.services;

import com.devhcm.billingservice.dto.InvoiceRequestDTO;
import com.devhcm.billingservice.dto.InvoiceResponseDTO;
import com.devhcm.billingservice.entities.Invoice;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO getInvoice(String invoiceId);
    List<InvoiceResponseDTO> listInvoices();
    List<InvoiceResponseDTO> customerInvoices(String customerID);
    InvoiceResponseDTO saveInvoice(InvoiceRequestDTO invoice);
    InvoiceResponseDTO updateInvoice(InvoiceRequestDTO invoice);
    void deleteInvoice(String id);
}
