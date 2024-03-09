package api.springboot2essentials.service;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import api.springboot2essentials.domain.Anime;
import api.springboot2essentials.dtos.AnimeRequestDTO;
import api.springboot2essentials.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService  {

    private final AnimeRepository animeRepository;

    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public Anime findById(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }

    public Anime save(AnimeRequestDTO animeRequest) {
        Anime anime = Anime.builder().name(animeRequest.getName()).build();
        return animeRepository.save(anime);
    }

    public void delete(long id) {
        animeRepository.delete(findById(id));
    }

     public void update(AnimeRequestDTO body, long id) {
        Anime animeFound = findById(id);
        Anime anime = Anime.builder().id(animeFound.getId()).name(body.getName()).build();
        animeRepository.save(anime);
    }
}
