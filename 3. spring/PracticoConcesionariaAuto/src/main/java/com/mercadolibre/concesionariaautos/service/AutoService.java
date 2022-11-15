package com.mercadolibre.concesionariaautos.service;

import com.mercadolibre.concesionariaautos.dto.AutoRequestDto.AutoRequestDto;
import com.mercadolibre.concesionariaautos.dto.AutoResponseDto.AutoResponseDto;
import com.mercadolibre.concesionariaautos.dto.AutoResponseDto.AutoResponseNoServiceDto;
import com.mercadolibre.concesionariaautos.entity.Auto;
import com.mercadolibre.concesionariaautos.repository.AutoRepository;
import com.mercadolibre.concesionariaautos.repository.IAutoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AutoService implements IAutoService{
    IAutoRepository autoRepository;

    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    @Override
    public AutoRequestDto agregarAuto(AutoRequestDto autoRequestDto) {
        Auto auto = new Auto(
                autoRequestDto.getBrand(),
                autoRequestDto.getModel(),
                autoRequestDto.getManufacturingDate(),
                autoRequestDto.getNumberOfKilometers(),
                autoRequestDto.getDoors(),
                autoRequestDto.getPrice(),
                autoRequestDto.getCurrency(),
                autoRequestDto.getServices(),
                autoRequestDto.getCountOfOwners()
        );
        autoRepository.agregarAuto(auto);
        return autoRequestDto;
    }

    @Override
    public List<AutoResponseNoServiceDto> verListadoAutos() {
        List<AutoResponseNoServiceDto> listadoAutosDto = new ArrayList<>();

        for (Auto auto : autoRepository.mostrarListaAutos()) {
            AutoResponseNoServiceDto autoDto = new AutoResponseNoServiceDto(
                    auto.getBrand(),
                    auto.getModel(),
                    auto.getManufacturingDate(),
                    auto.getNumberOfKilometers(),
                    auto.getDoors(),
                    auto.getPrice(),
                    auto.getCurrency(),
                    auto.getCountOfOwners()
            );
            listadoAutosDto.add(autoDto);
        }
        return listadoAutosDto;
    }

    @Override
    public List<AutoResponseDto> verAutosSegunFecha(String since, String to) {
        List<AutoResponseDto> listadoAutoDto = new ArrayList<>();
        LocalDate sinceDate = LocalDate.parse(since);
        LocalDate toDate = LocalDate.parse(to);

        for (Auto auto : autoRepository.mostrarListaAutos()) {
            LocalDate manufacturingDate = LocalDate.parse(auto.getManufacturingDate());
            if(manufacturingDate.isAfter(sinceDate) && manufacturingDate.isBefore(toDate)){
                AutoResponseDto autoDto = new AutoResponseDto();
                autoDto.setBrand(auto.getBrand());
                autoDto.setModel(auto.getModel());
                autoDto.setManufacturingDate(auto.getManufacturingDate());
                autoDto.setNumberOfKilometers(auto.getNumberOfKilometers());
                autoDto.setDoors(auto.getDoors());
                autoDto.setPrice(auto.getPrice());
                autoDto.setCurrency(auto.getCurrency());
                autoDto.setServices(auto.getServices());
                autoDto.setCountOfOwners(auto.getCountOfOwners());
                listadoAutoDto.add(autoDto);
            }
        }
        return listadoAutoDto;
    }

    @Override
    public List<AutoResponseDto> verAutosSegunPrecio(String since, String to) {
        List<AutoResponseDto> listadoAutoDto = new ArrayList<>();
        Double priceSince = Double.parseDouble(since);
        Double priceTo = Double.parseDouble(to);

        for (Auto auto : autoRepository.mostrarListaAutos()) {
            Double price = Double.parseDouble(auto.getPrice());
            if(price >= priceSince && price <= priceTo){
                AutoResponseDto autoDto = new AutoResponseDto();
                autoDto.setBrand(auto.getBrand());
                autoDto.setModel(auto.getModel());
                autoDto.setManufacturingDate(auto.getManufacturingDate());
                autoDto.setNumberOfKilometers(auto.getNumberOfKilometers());
                autoDto.setDoors(auto.getDoors());
                autoDto.setPrice(auto.getPrice());
                autoDto.setCurrency(auto.getCurrency());
                autoDto.setServices(auto.getServices());
                autoDto.setCountOfOwners(auto.getCountOfOwners());
                listadoAutoDto.add(autoDto);
            }
        }

        return listadoAutoDto;
    }

    @Override
    public AutoResponseDto verAuto(String id) {
        Auto auto = autoRepository.mostrarListaAutos().get(Integer.parseInt(id));
        AutoResponseDto autoDto = new AutoResponseDto(
                auto.getBrand(),
                auto.getModel(),
                auto.getManufacturingDate(),
                auto.getNumberOfKilometers(),
                auto.getDoors(),
                auto.getPrice(),
                auto.getCurrency(),
                auto.getServices(),
                auto.getCountOfOwners()
        );
        return autoDto;
    }
}
