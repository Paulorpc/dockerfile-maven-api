package br.blog.smarti.dockerfilemavenapi.dtos;

import java.net.URI;

public class ResponseDto {

	private String mensagem;
	private String site;
	private Long timestamp;
	private String path;

	public ResponseDto() {
		this.timestamp = System.currentTimeMillis();
		this.site = "https://www.smarti.blog.br";
	}

	public ResponseDto(URI uri) {
		this();
		this.path = uri.normalize().getPath().toString();
	}

	public ResponseDto(String mensagem, URI uri) {
		this();
		this.mensagem = mensagem;
		this.path = uri.normalize().getPath().toString();
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public String getPath() {
		return path;
	}

	public String getSite() {
		return site;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return "ResponseDto [mensagem=" + mensagem + ", site=" + site + ", timestamp=" + timestamp + ", path=" + path
				+ "]";
	}
}
