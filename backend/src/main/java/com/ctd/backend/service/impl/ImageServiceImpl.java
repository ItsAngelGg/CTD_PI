package com.ctd.backend.service.impl;

import com.ctd.backend.model.Image;
import com.ctd.backend.repository.ImageRepository;
import com.ctd.backend.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    public void saveImage(Image image) {
        imageRepository.save(image);
    }

    @Override
    public void updateImage(Image image) {
        imageRepository.save(image);
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
}
