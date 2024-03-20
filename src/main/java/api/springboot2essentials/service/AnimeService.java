package api.springboot2essentials.service;


import api.springboot2essentials.mapper.AnimeMapper;
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

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime save(AnimeRequestDTO animeRequest) {
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animeRequest));
    }

    public void delete(long id) {
        animeRepository.delete(findById(id));
    }

     public void update(AnimeRequestDTO body, long id) {
        Anime animeFound = findById(id);
        Anime anime = AnimeMapper.INSTANCE.toAnime(body);
        anime.setId(animeFound.getId());
        animeRepository.save(anime);
    }
}
