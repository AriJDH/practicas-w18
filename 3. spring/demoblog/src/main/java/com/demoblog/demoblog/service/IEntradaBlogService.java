package com.demoblog.demoblog.service;

import com.demoblog.demoblog.dto.req.EntradaBlogDto;
import com.demoblog.demoblog.dto.res.EntradaBlogIdDto;

public interface IEntradaBlogService {
    EntradaBlogIdDto crearEntradaBlog(EntradaBlogDto entradaBlogDto);
    EntradaBlogDto findById (Integer id);
}
