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
import java.util.Arrays;
import java.util.List;
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

        Product product1 = new Product("Pan", SectionCode.FRESH,100.0, "FS");
        Product product2 = new Product("Cereales", SectionCode.FRESH,50.0, "FS");
        Product product3 = new Product("Barrita de cereal", SectionCode.FRESH,20.0, "FS");
        Product product4 = new Product("Queso", SectionCode.COOL,200.0, "RF");
        Product product5 = new Product("Leche", SectionCode.COOL,200.0,"RF");
        Product product6 = new Product("Jamón", SectionCode.COOL,100.0,"RF");
        Product product7 = new Product("Helado", SectionCode.FROZEN,300.0, "FF");
        Product product8 = new Product("Bife de chorizo", SectionCode.FROZEN,400.0,"FF");
        Product product9 = new Product("Morcilla", SectionCode.FROZEN,200.0, "FF");
        Product product10 = new Product("Achuras", SectionCode.FROZEN,300.0, "FF");
        Product product11 = new Product("Pollo", SectionCode.FROZEN,400.0, "FF");
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

        Batch batch1 = new Batch(1L, product1,11.50,4.0,500,500,LocalDate.now(), LocalDateTime.of(LocalDate.now(), LocalTime.now()), LocalDate.now().plusDays(30));
        Batch batch2 = new Batch(2L, product2,13.00,1.2,2000,2000,LocalDate.of(2010,3,11), LocalDateTime.of(LocalDate.of(2010,3,11), LocalTime.now()), LocalDate.now().plusDays(30));
        Batch batch3 = new Batch(3L, product3,2.00,-4.2,300,300,LocalDate.of(2016,2,20), LocalDateTime.of(LocalDate.of(2016,2,20), LocalTime.now()), LocalDate.now().plusDays(30));
        Batch batch4 = new Batch(4L, product4,5.00,-1.2,4002,4002,LocalDate.of(2021,6,23), LocalDateTime.of(LocalDate.of(2021,6,23), LocalTime.now()), LocalDate.now().plusDays(30));
        Batch batch5 = new Batch(5L, product5,5.00,-1.2,807,807,LocalDate.of(2022,10,4), LocalDateTime.of(LocalDate.of(2022,10,4), LocalTime.now()), LocalDate.now().plusDays(5));
        Batch batch6 = new Batch(6L, product6,4.00,-5.0,1201,1201,LocalDate.of(2022,9,30), LocalDateTime.of(LocalDate.of(2021,9,30), LocalTime.now()), LocalDate.now().plusDays(6));
        Batch batch7 = new Batch(7L, product7,-80.00,-91.2,9990,9990,LocalDate.of(2022,10,1), LocalDateTime.of(LocalDate.of(2022,10,1), LocalTime.now()), LocalDate.now().plusDays(7));
        Batch batch8 = new Batch(8L, product8,-30.00,-50.6,2776,2776,LocalDate.of(2019,8,9), LocalDateTime.of(LocalDate.of(2019,8,9), LocalTime.now()), LocalDate.now().plusDays(8));
        Batch batch9 = new Batch(9L, product9,-12.00,-30.4,401,401,LocalDate.of(2019,5,29), LocalDateTime.of(LocalDate.of(2019,5,29), LocalTime.now()), LocalDate.now().plusDays(9));
        Batch batch10 = new Batch(10L, product10,-22.00,-42.7,343,343,LocalDate.of(2005,11,7), LocalDateTime.of(LocalDate.of(2005,11,7), LocalTime.now()), LocalDate.now().plusDays(10));
        Batch batch11 = new Batch(11L, product10,-40.00,-50.7,88580,88580,LocalDate.of(2022,7,14), LocalDateTime.of(LocalDate.of(2022,7,14), LocalTime.now()), LocalDate.now().plusDays(11));
        Batch batch12 = new Batch(12L, product10,-40.00,-50.7,88580,88580,LocalDate.of(2022,7,14), LocalDateTime.of(LocalDate.of(2022,7,14), LocalTime.now()), LocalDate.now().minusDays(12));
        Batch batch13 = new Batch(13L, product4,5.00,-1.2,4005,400,LocalDate.of(2021,6,23), LocalDateTime.of(LocalDate.of(2021,6,23), LocalTime.now()), LocalDate.now().plusDays(150));
        Batch batch14 = new Batch(14L, product4,5.00,-1.2,8089,8070,LocalDate.of(2022,10,4), LocalDateTime.of(LocalDate.of(2022,10,4), LocalTime.now()), LocalDate.now().plusDays(50));
        Batch batch15 = new Batch(15L, product4,5.00,-1.2,120,10,LocalDate.of(2022,9,30), LocalDateTime.of(LocalDate.of(2021,9,30), LocalTime.now()), LocalDate.now().plusDays(60));

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
        batchRepository.save(batch12);
        batchRepository.save(batch13);
        batchRepository.save(batch14);
        batchRepository.save(batch15);

        List<Batch> batchesFresh = Arrays.asList(batch1, batch2, batch3);
        List<Batch> batchesCool1 = Arrays.asList(batch4, batch5, batch6, batch13, batch14);
        List<Batch> batchesFrozen = Arrays.asList(batch7, batch8, batch9, batch10, batch11, batch12);
        List<Batch> batchesCool2 = Arrays.asList(batch15);

        logger.info("Productos creados:");
        productRepository.findAll().forEach(p-> logger.info(p.getDescription()));

        Agent marcos = new Agent("MarcosInfantino", "admin");
        agentRepository.save(marcos);
        Warehouse warehouse1 = new Warehouse(marcos);
        Warehouse warehouse2 = new Warehouse(marcos);
        warehouseRepository.save(warehouse1);
        warehouseRepository.save(warehouse2);

        Buyer miguel = new Buyer("MiguelAvalle", "admin");
        buyerRepository.save(miguel);

        logger.info("Warehouses creados:");
        warehouseRepository.findAll().forEach(w->logger.info("Warehouse de " + w.getAgent().getUserName()));

        applicationUserRepository.findAll().forEach(u->logger.info(u.getUserName()));

        Section sectionFresh = sectionRepository.findById(3L).get();
        Section sectionCool1 = sectionRepository.findById(4L).get();
        Section sectionFrozen = sectionRepository.findById(5L).get();
        Section sectionCool2 = sectionRepository.findById(8L).get();

        sectionFresh.setBatches(batchesFresh);
        sectionCool1.setBatches(batchesCool1);
        sectionFrozen.setBatches(batchesFrozen);
        sectionCool2.setBatches(batchesCool2);

        InboundOrder inboundOrder1 = new InboundOrder(1L, LocalDate.of(2020,3,11), sectionFresh, batchesFresh, marcos);
        InboundOrder inboundOrder2 = new InboundOrder(2L, LocalDate.of(2020,4,25), sectionCool1, batchesCool1, marcos);
        InboundOrder inboundOrder3 = new InboundOrder(3L, LocalDate.of(2020,7,7), sectionFrozen, batchesFrozen, marcos);
        InboundOrder inboundOrder4 = new InboundOrder(4L, LocalDate.of(2020,7,7), sectionCool2, batchesCool2, marcos);

        inboundOrderRepository.save(inboundOrder1);
        inboundOrderRepository.save(inboundOrder2);
        inboundOrderRepository.save(inboundOrder3);
        inboundOrderRepository.save(inboundOrder4);
    }
}
