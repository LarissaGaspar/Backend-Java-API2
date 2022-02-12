package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Musica;
import com.example.demo.service.MusicaService;
import com.example.demo.shared.MusicaDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//na controller fazemos as requisicoes
@RestController
@RequestMapping("api/musicas")
public class MusicaController {
    @Autowired//amarrar o servico (MusicaService)
    private MusicaService servico;

    @PostMapping//vamos retornar uma resposta (codigo) no Postman
    //dados serao inseridos no objeto Musica atraves do Postman no formato JSON
    //e depois atribuidos a musicaCriada atraves do servico(Service)
    public ResponseEntity<Musica> inserir(@RequestBody Musica musica){
        Musica musicaCriada = servico.inserir(musica);
        return new ResponseEntity<>(musicaCriada,HttpStatus.CREATED);
        //retorna "status 201" e o objeto (returno do service), o que nao for preenchido
        //fica nulo
    }//verificar se podemos adicionar endpoint ("api/musicas/cadastrar-musicas")

    @GetMapping
    public ResponseEntity<List<Musica>> listarTodas(){
        List<Musica> musicas = servico.listarTodas();
        return new ResponseEntity<>(musicas,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Musica> deletar(@PathVariable String id){
        servico.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping//a atualizacao sera pelo id entao nao podemos esquecer de inseri-lo no body
    public MusicaDto atualizar(@RequestBody MusicaDto dto){
        Musica musica = servico.atualizar(dto.getAlbum(),dto.getAnoLancamento(),
        dto.getArtista(),dto.getCompositor(),dto.getGenero(),dto.getId(),dto.getTitulo());
        return MusicaDto.parse(musica);
    }//so atualiza os dados que forem passados

    @GetMapping("/{id}")
    public Musica procurarPorId(@PathVariable String id){
        return servico.procurarPorId(id);
    }
}
