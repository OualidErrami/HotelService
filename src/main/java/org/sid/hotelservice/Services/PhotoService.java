package org.sid.hotelservice.Services;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.sid.hotelservice.entities.Photo;
import org.sid.hotelservice.repostories.PhotoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class PhotoService {
    private final PhotoRepository photoRepo;
    private final SequenceGeneratorService sequenceGeneratorService;

    public PhotoService(PhotoRepository photoRepo, SequenceGeneratorService sequenceGeneratorService) {
        this.photoRepo = photoRepo;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    public String addPhoto(String title, MultipartFile file) throws IOException {
        Photo photo = new Photo(title);
        photo.setImage(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        String AutoId =sequenceGeneratorService.getSequenceNumber(Photo.SEQUENCE_NAME) ;
        photo.set_id(AutoId);
        photo = photoRepo.insert(photo);
        return photo.get_id();
    }

    public Photo getPhoto(String id) {
        return photoRepo.findById(id).get();
    }
}
