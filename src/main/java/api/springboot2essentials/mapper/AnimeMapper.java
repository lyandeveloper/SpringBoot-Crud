package api.springboot2essentials.mapper;

import api.springboot2essentials.domain.Anime;
import api.springboot2essentials.dtos.AnimeRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);
    public abstract Anime toAnime(AnimeRequestDTO animeRequest);
}
