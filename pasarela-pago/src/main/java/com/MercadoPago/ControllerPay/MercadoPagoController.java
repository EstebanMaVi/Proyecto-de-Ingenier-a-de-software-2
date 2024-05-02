package com.MercadoPago.ControllerPay;

import com.MercadoPago.ModelEntity.UserBuyer;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MercadoPagoController {

    @Value("${codigo.mercadoLibre}")
    private String mercadoLibreToken;

    @GetMapping("/api/checkout")
    public RedirectView redirectIndex() {
        return new RedirectView("/");
    }

    @RequestMapping(value = "/api/mp", method = RequestMethod.POST)
    public String getList (@RequestBody UserBuyer userBuyer) {
        if(userBuyer  == null){return "error jsons :/";}
        String title = userBuyer.getTittle();
        int quantity = userBuyer.getQuantity();
        int price = userBuyer.getUnit_price();

        try{
            MercadoPagoConfig.setAccessToken(mercadoLibreToken);

            // 1 - Preferencia de venta
            PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                    .title(title)
                    .quantity(quantity)
                    .unitPrice(new BigDecimal(price))
                    .currencyId("COP")
                    .build();

            List<PreferenceItemRequest> items = new ArrayList<>();
            items.add(itemRequest);

            //2 - Preferencia de control de sucess
            PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest
                    .builder().success("https://www.success.com")
                    .pending("https://www.pending.com")
                    .failure("https://www.failure.com")
                    .build();

            //Preferencia que contiene todas las preferencias creadas
            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .items(items)
                    .backUrls(backUrls)
                    .build();

            //Objeto tipo cliente para comunicarlo con MP
            PreferenceClient client = new PreferenceClient();
            //Nueva preferencia que es la respuesta que nuestro cliente envía de la información enviada
            Preference preference = client.create(preferenceRequest);

            return preference.getId();

        }catch (MPException | MPApiException e){return e.toString();}

    }
}
