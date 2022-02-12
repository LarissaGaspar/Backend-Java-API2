package com.example.demo.repository;

import com.example.demo.model.Musica;

import org.springframework.data.mongodb.repository.MongoRepository;

//tipo do objeto(Musica) e qual e o tipo do id(String)
public interface MusicaRepository extends MongoRepository <Musica, String> {
    
}
