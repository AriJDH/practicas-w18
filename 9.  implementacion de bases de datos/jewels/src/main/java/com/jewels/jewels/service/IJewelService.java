
package com.jewels.jewels.service;

import com.jewels.jewels.dto.Request.RequestJewelDTO;
import com.jewels.jewels.dto.Response.JewelsResponseDTO;
import com.jewels.jewels.dto.Response.ResponseDTO;

import java.util.List;

public interface IJewelService {
    ResponseDTO create(RequestJewelDTO request);

    JewelsResponseDTO getList();

    ResponseDTO delete(Integer idJewel);

    ResponseDTO update(Integer idJewel, RequestJewelDTO request);


}
