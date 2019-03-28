<template>
    <div class="chat-room-container col-md-12 col-sm-12 col-xs-12">

        <ChatRoomView :receivedMessages="receivedMessages" />

        <SendMessageComponent :hasMaxLength="hasMaxLength"
                              v-on:send-message="sendMessage"
                              v-on:is-valid-input-string="isValidInputString"
                              v-on:update-message-to-send="updateMessageToSend" />


    </div>
</template>

<script>
    import ChatRoomView from './ChatRoomView';
    import SendMessageComponent from '../SendMessage/SendMessageComponent';
    import axios from 'axios';
    import SockJS from 'sockjs-client';
    import Stomp from 'webstomp-client';

    export default {
        name: 'ChatRoomComponent',
        components: {
            ChatRoomView,
            SendMessageComponent
        },
        mounted(){
            //this.renderAvatarImage = this.$store.getters.getAvatarImage;
            this.connect();
        },
        updated() {
            let container = this.$el.querySelector("#container");
            container.scrollTop = container.scrollHeight;
        },
        data(){

            return {
                connected: false,
                hasMaxLength: false,
                maxMessageLength: 150,
                renderAvatarImage: this.$store.getters.getAvatarImage,
                receivedMessages: []
            }
        },
        methods: {
            connect() {

                this.socket = new SockJS("http://localhost:8080/gs-guide-websocket");

                this.stompClient = Stomp.over(this.socket);

                this.stompClient.connect(
                    {},
                    frame => {
                        this.connected = true;
                        console.log(frame);
                        this.stompClient.subscribe("/topic/public", tick => {

                            let messageResponse = JSON.parse(tick.body);

                            let message = {
                                message: messageResponse.message,
                                messageDate: messageResponse.timeStamp,
                                messageType: messageResponse.actionType,
                                messageSender: messageResponse.sender,
                                messageAvatar: messageResponse.avatarImage

                            };

                            if (message.messageType === 'JOIN') {
                                this.retrieveMessageHistory()
                            }
                            this.receivedMessages.push(message);
                        });

                        this.sendJoinedMessage();

                    }, error => {
                        console.log("error");
                        console.log(error);

                        this.connected = false;
                    }
                );
            },
            sendJoinedMessage(){
                let userJoined = {
                    sender: this.$store.getters.getUserName,
                    actionType: 'JOIN',
                    avatarImage: this.$store.getters.getAvatarImage
                };

                this.stompClient.send("/app/chat.register", JSON.stringify(userJoined), {});
            },
            sendMessage(){

                let messageToSend = this.$store.getters.getMessageToSend;

                if (!this.hasMaxLength && messageToSend !== '') {
                    if (this.stompClient && this.stompClient.connected) {
                        let chatPayload = {
                            sender: this.$store.getters.getUserName,
                            message: messageToSend,
                            actionType: 'CHAT',
                            avatarImage: this.$store.getters.getAvatarImage
                        };

                        this.stompClient.send('/app/chat.send', JSON.stringify(chatPayload));

                        this.$store.commit('setMessageToSend', '');
                    }
                }
            },
            retrieveMessageHistory(){
                return axios.get("http://localhost:8080/messages")
                    .then( response => response.data)
                    .then(data => {

                        const messages = [];

                        data.messageLog.map(message => {

                            let log = {
                                message: message.message,
                                messageDate: message.timeStamp,
                                messageType: message.actionType,
                                messageSender: message.sender,
                                messageAvatar: message.avatarImage
                            };

                            messages.push(log);

                            this.receivedMessages = messages;
                        });
                    });
            },
            updateMessageToSend(e){
                this.$store.commit('setMessageToSend', e.target.value);
                this.isValidInputString();
            },
            isValidInputString(){
                this.hasMaxLength = this.$store.getters.getMessageToSend.length >= this.maxMessageLength;
            }
        }
    }
</script>

<style scoped>
    .chat-room-container {
        color: white;
        height: 90vh;
        margin-top: 5%;
        color: black;
    }

</style>
