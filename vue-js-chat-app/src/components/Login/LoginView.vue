<template>
    <div class="">
        <div class="login-container col-md-12 col-sm-12 col-xs-12">
            <div class="row">
                <div class="login-header">
                    Enter your Username
                </div>
            </div>

            <div class="row row-login-username-container">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="login-username-container col-md-6 col-sm-12 col-xs-12">
                        Enter username to login:
                    </div>
                    <div class="login-username-input-container text-md-left col-md-4 col-sm-12 col-xs-12">
                        <input placeholder="username"
                               class="login-username-input"
                               name="userName"
                               @input="$emit('update-user-name', $event)"
                               @keyup.enter="$emit('log-into-chat-room')"/>
                    </div>

                    <div class="login-avatar-button-container text-md-left col-md-2 col-sm-12 col-xs-12">
                        <button class="avatar-button" @click="$emit('show-avatar-modal')">
                            Add Avatar
                        </button>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="login-button-container">
                        <button class="login-button"
                                @click="$emit('log-into-chat-room')">
                            Submit
                        </button>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div v-if="userNameErrorMessage">
                        Empty username
                    </div>
                </div>
            </div>

            <div class="selected-avatar col-md-12 col-sm-12 col-xs-12">
                <p class="avatar-selected-text">User Avatar:</p>
                <img :src="avatarImage" alt="name" class="selected-avatar-image"/>
            </div>

            <div v-if="showAvatarModal">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="avatar-modal-container">
                        <AvatarModalComponent v-on:show-avatar-modal="$emit('show-avatar-modal')"
                                              :avatarImages="avatarImages" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import AvatarModalComponent from '../Modals/LoginAvatarModal/AvatarModalComponent'

    export default {
        name: 'LoginView',
        components: {
            AvatarModalComponent
        },
        props: [
            'userNameErrorMessage',
            'showAvatarModal',
            'avatarImages',
            'avatarImage'
        ]
    }

</script>

<style scoped>
    .login-container {
        width: 100%;
        height: 50vh;
        background: #283248;
    }
    .login-header {
        margin-top: 5%;
        font-size: 35px;
        font-weight: bold;

    }



    .row-login-username-container {
        margin: 8% 10% 0 10%;
    }
    .login-username-container {
        font-size: 28px;
    }
    @media screen and (max-width: 545px){
        .login-username-container {
            margin-top: 20%;
            font-size: 20px;
        }
    }
    @media screen and (max-width: 450px){
        .login-username-container {
            font-size: 18px;
            padding: 0;
        }
    }
    .login-username-input-container {

    }
    .login-username-input {
        height: 5vh;
        width: 90%;
        padding-left: 3%;
        color:black;
    }
    @media screen and (max-width: 450px){
        .login-username-input-container {
            margin-top: 10%;
        }
        .login-username-input {
            height: 5vh;
            width: 90%;
            padding-left: 3%;
        }
    }


    .login-avatar-button-container {

    }
    .avatar-button {
        margin-top: 10%;
        color: black;
    }

    .login-button-container {
        margin-top: 10%;
        width: 100%;
    }
    .login-button {
        width: 25%;
        height:5vh;
        font-size: 20px;
        color: black;
    }
    @media screen and (max-width: 450px){
        .login-button {
            margin-top: 20%;
            font-size: 15px;
            width: 100%;
        }
    }


    .avatar-selected-text{
        font-size: 12px;
        margin-top: 2%;
    }
    .selected-avatar-image {
        width: 10%;
        height: 10vh;
    }
    @media screen and (max-width: 1000px){
        .selected-avatar-image {
            width: 15%;
            height: 10vh;
        }
    }
    @media screen and (max-width: 650px){
        .selected-avatar-image {
            width: 20%;
            height: 10vh;
        }
    }
    @media screen and (max-width: 450px){
        .selected-avatar-image {
            width: 25%;
            height: 7vh;
        }
    }
</style>
