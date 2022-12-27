package com.example.frescos.config;

import com.example.frescos.entity.*;
import com.example.frescos.enums.SectionCode;
import com.example.frescos.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.logging.Logger;

@Configuration
public class LoadDbScript {
    private Logger logger = Logger.getLogger(String.valueOf(LoadDbScript.class));
    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private ApplicationUserRepository applicationUserRepository;
    @Autowired
    private BatchRepository batchRepository;
    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private InboundOrderRepository inboundOrderRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private WarehouseRepository warehouseRepository;

    @PostConstruct
    public void loadDb(){
        if(agentRepository.findByUserName("MarcosInfantino").isPresent())
            return;

        Product product1 = new Product("Pan", SectionCode.FRESH,100.0);
        Product product2 = new Product("Cereales", SectionCode.FRESH,50.0);
        Product product3 = new Product("Barrita de cereal", SectionCode.FRESH,20.0);
        Product product4 = new Product("Queso", SectionCode.COOL,200.0);
        Product product5 = new Product("Leche", SectionCode.COOL,200.0);
        Product product6 = new Product("Jamón", SectionCode.COOL,100.0);
        Product product7 = new Product("Helado", SectionCode.FROZEN,300.0);
        Product product8 = new Product("Bife de chorizo", SectionCode.FROZEN,400.0);
        Product product9 = new Product("Morcilla", SectionCode.FROZEN,200.0);
        Product product10 = new Product("Achuras", SectionCode.FROZEN,300.0);
        Product product11 = new Product("Pollo", SectionCode.FROZEN,400.0);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        productRepository.save(product6);
        productRepository.save(product7);
        productRepository.save(product8);
        productRepository.save(product9);
        productRepository.save(product10);
        productRepository.save(product11);

        Batch batch1 = new Batch(1L, product1,11.50,4.0,500,20,LocalDate.now(), LocalDateTime.of(LocalDate.now(), LocalTime.now()), LocalDate.of(2030,12,30));
        Batch batch2 = new Batch(2L, product2,13.00,1.2,2000,100,LocalDate.of(2010,03,11), LocalDateTime.of(LocalDate.of(2010,03,11), LocalTime.now()), LocalDate.of(2023,03,11));;
        Batch batch3 = new Batch(3L, product3,16.00,3.2,300,3,LocalDate.of(2016,03,11), LocalDateTime.of(LocalDate.of(2016,03,11), LocalTime.now()), LocalDate.of(2041,03,11));;
        batchRepository.save(batch1);
        batchRepository.save(batch2);
        batchRepository.save(batch3);



        logger.info("Productos creados:");
        productRepository.findAll().forEach(p-> logger.info(p.getDescription()));

        Agent marcos = new Agent("MarcosInfantino", "admin");
        agentRepository.save(marcos);
        Warehouse warehouse = new Warehouse(marcos);
        warehouseRepository.save(warehouse);

        logger.info("Warehouses creados:");
        warehouseRepository.findAll().forEach(w->logger.info("Warehouse de " + w.getAgent().getUserName()));

        applicationUserRepository.findAll().forEach(u->logger.info(u.getUserName()));

    }
}
