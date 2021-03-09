package br.blog.smarti.dockerfilemavenapi.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.blog.smarti.dockerfilemavenapi.dtos.NomeDto;
import br.blog.smarti.dockerfilemavenapi.dtos.ResponseDto;

@RestController
public class HelloController {

	private final Logger log = LoggerFactory.getLogger(HelloController.class);

	@GetMapping
	public ResponseEntity<String> helloWorld() {
		log.info("Requisição realizada com sucesso: ok");
		return ResponseEntity.ok("ok");
	}

	@PostMapping("/hello")
	public ResponseEntity<ResponseDto> helloWorld(@Validated @RequestBody NomeDto nomeDto, BindingResult result) {

		ResponseDto response = new ResponseDto(getUri());

		if (result.hasErrors()) {
			response.setMensagem(mapResultErrorsAsList(result).toString());
			log.error("Fahal na requisição: {}", response.getMensagem());
			return ResponseEntity.badRequest().body(response);
		}

		StringBuilder mensagem = new StringBuilder("Hello ");
		mensagem.append(nomeDto.getNome());
		response.setMensagem(mensagem.toString());

		log.info("Requisição realizada com sucesso: {}", mensagem.toString());
		return ResponseEntity.ok(response);
	}

	private static URI getUri() {
		return ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
	}

	private List<String> mapResultErrorsAsList(BindingResult result) {
		return result.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
	}

}
