package pl.awieczarek.ozwebsocket.chatroom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public Optional<String> getChatRoomId(final String senderId, final String recipientId, final boolean createRoomIfRoomExists) {
        return chatRoomRepository.findBySenderIdAndRecipientId(senderId, recipientId)
                .map(ChatRoom::getId)
                .or(() -> createChatIfNotExists(senderId, recipientId, createRoomIfRoomExists));
    }

    private Optional<String> createChatIfNotExists(final String senderId, final String recipientId, final boolean createRoomIfRoomExists) {
        if(createRoomIfRoomExists){
            var chatId = createChat(senderId, recipientId);
            return Optional.of(chatId);
        }
        return Optional.empty();
    }

    private String createChat(final String senderId, final String receiverId) {
        var chatId = String.format("%s_%s", senderId, receiverId);

        ChatRoom senderRecipient = ChatRoom.builder()
                .chatId(chatId)
                .senderId(senderId)
                .recipientId(receiverId)
                .build();

        ChatRoom recipientSender = ChatRoom.builder()
                .chatId(chatId)
                .senderId(receiverId)
                .recipientId(senderId)
                .build();

        chatRoomRepository.save(senderRecipient);
        chatRoomRepository.save(recipientSender);
        return chatId;
    }
}
