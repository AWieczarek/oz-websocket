package pl.awieczarek.ozwebsocket.chatroom;

import jdk.incubator.vector.ByteVector;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {
    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);

}
