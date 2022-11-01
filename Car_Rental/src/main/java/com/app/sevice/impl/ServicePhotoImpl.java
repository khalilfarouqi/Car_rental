package com.app.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Photo;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.PhotoRepo;
import com.app.sevice.IService;

@Service
public class ServicePhotoImpl implements IService<Photo> {
	
	@Autowired
	private PhotoRepo photoRepo;
	
	@Override
	public List<Photo> getAll() {
		return photoRepo.findAll();
	}

	@Override
	public Photo save(Photo photo) {
		return photoRepo.save(photo);
	}

	@Override
	public Photo getById(Long id) {
		return photoRepo.findById(id).get();
	}

	@Override
	public Photo update(Photo photo, Long id) {
		Photo existingPhoto = photoRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("photoRepository", "Id", id));
		
		existingPhoto.setPhoto_1(photo.getPhoto_1());
		existingPhoto.setPhoto_2(photo.getPhoto_2());
		existingPhoto.setPhoto_3(photo.getPhoto_3());
		existingPhoto.setPhoto_4(photo.getPhoto_4());
		existingPhoto.setCar(photo.getCar());
		
		photoRepo.save(existingPhoto);
		
		return existingPhoto;
	}

	@Override
	public void deleteById(Long id) {
		this.photoRepo.deleteById(id);
	}

}
