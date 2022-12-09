package com.RecapitulandoSpringP2VIVO.linkTracker.service;

import com.RecapitulandoSpringP2VIVO.linkTracker.dto.LinkDto;
import com.RecapitulandoSpringP2VIVO.linkTracker.dto.LinkDtoRes;
import com.RecapitulandoSpringP2VIVO.linkTracker.entity.Link;
import com.RecapitulandoSpringP2VIVO.linkTracker.repository.ILinkRepository;
import com.RecapitulandoSpringP2VIVO.linkTracker.repository.LinkRepository;
import com.RecapitulandoSpringP2VIVO.linkTracker.util.HandleURL;
import com.RecapitulandoSpringP2VIVO.linkTracker.util.MapperSingleton;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LinkService implements ILinkService {
	private final ILinkRepository linkRepository;
	
	public LinkService(LinkRepository linkRepository) {
		this.linkRepository = linkRepository;
	}
	
	@Override
	public LinkDtoRes addLink(LinkDto linkDTO) {
		Link link = MapperSingleton
						.getInstance()
						.map(linkDTO, Link.class);
		link.setUrl(linkDTO.getUrl().substring(7));
		
		if (HandleURL.isValidURL(linkDTO.getUrl())) {
			link.setValidated(true);
			Integer id = linkRepository.addLink(link);
			LinkDtoRes linkDTOres = MapperSingleton
							.getInstance()
							.map(linkDTO, LinkDtoRes.class);
			linkDTOres.setId(id);
			linkDTOres.setIsValidUrl(true);
			linkDTOres.setUrl(linkDTO.getUrl().substring(7));
			return linkDTOres;
		}
		return null;
	}
	
	@Override
	public LinkDto getLink(Integer id) {
		Link link = linkRepository.getLink(id);
		return MapperSingleton
						.getInstance()
						.map(link, LinkDto.class);
	}
	
	@Override
	public List<LinkDto> getLinks() {
		List<Link> linkList = linkRepository.getLinks();
		return linkList
						.stream()
						.map(link ->
										     MapperSingleton
														     .getInstance()
														     .map(link, LinkDto.class))
						.collect(Collectors.toList());
	}
	
	// TODO Redirección:
	//  Dado un link (ej: http://localhost:8080/link/{linkId} )
	//  tiene que realizar un redirect a la URL enmascarada.
	//  Siempre y cuando el link sea válido.
	//  En el caso de que el link sea inválido devolver 404(INVESTIGAR REDIRECT).
	
	
	// TODO Estadísticas por link:
	//  Endpoint GET que dado un link (ej: http://localhost:8080/metrics/{linkID} )
	//  tiene que devolver la estadística de cantidad de veces que se redireccionó.
	
	
	// TODO Invalidate link:
	//  Endpoint POST para invalidar un link (ej: http://localhost:8080/invalidate/{linkID} ).
	
	
	// TODO Al crear los links se tiene que poder agregar un password que
	//  va a ser un query param al llamar a la redirección.
}
