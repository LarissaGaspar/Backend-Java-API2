package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Musica;
import com.example.demo.repository.MusicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaServiceImpl implements MusicaService{
    
    @Autowired//amarrar o repositorio (banco de dados)
    private MusicaRepository repositorio;

    //retornamos o objeto e salvamos no banco
    @Override
    public Musica inserir(Musica musica){
        return repositorio.save(musica);
    }

    //vamos retornar uma lista
    @Override
    public List<Musica> listarTodas(){
        return repositorio.findAll();
    }

    @Override
    public void deletar(String id){
        repositorio.deleteById(id);
    }

    @Override
    public Musica atualizar(String album,Integer anoLancamento,
    String artista,String compositor,String genero, String id,
    String titulo){
        Optional<Musica> registro = repositorio.findById(id);
        
        if (!registro.isEmpty()) {
            Musica musica = registro.get();
            musica.setCompositor(compositor);
            musica.setAlbum(album);
            musica.setAnoLancamento(anoLancamento);
            musica.setArtista(artista);
            musica.setGenero(genero);
            musica.setTitulo(titulo);
            return repositorio.save(musica);
        }
        else {
            return null;
        }
    }

    @Override
    public Musica procurarPorId(String id){
        Optional<Musica> op = repositorio.findById(id);
        return op.isEmpty() ? null : op.get();
    }
}
