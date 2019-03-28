<template>
    <div class="container">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <h2 class="chat-header col-md-4 col-sm-4">
                {{ chatTitle }}
            </h2>
        </div>
        <div class="login-component-container col-md-12 col-sm-12 col-xs-12">
            <LoginView :avatarImage="avatarImage"
                       :avatarImages="avatarImages"
                       :showAvatarModal="showAvatarModal"
                       :userNameErrorMessage="userNameErrorMessage"
                       v-on:log-into-chat-room="logIntoChatRoom"
                       v-on:show-avatar-modal="shouldShowAvatarModal"
                       v-on:update-user-name="updateUserName" />
        </div>
    </div>
</template>


<script>
    import LoginView from './LoginView';
    export default {
        name: 'LoginComponent',
        components: {
            LoginView
        },
        mounted(){
          this.$store.dispatch('renderAvatarImageSelected');
          this.avatarImage = this.$store.getters.getAvatarImage;
        },
        updated(){
          this.avatarImage = this.$store.getters.getAvatarImage;
        },
        data() {
            return {
                chatTitle: 'Welcome to the Chat Room',
                avatarImage: this.$store.getters.getAvatarImage,
                userNameErrorMessage: false,
                showAvatarModal: false,
                avatarImages: [
                    { id: 1, img: 'Angular.png' },
                    { id: 2, img: 'Flutter.png' },
                    { id: 3, img: 'Kali-Linux.png' },
                    { id: 4, img: 'MongoDB.png' },
                    { id: 5, img: 'PostgreSQL.png' },
                    { id: 6, img: 'React.png' },
                    { id: 7, img: 'Spring-Boot.png' },
                    { id: 8, img: 'Swift.png' },
                    { id: 9, img: 'VueJS.png' }
                ]
            }
        },
        methods: {
            logIntoChatRoom() {

                let userName = this.$store.getters.getUserName;
                if (userName !== ''){

                    this.userNameErrorMessage = false;
                    this.$router.push({ name: 'ChatRoom'});

                } else {
                    this.userNameErrorMessage = true;
                }
            },
            shouldShowAvatarModal(){
                this.showAvatarModal = !this.showAvatarModal;
            },
            updateUserName(e){
                this.$store.commit('setUserName', e.target.value)
            }
        }
    }

</script>

<style scoped>
    .chat-header {
        width: 100%;
        font-size: 40px;
        text-align: center;
        margin-top: 5%;
        color: white;
    }
    .login-component-container {
        height: 60vh;
        background: #283248;
        margin-top: 5%;
        color: white;
    }
</style>
