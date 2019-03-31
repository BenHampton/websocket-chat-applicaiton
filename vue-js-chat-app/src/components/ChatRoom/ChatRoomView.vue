<template>
    <div class="chat-container col-md-12 col-sm-12 col-xs-12">
        <div class=" row message-topic-header">
            Welcome to the Chat Room
        </div>

        <vue-custom-scrollbar id="container" class="scroll-area">
            <div id="messagesContainer" class="row messages-container nopadding col-md-12 col-sm-12 col-xs-12">

                <div v-for="message in receivedMessages" :key="message.date" class="message-container col-md-12 col-sm-12 col-xs-12"  v-bind:class="{'message-container-join': message.messageType === 'JOIN'}">

                    <div class="message" v-bind:class="{'message-join': ( message.messageType === 'JOIN' || message.messageType === 'LEAVE' ) }">
                            <span class="message-avatar text-xs-left col-md-1 col-sm-2 col-xs-4" v-bind:class="{'message-avatar-joined': ( message.messageType === 'JOIN'  || message.messageType === 'LEAVE' ) }">
                                <img :src="message.messageAvatar" alt="message.messageAvatar" class="avatar-image ">
                            </span>
                        <span v-bind:class="( message.messageType === 'JOIN' || message.messageType === 'LEAVE' ) ?  'message-text-joined col-md-12 col-sm-12 col-xs-12' : 'message-text col-md-9 col-sm-8 col-xs-8'" >
                                <span v-bind:class="( message.messageType === 'JOIN' || message.messageType === 'LEAVE' ) ? 'message-user-name-joined' : 'message-user-name' " >
                                    &#60;{{message.messageSender}}&#62;
                                </span>
                                {{message.message}}
                            </span>
                        <span class="message-date text-right col-md-2 col-sm-2 col-xs-12" v-bind:class="{'message-date-joined': ( message.messageType === 'JOIN' || message.messageType === 'LEAVE' ) }">
                                {{message.messageDate}}
                            </span>
                    </div>

                </div>

            </div>
        </vue-custom-scrollbar>
    </div>
</template>

<script>
    import VueCustomScrollbar from "vue-custom-scrollbar/src/vue-scrollbar";

    export default {
        name: 'ChatRoomView',
        components: { VueCustomScrollbar },
        props: [ 'receivedMessages' ]
    }
</script>

<style scoped>
    .message-topic-header {
        color: white;
        background: black;
    }

    .chat-container {
        height: 60vh;
        background: #283248;
    }

    .messages-container {
        margin-top: 3%;
        margin-left: 0% !important;
        margin-bottom: 3%;
    }
    .scroll-area {
        position: relative;
        margin: auto;
        width: 100%;
        height: 100%;
    }
    .message-container {
        height: 7vh;
        width: 100%;
        color: black;
    }
    .message-container-join {
        height: 3vh;
    }
    div.message-container:nth-of-type(even) {
        background: #18294A  !important;
        height: 100%;
    }
    div.message-container:nth-of-type(odd) {
        height: 100%;
    }


    .message {
        text-align: left;
    }
    .message-join{
        text-align: center !important;
    }
    .message-avatar-joined {
        display: none !important;
        color: white;
    }
    .message-user-name-joined {
        display: none !important;
    }
    .message-date-joined {
        display: none !important;
        color: white;
    }
    .message-text-joined {
        color: lime !important;
    }
    .message-user-name {
        color: lime;
    }

    .message-avatar {
        color: black;
    }
    .avatar-image {
        width: 70%;
        padding: 5px;
        height: 5vh;
    }
    @media screen and (min-width: 995px) and (max-width: 1150px){
        .avatar-image {
            width: 100%;
            padding: 5px;
            height: 5vh;
        }
    }
    @media screen and (max-width: 765px){
        .avatar-image {
            width: 50%;
            padding: 5px;
            height: 5vh;
        }
    }
    @media screen and (max-width: 500px){
        .avatar-image {
            width: 100%;
            padding: 5px;
            height: 5vh;
        }
    }

    .message-text {
        color: white;
        overflow-wrap: break-word;
        display: block;
    }
    .message-date {
        font-size: 12px;
        color: lightgray;
        float: right;
        margin-top: 1%;
    }
</style>
