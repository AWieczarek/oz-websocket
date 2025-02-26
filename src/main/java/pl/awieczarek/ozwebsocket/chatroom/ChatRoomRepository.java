package pl.awieczarek.ozwebsocket.chatroom;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {
    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);

}
