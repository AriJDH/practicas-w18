package com.bootcamp.QATester.service.imp;

import com.bootcamp.QATester.dto.req.TestCaseReqDto;
import com.bootcamp.QATester.dto.views.TestCaseResDto;
import com.bootcamp.QATester.entity.TestCase;
import com.bootcamp.QATester.repository.ITestCaseRepository;
import com.bootcamp.QATester.service.ITestCaseService;
import com.bootcamp.QATester.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.bootcamp.QATester.util.Mapper.getTestCase;
import static com.bootcamp.QATester.util.Mapper.getTestCaseResDto;

@Service
public class TestCaseService implements ITestCaseService {
    private ITestCaseRepository repository;

    public TestCaseService(ITestCaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(TestCaseReqDto testCaseReqDto) {
        repository.save(getTestCase(testCaseReqDto));
    }

    @Override
    public List<TestCaseResDto> findAll() {
        return TestCaseResDtoList(
                Optional.of(repository.findAll())
                        .orElseThrow(() -> new RuntimeException("list empty")
                        )
        );

    }

    @Override
    public TestCaseResDto findById(Long id) {
        return getTestCaseResDto(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("id does not exist")));
    }

    @Override
    public void updateById(Long id,TestCaseReqDto dto) {

               TestCase repo= repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("id does not exist"));
        repository.save(updater(repo,dto));


    }
    private TestCase updater(TestCase t,TestCaseReqDto update){
        t.setDescription(update.getDescription());
        t.setLastUpdate(update.getLastUpdate());
        t.setTested(update.getTested());
        t.setPassed(update.getPassed());
        t.setNumber_of_tries(update.getNumber_of_tries());
        return t;
    }

    @Override
    public void deleteById(Long id) {

        repository.deleteById(
                repository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("id does not exist"))
                        .getId_case()
        );
    }

    @Override
    public List<TestCaseResDto> findAfterDate(String date) {
        return TestCaseResDtoList(
                repository.findAfterDate(LocalDate.parse(date))
                .orElseThrow(()->new RuntimeException("list is Empty"))
        );
    }

    private List<TestCaseResDto> TestCaseResDtoList(List<TestCase> testCases) {
        return testCases.stream()
                .map(Mapper::getTestCaseResDto)
                .collect(Collectors.toList());
    }
}
