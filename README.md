# Dockerfile-Maven-Api_Java
Projeto de exemplo para execução de containers docker com API REST Java embutida, gerando a imagem e subindo ao repositório automaticamente.


### Considerações

#### Autenticação dockerhub
A autenticação ao dockerhub está sendo feita da forma mais simples, utilizando o POM.XML. Para que a imagem gerada seja enviada ao seu repositório, basta criar as variáveis de ambiente local com seu usuário e senha do dockerhub. Existem outas outras formas mais seguras de autenticação, conforme informado no artigo. Lembre-se que este projeto é apenas um tutorial, mas aos fazer isso em seu ambiente, informações sensíveis de sua credencial podem ficar expostas.
```xml
<repository>conta/repo</repository>
<username>${env.DOCKERHUB_USERNAME}</username>
<password>${env.DOCKERHUB_PASSWORD}</password>
```


#### SpringBootServletInitializer
`SpringBootServletInitializer` é uma classe abstrata que implementa a interface `WebApplicationInitializer`. Através dessa extenção é possível que a aplicação rode como um pacote WAR tradicional em qualquer servidor de aplicação, como o Apache Tomcat.


#### Maven Deploy
O comando `mvn deploy` será usado para compilar e fazer o upload do projeto para o repositório do dockerhub. No entanto, não estamos fazendo um deploy da nossa aplicação de fato e, portanto, não temos as configurações para tal. Sendo assim, o maven irá abortar durante esta fase da execução. Para que isso não ocorra e seja executado o deploy, permitindo que o plugin envie a imagen ao dockerhub, basta adicionar a seguinte propriedade no POM.xml.
```xml
<maven.deploy.skip>true</maven.deploy.skip>
```


#### Configurações Tomcat
Dentro do projeto, existe a pasta `src/main/resources/tomcat/conf`. Está pasta contém um XML de configuração do servidor de aplicação Tomcat que pode ser alterado conforme necessário. Todos arquivos desta pasta serão copiado para a pasta `/usr/local/tomcat/conf` dentro da instalação do Tomcat na imagem docker gerada, tornando a configuração mais flexível. Lembre-se que este projeto é apenas um tutorial, mas aos fazer isso em seu projeto, configurações de segurança sensíveis podem estar expostas.


#### Execução Docker Image
https://hub.docker.com/repository/docker/smartiblogbr/dockerfilemavenplugin
```shell 
$ docker run --name smarti -d -p 8080:8080 smartiblogbr/dockerfilemavenplugin:1.0
```

#### Verificação:
- Requisição GET - Deve retornar: HttpStatus.OK | "ok"

```shell
$ curl -X GET http://localhost:8080/smarti/
```

- Requisição POST - Deve retornar: HttpStatus.OK | "Hello <nome>"

```shell
curl -X POST http://localhost:8080/smarti/hello \
--header 'Content-Type: application/json' \
--data '{"nome":""}';
```
