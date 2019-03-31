<template>
    <div class="send-message-container col-md-12 col-sm-12 col-xs-12 container-fluid">
        <div class="">

            <div class="row">
           <span v-if="hasMaxLength" class="input-error-message-container">
               <div class="input-error-message">
                   Max number of charters is 150
               </div>
            </span>
            </div>

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="message-input-container">
                    <input placeholder="type message"
                           class="send-message-input"
                           v-bind:class="{'input-error': hasMaxLength}"
                           :value="this.$store.getters.getMessageToSend"
                           @input="$emit('update-message-to-send', $event.target.value)"
                           @keyup.enter="$emit('send-message')"/>
                </div>

            </div>

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="message-button-container">
                    <button class="send-button"
                            @click="$emit('send-message')">
                        Send Message
                    </button>
                </div>
            </div>

        </div>
    </div>
</template>

<script>

    export default {
        name: 'SendMessageView',
        components: {},
        props: ['hasMaxLength']
    }

</script>

<style scoped>
    .send-message-container {
        background: black;
        height: 25vh;
        text-align: center;
    }


    .input-error-message-container{
        border-color: red;
        border-width: 1px;
        background: hsla(0, 65%, 75%, 1);
        width: 30%;
        height: 5vh;
        transition: all;
    }
    .input-error-message {
        color: red;
        display: block;
        font-size: 15px;

    }
    .input-error{
        border-color: red;
        border-width: 1px;
        background: hsla(0, 65%, 75%, 1);
    }



    .message-input-container {
        margin-top: 2%;
    }
    .send-message-input {
        width: 64%;
        padding: 1%;
    }


    .message-button-container {
        margin-top: 2%;
    }
    .send-button {
        height: 5vh;
        width: 30%;
        font-size: 17px;
    }



    @media screen and (max-width: 550px){
        .message-input-container {
            margin-top: 5%;
        }
        .send-message-input {
            width: 100%;
            padding: 1%
        }
        .message-button-container {
            margin-top: 5%;
        }
        .send-button {
            height: 5vh;
            width: 60%;
            font-size: 17px;
        }
    }

    @media screen and (max-width: 450px) {
        .message-input-container {
            margin-top: 12%;
        }

        .send-button {
            height: 5vh;
            width: 70%;
            font-size: 17px;
        }
    }
</style>
