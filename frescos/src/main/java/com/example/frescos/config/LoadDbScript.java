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

        Batch batch1 = new Batch(1L, product1,11.50,4.0,500,20,LocalDate.now(), LocalDateTime.of(LocalDate.now(), LocalTime.now()), LocalDate.now().plusDays(1));
        Batch batch2 = new Batch(2L, product2,13.00,1.2,2000,100,LocalDate.of(2010,3,11), LocalDateTime.of(LocalDate.of(2010,3,11), LocalTime.now()), LocalDate.now().plusDays(2));
        Batch batch3 = new Batch(3L, product3,2.00,-4.2,300,3,LocalDate.of(2016,2,20), LocalDateTime.of(LocalDate.of(2016,2,20), LocalTime.now()), LocalDate.now().plusDays(3));
        Batch batch4 = new Batch(4L, product4,5.00,-1.2,5231,4002,LocalDate.of(2021,6,23), LocalDateTime.of(LocalDate.of(2021,6,23), LocalTime.now()), LocalDate.now().plusDays(4));
        Batch batch5 = new Batch(5L, product5,5.00,-1.2,1489,807,LocalDate.of(2022,10,4), LocalDateTime.of(LocalDate.of(2022,10,4), LocalTime.now()), LocalDate.now().plusDays(5));
        Batch batch6 = new Batch(6L, product6,4.00,-5.0,3210,1201,LocalDate.of(2022,9,30), LocalDateTime.of(LocalDate.of(2021,9,30), LocalTime.now()), LocalDate.now().plusDays(6));
        Batch batch7 = new Batch(7L, product7,-80.00,-91.2,10205,9990,LocalDate.of(2022,10,1), LocalDateTime.of(LocalDate.of(2022,10,1), LocalTime.now()), LocalDate.now().plusDays(7));
        Batch batch8 = new Batch(8L, product8,-30.00,-50.6,4506,2776,LocalDate.of(2019,8,9), LocalDateTime.of(LocalDate.of(2019,8,9), LocalTime.now()), LocalDate.now().plusDays(8));
        Batch batch9 = new Batch(9L, product9,-12.00,-30.4,888,401,LocalDate.of(2019,5,29), LocalDateTime.of(LocalDate.of(2019,5,29), LocalTime.now()), LocalDate.now().plusDays(9));
        Batch batch10 = new Batch(10L, product10,-22.00,-42.7,343,3,LocalDate.of(2005,11,7), LocalDateTime.of(LocalDate.of(2005,11,7), LocalTime.now()), LocalDate.now().plusDays(10));
        Batch batch11 = new Batch(11L, product10,-40.00,-50.7,88580,77565,LocalDate.of(2022,7,14), LocalDateTime.of(LocalDate.of(2022,7,14), LocalTime.now()), LocalDate.now().plusDays(500));
        Batch batch12 = new Batch(11L, product10,-40.00,-50.7,88580,77565,LocalDate.of(2022,7,14), LocalDateTime.of(LocalDate.of(2022,7,14), LocalTime.now()), LocalDate.now().minusDays(1));
        batchRepository.save(batch1);
        batchRepository.save(batch2);
        batchRepository.save(batch3);
        batchRepository.save(batch4);
        batchRepository.save(batch5);
        batchRepository.save(batch6);
        batchRepository.save(batch7);
        batchRepository.save(batch8);
        batchRepository.save(batch9);
        batchRepository.save(batch10);
        batchRepository.save(batch11);



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
