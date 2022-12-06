package com.jpaHibernate.testerQA.service;

import com.jpaHibernate.testerQA.dto.MessageDTOResponse;
import com.jpaHibernate.testerQA.dto.TestCaseDTO;
import com.jpaHibernate.testerQA.model.TestCase;
import com.jpaHibernate.testerQA.repository.IRepositoryTestCase;
import com.jpaHibernate.testerQA.util.MapTo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService{

    private final IRepositoryTestCase repositoryTestCase;

    public TestCaseService(IRepositoryTestCase repositoryTestCase) {
        this.repositoryTestCase = repositoryTestCase;
    }

    /**
     * @return List<TestCase>
     */
    @Override
    @Transactional(readOnly = true)
    public List<TestCase> getAll() {
        return repositoryTestCase.findAll();
    }

    /**
     * @param testCaseDTO
     * @return List<TestCaseDTO>
     */
    @Override
    @Transactional
    public TestCase save(TestCase testCase) {
        return repositoryTestCase.save(testCase);
    }

    /**
     * @param id
     */
    @Override
    @Transactional
    public MessageDTOResponse delete(Long id) {

        MessageDTOResponse message = new MessageDTOResponse();

        if(!repositoryTestCase.findById(id).isPresent()){
            message.setMessage("Ese test no existe. No es posible eliminarlo");
        }

        repositoryTestCase.deleteById(id);
        message.setMessage("Test Eliminado");
        return message;
    }

    /**
     * @param id
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public TestCase findById(Long id) {
        return repositoryTestCase.findById(id).orElse(null);
        //TODO devolver mensaje en caso de no encontrar
    }

    /**
     * @param date
     * @return List<TestCase> after date
     */
    @Override
    public List<TestCase> findAfterDate(LocalDate date) {
        return repositoryTestCase.findTestCasesAfterDate(date);
    }

    /**
     * @param id
     * @param testCaseDTO
     */
    @Override
    public TestCaseDTO updateTestCase(Long id, TestCaseDTO testCaseDTO) {

        TestCase findTC = repositoryTestCase.findById(id).orElseThrow();

        TestCase updateTC = MapTo.dtoToEntity(testCaseDTO); //Convierto a entidad el dto que recibo
        updateTC.setId_case(findTC.getId_case());           //Setteo id del Test case convertido de DTO a Entity
        updateTC.setLast_update(testCaseDTO.getLast_updated());

        repositoryTestCase.save(updateTC);                  //Guardo a través del repo
        return MapTo.entityToDTO(updateTC);                 //Convierto de entidad a DTO y lo retorno actualizado
    }
}
