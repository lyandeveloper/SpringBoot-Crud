package api.springboot2essentials.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.springboot2essentials.domain.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Long>{

}
