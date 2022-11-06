package com.devhcm.billingservice.mappers;

import com.devhcm.billingservice.dto.InvoiceRequestDTO;
import com.devhcm.billingservice.dto.InvoiceResponseDTO;
import com.devhcm.billingservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    InvoiceResponseDTO invoiceToInvoiceResponseDTO(Invoice invoice);
    Invoice InvoiceRequestDTOToInvoice(InvoiceRequestDTO invoiceRequestDTO);
}
