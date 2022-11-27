package org.sid.hotelservice.repostories;

import org.sid.hotelservice.entities.Room;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room,Integer> {
    @Aggregation(pipeline = {"{$match: {state: false}}","{$sample:{size:1}}"})
    AggregationResults<Room> random();
}

