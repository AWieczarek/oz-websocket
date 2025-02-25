package pl.awieczarek.ozwebsocket.chat;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    List<ChatMessage> findByChatId(String chatId);
}
