package org.sid.hotelservice.Services;

import org.sid.hotelservice.entities.AutogenerateID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;


import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SequenceGeneratorService {

    private final MongoOperations mongoOperations;
    @Autowired
    public SequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public String getSequenceNumber(String sequenceName){
        AutogenerateID counter = mongoOperations.findAndModify(Query.query(Criteria.where("_id").is(sequenceName)),

        new Update().inc("seq",1), options().returnNew(true).upsert(true),
                AutogenerateID.class);
        return !Objects.isNull(counter) ? counter.getSeq() : "1";

    }
}