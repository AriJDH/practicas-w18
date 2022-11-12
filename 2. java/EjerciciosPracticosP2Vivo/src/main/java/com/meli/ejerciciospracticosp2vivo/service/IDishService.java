package com.meli.ejerciciospracticosp2vivo.service;

import com.meli.ejerciciospracticosp2vivo.dto.DishDTO;
import com.meli.ejerciciospracticosp2vivo.dto.DishResponseDTO;

public interface IDishService {
    DishResponseDTO getTotalCalories(DishDTO dishDTO);
}
