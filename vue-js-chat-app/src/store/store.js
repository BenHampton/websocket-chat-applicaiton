import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export const store = new Vuex.Store({
   state: {
       userName: '',
       avatarImage: '',
       messageToSend: ''
   },
    mutations: {
       setUserName( state, userName ) {
           state.userName = userName;
       },
       setAvatarImage( state, image ) {
           state.avatarImage = image;
       },
       setMessageToSend( state, message) {
           state.messageToSend = message;
       }
    },
    getters: {
        getUserName: state => state.userName,
        getAvatarImage: state => state.avatarImage,
        getMessageToSend: state => state.messageToSend
    },
    actions: {
        renderAvatarImageSelected(context) {
            let image = this.getters.avatarImage;
            if (typeof(image) == "undefined") {
                image = 'Heisenberg.png';
            } else {
                image = this.getters.avatarImage;
            }
            context.commit('setAvatarImage', require(`@/assets/${image}`))
        }
    }
});
