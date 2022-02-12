package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Musica;
//uma classe pode ser herdada apenas uma vez, mas pode implementar inúmeras interfaces
public interface MusicaService {

    //retornamos o objeto e salvamos no banco
    public Musica inserir(Musica musica);

    //vamos retornar uma lista
    public List<Musica> listarTodas();

    public void deletar(String id);

    public Musica atualizar(String album,Integer anoLancamento,
    String artista,String compositor,String genero, String id,
    String titulo);

    public Musica procurarPorId(String id);
}
