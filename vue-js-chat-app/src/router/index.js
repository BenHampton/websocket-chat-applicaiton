import Vue from 'vue';
import Router from 'vue-router';
import LoginComponent from "../components/Login/LoginComponent";
import ChatRoomComponent from "../components/ChatRoom/ChatRoomComponent";

Vue.use(Router);

export default new Router({
    routes: [
        { path: '/', name: 'LoginPage', component: LoginComponent},
        { path: '/chat-room', name: 'ChatRoom', component: ChatRoomComponent},
        { path: '*', redirect: '/' }
    ]
})

