package com.ctd.backend.service;

import com.ctd.backend.model.Image;

public interface ImageService {
    void saveImage(Image image);
    void updateImage (Image image);
    void deleteImage(Long id);
}
